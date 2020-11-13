import java.awt.*;

public abstract class Polygon {
    private String name;
    public Point centerPoint;

    private Polygon(Point centerPoint){
            this.centerPoint=centerPoint;
    }
    public Polygon(int width, int height){
        this(new Point(100,100)); //Constructor chain, kallar på Polygon Point
    }
    public void paint (Graphics g){

    }


}
