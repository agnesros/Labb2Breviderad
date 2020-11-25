import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ferry <A extends Car>  extends Transporter<A>{

    public Ferry(int maxCars){
        super(0, 1000, Color.YELLOW, "Bjorn Ferry",40);
    }


    public void unloadCars(int nrCars) {
        if(!this.isRampUp()){
           for(int i= 0; i <= Math.min(nrCars, getCarList().size()); i++) {
               Car unloadedCar = this.getCarList().get(i);
                this.getCarList().remove(i);
               System.out.println(unloadedCar.getModelName()+" has been unloaded.");

           }
        } else
            System.out.println("serrigöst?! The flak is up! Snälla lower it :P ");
    }
}
