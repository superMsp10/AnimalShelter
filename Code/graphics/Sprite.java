package graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	public static Sprite defualt = new Sprite(Color.BLUE, 100);

	
	public final int[] pixels;
	public int x, y;
	public final int Width;
	public final int Height;
	public final int Size;
	public int col;
	private String path;

	public Sprite(String path, int size) {
		Size = size;
		Width = size;
		Height = size;
		this.path = path;
		pixels = new int[size * size];
		load();
		System.out.println("pixel@ 0,0 : " + pixels[0] + path);
	}
	
	public Sprite(Color c, int size) {
		Size = size;
		Width = size;
		Height = size;
		pixels = new int[size * size];
		
		for(int i = 0; i < pixels.length; i ++){
			pixels[i] = getIntFromColor(c.getRed(), c.getGreen(), c.getBlue()) * c.getAlpha();
		}
		System.out.println("pixel@ 0,0 : " + pixels[0] + c);
	}
	
	public int getIntFromColor(float Red, float Green, float Blue){
	    int R = Math.round(255 * Red);
	    int G = Math.round(255 * Green);
	    int B = Math.round(255 * Blue);

	    R = (R << 16) & 0x00FF0000;
	    G = (G << 8) & 0x0000FF00;
	    B = B & 0x000000FF;

	    return 0xFF000000 | R | G | B;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(Sprite.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
