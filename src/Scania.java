import java.awt.*;

public class Scania extends Car {
    private double flakAngle=0;
    private double currentSpeed; //fungerar detta?
    public Scania(){
        super(4, Color.blue,150,"Scania");
    }

    /**
     *
     * @param degree is the degree the flak should be lifted. It won't be able to lift the flak for more than 70 degrees above the horizontal.
     */

    public void liftFlak(double degree){
        if(this.getCurrentSpeed()==0)
            flakAngle=Math.min(flakAngle+degree,70);
    }

    /**
     *
     * @param degree is the degree the flak should be lowered. It won't be able to lower the flak for less than 0 degrees above the horizontal.
     */
    public void lowerFlak(double degree){
        if(this.getCurrentSpeed()==0)
            flakAngle=Math.max(flakAngle-degree,0);
    }

    /**
     *
     * @param newSpeed the method will change the currentspeed only if the flak angle is 0 degrees.
     */
    public void setCurrentSpeed(double newSpeed){
        if(flakAngle==0){
            if (newSpeed <= this.getEnginePower() && newSpeed >= 0)
            this.setCurrentSpeed(newSpeed); //?
            System.out.println("Mata in ett värde emellan 0 och motorkraft!");
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
