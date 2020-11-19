import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class Car_Test {
    Car car;

    @Before
    public void init(){
        car= new Volvo240();
    }

    @Test
    public void testGas(){
        car.gas(0.4);
        assert(car.getCurrentSpeed()>0);
    }
    @Test
    public void testBrake(){
        car.setCurrentSpeed(0.5);
        double speed= car.getCurrentSpeed();
        car.brake(0.3);
        assert(car.getCurrentSpeed()<speed);
    }
    @Test
    public void testMove(){
        double[] position= car.getPos();
        car.setCurrentSpeed(1.4);
        car.move();
        assert(car.getPos()!=position);
    }
    @Test
    public void testStartEngine(){
        car.setCurrentSpeed(0);
        car.startEngine();
        assert(car.getCurrentSpeed()>0);
    }
    @Test
    public void testStopEngine(){
        car.setCurrentSpeed(0.4);
        car.stopEngine();
        assert(car.getCurrentSpeed()==0);
    }
    @Test
    public void testTurnLeft(){
        car.turnLeft();
        assert(car.getDirection()==Car.WEST);
    }
    @Test
    public void testTurnRight(){
        car.setDirection(car.SOUTH);
        car.turnRight();
        assert(car.getDirection()==Car.WEST);
    }
    @Test
    public void testColor(){
        assert(car.getColor()== Color.BLACK);
    }
    @Test
    public void testReColoring(){
        car.setColor(Color.PINK);
        assert(car.getColor()==Color.PINK);
    }
    @Test
    public void testGetNrDoors(){
        assert(car.getNrDoors()==4);
    }
}
