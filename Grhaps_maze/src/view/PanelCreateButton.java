package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import constant.ConstantsView;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase del panel donde se encuntra las opciones de dibujar o resolver  el laberinto
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class PanelCreateButton extends JPanel {

	//------Atributtes-------
	
	private JButton buttonCreate;
	private JButton buttonSolve;
	
	//------Builder------
	
	public PanelCreateButton() {
	load();
	}
	//------Methods-------
	
	public void load(){
		initializateThis();
		initializateButtonCreate();
		initialzateButtonSolve();
	}
	public void initializateThis(){
		this.setLayout(new GridLayout(1,2));
	}
	public void initializateButtonCreate(){
		this.buttonCreate = new JButton(ConstantsView.DEFAULT_BUTTON_CREATE);
		this.add(buttonCreate);
	}
	
	public void initialzateButtonSolve(){
		this.buttonSolve = new JButton(ConstantsView.DEFAULT_BUTTON_SOLVE);
		this.add(buttonSolve);
	}
	
	//-------Gets&Sets-------
	
}
