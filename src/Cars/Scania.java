package Cars;
import java.awt.*;
import Main.*;

public class Scania extends Vehicle {
    private int flakAngle=0;
    private static int counter = 1;

    Scania(){
        super(4, 450 ,Color.blue, "Scania nr." + counter);
        counter++;
    }

    /**
     *
     * @param degree is the degree the flak should be lifted. It won't be able to lift the flak for more than 70 degrees above the horizontal.
     */

    public void liftFlak(int degree){
        if(this.getCurrentSpeed()==0)
            flakAngle=Math.min(flakAngle+degree,70);
    }

    /**
     *
     * @param degree is the degree the flak should be lowered. It won't be able to lower the flak for less than 0 degrees above the horizontal.
     */
    public void lowerFlak(int degree){
        if(this.getCurrentSpeed()==0)
            flakAngle=Math.max(flakAngle-degree,0);
    }

    /**
     *
     * @param newSpeed the method will change the currentspeed only if the flak angle is 0 degrees.
     */
    @Override
    public void setCurrentSpeed(double newSpeed){
        if(flakAngle==0){
            if (newSpeed <= this.getEnginePower() && newSpeed >= 0) {
                super.setCurrentSpeed(newSpeed); //?
            }
        }
    }
    public double getFlakAngle(){
        return this.flakAngle;
    }

    @Override
    public double speedFactor() {
        return this.getEnginePower()*0.01;
    }
}
