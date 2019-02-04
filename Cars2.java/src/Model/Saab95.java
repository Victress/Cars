package Model;

import Model.Cars;

import java.awt.*;

/**
 * Class for a Saa95
 */
public class Saab95 extends Cars {

    private boolean turboOn;

    public Saab95(){
        super(2,125,8,Color.red,"Model.Saab95",0,0,directions.UP);
        turboOn = false;

        //stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

}