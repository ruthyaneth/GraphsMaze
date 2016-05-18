package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JWindow;

import constant.ConstantsView;

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
	
	 PanelCreateButton panelCreateButton;
	 PanelDraw panelDraw;
	 
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
	 
	
}
