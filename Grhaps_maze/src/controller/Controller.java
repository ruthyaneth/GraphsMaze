package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import config.HandlerLanguage;
import constant.ConstantsListener;
import view.PrinicipalFrame;
import view.CreateWindowMaze;
import view.PanelViewImage;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION. PRESENTADO A: Ing Helver
 * Valero. PROGRAMACION III Clase donde se encuenta el manejador de evento d e
 * 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
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
		frame = new PrinicipalFrame(this);
		frame.setVisible(true);

	}

	public void showWindowCreate() {

		this.createWindow = new CreateWindowMaze();
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

	private void showFileChooser() {
		provicional = new PanelViewImage(this);
		frame.add(provicional);
		provicional.updateUI();
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
		case ConstantsListener.ITEM_FILE_LANGUAGE_ENGLISH:
			changeToEnglish();
			break;
		}
	}
}
