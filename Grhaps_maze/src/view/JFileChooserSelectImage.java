package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import constant.ConstantsView;

public class JFileChooserSelectImage extends JFileChooser {

	private static final long serialVersionUID = 1L;
	File abre;
	String aux = "";
	String texto = "";

	public JFileChooserSelectImage() {
		super(ConstantsView.TITLE_FILE_CHOOSER);
		showOpenDialog(this);
		abre = getSelectedFile();
	}

	public String openImage() {
		try {

			if (abre != null) {
				FileReader archivos = new FileReader(abre);
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
}
