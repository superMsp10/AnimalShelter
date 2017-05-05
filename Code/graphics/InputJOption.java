package graphics;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputJOption {
	public JTextField inputField = new JTextField("Enter input here");
	public JOptionPane pane;
	public JDialog dialog;
	
	public InputJOption(String display, String title) {
		pane = new JOptionPane(display, JOptionPane.QUESTION_MESSAGE);
		pane.add(inputField, 1);
		dialog = pane.createDialog(null, title);
		// the line below is added to the example from the docs
		dialog.setModal(false); // this says not to block background components
		dialog.setContentPane(pane);
		dialog.setVisible(true);
	}
	
	public void showInput(){
		dialog.setVisible(true);
	}
	
	public void closeInput(){
		dialog.setVisible(false);
		dialog.dispose();
	}
	
	public static void showMessage(String text, String title){
		new JOptionPane(text, JOptionPane.INFORMATION_MESSAGE).createDialog(null, title);
	}
	
	
	

}
