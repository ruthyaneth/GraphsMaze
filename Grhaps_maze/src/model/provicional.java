package model;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import constant.ConstantsListener;
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
public class provicional implements ActionListener{

	//------Atributtes-------

	private JFrame frame;
	private JLabel labelImagen;
	private JButton button;
	private JPanel panelComponentes, panelImagen;
	private JFileChooser fileChooser;
	private Controller controller;

	//-----Builder------
	public provicional(Controller controller, JFileChooser fileChooser){
		this.fileChooser = fileChooser;
		this.controller = new Controller();
		frame = new JFrame("Abrir imagenes");
		frame.getContentPane().setLayout( new BorderLayout() );

		/**Creacion de componentes*/

		//---Labels---
		labelImagen = new JLabel();

		//---Buttons---
		button = new JButton("Abrir archivo");
		button.setActionCommand(ConstantsListener.OPEN);

		//----Panels----
		panelComponentes = new JPanel();
		panelComponentes.setLayout( new BorderLayout() );
		panelComponentes.add(button, BorderLayout.CENTER);
		panelComponentes.setBorder( BorderFactory.createTitledBorder ("Abre la imagen...") );
		frame.add(panelComponentes, BorderLayout.NORTH);
		panelImagen = new JPanel();
		panelImagen.setLayout( new BorderLayout() );
		panelImagen.setBorder( BorderFactory.createTitledBorder ("Visualizacion de la imagen") );
		panelImagen.add( labelImagen, BorderLayout.CENTER);
		frame.add( panelImagen ,BorderLayout.CENTER );
		frame.setVisible(true);
		frame.setBounds(500,200, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(controller);
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
		fileChooser.setFileFilter(filter);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(ConstantsListener.OPEN.equals( e.getActionCommand() ) )
		{                       
			//Valor que tomara el fileChooser
			int regresaValor = fileChooser.showOpenDialog(null);    
			//Accion del fileChooser
			if(regresaValor == JFileChooser.APPROVE_OPTION)
			{
				//Crear propiedades para ser utilizadas por fileChooser
				File archivoElegido = fileChooser.getSelectedFile();
				//Obteniendo la direccion del archivo
				String direccion = archivoElegido.getPath();
				//Bloque try-catch para errores
				try
				{
					//Obtiene la direccion del archivo y lo instancia en icon
					ImageIcon icon = new ImageIcon( direccion );
					//Setea el labelImagen con el archivo obtenido
					labelImagen.setIcon( icon );
				}
				catch(Exception es)
				{
					JOptionPane.showMessageDialog(null, "Upss!! error abriendo la imagen "+ es);
				}
			}
		}
	}
	public JLabel getLabelImagen() {
		return labelImagen;
	}
	public void setLabelImagen(JLabel labelImagen) {
		this.labelImagen = labelImagen;
	}


}