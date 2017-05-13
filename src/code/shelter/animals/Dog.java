package code.shelter.animals;

public class Dog extends Mammal {
  public Dog(boolean randomize, int x, int y) {
		super(randomize,x,y);
		// TODO Auto-generated constructor stub
	}

public void speak() {
    System.out.println("BARK!!!");
  }

  //Unique method for Dog Class
  public void wagTail() {
    System.out.println("Tail Wagging...");
  }
}

