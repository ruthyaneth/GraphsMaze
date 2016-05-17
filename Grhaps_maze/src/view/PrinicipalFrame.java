package view;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;
import controller.Controller;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class PrinicipalFrame extends JFrame   {

	private static final long serialVersionUID = 1L;
	private Menu menuBar;
	private ToolBar toolBar;

	public PrinicipalFrame(Controller controller) {
		super();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(ConstantsView.WIDTH_WINDOW, ConstantsView.HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
		menuBar = new Menu(controller);
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		toolBar = new ToolBar(controller);
		this.add(toolBar, BorderLayout.NORTH);
	}
	public Menu getMenu() {
		return menuBar;
	}
	public void changeLenguage() throws IOException{

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		this.setTitle(handlerProperties.getProperty(ConstantsView.TITLE_APPLICATION));
	}
	public ToolBar getToolBar() {
		return toolBar;
	}

}
