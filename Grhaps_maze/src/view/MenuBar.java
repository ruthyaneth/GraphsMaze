package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import constant.Constants;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu menuFile;
	private JMenuItem itemFileOpenImage;
	private JMenuItem itemFileCreateImage;
	
	public MenuBar() {
		super();
		initial();
	}
	//abrir
	//crear
	//editar
	//salir
	private void initial(){
		addMenuFile();
		addItemFileOpenImage();
		addItemFileCreateImage();
	}
	
	private void addMenuFile(){
		menuFile = new JMenu();
		menuFile.setText(Constants.NAME_MENU_FILE);
		this.add(menuFile);
	}
	private void addItemFileOpenImage(){
		itemFileOpenImage = new JMenuItem();
		itemFileOpenImage.setText(Constants.NAME_ITEM_FILE_OPEN_IMAGE);
		menuFile.add(itemFileOpenImage);
	}
	public void addItemFileCreateImage(){
		itemFileCreateImage = new JMenuItem();
		itemFileCreateImage.setText(Constants.NAME_ITEM_FILE_CREATE_IMAGE);
		menuFile.add(itemFileCreateImage);
	}
	
}
