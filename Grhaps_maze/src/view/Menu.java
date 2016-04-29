package view;

import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsListener;
import constant.ConstantsView;
import controller.Controller;

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu menuFile;
	private JMenuItem itemFileOpenImage;
	private JMenuItem itemFileCreateImage;
	private JMenuItem itemFileEditImage;
	private JMenuItem itemFileCloseApp;
	private JMenu menuSettings;
	private JMenu menuLanguage;
	private JMenuItem itemLanguageSpanish;
	private JMenuItem itemLanguageEnglish;

	public Menu(Controller controller) {
		super();
		initial();
	}

	private void initial() {
		addMenuFile();
		addItemFileOpenImage();
		addItemFileCreateImage();
		addItemFileEditImage();
		addItemFileCloseApp();
		addMenuSettup();
		addMenuLanguage();
		addItemLanguageSpanish();
		addItemLanguageEnglish();
		try {
			changeLenguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addMenuFile() {
		menuFile = new JMenu();
		menuFile.setText(ConstantsView.NAME_MENU_FILE);
		this.add(menuFile);
	}

	private void addItemFileOpenImage() {
		itemFileOpenImage = new JMenuItem();
		itemFileOpenImage.setText(ConstantsView.NAME_ITEM_FILE_OPEN_IMAGE);
		itemFileOpenImage.setActionCommand(ConstantsListener.ITEM_FILE_OPEN_IMAGE);
		menuFile.add(itemFileOpenImage);
	}

	public void addItemFileCreateImage() {
		itemFileCreateImage = new JMenuItem();
		itemFileCreateImage.setText(ConstantsView.NAME_ITEM_FILE_CREATE_IMAGE);
		menuFile.add(itemFileCreateImage);
	}

	private void addItemFileEditImage() {
		itemFileEditImage = new JMenuItem();
		itemFileEditImage.setText(ConstantsView.NAME_ITEM_FILE_EDIT_IMAGE);
		menuFile.add(itemFileEditImage);
	}

	private void addItemFileCloseApp() {
		itemFileCloseApp = new JMenuItem();
		itemFileCloseApp.setText(ConstantsView.NAME_ITEM_FILE_CLOSE_APP);
		menuFile.add(itemFileCloseApp);
	}

	private void addMenuSettup() {
		menuSettings = new JMenu();
		menuSettings.setText(ConstantsView.NAME_MENU_SETTINGS);
		this.add(menuSettings);
	}

	private void addMenuLanguage() {
		menuLanguage = new JMenu();
		menuLanguage.setText(ConstantsView.NAME_MENU_LANGUAGE);
		menuSettings.add(menuLanguage);
	}

	private void addItemLanguageSpanish() {
		itemLanguageSpanish = new JMenuItem(ConstantsView.NAME_ITEM_LANGUAGE_SPANISH);
		menuLanguage.add(itemLanguageSpanish);
	}

	private void addItemLanguageEnglish() {
		itemLanguageEnglish = new JMenuItem(ConstantsView.NAME_ITEM_LANGUAGE_ENGLISH);
		menuLanguage.add(itemLanguageEnglish);
	}
	public void changeLenguage() throws IOException{
		
		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		
		menuFile.setText(handlerProperties.getProperty(ConstantsView.NAME_MENU_FILE));
		menuSettings.setText(handlerProperties.getProperty(ConstantsView.NAME_MENU_SETTINGS));
		menuLanguage.setText(handlerProperties.getProperty(ConstantsView.NAME_MENU_LANGUAGE));
		
		itemFileOpenImage.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_FILE_OPEN_IMAGE));
		itemFileEditImage.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_FILE_EDIT_IMAGE));
		itemFileCreateImage.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_FILE_CREATE_IMAGE));
		itemFileCloseApp.setText(handlerProperties .getProperty(ConstantsView.NAME_ITEM_FILE_CLOSE_APP));
		itemLanguageSpanish.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_LANGUAGE_SPANISH));
		itemLanguageEnglish.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_LANGUAGE_ENGLISH));
	}
	


}
