package view;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.HandlerLanguage;
import config.HandlerProperties;
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
		try {
			changeLenguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(ConstantsView.WIDTH_WINDOW, ConstantsView.HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
		menuBar = new Menu(controller);
		this.setJMenuBar(menuBar);
		panelOpenImage = new PanelOpenImage();
		this.add(panelOpenImage);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Menu getMenu() {
		return menuBar;
	}
public void changeLenguage() throws IOException{
		
		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		this.setTitle(handlerProperties.getProperty(ConstantsView.TITLE_APPLICATION));
}


}
