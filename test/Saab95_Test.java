import org.junit.Before;
import org.junit.Test;
public class Saab95_Test {

    Saab95 saab;
    Saab95 saab2;
    @Before
    public void init() {
        saab = new Saab95();
        saab2 = new Saab95();
    }

    @Test
    public void testTurbo(){
        saab.setTurboOn();
        saab2.setTurboOff();
        saab.gas(0.8);
        saab2.gas(0.8);
        assert(saab.getCurrentSpeed()>saab2.getCurrentSpeed());
    }



}
