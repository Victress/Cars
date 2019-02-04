package Model;

import Model.Cars;

import java.awt.*;

/**
 * Class for a Volvo240
 */
public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4,100,8,Color.BLACK, "Model.Volvo240",0,0,directions.UP);

        //stopEngine();
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


}