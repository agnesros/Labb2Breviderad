import org.junit.Before;
import org.junit.Test;
import Cars.*;

public class Saab95_Test {

    Saab95 saab;
    Saab95 saab2;
    @Before
    public void init() {
        saab = CarFactory.createSaab95();
        saab2 = CarFactory.createSaab95();
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
