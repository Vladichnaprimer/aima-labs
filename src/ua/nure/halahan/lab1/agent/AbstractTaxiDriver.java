package ua.nure.halahan.lab1.agent;


import aima.core.agent.Action;
import aima.core.agent.AgentProgram;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractAgent;
import aima.core.agent.impl.NoOpAction;

import java.util.List;


public abstract class AbstractTaxiDriver extends AbstractAgent {


    /**
     * Percepts  of taxi driver agent
     */
    private List<Percept> cameras;
    private Percept speedometer;
    private Percept gps;
    private Percept sonar;
    private Percept microphone;

    /**
     * Actuators of taxi driver agent
     */
    private Action steer;
    private Action accelerate;
    private Action brake;
    private Action talkToPassenger;

    public AbstractTaxiDriver() {
    }

    public List<Percept> getCameras() {
        return cameras;
    }

    public void setCameras(List<Percept> cameras) {
        this.cameras = cameras;
    }

    public Percept getSpeedometer() {
        return speedometer;
    }

    public void setSpeedometer(Percept speedometer) {
        this.speedometer = speedometer;
    }

    public Percept getGps() {
        return gps;
    }

    public void setGps(Percept gps) {
        this.gps = gps;
    }

    public Percept getSonar() {
        return sonar;
    }

    public void setSonar(Percept sonar) {
        this.sonar = sonar;
    }

    public Percept getMicrophone() {
        return microphone;
    }

    public void setMicrophone(Percept microphone) {
        this.microphone = microphone;
    }

    public Action getSteer() {
        return steer;
    }

    public void setSteer(Action steer) {
        this.steer = steer;
    }

    public Action getAccelerate() {
        return accelerate;
    }

    public void setAccelerate(Action accelerate) {
        this.accelerate = accelerate;
    }

    public Action getBrake() {
        return brake;
    }

    public void setBrake(Action brake) {
        this.brake = brake;
    }

    public Action getTalkToPassenger() {
        return talkToPassenger;
    }

    public void setTalkToPassenger(Action talkToPassenger) {
        this.talkToPassenger = talkToPassenger;
    }
}
