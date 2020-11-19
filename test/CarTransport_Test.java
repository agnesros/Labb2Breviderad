import org.junit.Before;
import org.junit.Test;

public class CarTransport_Test {
    CarTransport cartransport;
    Saab95 saab;
    Volvo240 volvo;
    @Before
    public void init(){
        cartransport=new CarTransport();
        saab=new Saab95();
        volvo=new Volvo240();
        cartransport.lowerFlak();
        cartransport.loadCars(saab);
    }
    @Test
    public void testLoadCars(){
        assert(cartransport.contain(saab)==true);
    }
    @Test
    public void testUnloadCars(){
        cartransport.loadCars(volvo);
        Saab95 saab2=new Saab95();
        cartransport.loadCars(saab2);
        cartransport.unloadCars(1);
        assert(!cartransport.contain(saab2));

    }
    @Test
    public void testMove(){
        double [] carTransportPos=cartransport.getPos();
        double [] saabPos= saab.getPos();
        cartransport.startEngine();
        cartransport.move();
        assert(!carTransportPos.equals(cartransport.getPos()));
        assert(!saabPos.equals(saab.getPos()));
    }
    @Test
    public void testIsClose(){
        double[]newPos={10,10};
        saab.setPos(newPos);
        assert(!cartransport.isClose(saab));
    }
}
