package graphics;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputJOption extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel textDisplay;
	private JTextField textfield = new JTextField(10);
	private JButton confirmBtn = new JButton("Confirm");

	public InputJOption(JFrame frame, String display, String title) {
		super(frame, title, false);
		JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout(panel, BoxLayout.Y_AXIS));
		textDisplay = new JLabel(display);

		panel.add(textDisplay);
		panel.add(textfield);
		panel.add(confirmBtn);

		add(panel);
		pack();
		setLocationRelativeTo(frame);
	}

	public String getTextFieldText() {
		return textfield.getText();
	}

	public void addConfirmListener(ActionListener listener) {
		confirmBtn.addActionListener(listener);
	}

}
