package view;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JToolBar;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JButton buttonOpenImage;
	private JButton buttonCreateImage;
	private JButton buttonEditImage;

	public ToolBar() {
	super();
	init();
	try {
		changeLenguage();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private void init(){
		addButtonOpenImage();
		addButtonCreateImage();
		addButtonEditImage();
	}
	private void addButtonOpenImage(){
		buttonOpenImage = new JButton("Provicional");
		this.add(buttonOpenImage);
	}
	private void addButtonCreateImage(){
		buttonCreateImage = new JButton("create Image");
		this.add(buttonCreateImage);
	}
	private void addButtonEditImage(){
		buttonEditImage = new JButton("Edit");
		this.add(buttonEditImage);
	}
	public void changeLenguage() throws IOException{

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		buttonOpenImage.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_OPEN_IMAGE));
		buttonCreateImage.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_CREATE_IMAGE));
		buttonEditImage.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_EDIT_IMAGE));
	}

}
