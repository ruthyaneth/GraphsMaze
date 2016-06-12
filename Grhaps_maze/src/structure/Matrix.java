package structure;

import java.util.List;
import java.util.Stack;
import java.util.Vector;


public class Matrix <V,A>{
	//estructura basica matriz de adayacencia
	private Cell <A>[][]  data;
	private Cell<V>[] names;

	//	public static final int NUM_lINES=100;
	//	private Stack<A> stack;

	//	public Matrix( V[] vertices) {
	//		this.vertice= new Cell[vertices.length];
	//		this.data =new Cell [vertice.length][vertice.length];
	//	}

	public Matrix( A valueDefault, V ... vertices) {
		this.names = new Cell[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			names[i]= new Cell<V>(vertices[i]);
		}
		data =new Cell [vertices.length][vertices.length];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[i][j]=(Cell<A>)new Cell<A>(valueDefault);
			}	
		}
	}


	public boolean insertArista(V home, V target, A value) {
		if(encontrarValor(home)!=-1 &&encontrarValor(target)!=-1){
			data[encontrarValor(home)][encontrarValor(target)].setInfo(value);
			return true;
		}else{
			return false;
		}
	}

	public int encontrarValor(V name){
		int valor=0;
		for (int i = 0; i < names.length; i++) {
			if (names[i].getInfo()==name) {
				return i;
			}
		}
		return -1;
	}

	public A get(V row, V col){
		if(encontrarValor(row)!=-1 &&encontrarValor(col)!=-1){
			return 
					data[encontrarValor(row)][encontrarValor(col)].getInfo();
		}
		return null;
	}

	public V getVertice(int value){
		return names[value].getInfo();
	}
	
	public A get1(int col, int row){//abreviado
			return data[col][row].getInfo();
	}
	
	public int size(){
		return names.length;
	}
	
	public Cell<A>[][] getData() {
		return data;
	}

	public Cell<V>[] getVertice() {
		return names;
	}

	public void setVertice(Cell<V>[] vertice) {
		this.names = vertice;
	}

	public void setData(Cell<A>[][] data) {
		this.data = data;
	}



	public boolean isPath(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

}
