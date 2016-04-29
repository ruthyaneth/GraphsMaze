package view;

import javax.swing.JFrame;


import constant.ConstantsView;
import controller.Controller;

public class PrinicipalFrame extends JFrame   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu menuBar;
	
	public PrinicipalFrame(Controller controller) {
		super();
		this.setSize(ConstantsView.WIDTH_WINDOW, ConstantsView.HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
		this.setTitle(ConstantsView.TITLE_APPLICATION);
		menuBar = new Menu(controller);
		this.setJMenuBar(menuBar);
		
	}
	public Menu getMenu() {
		return menuBar;
	}


}
