import java.util.List;

public interface Loadable <A extends Car> {

    void loadCars(A aCar);
    void unloadCars(int nrCars);

    }