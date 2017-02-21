package ua.nure.halahan.lab1.environment.vacuum;

import java.util.Random;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.impl.DynamicAction;
import aima.core.environment.vacuum.VacuumEnvironment;


public class VacuumEnvironmentImpl extends VacuumEnvironment {

	//Room 3 - Left
	public static final String LOCATION_C = "C";

	//Room D - Right
	public static final String LOCATION_D = "D";

	//Direction forward
	public static final String DIRECTION_FORWARD = "FORWARD";

	//Direction backward
	public static final String DIRECTION_BACKWARD = "BACKWARD";

	//Forward Direction
	public static final Action CHANGE_DIRECTION_FORWARD = new DynamicAction("ToForward");

	//Backward Direction
	public static final Action CHANGE_DIRECTION_BACKWARD = new DynamicAction("ToBackward");

	/**
	 * Add rooms C and D
	 */
	public VacuumEnvironmentImpl() {
		Random r = new Random();
		
		envState = new VacuumEnvironmentState(
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty,
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty,
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty,
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty);
		
	}

	private VacuumEnvironmentState envState;

	/**
	 * Add rooms C and D
	 * @param locAState
	 * @param locBState
	 * @param locCState
	 * @param locDState
	 */
	public VacuumEnvironmentImpl(LocationState locAState, LocationState locBState,LocationState locCState,LocationState locDState) {
		envState = new VacuumEnvironmentState(locAState,locBState,locCState,locDState);
	}
	
	/**
	 * Add movement to rooms C and D
	 */
	public EnvironmentState executeAction(Agent a, Action agentAction) {

		if(ACTION_MOVE_RIGHT == agentAction && envState.getAgentLocation(a) == LOCATION_C && envState.getAgentDirection(a) == DIRECTION_FORWARD ){
			envState.setAgentLocation(a, LOCATION_A);
			updatePerformanceMeasure(a, -1);
		}else if (ACTION_MOVE_RIGHT == agentAction && envState.getAgentLocation(a) == LOCATION_A && envState.getAgentDirection(a) == DIRECTION_FORWARD){
			envState.setAgentLocation(a, LOCATION_B);
			updatePerformanceMeasure(a, -1);
		}else if (ACTION_MOVE_RIGHT == agentAction && envState.getAgentLocation(a) == LOCATION_B && envState.getAgentDirection(a) == DIRECTION_FORWARD){
			envState.setAgentLocation(a, LOCATION_D);
			updatePerformanceMeasure(a, -1);
		}else if(ACTION_MOVE_LEFT == agentAction && envState.getAgentLocation(a) == LOCATION_D && envState.getAgentDirection(a) == DIRECTION_BACKWARD){
			envState.setAgentLocation(a, LOCATION_B);
			updatePerformanceMeasure(a, -1);
		}else if(ACTION_MOVE_LEFT == agentAction && envState.getAgentLocation(a) == LOCATION_B && envState.getAgentDirection(a) == DIRECTION_BACKWARD){
			envState.setAgentLocation(a, LOCATION_A);
			updatePerformanceMeasure(a, -1);
		}else if(ACTION_MOVE_LEFT == agentAction && envState.getAgentLocation(a) == LOCATION_A && envState.getAgentDirection(a) == DIRECTION_BACKWARD){
			envState.setAgentLocation(a, LOCATION_C);
			updatePerformanceMeasure(a, -1);
		}else if (ACTION_SUCK == agentAction) {
			if (LocationState.Dirty == envState.getLocationState(envState
					.getAgentLocation(a))) {
				envState.setLocationState(envState.getAgentLocation(a),
						LocationState.Clean);
				updatePerformanceMeasure(a, 10);
			}
		} else if (agentAction.isNoOp()) {
			// In the Vacuum Environment we consider things done if
			// the agent generates a NoOp.
			isDone = true;
		}

		return envState;

	}
	
	/**
	 * Add rooms C and D
	 */
	public void addAgent(Agent a) {
		int idx = new Random().nextInt(4);
		switch (idx) {
		case 0:
			envState.setAgentLocation(a, LOCATION_A );
			envState.setAgentDirection(a, DIRECTION_FORWARD);
			break;
		case 1:
			envState.setAgentLocation(a, LOCATION_B );
			envState.setAgentDirection(a, DIRECTION_FORWARD);
			break;
		case 2:
			envState.setAgentLocation(a, LOCATION_C );
			envState.setAgentDirection(a, DIRECTION_FORWARD);
			break;
		case 3:
			envState.setAgentLocation(a, LOCATION_D );
			envState.setAgentDirection(a, DIRECTION_BACKWARD);
			break;
		default:
			break;
		}
		
		super.addAgent(a);
	}

}
