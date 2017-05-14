package code.shelter;

import java.util.ArrayList;

import code.MainFile;
import code.graphics.Display;
import code.graphics.Sprite;
import code.shelter.animals.Mammal;

public class AnimalShelter {

	public Sprite background = new Sprite("/Background.png", 800);
	public ArrayList<Mammal> animals = new ArrayList<>();

	int spaceBetween = 150;
	int animalsPerRow;
	int curentMaxRowPos;
	int totalAnimalsOnScreen;

	int yOffMax = 100;
	int scrollRate = 1;
	boolean scrolledBefore;

	public AnimalShelter() {
		animalsPerRow = MainFile.WIDTH / spaceBetween;
		MainFile.SCREEN.setYOffset(yOffMax);
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
		scrollShelter();
	}

	void scrollShelter() {
		if (scrolledBefore) {
			scrollRate++;
		} else {
			scrollRate = 1;
		}

		int addition = 0;
		if (MainFile.thisMain.keyboard.up) {
			addition = -scrollRate;
		}
		if (MainFile.thisMain.keyboard.down) {
			addition = scrollRate;
		}
		if (addition != 0) {
			int newVal = MainFile.SCREEN.getYOffset() + addition;
			if (newVal < yOffMax
					&& newVal > -(curentMaxRowPos - MainFile.HEIGHT)) {
				MainFile.SCREEN.addYOffset(addition);
			}
			scrolledBefore = true;
		} else {
			scrolledBefore = false;
		}
	}

	public void AddAnimal(Mammal m) {
		animals.add(m);
		int x = (animals.size() % animalsPerRow) * spaceBetween;

		int y = animals.size() / animalsPerRow * spaceBetween;
		curentMaxRowPos = y;
		m.setPos(x, y);

	}

}
