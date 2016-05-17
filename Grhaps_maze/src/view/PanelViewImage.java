package view;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 *NO SE PARA QUE ES 
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
		

		/**Creacion de componentes*/

		//---Labels---
		labelImagen = new JLabel();

		//---Buttons---

		//----Panels----
		this.setBorder( BorderFactory.createTitledBorder ("Visualizacion de la imagen") );
		this.add( labelImagen, BorderLayout.CENTER);
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
		fileChooser.setFileFilter(filter);
	}
	
	public JLabel getLabelImagen() {
		return labelImagen;
	}
	public void setLabelImagen(JLabel labelImagen) {
		this.labelImagen = labelImagen;
	}


}