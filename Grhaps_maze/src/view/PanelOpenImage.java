package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelOpenImage  extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel label ;
	public PanelOpenImage() {
	super();
	this.setBorder(new LineBorder(Color.BLUE));
	label = new JLabel();
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
