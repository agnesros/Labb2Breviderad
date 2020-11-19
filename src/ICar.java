import java.awt.*;

public interface ICar {
     void setCurrentSpeed(double newSpeed);
     void stopEngine();
     void startEngine();
     int getNrDoors();
     double getEnginePower();
     double getCurrentSpeed();
     Color getColor();
     void setColor(Color clr);
     void setDirection(int direction);
     boolean validAmount(double amount);
     void brake(double amount);
     double speedFactor();
     void incrementSpeed(double amount);
     void decrementSpeed(double amount);
     double [] getPos();
}








