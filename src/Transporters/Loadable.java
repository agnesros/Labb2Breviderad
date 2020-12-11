package Transporters;
import Cars.CarFactory;
import Main.*;

public interface Loadable <A extends Cars.Passenger> {

    void loadCars(A aCar);
    void unloadCars(int nrCars);

    }