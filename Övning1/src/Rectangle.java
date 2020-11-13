import java.awt.*;
public class Rectangle extends Polygon{
    public Rectangle(int width, int height){
        super (width, height);
    }
    public void paint(int width, int height, Graphics g){
        g.drawRect(centerPoint.x,centerPoint.y, width, height);
    }
}
