package view;

import javax.swing.JFrame;


import constant.Constants;

public class PrinicipalFrame extends JFrame   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar;
	
	public PrinicipalFrame() {
		super();
		this.setSize(Constants.WIDTH_WINDOW, Constants.HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
		this.setTitle(Constants.TITLE_APPLICATION);
		menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		
	}

}
