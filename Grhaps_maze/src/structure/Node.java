package structure;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase nodo
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class Node <T>{
	private T info;
	private Node<T> next;
	private Node<T> previous;

	public Node(T info) {
		this.info = info;
		this.next = null;
		this.previous = null;
	}
	
	public Node(T info, Node<T> next) {
		this.info = info;
		this.next = next;
		this.previous = null;
	}

	public Node(T info, Node<T> next, Node<T>previous) {
		this.info = info;
		this.next = next;
		this.previous = previous;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
