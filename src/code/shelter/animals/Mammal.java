package code.shelter.animals;

import java.util.Random;

import javax.swing.JOptionPane;

import code.MainFile;
import code.graphics.Display;
import code.graphics.Sprite;

public class Mammal {
	public static String Genders[] = { "Male", "Female", "Trans" };
	public static String Names[] = { "Abby", "Bob", "Jung", "Katy", "Purry", "Jones", "Vincent" };
	public static String title = "Dogs: Mammal";
	public String name;
	protected int itsAge;
	protected double itsWeight;
	private String breed;
	private String gender;
	public Sprite thisSprite = Sprite.defualt;
	public Sprite namePlate;

	private int x, y;
	int xOff, yOff;
	Random r = new Random();

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public void setPos(int _x, int _y) {
		x = _x;
		y = _y;
	}

	public Mammal(boolean randomize, int x, int y) {
		setAttributes(randomize);
		this.x = x;
		this.y = y;
		namePlate = new Sprite(name);
	}

	public Mammal(boolean randomize) {
		setAttributes(randomize);
		namePlate = new Sprite(name);
	}

	void setAttributes(boolean randomize) {
		if (randomize) {
			gender = Genders[(int) (Math.random() * (Genders.length - 1))];
			name = Names[(int) (Math.random() * (Names.length - 1))];
		} else {
			name = JOptionPane.showInputDialog(null, "Name? Type a good name!", title, JOptionPane.QUESTION_MESSAGE);
			itsAge = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Age? Type in any number", title, JOptionPane.QUESTION_MESSAGE));
			itsWeight = Double.parseDouble(JOptionPane.showInputDialog(null, "Weight? Type in any number", title,
					JOptionPane.QUESTION_MESSAGE));
			gender = JOptionPane.showInputDialog(null, "Gender? Type Male or Female", title,
					JOptionPane.QUESTION_MESSAGE);
		}
	}

	public void Render(Display screen) {
		screen.renderWithOffset(thisSprite, x + xOff, y + yOff);
		screen.renderWithOffset(namePlate, x, y + thisSprite.Size/2);

	}

	public void Update() {
		if (r.nextInt(10) == 1) {
			int yOnScreen = y + MainFile.SCREEN.getYOffset();
			if (yOnScreen > 0 && yOnScreen < MainFile.HEIGHT) {
				xOff = r.nextInt(10) - 5;
				yOff = r.nextInt(10) - 5;
			}
		}
	}

	public void edit() {
		setAge(Integer.parseInt(
				JOptionPane.showInputDialog(null, "Age? Type in any number", title, JOptionPane.QUESTION_MESSAGE)));
		setWeight(Double.parseDouble(
				JOptionPane.showInputDialog(null, "Weight? Type in any number", title, JOptionPane.QUESTION_MESSAGE)));
	}

	public int getAge() {
		return itsAge;
	}

	public String getGender() {
		return gender;
	}

	public double getWeight() {
		return itsWeight;
	}

	public void setAge(int newAge) {
		itsAge = newAge;
	}

	public void setWeight(double newWeight) {
		itsWeight = newWeight;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String newBreed) {
		breed = newBreed;
	}

	public void speak() {
		// will be overwritten by Dog class and Cat class
	}

	public String ToString() {
		String s = "Mammal: \n";
		s += "Name: " + name + " \n";
		s += "Age: " + itsAge + " \n";
		s += "Weight: " + itsWeight + " \n";
		s += "Gender: " + gender + "  \n";
		return s;
	}

}