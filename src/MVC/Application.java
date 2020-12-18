package MVC;
import Cars.CarFactory;
import Main.Vehicle;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarView carView= new CarView("Vehicle race", model);
        CarController cc = new CarController(model, carView);

        model.vehicles.add(CarFactory.createVolvo240());
        model.vehicles.add(CarFactory.createSaab95());
        model.vehicles.add(CarFactory.createScania());
        model.addCarObserver(cc);
        model.addCarObserver(carView);
        model.addCarObserver(carView.speedometer);

        ArrayList<Vehicle> vehicleList=model.vehicles;
        double[] saabPos = {0, 100};
        vehicleList.get(1).setPos(saabPos);
        double[] scaniaPos = {0, 200};
        vehicleList.get(2).setPos(scaniaPos);

        // Start a new view and send a reference of self
        //TODO: ta bort ersatt med att ta in i konstrtuktorn istället.
 //       cc.frame = new CarView("Vehicle race", cc);
        // Start the timer
        cc.timer.start();

        cc.frame.addActionListeners();
    }

}

