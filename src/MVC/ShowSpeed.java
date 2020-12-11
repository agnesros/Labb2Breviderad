package MVC;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ShowSpeed extends JLabel {

    public ShowSpeed(int x, int y){
        this.setLayout(new BorderLayout());
        this.setBounds(x, y, 800, 15);
        this.setVisible(true);
        this.setOpaque(true);
        makePretty();
    }

    private void makePretty(){
        this.setBackground(Color.PINK);
        this.setForeground(Color.BLACK);
    }
    void updateSpeed(Map<String,Double> speedMap){
        String tmp = "";
        for(Map.Entry<String,Double> e : speedMap.entrySet()){
            tmp = tmp + e.getKey() + ": " + Math.round(e.getValue()) + ", ";
        }
        this.setText(tmp);

    }


}
