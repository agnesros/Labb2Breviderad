import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class CarTransport <A extends Car> extends Car implements Loadable<A>{
    private List  <A>  carsOnTransport=new ArrayList<>(10);
    private boolean rampUp=true;

    /**
     * Inherits constructor from superclass.
     */
    public CarTransport() {
        super(2, Color.GRAY, 150, "Car Transport");
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
    public void loadCars (A aCar){
        if(!aCar.equals(this)) {
            if (isClose(aCar) && !rampUp) {
                carsOnTransport.add(aCar);
                aCar.setPos(this.getPos());
                System.out.println(aCar.getModelName() + "has been loaded.");
            }
        }
        else
            System.out.println("Fel!");
    }

    /**
     *
     * @param nrCars is the amount of cars we want to unload. If the nrCars exceeds the cars currently loaded, all cars on the transport will be unloaded.
     *               Will only be able to unload cars when standing still and the flak is lowered.
     *               It will follow the principle "last in, first out".
     */
    public void unloadCars (int nrCars){
        if(!rampUp) {
            int size=carsOnTransport.size();
            for (int i=1; i<=Math.min(nrCars, size); i++){
                Car unloadedCar= carsOnTransport.get(size-i);
                carsOnTransport.remove(size-i);
                System.out.println(unloadedCar.getModelName()+" has been unloaded.");
            }
        }
        else
            System.out.println("Du kan inte lasta ur bilar medan du kör! Stanna motorn och sänk rampen");
    }

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

    public static void main (String[] args){
        Volvo240 volvo=new Volvo240();
        Saab95 saab=new Saab95();
        CarTransport test1=new CarTransport<>();
        test1.setCurrentSpeed(0);
        test1.lowerFlak();
        test1.loadCars(saab);
         System.out.println(volvo.getPos().toString());  
        test1.loadCars(volvo);
        test1.loadCars(test1);
        test1.unloadCars(2);

    }

}
