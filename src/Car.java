import java.awt.*;
/**
 * Created by Agnes Rosendahhhl, William Nordgren and Erik Andersson on 2020-11-11.
 */

public abstract class Car extends Vehicle {

    public Car(int nrD, Color c, double eP, String mN) {
        super(nrD, eP, c, mN);
    }//Constructor, tar ej riktning som en parameter, sätter alltid åt norr

}