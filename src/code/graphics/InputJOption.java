package code.graphics;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InputJOption extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextArea textDisplay;
	public JTextField textfield = new JTextField(10);
	private JButton confirmBtn = new JButton("Confirm");
	
	ActionListener linstener;

	public InputJOption(JFrame frame, String display, String title) {
		
		super(frame, title, false);
		JPanel panel = new JPanel();
		EmptyBorder b = new EmptyBorder(5, 5, 5, 5);
		panel.setBorder(b);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		confirmBtn.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		textDisplay = new JTextArea(display);
		textDisplay.setFont(textDisplay.getFont().deriveFont(18.0f));
		textDisplay.setEditable(false);
		textDisplay.setBorder(b);

		panel.add(textDisplay);
		panel.add(textfield);
		JLabel l = new JLabel();
		l.setBorder(b);
		panel.add(l);
		panel.add(confirmBtn);
		
		add(panel);
		pack();
		setResizable(false);
		setLocationRelativeTo(frame);
	}

	public String getTextFieldText() {
		return textfield.getText();
	}

	public void addConfirmListener(ActionListener listener) {
		confirmBtn.addActionListener(listener);
	}


}
