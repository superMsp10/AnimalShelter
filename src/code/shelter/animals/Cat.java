package code.shelter.animals;

public class Cat extends Mammal {
  public Cat(boolean randomize, int x, int y) {
		super(randomize,x,y);
		// TODO Auto-generated constructor stub
	}

public void speak() {
    System.out.println("Meow!!!");
  }
}