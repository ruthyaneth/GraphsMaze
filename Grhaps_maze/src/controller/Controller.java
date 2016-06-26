package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;


import config.HandlerLanguage;
import constant.ConstantsListener;
import view.PrinicipalFrame;
import view.CreateWindowMaze;
import view.PanelDrawTablero;
import view.PanelViewImage;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero. 
 * PROGRAMACION III 
 * Clase donde se encuenta el manejador de eventos
 * @author  Jenny Quesada , Ruth Rojas
 */
public class Controller implements ActionListener {

	// ------Atributtes-----

	private HandlerLanguage handlerLanguage;
	private PrinicipalFrame frame;
	private PanelViewImage provicional;
	private CreateWindowMaze createWindow;

	// ------Builder------

	public Controller() {
		loadConfiguration();
	}

	// -----Methods-----

	public void show() {
		frame = new PrinicipalFrame();
		frame.setVisible(true);

	}

	public void showWindowCreate() {

		this.createWindow = new CreateWindowMaze(this);
		this.createWindow.setVisible(true);
	}

	public void loadConfiguration() {
		if (handlerLanguage == null) {
			handlerLanguage = new HandlerLanguage("language/config.ini");
			try {
				handlerLanguage.loadLanguage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(HandlerLanguage.language);
		}
	}
	private void showFileChooser() {
		provicional = new PanelViewImage(this);
		frame.add(provicional);
		provicional.updateUI();
		provicional.binarizarImagen(122.0);
	}
	public void changeToEnglish() {
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language = "language/languageUs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
			frame.getToolBar().changeLenguage();
			frame.changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void changeToSpanish() {
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language = "language/languageEs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
			frame.getToolBar().changeLenguage();
			frame.changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantsListener.ITEM_FILE_OPEN_IMAGE:
			showFileChooser();
			break;
		case ConstantsListener.ITEM_FILE_CREATE_IMAGE:
			showWindowCreate();
			break;
		case ConstantsListener.ITEM_FILE_EDIT_IMAGE:
			System.out.println("edit");
			break;
		case ConstantsListener.ITEM_FILE_CLOSE_APP:
			System.exit(0);
			break;
		case ConstantsListener.ITEM_FILE_LANGUAGE_SPANISH:
			changeToSpanish();
			break;
		case ConstantsListener.CREATE_MAZE :
			System.out.println("Hola Jenny Paola Quesada Hernandez");
			createWindow.generateMaze();
			break;
		case ConstantsListener.ITEM_FILE_LANGUAGE_ENGLISH:
			changeToEnglish();
			
//		case ConstantsListener.CREATE_MAZE :
//			System.out.println("Hola Jenny Paola Quesada Hernandez");
//			createWindow.generateMaze();
//			break
			
		}
	}
}
