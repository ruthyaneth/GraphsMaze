package view;

import javax.swing.JFileChooser;

import constant.ConstantsView;

public class JFileChooserSelectImage extends JFileChooser {

	private static final long serialVersionUID = 1L;

	public JFileChooserSelectImage() {
		super(ConstantsView.TITLE_FILE_CHOOSER);
		showOpenDialog(this);
		getSelectedFile();
	}
}
