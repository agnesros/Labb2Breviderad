package Transporters;
import Cars.CarFactory;
import Main.*;
import java.awt.*;
public class CarTransport <A extends Cars.Passenger> extends Transporter<A>{

    /**
     * Inherits constructor from superclass.
     */
    public CarTransport(int maxCars) {
        super(2,150, Color.GRAY, "Cars.CarFactory.Car Transport", 10);
    }

    /**
     *
     * @param nrCars is the amount of cars we want to unload. If the nrCars exceeds the cars currently loaded, all cars on the transport will be unloaded.
     *               Will only be able to unload cars when standing still and the flak is lowered.
     *               It will follow the principle "last in, first out".
     */

    @Override
    public void unloadCars (int nrCars){
        if(!this.isRampUp()) {
            int size=getCarList().size();
            for (int i=1; i<=Math.min(nrCars, size); i++){
               Cars.Passenger unloadedCar = this.getCarList().get(size - i);
                this.getCarList().remove(size-i);
                System.out.println(unloadedCar.getModelName()+" has been unloaded.");
            }
        } else
            System.out.println("Du kan inte lasta ur bilar medan du kör! Stanna motorn och sänk rampen please");
    }


}
