package structure;

public class Cell <T>{

	private T info;

	public Cell(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
}
