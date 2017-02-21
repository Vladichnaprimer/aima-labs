package ua.nure.halahan.lab1.environment.vacuum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aima.core.agent.Action;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractAgent;
import aima.core.agent.impl.aprog.TableDrivenAgentProgram;


public class TableDrivenVacuumAgentImpl extends AbstractAgent {

	public TableDrivenVacuumAgentImpl()
	{
		super(new TableDrivenAgentProgram(getPerceptSequenceActions()));
	}

	private static Map<List<Percept>, Action> getPerceptSequenceActions() {
		Map<List<Percept>, Action> perceptSequenceActions = new HashMap<List<Percept>, Action>();

		// NOTE: While this particular table could be setup simply
		// using a few loops, the intent is to show how quickly a table
		// based approach grows and becomes unusable.
		List<Percept> ps;
		
		/*
		 * Level 1 (14 states)
		 */

		// Dirty C room. Forward Direction -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_C,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_FORWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Dirty C room, Backward Direction  -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_C,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Clean C room. Forward Direction -> Move right
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_C,
				VacuumEnvironmentImpl.LocationState.Clean,
				VacuumEnvironmentImpl.DIRECTION_FORWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_MOVE_RIGHT);

		// Dirty A room. Forward Direction -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_A,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_FORWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Dirty A room, Backward Direction  -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_A,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Clean A room. Forward Direction -> Move right
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_A,
				VacuumEnvironmentImpl.LocationState.Clean,
				VacuumEnvironmentImpl.DIRECTION_FORWARD
				));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_MOVE_RIGHT);

		// Clean A room, Backward Direction  -> Move left
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_A,
				VacuumEnvironmentImpl.LocationState.Clean,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_MOVE_LEFT);

		// Dirty B room. Forward Direction   -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_B,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_FORWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Dirty B room, Backward Direction  -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_B,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);


		// Clean B room. Forward Direction -> Move right
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_B,
				VacuumEnvironmentImpl.LocationState.Clean,
				VacuumEnvironmentImpl.DIRECTION_FORWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_MOVE_RIGHT);

		// Clean B room, Backward Direction  -> Move left
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_B,
				VacuumEnvironmentImpl.LocationState.Clean,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_MOVE_LEFT);

		// Dirty D room. Forward Direction -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_D,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_FORWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Dirty D room, Backward Direction  -> Suck
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_D,
				VacuumEnvironmentImpl.LocationState.Dirty,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_SUCK);

		// Clean D room, Backward Direction -> Move left
		ps = createPerceptSequence(new LocalVacuumEnvironmentPerceptImpl(
				VacuumEnvironmentImpl.LOCATION_D,
				VacuumEnvironmentImpl.LocationState.Clean,
				VacuumEnvironmentImpl.DIRECTION_BACKWARD));
		perceptSequenceActions.put(ps, VacuumEnvironmentImpl.ACTION_MOVE_LEFT);


		return perceptSequenceActions;
	}
	
	private static List<Percept> createPerceptSequence(Percept... percepts) {
		List<Percept> perceptSequence = new ArrayList<Percept>();

		for (Percept p : percepts) {
			perceptSequence.add(p);
		}

		return perceptSequence;
	}
}
