package logic;

import view.CreateWindowMaze;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase  donde se van a generar las casillas que el usuario va a ver dependiendo de la cantidad de filas y columnas 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class GenerateBox {
	
	//------Atributtes------
	
	private int row ; // Numero de filas del laberinto
	private int column; // Numero de columnas
	private Box [][] box;
	private CreateWindowMaze create; // Esto es de presentacion mirar como arreglarlo 
	
	//------Builder-------
	
	public GenerateBox(CreateWindowMaze create , int row , int column) {
	  this.create = create;
	  this.column = column;
	  this.row = row;
	}
	
	//-----Methods------
	
	public void initializate(){
		this.box = new Box[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				box[row][column] = new Box(i * column + j);
			}
		}
	}
	
	
}
