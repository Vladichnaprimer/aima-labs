package ua.nure.halahan.lab1.environment.vacuum;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.Model;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractAgent;
import aima.core.agent.impl.DynamicState;
import aima.core.agent.impl.NoOpAction;
import aima.core.agent.impl.aprog.ModelBasedReflexAgentProgram;
import aima.core.agent.impl.aprog.simplerule.ANDCondition;
import aima.core.agent.impl.aprog.simplerule.EQUALCondition;
import aima.core.agent.impl.aprog.simplerule.Rule;
import aima.core.environment.vacuum.LocalVacuumEnvironmentPercept;
import aima.core.environment.vacuum.ModelBasedReflexVacuumAgent;
import aima.core.environment.vacuum.VacuumEnvironment;


public class ModelBasedReflexVacuumAgentImpl extends AbstractAgent {

	private static final String ATTRIBUTE_CURRENT_LOCATION = "currentLocation";
	private static final String ATTRIBUTE_CURRENT_STATE = "currentState";
	private static final String ATTRIBUTE_CURRENT_DIRECTION = "currentDirection";

	private static final String ATTRIBUTE_STATE_LOCATION_A = "stateLocationA";
	private static final String ATTRIBUTE_STATE_LOCATION_B = "stateLocationB";
	private static final String ATTRIBUTE_STATE_LOCATION_C = "stateLocationC";
	private static final String ATTRIBUTE_STATE_LOCATION_D = "stateLocationD";

	private static final String ATTRIBUTE_STATE_DIRECTION_FORWARD = "stateDirectionForward";
	private static final String ATTRIBUTE_STATE_DIRECTION_BACKWARD = "stateDirectionBackward";

	public ModelBasedReflexVacuumAgentImpl() {
		super(new ModelBasedReflexAgentProgram() {
			@Override
			protected void init() {
				setState(new DynamicState());
				setRules(getRuleSet());
			}

			protected DynamicState updateState(DynamicState state,
												Action anAction, Percept percept, Model model) {

				LocalVacuumEnvironmentPerceptImpl vep = (LocalVacuumEnvironmentPerceptImpl) percept;

				state.setAttribute(ATTRIBUTE_CURRENT_LOCATION,
						vep.getAgentLocation());
				state.setAttribute(ATTRIBUTE_CURRENT_STATE,
						vep.getLocationState());
				state.setAttribute(ATTRIBUTE_CURRENT_DIRECTION,
						vep.getAgentDirection());
				
				// Keep track of the state of the different locations
				if (Objects.equals(VacuumEnvironmentImpl.LOCATION_A, vep.getAgentLocation())) {
					state.setAttribute(ATTRIBUTE_STATE_LOCATION_A,
							vep.getLocationState());
				} else if (Objects.equals(VacuumEnvironmentImpl.LOCATION_B, vep.getAgentLocation())){
					state.setAttribute(ATTRIBUTE_STATE_LOCATION_B,
							vep.getLocationState());
				} else if (Objects.equals(VacuumEnvironmentImpl.LOCATION_C, vep.getAgentLocation())){
					state.setAttribute(ATTRIBUTE_STATE_LOCATION_C,
							vep.getLocationState());
				} else if (Objects.equals(VacuumEnvironmentImpl.LOCATION_D, vep.getAgentLocation())){
					state.setAttribute(ATTRIBUTE_STATE_LOCATION_D,
							vep.getLocationState());
				}

				if(Objects.equals(VacuumEnvironmentImpl.DIRECTION_FORWARD, vep.getAgentDirection())) {
					state.setAttribute(ATTRIBUTE_CURRENT_DIRECTION, ATTRIBUTE_STATE_DIRECTION_FORWARD);
				} else {
					state.setAttribute(ATTRIBUTE_CURRENT_DIRECTION, ATTRIBUTE_STATE_DIRECTION_BACKWARD);
				}
				
				return state;
			}
		});
	}


	private static Set<Rule> getRuleSet() {
		// Note: Using a LinkedHashSet so that the iteration order (i.e. implied
		// precedence) of rules can be guaranteed.
		Set<Rule> rules = new LinkedHashSet<Rule>();

		rules.add(new Rule(
				new ANDCondition(
					new EQUALCondition(ATTRIBUTE_STATE_LOCATION_A, VacuumEnvironmentImpl.LocationState.Clean),
					new EQUALCondition(ATTRIBUTE_STATE_LOCATION_B, VacuumEnvironmentImpl.LocationState.Clean)
				), NoOpAction.NO_OP));

		rules.add(new Rule(
				new ANDCondition(
					new EQUALCondition(ATTRIBUTE_STATE_LOCATION_C, VacuumEnvironmentImpl.LocationState.Clean),
					new EQUALCondition(ATTRIBUTE_STATE_LOCATION_D, VacuumEnvironmentImpl.LocationState.Clean)
				), NoOpAction.NO_OP));

		rules.add(new Rule(new EQUALCondition(ATTRIBUTE_CURRENT_STATE,
				VacuumEnvironment.LocationState.Dirty), VacuumEnvironment.ACTION_SUCK));
		

		rules.add(new Rule(
					new ANDCondition(
							new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_C),
							new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
					), VacuumEnvironmentImpl.ACTION_MOVE_RIGHT));

		rules.add(new Rule(
					new ANDCondition(
							new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_A),
							new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
					), VacuumEnvironmentImpl.ACTION_MOVE_RIGHT));

		rules.add(new Rule(
					new ANDCondition(
							new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_B),
							new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
					), VacuumEnvironmentImpl.ACTION_MOVE_RIGHT));

		rules.add(new Rule(
					new ANDCondition(
							new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_D),
							new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
					), VacuumEnvironmentImpl.CHANGE_DIRECTION_BACKWARD));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_D),
						new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_LEFT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_B),
						new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_LEFT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_A),
						new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_LEFT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(ATTRIBUTE_CURRENT_LOCATION, VacuumEnvironmentImpl.LOCATION_C),
						new EQUALCondition(ATTRIBUTE_CURRENT_DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.CHANGE_DIRECTION_FORWARD));



		return rules;
	}

}
