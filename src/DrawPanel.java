import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
// This panel represent the animated part of the view with the car images.

public class DrawPanel <A extends Vehicle> extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage, saabImage, scaniaImage;

    // To keep track of a the cars positions
    Point volvoPoint = new Point();
    Point saabPoint = new Point((int) volvoPoint.getX(), (int) volvoPoint.getY()+100);
    Point scaniaPoint = new Point((int) volvoPoint.getX(),(int) saabPoint.getY()+100);

    private Map<String, Point> pointMap = new HashMap<String, Point>();
    // TODO: Make this genereal for all cars

    void moveit(int x, int y, A vehicle){
        if(pointMap.containsKey(vehicle.getModelName())){
                pointMap.get(vehicle.getModelName()).x = x;
                pointMap.get(vehicle.getModelName()).y = y;
            }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            pointMap.put("Saab95", saabPoint);
            pointMap.put("Volvo240", volvoPoint);
            pointMap.put("Scania", scaniaPoint);

        } catch (IOException ex)
        {

        }
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);// see javadoc for more info on the parameters

    }
}
