package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;
import controller.Controller;
import model.ReadImage;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION. PRESENTADO A: Ing Helver
 * Valero. PROGRAMACION III
 * 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class PanelViewImage extends JPanel {

	// ------Atributtes-------

		private static final long serialVersionUID = 1L;
	private Controller controller;

	private ReadImage readImage;
	private BufferedImage imagePaintOriginal;

	// -----Builder------
	public PanelViewImage(Controller controller) {
		this.controller = controller;
		String direccion = "";
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png", "bmp", "gif");
		fileChooser.setFileFilter(filter);

		int regresaValor = fileChooser.showOpenDialog(null);

		if (regresaValor == JFileChooser.APPROVE_OPTION) {
			File archivoElegido = fileChooser.getSelectedFile();
			direccion = archivoElegido.getPath();
		}

		try {
			readImage = new ReadImage(direccion);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		imagePaintOriginal = readImage.darImagenBuffer();
		setPreferredSize(new Dimension(imagePaintOriginal.getWidth(), imagePaintOriginal.getHeight()));

		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void binarizarImagen( double umbral )
    {
        if( readImage != null )
        {
            readImage.binarizarImagen( umbral );
            repaint( );
        }
    }

	public void paint(Graphics g) {
		super.paint(g);
		if (readImage != null) {
			imagePaintOriginal = readImage.darImagenBuffer();
			g.drawImage(imagePaintOriginal, 10, 19, null, null);
		}
	}
	

	public ReadImage getReadImage() {
		return readImage;
	}

	public void changeLenguage() throws IOException {

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		this.setBorder(
				BorderFactory.createTitledBorder(handlerProperties.getProperty(ConstantsView.TITLE_PANEL_IMAGE)));
	}
}