package MVC;
import Main.*;
import javax.swing.*;
import java.awt.*;
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
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    CarModel model;

    CarController(CarModel model){
        this.model=model;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Vehicle> vehicleList=model.vehicles;
            for (Vehicle vehicle :  vehicleList) {
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

        vehicle.move();
        int x = (int) Math.round(vehicle.getX());
        int y = (int) Math.round(vehicle.getY());


        model.moveit(x,y,vehicle);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
        update(model.vehicles);
    }

    private boolean withinFrame(Vehicle vehicle){
        if(vehicle.getDirection()== Vehicle.NORTH||vehicle.getDirection()== Vehicle.WEST) {
            return frame.drawPanel.contains((int) vehicle.getX(), (int) vehicle.getY());
        }else if(vehicle.getDirection()== Vehicle.SOUTH){
            return frame.drawPanel.contains((int) vehicle.getX(), (int)  vehicle.getY()+60);
        }else
            return frame.drawPanel.contains((int) vehicle.getX()+100,(int) vehicle.getY());

    }

    void update(ArrayList<Vehicle> vehicles){
        updateSpeedList(vehicles);
        updatePointList(vehicles);
    }

    void updateSpeedList(ArrayList<Vehicle> vehicles) {
        model.speedMap.clear();
        for(Vehicle e : vehicles) {
            model.speedMap.put(e.getModelName(), e.getCurrentSpeed());
        }
        frame.speedometer.updateSpeed(model.speedMap);

    }

    void updatePointList(ArrayList<Vehicle>vehicles){
        model.pointMap.clear();
        for(Vehicle e: vehicles){
            model.pointMap.put(e.getModelName(), new Point((int) e.getX(), (int) e.getY()));
        }
        frame.drawPanel.updateImages(model.pointMap);
    }






}