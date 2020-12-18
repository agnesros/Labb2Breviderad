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

public class CarController implements CarObserver {
    private final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());

    CarView frame;
    CarModel model;

    CarController(CarModel model, CarView frame){
        this.frame=frame;
        this.model=model;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();

        }
    }

    @Override
    public void actOnCarsChange() {
        checkCarsOutsideFrame();
    }

    void checkCarsOutsideFrame() {
        int q=(int)frame.drawPanel.saabImage.getHeight(); //ej generellt
        int r=(int)frame.drawPanel.saabImage.getWidth();
        int y=(int)frame.drawPanel.getPreferredSize().getHeight()-q;
        int x=(int)frame.drawPanel.getPreferredSize().getWidth()-r;
        model.placeWithinFrame(x,y);

    }

}