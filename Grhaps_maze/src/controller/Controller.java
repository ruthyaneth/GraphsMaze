package controller;

import java.io.IOException;

import config.HandlerLanguage;
import view.PrinicipalFrame;

public class Controller {

	private HandlerLanguage handlerLanguage;
	private PrinicipalFrame frame;

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
	public void changeToEnglish(){
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language= "language/languageUs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeToSpanish(){
		HandlerLanguage handlerLanguage = new HandlerLanguage("language/config.ini");
		try {
			handlerLanguage.language= "language/languageEs.properties";
			handlerLanguage.setLanguage();
			frame.getMenu().changeLenguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
