import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = CarFactory.createVehicleList();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.vehicles.add(CarFactory.createVolvo240());
        cc.vehicles.add(CarFactory.createSaab95());
        cc.vehicles.add(CarFactory.createScania());

        double[] saabPos = {0, 100};
        cc.vehicles.get(1).setPos(saabPos);
        double[] scaniaPos = {0, 200};
        cc.vehicles.get(2).setPos(scaniaPos);

        // Start a new view and send a reference of self
        cc.frame = new CarView("Carsim 3.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    //controller
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                if(withinFrame(vehicle))
                    updateVehicle(vehicle);
                else {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                    updateVehicle(vehicle);
                }
            }
        }
    }

    //controller
    private void updateVehicle(Vehicle vehicle){
 //       System.out.println(""+vehicle.getModelName()+", "+vehicle.getX()+", "+vehicle.getY());
        vehicle.move();
        int x = (int) Math.round(vehicle.getX());
        int y = (int) Math.round(vehicle.getY());
        frame.drawPanel.moveit(x, y, vehicle);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }

    //Model? Kan vi fixa så att den inte är beroende av CarView?!?!!??!
    private boolean withinFrame(Vehicle vehicle){
        if(vehicle.getDirection()==Vehicle.NORTH||vehicle.getDirection()==Vehicle.WEST) {
            return frame.drawPanel.contains((int) vehicle.getX(), (int) vehicle.getY());

        }else if(vehicle.getDirection()==Vehicle.SOUTH){
            return frame.drawPanel.contains((int) vehicle.getX(), (int)  vehicle.getY()+60);
        }else
            return frame.drawPanel.contains((int) vehicle.getX()+100,(int) vehicle.getY());

    }  //TODO: förenkla?

    // hör till model
    void stopAllEngines(){
        for(Vehicle car : vehicles)
            car.stopEngine();
    }

    //Model
    void startAllEngines(){
        for(Vehicle car : vehicles)
            car.startEngine();
    }

    //Model
    void turboOnSaab(){
        for(Vehicle car : vehicles){
            if(car.getModelName().equals("Saab95"))
                ((Saab95) car).setTurboOn();
        }
    }

    //Model
    void turboOffSaab(){
        for(Vehicle car : vehicles){
            if(car.getModelName().equals("Saab95"))
                ((Saab95) car).setTurboOff();
        }
    }

    //Model
    void liftflak(int amount){
        for(Vehicle vehicle:vehicles){
            if(vehicle.getModelName().equals("Scania"))
                ((Scania) vehicle).liftFlak(amount);
        }
    }

    //Model
    void lowerflak(int amount){
        for(Vehicle vehicle:vehicles){
            if(vehicle.getModelName().equals("Scania"))
                ((Scania) vehicle).lowerFlak(amount);
        }
    }

    // Calls the gas method for each car once, model
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    //Model
    void brake(int amount){
        double brake=((double) amount)/100;
        for(Vehicle vehicle: vehicles){
            vehicle.brake(brake);
        }
    }

}
