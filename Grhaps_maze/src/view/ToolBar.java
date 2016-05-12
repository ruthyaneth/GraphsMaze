package view;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsListener;
import constant.ConstantsView;
import controller.Controller;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JButton buttonOpenImage;
	private JButton buttonCreateImage;
	private JButton buttonEditImage;
	private Controller controller;

	public ToolBar(Controller controller) {
		super();
	this.controller = controller;
		init();
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		addButtonOpenImage();
		addButtonCreateImage();
		addButtonEditImage();
	}

	private void addButtonOpenImage() {
		buttonOpenImage = new JButton(createImageIcon("/imagesSettings/open_folder_green.png"));
		buttonOpenImage.addActionListener(controller);
		buttonOpenImage.setActionCommand(ConstantsListener.ITEM_FILE_OPEN_IMAGE);
		this.add(buttonOpenImage);
	}

	private void addButtonCreateImage() {
		buttonCreateImage = new JButton(createImageIcon("/imagesSettings/new_document.png"));
		this.add(buttonCreateImage);
	}

	private void addButtonEditImage() {
		buttonEditImage = new JButton(createImageIcon("/imagesSettings/color_line.png"));
		this.add(buttonEditImage);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	public void changeLenguage() throws IOException {

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		buttonOpenImage
				.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_OPEN_IMAGE));
		buttonCreateImage
				.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_CREATE_IMAGE));
		buttonEditImage
				.setToolTipText(handlerProperties.getProperty(ConstantsView.TOOL_BAR_TOOL_TIP_BUTTON_EDIT_IMAGE));

	}

}
