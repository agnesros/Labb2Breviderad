package Transporters;
import Cars.CarFactory;
import java.awt.*;
import Main.*;

public class Ferry <A extends Cars.Passenger>  extends Transporter<A>{

    public Ferry(int maxCars){
        super(0, 1000, Color.YELLOW, "Bjorn Ferry",40);
    }


    public void unloadCars(int nrCars) {
        if(!this.isRampUp()){
           for(int i= 0; i <= Math.min(nrCars, getCarList().size()); i++) {
               Cars.Passenger unloadedCar = this.getCarList().get(i);
                this.getCarList().remove(i);
               System.out.println(unloadedCar.getModelName()+" has been unloaded.");

           }
        } else
            System.out.println("Please lower the flak!");
    }
}
