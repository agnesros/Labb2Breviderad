import java.awt.*;
import java.sql.Array;
import java.util.List;
import java.util.ArrayList;

public abstract class Transporter<A extends Car> extends Vehicle implements Loadable<A> {
    private int maxCars;
    private List<A> carsOnTransport = new ArrayList<>(maxCars);
    private boolean rampUp=true;

    /**
     * Inherits constructor from superclass.
     */
    public Transporter(int nrDoors, int engPwr, Color clr, String mdlName, int maxCars){
        super(nrDoors,engPwr, clr, mdlName);
        this.maxCars = maxCars;
    }

    public double speedFactor(){
        return this.getEnginePower()*0.01;
    }

    public void liftFlak() {
        rampUp=true;
    }

    public void lowerFlak(){
        if(this.getCurrentSpeed()==0)
            rampUp=false;
    }
    /**
     *
     * @param car is the car we want to compare it's position in relation to the cartransport.
     * @return true if the car is close, otherwise false.
     */
     public boolean isClose(A car){
        if(Math.abs(this.getPos()[0]-car.getPos()[0])<=3&&Math.abs(this.getPos()[1]-car.getPos()[1])<=3)
            return true;
        return false;
    }
    /**
     *
     * @param aCar is the car we'd like to load onto the cartransport. The method will make sure it's close and that the ramp is lowered.
     * If the cartransport is full or if the cartransport tries to laod itself we will receive a notification error.
     */
    @Override
    public void loadCars (A aCar){
        if (isClose(aCar) && !rampUp) {
            carsOnTransport.add(aCar);
            aCar.setPos(this.getPos());
            System.out.println(aCar.getModelName() + "has been loaded.");
        } else
            System.out.println("Not even close or the flak is up");

    }
    /**
     *
     * @param nrCars Abstract method, depending on which subtype of Transporter, it will unloadCars in different ways.
     */
    public abstract void unloadCars (int nrCars);

    /**
     * In addition to the superclass's move method, this method will also make  sure the ramp is up and that the cars loaded will change their positions.
     */
    @Override
    public void move(){
        rampUp=true;
        super.move();
        for(A e: carsOnTransport){
            e.setPos(this.getPos());
        }
    }

    public boolean contain(A car){
        return carsOnTransport.contains(car);
    }

    public List<A> getCarList(){
        return carsOnTransport;
    }

    public boolean isRampUp(){
        return this.rampUp;
    }

    public static void main(String [] args){
        CarTransport nr1=new CarTransport<>(10);
        Car volvo=new Volvo240();
        nr1.lowerFlak();
        nr1.loadCars(volvo);
        System.out.println(""+nr1.getCarList());
    }

}

