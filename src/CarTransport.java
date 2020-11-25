import kotlin.OverloadResolutionByLambdaReturnType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class CarTransport <A extends Car> extends Transporter<A>{


    /**
     * Inherits constructor from superclass.
     */
    public CarTransport(int maxCars) {
        super(2,150, Color.GRAY, "Car Transport", 10);
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
               Car unloadedCar = this.getCarList().get(size - i);
                this.getCarList().remove(size-i);
                System.out.println(unloadedCar.getModelName()+" has been unloaded.");
            }
        } else
            System.out.println("Du kan inte lasta ur bilar medan du kör! Stanna motorn och sänk rampen");
    }


/*
    public static void main (String[] args){
        Volvo240 volvo=new Volvo240();
        Saab95 saab=new Saab95();
        CarTransport test1=new CarTransport<>(10);
        test1.setCurrentSpeed(0);
        test1.lowerFlak();
        test1.loadCars(saab);
         System.out.println(volvo.getPos().toString());  
        test1.loadCars(volvo);
        //test1.loadCars(test1);
        test1.unloadCars(2);

    }

 */

}
