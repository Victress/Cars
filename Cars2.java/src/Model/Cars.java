package Model;

import java.awt.*;

/**
 * This a class for cars. That implements a cars properties from the interface Model.IMovable.
 *
 */
public abstract class Cars implements IMovable {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    private final static double trimFactor = 1.25;
    private double x;
    private double y;
    private directions currentDirection;

    /**
     *Constructour for the
     */

    public Cars (int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, directions currentDirection){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.currentDirection = currentDirection;
        this.modelName = modelName;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /**
     * This is an enum for directions to the move method
     */

    public enum directions{
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    /**
     * This is a method that calculates the movement of a car.
     * @return currentSpeed
     */
    @Override
    public void move() {
        switch (currentDirection) {
            case UP:
                y = y + currentSpeed;
                break;
            case LEFT:
                x = x + currentSpeed;
                break;
            case DOWN:
                y = y - currentSpeed;
                break;
            case RIGHT:
                x = x - currentSpeed;
                break;
        }
    }


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= 0 && currentSpeed <= enginePower) {
            this.currentSpeed = currentSpeed;
        }
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void setCurrentDirection(directions currentDirection){
        this.currentDirection = currentDirection;
    }

    public directions getCurrentDirection(){
        return currentDirection;
    }

    /**
     * A method to make a car turn left
     */

    @Override
    public void turnLeft() {
        switch (currentDirection){
            case UP:
                currentDirection = directions.LEFT;
                break;
            case LEFT:
                currentDirection = directions.DOWN;
                break;
            case DOWN:
                currentDirection = directions.RIGHT;
                break;
            case RIGHT:
                currentDirection = directions.UP;
                break;
        }
    }

    /**
     * A method to make a car turn right
     */

    @Override
    public void turnRight() {
        switch (currentDirection){
            case UP:
                currentDirection = directions.RIGHT;
                break;
            case RIGHT:
                currentDirection = directions.DOWN;
                break;
            case DOWN:
                currentDirection = directions.LEFT;
                break;
            case LEFT:
                currentDirection = directions.UP;
                break;
        }
    }

    @Override
    public void setX(double x) {
        this.x= x;
    }

    @Override
    public void setY(double y) {
        this.y= y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    /**
     * Method that returns the speedfacor
     * @return
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Method that increases the speed
     * @param amount
     */
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Method that decreases the speed
     * @param amount
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Method to make the car gas
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * Method to make the car brake
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
    /**
     *
     */
}
