public class SuperBike extends Bike{
    private double speed;
    private int wheels;
    private String color, modelbrand;
    public double speed(){return this.speed;}
    public String color(){return this.color;}
    public int wheels(){return this.wheels;}
    public String modelbrand(){return this.modelbrand;}

    public void accelerate(double c){this.speed+=c;}
    public void brake(double c){this.speed-=c;}
    SuperBike(String modelbrand, String color, int wheels){
        super(modelbrand,color,wheels);
    }
}
