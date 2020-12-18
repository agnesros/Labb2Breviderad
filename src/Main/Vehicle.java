package Main;

import java.awt.*;

public abstract class Vehicle implements Movable {
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private double currentSpeed;
    private double pos[] = {0, 0};
    /** A set of constants for possible directions
     *
     */
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    final int LEFT[] = {3, 0, 1, 2};
    final int RIGHT[] = {1, 2, 3, 0};

    private int dir;
    /** Every car that's created needs to have the following list of characteristics.
     *
     * @param nrD is the number of doors the car has.
     * @param c is the color it displays.
     * @param eP is the enginePower the car has.
     * @param mN is the cars modelName.
     */

    public Vehicle(int nrD,  double eP, Color c, String mN){
        this.nrDoors = nrD;
        this.enginePower = eP;
        this.color = c;
        this.modelName = mN;
        stopEngine();
        this.dir = NORTH;
    }

    public void setCurrentSpeed(double newSpeed) {
        if (newSpeed <= enginePower && newSpeed >= 0)
            currentSpeed = newSpeed;
    }

    public void stopEngine() { currentSpeed = 0; }

    public void startEngine() { currentSpeed = 0.1; }

    public int getNrDoors() { return nrDoors; }

    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed() { return currentSpeed; }

    public Color getColor() { return color; }

    public void setColor(Color clr) { color = clr; }

    @Override
    /**
     * Depending on the cars current direction it will either increase or decrease it's position in the x,y-directions.
     */
    public void move() {
        if (dir == NORTH)
            this.setPos(new double[]{getPos()[0],getPos()[1]-this.getCurrentSpeed()});
        else if (dir == EAST)
            this.setPos(new double[]{getPos()[0]+this.getCurrentSpeed(),getPos()[1]});
        else if (dir == SOUTH)
            this.setPos(new double[]{getPos()[0],getPos()[1]+this.getCurrentSpeed()});
        else
            this.setPos(new double[]{getPos()[0]-this.getCurrentSpeed(),getPos()[1]});
    }

    @Override
    public void turnLeft() { dir = LEFT[dir]; }

    @Override
    public void turnRight() { dir = RIGHT[dir]; }

    public void setDirection(int direction) { this.dir = direction; }

    public int getDirection(){ return this.dir; }

    private boolean validAmount(double amount) { return (amount >= 0 && amount <= 1); }

    public void gas(double amount) {
        if (validAmount(amount)) {
            incrementSpeed(amount);
            this.move();
        }
    }

    public void brake(double amount) {
        if (validAmount(amount)){
            decrementSpeed(amount);
            this.move();
        }
    }
    /**
     * If adding a new model that extends from Cars.CarFactory.Car you must have a speedFactor method.
     * @return
     */
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + Math.abs(speedFactor()) * amount,getEnginePower()));
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - Math.abs(speedFactor()) * amount,0));
    }

    public double [] getPos(){ return this.pos; }

    public double getX(){
        return this.getPos()[0];
    }
    public double getY(){
        return this.getPos()[1];
    }

    public boolean isNextPosValid(int x, int y){
        if(this.getDirection()== Vehicle.NORTH) {
            return checkParameter(y,(int)this.getY()-this.getCurrentSpeed());
        }else if(this.getDirection()== Vehicle.SOUTH){
            return checkParameter(y,(int)this.getY()+this.getCurrentSpeed());
        }else if(this.getDirection()==Vehicle.EAST){
            return checkParameter(x,(int)this.getX()+this.getCurrentSpeed());
        }else
            return checkParameter(x,(int)this.getX()-this.getCurrentSpeed());
    }

    private boolean checkParameter(int z, double nextPos) {
        if(0<nextPos && nextPos<z) {
            return true;
        }
        else
            return false;
    }

    public void turnAround(){
        this.turnLeft();
        this.turnLeft();
    }

    public void setPos(double [] newPos){ this.pos=newPos; }

    public String getModelName(){ return this.modelName; }

}


