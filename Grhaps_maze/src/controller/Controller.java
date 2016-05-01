package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import config.HandlerLanguage;
import constant.ConstantsListener;
import view.JFileChooserSelectImage;
import view.PrinicipalFrame;

public class Controller implements ActionListener {

	private HandlerLanguage handlerLanguage;
	private PrinicipalFrame frame;
	private JFileChooserSelectImage fileChooser;

	public Controller() {
		loadConfiguration();
		
	}

	public void show() {
		frame = new PrinicipalFrame(this);
		frame.setVisible(true);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeToSpanish() {
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language = "language/languageEs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantsListener.ITEM_FILE_OPEN_IMAGE:
			showFileChooser();
			System.out.println("ESta escuchandp");
			break;
		case ConstantsListener.ITEM_FILE_CREATE_IMAGE:
			System.out.println("escucha create");
;
		case ConstantsListener.ITEM_FILE_EDIT_IMAGE:
			System.out.println("edit");
			break;
		case ConstantsListener.ITEM_FILE_CLOSE_APP:
			System.out.println("escucho close");
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
	
	private void showFileChooser(){
		fileChooser = new JFileChooserSelectImage();
		fileChooser.openImage();
	}

}
