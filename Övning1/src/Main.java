import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[]arg){
        JFrame frame = new JFrame();
        DrawPolygons polygons=new DrawPolygons();
        Triangle triangle=new Triangle(20,20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        //frame.getContentPane().add(triangle);

        frame.setVisible(true);
    }
}
