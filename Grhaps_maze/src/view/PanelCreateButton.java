package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
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
	private JButton buttonClose;
	
	//------Builder------
	
	public PanelCreateButton() {
	load();
	}
	//------Methods-------
	
	public void load(){
		initializateThis();
		initializateButtonCreate();
		initialzateButtonSolve();
		initializateButtonClose();
	}
	
	public void initializateThis(){
		this.setLayout(new GridLayout(1,3));
	}
	
	public void initializateButtonCreate(){
		this.buttonCreate = new JButton(ConstantsView.DEFAULT_BUTTON_CREATE);
		this.buttonCreate.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_CREATE)));
		this.add(buttonCreate);
	}
	
	public void initialzateButtonSolve(){
		this.buttonSolve = new JButton(ConstantsView.DEFAULT_BUTTON_SOLVE);
		this.buttonSolve.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_SOLVE)));
		this.add(buttonSolve);
	}
	
	public void initializateButtonClose(){
		this.buttonClose = new JButton(ConstantsView.DEFAULT_BUTTON_CLOSE);
		this.buttonClose.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_EXIT)));
		this.add(buttonClose);
	}
	
	//-------Gets&Sets-------
	
}
