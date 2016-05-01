package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class PanelOpenImage  extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel label ;
	private JScrollPane scrollPane;
	
	public PanelOpenImage() {
	super();
	this.setBorder(new LineBorder(Color.BLUE));
	label = new JLabel();
	label.setSize(100, 100);
	label.setBorder(new LineBorder(Color.blue));
	scrollPane = new JScrollPane(label);
	this.add(scrollPane, BorderLayout.CENTER);
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
