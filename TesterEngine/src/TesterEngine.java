
public class TesterEngine {


	public static void main(String[] args) {
		Vehicle Bora=new Car("VOlkwagen","Red",4);
		System.out.println(Bora.speed());
		Bora.accelerate(10);
		System.out.println(Bora.speed());
		Bora.brake(4);
		System.out.println(Bora.speed());
		Bora= new Bike("Yamaha","Black",2);
		System.out.println(Bora.speed());
		Bora.accelerate(10);
		Bora.brake(4);
		System.out.println(Bora.speed());
		Bora= new SuperBike("YamahaSuper","SuperBlack",3);
		System.out.println(Bora.speed());
		Bora.accelerate(10);
		Bora.brake(4);
		System.out.println(Bora.speed());
	}



}
