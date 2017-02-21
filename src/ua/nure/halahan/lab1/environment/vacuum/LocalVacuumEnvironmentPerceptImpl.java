package ua.nure.halahan.lab1.environment.vacuum;

import aima.core.environment.vacuum.LocalVacuumEnvironmentPercept;
import aima.core.environment.vacuum.VacuumEnvironment.LocationState;


public class LocalVacuumEnvironmentPerceptImpl extends
		LocalVacuumEnvironmentPercept {

	public static final String DIRECTION = "Direction";
	

	public LocalVacuumEnvironmentPerceptImpl(String agentLocation,
			LocationState state) {
		super(agentLocation, state);
	}

	public LocalVacuumEnvironmentPerceptImpl(String agentLocation,
			LocationState state, String agentDirection) {
		super(agentLocation, state);
		setAttribute(DIRECTION, agentDirection);
	}

	public String getAgentDirection() {
		return (String) getAttribute(DIRECTION);
	}

}
