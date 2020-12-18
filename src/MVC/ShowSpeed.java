package MVC;
import Main.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class ShowSpeed extends JLabel implements CarObserver {
    CarModel model;
    public ShowSpeed(int x, int y, CarModel model){
        this.setLayout(new BorderLayout());
        this.setBounds(x, y, 800, 15);
        this.setVisible(true);
        this.setOpaque(true);
        this.model=model;
        makePretty();
    }

    private void makePretty(){
        this.setBackground(Color.PINK);
        this.setForeground(Color.BLACK);
    }

    @Override
    public void actOnCarsChange() {
     String tmp="";
     ArrayList<Vehicle> vehicleList = model.vehicles;
     for(Vehicle v: vehicleList) {
         tmp = tmp + v.getModelName() + ":" + Math.round(v.getCurrentSpeed()) + ",";
     }
     this.setText(tmp);
    }


}