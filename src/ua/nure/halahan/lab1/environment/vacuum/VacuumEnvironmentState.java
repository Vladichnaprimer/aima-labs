package ua.nure.halahan.lab1.environment.vacuum;

import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.environment.vacuum.FullyObservableVacuumEnvironmentPercept;
import aima.core.environment.vacuum.VacuumEnvironment;

import java.util.LinkedHashMap;
import java.util.Map;


public class VacuumEnvironmentState implements EnvironmentState,
		FullyObservableVacuumEnvironmentPercept {

	private Map<String, VacuumEnvironment.LocationState> state;
	private Map<Agent, String> agentLocations;
	private Map<Agent, String> agentDirection;

	/**
	 * Constructor
	 */
	public VacuumEnvironmentState() {
		state = new LinkedHashMap<String, VacuumEnvironment.LocationState>();
		agentLocations = new LinkedHashMap<Agent, String>();
	}

	/**
	 * Constructor
	 * 
	 * @param locAState
	 * @param locBState
	 * @param locCState
	 * @param locDState
	 */

	public VacuumEnvironmentState(VacuumEnvironment.LocationState locAState,
			VacuumEnvironment.LocationState locBState,
			VacuumEnvironment.LocationState locCState,
			VacuumEnvironment.LocationState locDState) {
		this();
		state.put(VacuumEnvironmentImpl.LOCATION_A, locAState);
		state.put(VacuumEnvironmentImpl.LOCATION_B, locBState);
		state.put(VacuumEnvironmentImpl.LOCATION_C, locBState);
		state.put(VacuumEnvironmentImpl.LOCATION_D, locBState);
	}


	public VacuumEnvironmentState(VacuumEnvironmentState toCopyState) {
		this();
		this.state.putAll(toCopyState.state);
		this.agentLocations.putAll(toCopyState.agentLocations);
	}


	public String getAgentDirection(Agent a) {
		return agentDirection.get(a);
	}

	public void setAgentDirection(Agent a, String location) {
		agentDirection.put(a, location);
	}

	public String getAgentLocation(Agent a) {
		return agentLocations.get(a);
	}


	public void setAgentLocation(Agent a, String location) {
		agentLocations.put(a, location);
	}
	

	public VacuumEnvironment.LocationState getLocationState(String location) {
		return state.get(location);
	}


	public void setLocationState(String location,
			VacuumEnvironment.LocationState s) {
		state.put(location, s);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof VacuumEnvironmentState) {
			VacuumEnvironmentState s = (VacuumEnvironmentState) o;
			if (this.state.equals(s.state)
					&& this.agentLocations.equals(s.agentLocations)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public int hashCode() {
		return 3 * state.hashCode() + 13 * agentLocations.hashCode();
	}


	@Override
	public String toString() {
		return this.state.toString();
	}


}