import java.util.ArrayList;

public class CarFactory {

    public static ArrayList<Vehicle> createVehicleList() {
        return new ArrayList<Vehicle>();
    }

    public static Saab95 createSaab95(){
        return new Saab95();
    }
    public static Volvo240 createVolvo240(){
        return new Volvo240();
    }
    public static Scania createScania(){
        return new Scania();
    }

}
