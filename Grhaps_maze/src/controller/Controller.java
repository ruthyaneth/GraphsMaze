package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import config.HandlerLanguage;
import constant.ConstantsListener;
import model.provicional;
import view.PrinicipalFrame;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase donde se encuenta el manejador de evento d e los botones. 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class Controller implements ActionListener {

	//------Atributtes-----
	
	private HandlerLanguage handlerLanguage;
	private PrinicipalFrame frame;
	private JFileChooser fileChooser;

	//------Builder------
	
	public Controller() {
		loadConfiguration();
		fileChooser = new JFileChooser();
	}

	//-----Methods-----
	
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
			e.printStackTrace();
		}
	}
	
	private void showFileChooser() {
		provicional provicional = new provicional(this, fileChooser);
		// Valor que tomara el fileChooser
		this.fileChooser = fileChooser;
		int regresaValor = fileChooser.showOpenDialog(null);
		// Accion del fileChooser
		if (regresaValor == JFileChooser.APPROVE_OPTION) {
			// Crear propiedades para ser utilizadas por fileChooser
			File archivoElegido = fileChooser.getSelectedFile();
			// Obteniendo la direccion del archivo
			String direccion = archivoElegido.getPath();
			// Bloque try-catch para errores
			try {
				// Obtiene la direccion del archivo y lo instancia en icon
				ImageIcon icon = new ImageIcon(direccion);
				// Setea el labelImagen con el archivo obtenido
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
		case ConstantsListener.OPEN:

		}
	}

	

	

}
