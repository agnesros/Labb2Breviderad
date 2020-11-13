import java.awt.*;
public class Square extends Polygon{
    public Square (int width){
        super(width, width);
    }
    public void paint(int width, Graphics g){
            System.out.println("Hey");
            g.drawRect(centerPoint.x,centerPoint.y,width,width);
            System.out.println("Hey");
    }
}
