package Cars;
import Main.*;

public interface Passenger<A extends Vehicle> {

    String getModelName();
    double [] getPos();
    void setPos(double [] pos);

}
