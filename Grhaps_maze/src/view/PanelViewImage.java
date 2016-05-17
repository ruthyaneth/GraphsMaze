package view;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;
import controller.Controller;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class PanelViewImage extends JPanel {

	//------Atributtes-------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelImagen;
	private Controller controller;

	//-----Builder------
	public PanelViewImage(Controller controller, JFileChooser fileChooser){
		
		//---Labels---
		labelImagen = new JLabel();

		this.add( labelImagen, BorderLayout.CENTER);
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
		fileChooser.setFileFilter(filter);
		try {
			changeLenguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JLabel getLabelImagen() {
		return labelImagen;
	}
	public void setLabelImagen(JLabel labelImagen) {
		this.labelImagen = labelImagen;
	}
public void changeLenguage() throws IOException{
		
		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		
		this.setBorder(BorderFactory.createTitledBorder (handlerProperties.getProperty(ConstantsView.TITLE_PANEL_IMAGE)));
	}

}