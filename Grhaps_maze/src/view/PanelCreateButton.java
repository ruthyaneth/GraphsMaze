package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import constant.ConstantsListener;
import constant.ConstantsView;
import controller.Controller;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonCreate;
	private JButton buttonSolve;
	private JButton buttonClose;
	private Controller controller;

	//------Builder------

	public PanelCreateButton(Controller controller) {
		this.controller = controller;
		load(controller);
	}
	//------Methods-------

	public void load(Controller controller){
		initializateThis();
		initializateButtonCreate(controller);
		initialzateButtonSolve();
		initializateButtonClose();
	}

	public void initializateThis(){
		this.setLayout(new GridLayout(1,3));
	}

	public void initializateButtonCreate(Controller controller){
		this.buttonCreate = new JButton(ConstantsView.DEFAULT_BUTTON_CREATE);
		this.buttonCreate.setIcon(new ImageIcon(getClass().getResource(ConstantsView.IMAGE_CREATE)));
		this.buttonCreate.setActionCommand(ConstantsListener.CREATE_MAZE);
		this.buttonCreate.addActionListener(controller);
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
