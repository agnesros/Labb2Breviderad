package Cars;
import Main.*;
import java.awt.*;

public class Saab95 extends Vehicle implements Passenger{
    public boolean turboOn;
    private static int counter = 1;

    Saab95 () {
        super(2,  100, Color.red,"Saab95 nr."+ counter);
        turboOn = false;
        counter++;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * How fast the car's speed changes.
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}

