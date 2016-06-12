package logic;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase de las lineas del laberinto 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class Line {

	//------Atributes------
	private int positionX1;
	private int positionX2;
	private int positionY1;
	private int positionY2;
	
	//------Builder------
	
	public Line(int positionX1 , int positionX2 , int positionY1 , int positionY2 ) {
	this.positionX1 = positionX1;
	this.positionX2 = positionX2;
	this.positionY1 = positionY1;
	this.positionY2 = positionY2;
	
	}
	
	//------Methods------
	
	//-----Sets&Gets-------

	public int getPositionX1() {
		return positionX1;
	}

	public void setPositionX1(int positionX1) {
		this.positionX1 = positionX1;
	}

	public int getPositionX2() {
		return positionX2;
	}

	public void setPositionX2(int positionX2) {
		this.positionX2 = positionX2;
	}

	public int getPositionY1() {
		return positionY1;
	}

	public void setPositionY1(int positionY1) {
		this.positionY1 = positionY1;
	}

	public int getPositionY2() {
		return positionY2;
	}

	public void setPositionY2(int positionY2) {
		this.positionY2 = positionY2;
	}
	
	
	
	
}

