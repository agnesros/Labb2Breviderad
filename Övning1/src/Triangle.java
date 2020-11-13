import java.awt.*;
public class Triangle extends Polygon{
    public Triangle (int width, int height) {
        super(width, height);
    }
    public void paint(int width, int height, Graphics g){
        g.drawLine(centerPoint.x,centerPoint.y-width/2,centerPoint.x-width/2, centerPoint.y+width/2);
        g.drawLine(centerPoint.x-width/2, centerPoint.y+width/2,centerPoint.x+width/2, centerPoint.y+width/2);
        g.drawLine(centerPoint.x+width/2, centerPoint.y+width/2, centerPoint.x, centerPoint.y-width/2);
    }
}
