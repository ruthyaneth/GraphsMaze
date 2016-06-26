package view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ResourceBundle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;
import controller.Controller;
import persistence.FileUtil;

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
	private CreateWindowMaze create;
	private Controller controller;
	
	
	

	public PrinicipalFrame() {
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.controller = new Controller();
		this.create = new CreateWindowMaze(controller);
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
