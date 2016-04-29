package config;

import java.io.IOException;

public class HandlerLanguage {
	
	private String fileName;
	public static String language = "undified";
	
	public HandlerLanguage(String fileName) {
		this.fileName = fileName;
	}
	
	public void loadLanguage() throws IOException{
		
		HandlerProperties handlerProperties = new HandlerProperties(fileName);
		handlerProperties.load();
		language = handlerProperties.getProperty("language");
	}

	public void setLanguage() throws IOException{
		HandlerProperties handlerProperties = new HandlerProperties(fileName);
		handlerProperties.load();
		handlerProperties.setProperty("language", language);
		handlerProperties.save();
	}

}
