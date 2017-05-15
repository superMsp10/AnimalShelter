package code.graphics;

import java.util.Random;

import code.MainFile;

public class Display {
	public int[] pixels;
	public Random random;
	private int yOffSet = 0;
	private int xOffSet = 50;

	public void addYOffset(int addition) {
		yOffSet += addition;
	}

	public int getYOffset() {
		return yOffSet;
	}

	public void setYOffset(int set) {
		yOffSet = set;
	}

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

				int col = sprite.pixels[x + y * sprite.Width];

				if (col != 0) {
					pixels[xx + yy * MainFile.WIDTH] = col;
				}
			}
		}
	}

	public void renderWithOffset(Sprite sprite, int xstart, int ystart) {
		renderSprite(sprite, xstart + xOffSet, ystart + yOffSet);
	}

}
