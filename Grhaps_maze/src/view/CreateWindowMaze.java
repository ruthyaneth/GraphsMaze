package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JWindow;

import constant.ConstantsView;
import persistence.FileUtil;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase donde se generara el laberinto que el usuario ingrese con su ancho y su alto 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class CreateWindowMaze  extends JDialog{

	//------Atributtes------
	
	private  PanelCreateButton panelCreateButton;
	 private PanelDraw panelDraw;
	 private boolean pintarLaberinto = false;
	 int inicio,fin,filas,columnas,nodos[][];
	 private FileUtil util;
	 //------Builder------
	 
	 public CreateWindowMaze() {
		 
		 load();
		 
	}
	 
	 //------Methods------
	 public void load(){
		 initializateThis();
		 initializatePanelButton();
		 initializatePanelDraw();
	 }
	 
	 public void initializateThis(){
		 this.setTitle(ConstantsView.DEFAUTL_NAME_WINDOW);
		 this.setSize(ConstantsView.DEFAULT_SIZE, ConstantsView.DEFAULT_SIZE);
		 this.setLocationRelativeTo(null);
	 }
	 
	 public void initializatePanelButton(){
		 this.panelDraw = new PanelDraw();
		 this.panelDraw.setBorder(BorderFactory.createTitledBorder("Laberinto"));
		 this.add(panelDraw,BorderLayout.CENTER);
		 
	 }
	 
	 public void initializatePanelDraw(){
		 this.panelCreateButton = new PanelCreateButton();
		 this.panelCreateButton.setBorder(BorderFactory.createTitledBorder("Opciones"));
		 this.add(panelCreateButton,BorderLayout.SOUTH);
	 }
	 
	 /**
	  * Metodo que me toca mirar algunas cosas que no pienso que vaya ahi 
	  */
	 
	 public void read(InputStream input , String file , boolean openEditor){
		 
		String line = "";
		BufferedReader buffer;
		 //me falta mete la parte del grafo 
		pintarLaberinto =! openEditor;
		try {
			buffer = new BufferedReader(new InputStreamReader(input));
			filas = Integer.parseInt(buffer.readLine());
			columnas = Integer.parseInt(buffer.readLine());
			inicio = Integer.parseInt(buffer.readLine());
			fin = Integer.parseInt(buffer.readLine());
			int total = filas* columnas ;
			//nodos 
			//Nodo
			//Clase Principal linea 306
			for (int i = 0; i < total; i++) {
				line = buffer.readLine();
				String[] numeros = line.trim().split(" ") ; // BUSCAR QUE ES UN TRIM 
				int nodoNumber = Integer.parseInt(numeros[0]);
				//Linea de atributo de Nodo linea 314 clase principal
				for (int j = 0; j < numeros.length; j++) {
				//linea de clase principal node linea 317
				//318
				int nVecinos = Integer.parseInt(numeros[j]);
				//322
				//323
				}
			}
		} catch (Exception e) {
			
		}
		
		 
	 }
	 
	 public void readFile(File file , boolean openEditor){
		 
		 
	 }
	
}
