package code.graphics;

import java.util.Random;

import code.MainFile;

public class Display {
	public int[] pixels;
	public Random random;
	public int xOffSet = 0;
	public int yOffSet = 0;

	public Display() {
		pixels = new int[MainFile.WIDTH * MainFile.HEIGHT];
		random = new Random();
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 100000;
		}

	}

	public void testRender() {

		for (int y = 0; y < MainFile.HEIGHT; y++) {
			for (int x = 0; x < MainFile.WIDTH; x++) {
				pixels[x + y * MainFile.WIDTH] = random.nextInt();
			}

		}

	}

	public void renderSprite(Sprite sprite, int xstart, int ystart) {
		
		for (int y = 0; y < sprite.Height; y++) {
			int yy = ystart + y;
			if (yy >= MainFile.HEIGHT || yy < 0)
				continue;

			for (int x = 0; x < sprite.Width; x++) {
				int xx = xstart + x;
				if (xx >= MainFile.WIDTH || xx < 0)
					continue;

				int col = sprite.pixels[x + y * sprite.Size];
				if (col != -16777216)
					pixels[xx + yy * MainFile.WIDTH] = col;

			}

		}
	}
	
	public void renderAnimal(Sprite sprite, int xstart, int ystart){
		renderSprite(sprite,  xstart + xOffSet,  ystart + yOffSet);
	}

}
