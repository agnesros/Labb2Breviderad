package MVC;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarController carC;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);
    ShowSpeed speedometer= new ShowSpeed(0, 545);
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Flak");
    JButton lowerBedButton = new JButton("Scania Lower Flak");
    JButton addCarButton = new JButton("Add new car");
    JButton removeCarButton=new JButton("Remove car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, CarController cc){
        super(framename);
        this.carC = cc;
        initComponents(framename);

    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        //initiates carview
        initiateCarview(title);
        //attach drawPanel to it
        this.add(drawPanel);

        drawPanel.setLayout(null);

        drawPanel.add(speedometer);

        initiateGasControl();
        addChangeListener();
        setUpGasPanel();

        this.add(gasPanel);

        setUpButtons();
        makePretty();

        this.add(startButton);
        this.add(stopButton);


        // This actionListener is for all the buttons only yes!
      //  addActionListeners();

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   private void makePretty(){
        controlPanel.setBackground(Color.PINK);
        startButton.setBackground(Color.CYAN);
        startButton.setForeground(Color.BLACK);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        addCarButton.setForeground(Color.MAGENTA);
   }
    private void setUpButtons() {
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
    }

    private void addChangeListener(){
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }

    private void setUpGasPanel(){
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
    }


    private void initiateCarview(String title){
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    private void initiateGasControl(){
          SpinnerModel spinnerModel =
                        new SpinnerNumberModel(0, //initial value
                                0, //min
                                100, //max
                                1);//step
                gasSpinner = new JSpinner(spinnerModel);
    }

    void addActionListeners(){
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carC.model.gas(gasAmount); }
        });

        gasButton.addActionListener(e -> carC.model.gas(gasAmount));
        brakeButton.addActionListener(e -> carC.model.brake(gasAmount));
        stopButton.addActionListener(e->carC.model.stopAllEngines());
        startButton.addActionListener(e->carC.model.startAllEngines());
        turboOnButton.addActionListener(e->carC.model.turboOnSaab());
        turboOffButton.addActionListener(e->carC.model.turboOffSaab());
        lowerBedButton.addActionListener(e->carC.model.lowerflak(gasAmount));
        liftBedButton.addActionListener(e->carC.model.liftflak(gasAmount));
        addCarButton.addActionListener(e->carC.model.addCar());
        removeCarButton.addActionListener(e->carC.model.removeCar());

    }
}