package code.graphics;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SidePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SidePanel(){
		super();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridLayout lay = new GridLayout(2, 1);
		lay.setVgap(10);
		setLayout(lay);
		add(new JButton("Add"));
		add(new JButton("Search"));

	}

}
