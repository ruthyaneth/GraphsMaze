package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class JFileChooserSelectImage extends JFileChooser {

	//------Atributtes-------
	
	private static final long serialVersionUID = 1L;
	private File open;
	private String aux = "";
	private String texto = "";

	//------Builder-------
	
	public JFileChooserSelectImage() {
		super(ConstantsView.TITLE_FILE_CHOOSER);
		showOpenDialog(this);
		open = getSelectedFile();
	}

	//------Methods-------
	
	public String openImage() {
		try {

			if (open != null) {
				FileReader archivos = new FileReader(open);
				BufferedReader lee = new BufferedReader(archivos);
				while ((aux = lee.readLine()) != null) {
					texto += aux + "\n";
				}
				lee.close();
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo", "ADVERTENCIA!!!",
					JOptionPane.WARNING_MESSAGE);
		}
		return texto;
	}
	
public void changeLenguage() throws IOException{
		
		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		
		this.setDialogTitle(handlerProperties.getProperty(ConstantsView.TITLE_FILE_CHOOSER));
	}
}
