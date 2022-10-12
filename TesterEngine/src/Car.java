
public class Car implements Vehicle{
	private String color;
	private String modelbrand;
	private double speed;
	private int wheels;
	public double speed() {
		return this.speed;
	}
	
	public void accelerate(double c){
		this.speed+=c;
	}
	public void brake(double c){
		this.speed-=c;
	}
	public String color() {
		return this.color;
	}
	public String modelbrand() {
		return this.modelbrand;
	}
	
	public int wheels() {
		return this.wheels;
	}
	
	Car(String modelbrand, String color, int wheels){
		this.modelbrand=modelbrand;
		this.color=color;
		this.wheels=wheels;
	}
	public boolean airbags;
}
