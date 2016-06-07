package logic;


import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

import persistence.FileUtil;

import java.util.List;
import structure.SimpleList;
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
	private FileUtil fileUtil;
	
	//------Builder-------
	
	public GenerateBox(CreateWindowMaze create , int row , int column) {
	  this.create = create;
	  this.column = column;
	  this.row = row;
	  initializate();
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
	
	public void generateBox(){
		
		TreeSet<Box> visitados = new TreeSet<Box>();
		List<Box> porVisitar = (List<Box>) new SimpleList<Box>();
		porVisitar.add(0, box[0][0]);
		File file = new File(File.separator + "lab.txt");
		fileUtil.save(file, box, 0, row*column-1);
		create
		
		
		
	}
}
