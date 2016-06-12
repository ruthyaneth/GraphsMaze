package logic;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Circulo 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class Circle {
	
	//-------Atributtes------
	
	private int xCenter;
	private int yCenter;
	private int radio;
	
	//-------Builder-------
	
	public Circle(int xCenter, int yCenter , int radio) {
		
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radio = radio;
	}
	
	//-------Methods-------
	
	//-----Sets&&Gets-------

	public int getxCenter() {
		return xCenter;
	}

	public void setxCenter(int xCenter) {
		this.xCenter = xCenter;
	}

	public int getyCenter() {
		return yCenter;
	}

	public void setyCenter(int yCenter) {
		this.yCenter = yCenter;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
}
