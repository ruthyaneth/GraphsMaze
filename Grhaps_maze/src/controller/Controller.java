package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import config.HandlerLanguage;
import constant.ConstantsListener;
import drawMaze.MazeCreator;
import view.PrinicipalFrame;
import view.CreateWindowMaze;
import view.PanelViewImage;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION. PRESENTADO A: Ing Helver
 * Valero. PROGRAMACION III Clase donde se encuenta el manejador de evento d e 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class Controller implements ActionListener {

	// ------Atributtes-----

	private HandlerLanguage handlerLanguage;
	private PrinicipalFrame frame;
	private JFileChooser fileChooser;
	private PanelViewImage provicional;
	private CreateWindowMaze createWindow;

	// ------Builder------

	public Controller() {
		loadConfiguration();
		fileChooser = new JFileChooser();
	}

	// -----Methods-----

	public void show() {
		frame = new PrinicipalFrame(this);
		frame.setVisible(true);
	}
	
	public void showWindowCreate(){
		
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
			provicional.changeLenguage();
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
			provicional.changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showFileChooser() {
		provicional = new PanelViewImage(this, fileChooser);
		frame.add(provicional);
		int regresaValor = fileChooser.showOpenDialog(null);
		if (regresaValor == JFileChooser.APPROVE_OPTION) {
			File archivoElegido = fileChooser.getSelectedFile();
			String direccion = archivoElegido.getPath();
			try {
				ImageIcon icon = new ImageIcon(direccion);
				provicional.getLabelImagen().setIcon(icon);
			} catch (Exception es) {
				JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + es);
			}
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
}
