package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import constant.ConstantsView;
import controller.Controller;

public class PrinicipalFrame extends JFrame   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu menuBar;
	private PanelOpenImage panelOpenImage;
	
	public PrinicipalFrame(Controller controller) {
		super();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(ConstantsView.WIDTH_WINDOW, ConstantsView.HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
		this.setTitle(ConstantsView.TITLE_APPLICATION);
		menuBar = new Menu(controller);
		this.setJMenuBar(menuBar);
		panelOpenImage = new PanelOpenImage();
		this.add(panelOpenImage);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Menu getMenu() {
		return menuBar;
	}


}
