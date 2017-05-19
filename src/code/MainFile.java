package code;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import code.graphics.Display;
import code.graphics.SidePanel;
import code.shelter.AnimalShelter;
import code.shelter.animals.Mammal;
import input.Keyboard;

public class MainFile extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static MainFile thisMain;

	// Canvas
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	public static int SCALE = 1;

	// JPanels
	public SidePanel sidePanel;
	JFrame frame;
	private Thread thread;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	// Mechanics
	public boolean running = false;

	// Others
	public static Display SCREEN;
	public AnimalShelter shelter;
	public static String title = "Animal House";
	public Keyboard keyboard;

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Welcome to Animal House \nMade by Mahan Pandey \n", "Welcome!",
				JOptionPane.INFORMATION_MESSAGE);

		// Main Frame init
		MainFile main = new MainFile();
		main.start();
		main.addAnimals();

	}

	public MainFile() {
		// Initialize static reference to this instance
		thisMain = this;

		frame = new JFrame();
		SCREEN = new Display();
		sidePanel = new SidePanel();
		FlowLayout layout = new FlowLayout();
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

		setPreferredSize(size);
		requestFocus();

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(layout);
		frame.add(this);
		frame.add(sidePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		frame.setVisible(true);

		keyboard = Keyboard.defKeyboard;
		addKeyListener(keyboard);

		shelter = new AnimalShelter();
	}

	public void addAnimals() {
		try {
			int num = HowMany("Animals", 10);
			if (num == -1)
				return;

			int randomAmount = Integer.parseInt(JOptionPane.showInputDialog(null,
					"How many would you like to randomize: "
							+ "\n-1. All animals \n 0. No animals\n Or enter a positive integer out of " + num,
					title, JOptionPane.QUESTION_MESSAGE));
			boolean random = false;

			for (int i = 0; i < num; i++) {
				switch (randomAmount) {
				case -1:
					random = true;
					break;
				case 0:
					random = false;
					break;
				default:
					if (randomAmount >= num || randomAmount < 0) {
						throw new NumberFormatException(
								"Entered number cannot be less than 0 or higher than the number of animals");
					}

					if ((i + 1) < randomAmount)
						random = true;
					break;
				}
				shelter.AddAnimal(new Mammal(random));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Not an accepted value, retry", title, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public int HowMany(String name, int max) {

		String input = JOptionPane.showInputDialog(null,
				"How many " + name + " would you like?" + "\n-1. Cancel \n 0. Randomize \n Or type a positive integer",
				title, JOptionPane.QUESTION_MESSAGE);
		int num = Integer.parseInt(input);

		if (num != -1) {
			if (num == 0) {
				num = (int) (Math.random() * max);
			} else if (num < 0) {
				throw new NumberFormatException("Entered number cannot be less than 0");
			}
		}

		return num;

	}

	public void run() {

		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();

		final double wantedUpdates = 10000000000.0 / 120.0;
		double delta = 0;
		while (running) {

			render();
			long now = System.nanoTime();
			delta += (now - lastTime) / wantedUpdates;
			lastTime = now;

			while (delta >= 1) {
				update();

				delta--;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}

	}

	public void update() {
		keyboard.update();
		shelter.Update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		SCREEN.clear();
		shelter.Render(SCREEN);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = SCREEN.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();

	}

	private void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
