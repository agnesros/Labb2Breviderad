import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ferry <A extends Car>  extends Transporter{

    public Ferry(int maxCars){
        super(0, 1000, Color.YELLOW, "Bjorn Ferry",40);
    }

    public void unloadCars(int nrCars) {
        if(!this.isRampUp()){
         //   for(A e:this.getCarList()){
//
     //       }

        } else
            System.out.println("serriöst?! the flak is up! Snälla lower it :P ");

    }

}
