import java.awt.*;
/**
 * Created by Agnes Rosendal, William Nordgren and Erik Andersson on 2020-11-11.
 */

public abstract class Car implements Movable {
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private double currentSpeed;

    private double pos[] = {0, 0};

    /** A set of constants for possible directions
     *
     */
    public static final int NORTH = 0; //skulle kunna vara enom
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3; //public så de kan användas för att välja riktning

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

    public Car(int nrD, Color c, double eP, String mN) {
        this.nrDoors = nrD;
        this.enginePower = eP;
        this.color = c;
        this.modelName = mN;
        stopEngine();
        this.dir = NORTH;
    }//Constructor, tar ej riktning som en parameter, sätter alltid åt norr


    public void setCurrentSpeed(double newSpeed) {
        if (newSpeed <= enginePower && newSpeed >= 0)
            currentSpeed = newSpeed;
        System.out.println("Mata in ett värde emellan 0 och motorkraft!");
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    /**
     * Depending on the cars current direction it will either increase or decrease it's position in the x,y-directions.
     */
    public void move() {
        if (dir == NORTH)
            pos[1] += currentSpeed;
        else if (dir == EAST)
            pos[0] += currentSpeed;
        else if (dir == SOUTH)
            pos[1] -= currentSpeed;
        else
            pos[0] -= currentSpeed;
    } //kan göra om så den löper igenom en array (av riktningarna) eller

    @Override
    public void turnLeft() {
        dir = LEFT[dir];
    }

    @Override
    public void turnRight() {
        dir = RIGHT[dir];
    }

    public void setDirection(int direction) {
        this.dir = direction;
    } //Extra
    public int getDirection(){
        return this.dir;
    }

    public boolean validAmount(double amount) {
        return (amount >= 0 && amount <= 1);
    }
    public void gas(double amount) {
        if (validAmount(amount))
            incrementSpeed(amount);
        System.out.println("Mata in ett värde mellan 0 och 1");
    } //Kommer gå till resp. incrementSpeed beroende på vilken biltyp

    public void brake(double amount) {
        if (validAmount(amount))
            decrementSpeed(amount);
        System.out.println("Mata in ett värde mellan 0 och 1");
    }


    /**
     * If adding a new model that extends from Car you must have a speedFactor method.
     * @return
     */

    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + Math.abs(speedFactor()) * amount,getEnginePower()));
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - Math.abs(speedFactor()) * amount,0));
    }

    public double [] getPos(){
        return this.pos;
    }
}


//metoder för get,set bör vara public för att kunna kallas på utanför klassen?

//instansvariabler bör vara private så de ej kan  ändras utifrån?

//interfaces/specifikationosarv bäst?