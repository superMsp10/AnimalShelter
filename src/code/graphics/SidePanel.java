package code.graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.MainFile;

public class SidePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SidePanel() {
		super();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridLayout lay = new GridLayout(2, 1);
		lay.setVgap(10);
		setLayout(lay);
		JButton add = new JButton("Add");
		JButton search = new JButton("Search");

		add(add);
		add(search);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFile.thisMain.addAnimals();
			}
		});

	}

}
