package view;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsListener;
import constant.ConstantsView;
import controller.Controller;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase  Menu donde estan la opciones de la aplicacion. 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class Menu extends JMenuBar {

	//-----Atributtes------

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
	private Controller controller;

	//-----Builder-----

	public Menu(Controller controller) {
		super();
		this.controller = controller;
		initial();
	}

	//------Methods------

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
			e.printStackTrace();
		}
	}

	private void addMenuFile() {
		this.menuFile = new JMenu();
		this.menuFile.setText(ConstantsView.NAME_MENU_FILE);
		this.add(menuFile);
	}

	private void addItemFileOpenImage() {
		this.itemFileOpenImage = new JMenuItem();
		this.itemFileOpenImage.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_OPEN)));
		this.itemFileOpenImage.setText(ConstantsView.NAME_ITEM_FILE_OPEN_IMAGE);
		this.itemFileOpenImage.setActionCommand(ConstantsListener.ITEM_FILE_OPEN_IMAGE);
		this.itemFileOpenImage.addActionListener(controller);
		this.menuFile.add(itemFileOpenImage);
	}

	public void addItemFileCreateImage() {
		this.itemFileCreateImage = new JMenuItem();
		this.itemFileCreateImage.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_CREATE)));
		this.itemFileCreateImage.setText(ConstantsView.NAME_ITEM_FILE_CREATE_IMAGE);
		this.itemFileCreateImage.setActionCommand(ConstantsListener.ITEM_FILE_CREATE_IMAGE);
		this.itemFileCreateImage.addActionListener(controller);
		this.menuFile.add(itemFileCreateImage);
	}

	private void addItemFileEditImage() {
		this.itemFileEditImage = new JMenuItem();
		this.itemFileEditImage.setText(ConstantsView.NAME_ITEM_FILE_EDIT_IMAGE);
		this.itemFileEditImage.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_EDIT)));
		this.itemFileEditImage.setActionCommand(ConstantsListener.ITEM_FILE_EDIT_IMAGE);
		this.itemFileEditImage.addActionListener(controller);
		this.menuFile.add(itemFileEditImage);
	}

	private void addItemFileCloseApp() {
		this.itemFileCloseApp = new JMenuItem();
		this.itemFileCloseApp.setText(ConstantsView.NAME_ITEM_FILE_CLOSE_APP);
		this.itemFileCloseApp.setActionCommand(ConstantsListener.ITEM_FILE_CLOSE_APP);
		this.itemFileCloseApp.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_EXIT)));
		this.itemFileCloseApp.addActionListener(controller);
		this.menuFile.add(itemFileCloseApp);
	}

	private void addMenuSettup() {
		this.menuSettings = new JMenu();
		this.menuSettings.setText(ConstantsView.NAME_MENU_SETTINGS);
		this.add(menuSettings);
	}

	private void addMenuLanguage() {
		this.menuLanguage = new JMenu();
		this.menuLanguage.setText(ConstantsView.NAME_MENU_LANGUAGE);
		this.menuLanguage.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_CONFIGURATION)));
		this.menuSettings.add(menuLanguage);
	}

	private void addItemLanguageSpanish() {
		this.itemLanguageSpanish = new JMenuItem(ConstantsView.NAME_ITEM_LANGUAGE_SPANISH);
		this.itemLanguageSpanish.addActionListener(controller);
		this.itemLanguageSpanish.setActionCommand(ConstantsListener.ITEM_FILE_LANGUAGE_SPANISH);
		this.menuLanguage.add(itemLanguageSpanish);
	}

	private void addItemLanguageEnglish() {
		this.itemLanguageEnglish = new JMenuItem(ConstantsView.NAME_ITEM_LANGUAGE_ENGLISH);
		this.itemLanguageEnglish.addActionListener(controller);
		this.itemLanguageEnglish.setActionCommand(ConstantsListener.ITEM_FILE_LANGUAGE_ENGLISH);
		this.menuLanguage.add(itemLanguageEnglish);
	}
	public void changeLenguage() throws IOException{

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();

		this.menuFile.setText(handlerProperties.getProperty(ConstantsView.NAME_MENU_FILE));
		this.menuSettings.setText(handlerProperties.getProperty(ConstantsView.NAME_MENU_SETTINGS));
		this.menuLanguage.setText(handlerProperties.getProperty(ConstantsView.NAME_MENU_LANGUAGE));

		this.itemFileOpenImage.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_FILE_OPEN_IMAGE));
		this.itemFileEditImage.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_FILE_EDIT_IMAGE));
		this.itemFileCreateImage.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_FILE_CREATE_IMAGE));
		this.itemFileCloseApp.setText(handlerProperties .getProperty(ConstantsView.NAME_ITEM_FILE_CLOSE_APP));
		this.itemLanguageSpanish.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_LANGUAGE_SPANISH));
		this.itemLanguageEnglish.setText(handlerProperties.getProperty(ConstantsView.NAME_ITEM_LANGUAGE_ENGLISH));
	}



}
