package code.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = getIntFromColor(c.getRed(), c.getGreen(), c.getBlue()) * c.getAlpha();
		}
		System.out.println("pixel@ 0,0 : " + pixels[0] + c);
	}

	public Sprite(String text) {
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		Font font = new Font("Arial", Font.PLAIN, 24);
		g2d.setFont(font);

		// Get height and width
		FontMetrics fm = g2d.getFontMetrics();
		Size = Width = fm.stringWidth(text);
		Height = fm.getHeight();
		g2d.dispose();

		// Render text into image
		image = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setFont(font);
		fm = g2d.getFontMetrics();
		g2d.setColor(Color.WHITE);
		g2d.drawString(text, 0, fm.getAscent());
		g2d.dispose();

		pixels = new int[Width * Height];
		image.getRGB(0, 0, Width, Height, pixels, 0, Width);
	}

	public int getIntFromColor(float Red, float Green, float Blue) {
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
