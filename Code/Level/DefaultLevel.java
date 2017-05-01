package Level;

import java.util.ArrayList;

import Animals.Mammal;
import Code.MainFile;
import graphics.Display;
import graphics.Sprite;

public class DefaultLevel {

	public Sprite background = new Sprite("/Background.png", 800);
	int numberofClouds = 10;
	Sprite s;
	public ArrayList<Mammal> animals = new ArrayList<>();

	int spaceBetween = 150;
	int animalsPerRow;

	public DefaultLevel() {
		animalsPerRow = MainFile.WIDTH / spaceBetween;
	}

	public void Render(Display screen) {
		screen.renderSprite(background, 0, 0);

		for (Mammal m : animals) {
			m.Render(screen);
		}
	}

	public void Update() {
		for (Mammal m : animals) {
			m.Update();
		}
	}

	public void AddAnimal(Mammal m) {
		animals.add(m);
		int x = (animals.size() % animalsPerRow);
				
		int y = animals.size()/animalsPerRow;
		m.setPos(x * spaceBetween + spaceBetween/3, y * spaceBetween + (int)(spaceBetween/1.5));
		
	}

}
