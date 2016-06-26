package view;


import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;
import java.awt.Graphics;
import logic.Circle;
import logic.Line;
import logic.Step;

/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase donde se generara el laberinto que el usuario ingrese con su ancho y su alto 
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class PanelDrawTablero extends JPanel{
	
	//------Atrinuttes------
	private Vector<Line> line;
	private Vector<Step> step;
	private Circle init;
	private Circle fin;
	
	//------Builder------
	
	public PanelDrawTablero() {
		
		this.line = new Vector<Line>(0);
		this.step = new Vector<Step>(0);
		this.setBackground(Color.black);
		
	}
	//-----Methods-------
	public void addLine(Line lines){
		line.add(lines);
	}
	
	public void addLine(int x1, int x2, int y1, int y2 ){
		line.add(new Line(x1, x2, y1, y2));
	}
	
	public void addStep(Step steps){
		step.add(steps);
	}
	public void addStep(int x1, int x2, int y1, int y2){
		
		step.add(new Step(x1, x2, y1, y2));
	}
	
	public void paint(Graphics graphics){
		 // sigue lo de la linea 40 hata la linea 48 que es la parte del hilo  de la clase tablero del proyecto Maze
		graphics.setColor(Color.BLUE);
		for (Line line2 : line) {
			graphics.drawLine(line2.getPositionX1(), line2.getPositionX2(), line2.getPositionY1(), line2.getPositionY2());
		}
		
		//Falta lo de las linea 55 hasta la 63 de la clase Tablero del proyecto Maze
	}
	
	public void cleanAll(){
		line.removeAllElements();
		step.removeAllElements();
		setFin(null);
		setInicio(null);
	}
	
	//------Gets&Sets-------
	public Vector<Line> getLine() {
		return line;
	}
	public void setLine(Vector<Line> line) {
		this.line = line;
	}
	public Vector<Step> getStep() {
		return step;
	}
	public void setStep(Vector<Step> step) {
		this.step = step;
	}
	public Circle getInit() {
		return init;
	}
	public void setInicio(Circle inicio) {
		this.init = inicio;
	}
	public Circle getFin() {
		return fin;
	}
	public void setFin(Circle fin) {
		this.fin = fin;
	}
	
	
	
	

}
