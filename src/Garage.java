import java.util.ArrayList;
import java.util.List;

public class Garage <A extends Car> implements Loadable <A>{
    private int maxCars;
    private List <A> carsInService=new ArrayList<A>(maxCars);

    public Garage(int maxCars){
        this.maxCars=maxCars;
    }

    @Override
    public void loadCars(A car) {
        int i=0;
        if(carsInService.size()<this.maxCars)
            carsInService.add(car);
        else
            for(A e: carsInService){
                if(e==null) {
                    carsInService.set(i, car);
                    break;
                }
                i++;
        }
    }
    @Override
    public void unloadCars(int n) {
        carsInService.set(n-1,null);
    }
    public void whichCar(int n){
        System.out.println("Bilen på plats "+n+" är: "+carsInService.get(n));
    }

}
