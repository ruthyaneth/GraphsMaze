package model;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.PanelOpenImage;

public class provicional {

	private PanelOpenImage panelOpenImage;
	private JFileChooser fileChooser;

	public provicional() {


		panelOpenImage = new PanelOpenImage();
		panelOpenImage.setLayout(new BorderLayout());
		panelOpenImage.setBorder(BorderFactory.createTitledBorder("Visualizacion de la imagen"));

		
	}

	public void showFile() {
		
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
		fileChooser.setFileFilter(filter);
		
		int regresaValor = fileChooser.showOpenDialog(null);
		if (regresaValor == JFileChooser.APPROVE_OPTION) {
			File archivoElegido = fileChooser.getSelectedFile();
			String direccion = archivoElegido.getPath();
			try {
				ImageIcon icon = new ImageIcon(direccion);
				panelOpenImage.getLabel().setIcon(icon);
			} catch (Exception es) {
				JOptionPane.showMessageDialog(null, "Upss!! error abriendo la imagen " + es);
			}
		}
	}

}