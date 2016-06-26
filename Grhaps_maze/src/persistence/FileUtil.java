package persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import com.sun.xml.internal.ws.api.Component;

import logic.Box;


/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase  donde se creara los archivos para guardar las coordenas de los laberintos generados por el usuario   // MODIFICAR 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */

public class FileUtil{
	
	//-------Atributtes------

	private ResourceBundle resource = ResourceBundle.getBundle("resources.textos", Locale.getDefault());
	private MessageFormat formatter = new MessageFormat("");
	
	//------Builder------
	public FileUtil() {
		//Mirar que tiene el constructor 
	}
	
	//------Methods-------
	
	public String mesagge(String key , Object[] object){
		formatter.applyPattern(resource.getString(key));
		return formatter.format(object);
	}
	
	public void showMessagger(Component parent , String string){
		JOptionPane.showMessageDialog((java.awt.Component) parent, string, "Error",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void save(File file, Box[][] casillas, int inicio,int fin) {
		System.out.println("Argentina");
		int filas = casillas.length;
		int columnas = casillas[0].length;
		
		if (!file.isFile()) {
			try {
				if (!file.createNewFile()) {
				showMessagger(null,mesagge("mensajes.error.archivo_no_crear", new Object[]{file.getName()}));
				}
			} catch (IOException e) {
				showMessagger(null, mesagge("mensajes.error.archivo_no_crear",new Object[]{file.getName()}));
			}
		}
		
		if (file.canWrite()) {
			Box box = null;
			try {
				PrintStream ps = new PrintStream(new FileOutputStream(file));
				ps.println(filas);
				ps.println(columnas);
				ps.println(inicio);
				ps.println(fin);
				String str = null;
				for (int i = 0; i < filas; i++) {
					for (int j = 0; j < columnas; j++) {
						box = casillas[i][j];
						str = box.getNumber() + "";
						if (box.tieneVecinoSup()) {
							str += " " + casillas[i - 1][j].getNumber();
						}
						if (box.tieneVecinoIzq()) {
							str += " " + casillas[i][j - 1].getNumber();
						}
						if (box.tieneVecinoDer()) {
							str += " " + casillas[i][j + 1].getNumber();
						}
						if (box.tieneVecinoInf()) {
							str += " " + casillas[i + 1][j].getNumber();
						}
						ps.println(str);
					}
				}

			} catch (IOException e) {
				showMessagger(null, mesagge(
						"mensajes.error.archivo_no_guardar",
						new Object[] { file.getName() }));
			}
		} else {
			showMessagger(null, mesagge(
					"mensajes.error.archivo_no_permisos",
					new Object[] { file.getName() }));
		}
	}

	public ResourceBundle getResource() {
		return resource;
	}

	public void setResource(ResourceBundle resource) {
		this.resource = resource;
	}

	public MessageFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(MessageFormat formatter) {
		this.formatter = formatter;
	}
	
}
