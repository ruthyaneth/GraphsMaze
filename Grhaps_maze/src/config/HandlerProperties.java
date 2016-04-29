package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HandlerProperties extends Properties {

	private static final long serialVersionUID = 1L;
	private String fileName;

	public HandlerProperties(String fileName) {
		this.fileName = fileName;
	}

	public void load() throws IOException {
		InputStream input;
		try {
			input = new FileInputStream(fileName);
			load(input);
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save() throws IOException{
		FileOutputStream output = new FileOutputStream(fileName);
		store(output, null);
		output.close();
	}
}
