public class Main {
    public static void main (String[] args){
        Volvo240 bil1=new Volvo240();
        bil1.startEngine();
        Saab95 Hilda=new Saab95();
        bil1.startEngine();
        bil1.move();
        bil1.getCurrentSpeed();
        bil1.stopEngine();
        bil1.getCurrentSpeed();
        bil1.incrementSpeed(1.2);

    }
}

