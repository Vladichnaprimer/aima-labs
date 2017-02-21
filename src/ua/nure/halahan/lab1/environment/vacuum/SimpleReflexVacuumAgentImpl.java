package ua.nure.halahan.lab1.environment.vacuum;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.impl.aprog.simplerule.ANDCondition;
import aima.core.agent.impl.aprog.simplerule.EQUALCondition;
import aima.core.agent.impl.aprog.simplerule.Rule;
import aima.core.environment.vacuum.LocalVacuumEnvironmentPercept;
import aima.core.environment.vacuum.SimpleReflexVacuumAgent;
import aima.core.environment.vacuum.VacuumEnvironment;


public class SimpleReflexVacuumAgentImpl extends SimpleReflexVacuumAgent {

	public SimpleReflexVacuumAgentImpl() {

	}


	private static Set<Rule> getRuleSet() {
		// Note: Using a LinkedHashSet so that the iteration order (i.e. implied
		// precedence) of rules can be guaranteed.
		Set<Rule> rules = new LinkedHashSet<Rule>();

		rules.add(new Rule(new EQUALCondition(LocalVacuumEnvironmentPercept.ATTRIBUTE_STATE,
				VacuumEnvironmentImpl.LocationState.Dirty),
				VacuumEnvironmentImpl.ACTION_SUCK));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_C),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_RIGHT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_A),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_RIGHT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_B),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_RIGHT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_D),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_FORWARD)
				), VacuumEnvironmentImpl.CHANGE_DIRECTION_BACKWARD));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_D),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_LEFT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_B),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_LEFT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_A),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.ACTION_MOVE_LEFT));

		rules.add(new Rule(
				new ANDCondition(
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.ATTRIBUTE_AGENT_LOCATION, VacuumEnvironmentImpl.LOCATION_C),
						new EQUALCondition(LocalVacuumEnvironmentPerceptImpl.DIRECTION, VacuumEnvironmentImpl.DIRECTION_BACKWARD)
				), VacuumEnvironmentImpl.CHANGE_DIRECTION_FORWARD));




		return rules;
	}

}
