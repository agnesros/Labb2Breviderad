package Cars;
import Main.Vehicle;
import java.awt.*;

public class Volvo240  extends Vehicle implements Passenger {
    private final static double trimFactor = 1.25;
    private static int counter = 1;

    Volvo240() {
        super(4, 100, Color.black, "Volvo240 nr."+counter);
        counter++;
    }
    /** How fast the car's speed changes.
     *
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}

/**
 * Created by Agnes Rosendahhhl, William Nordgren and Erik Andersson on 2020-11-11.
 */


