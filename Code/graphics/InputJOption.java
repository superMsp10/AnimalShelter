package graphics;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputJOption extends JOptionPane {
	JTextField inputField = new JTextField("Enter input here");

	private static final long serialVersionUID = 1L;
	
	public InputJOption(){
		add(inputField);
	}

}
