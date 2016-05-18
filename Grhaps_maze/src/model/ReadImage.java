package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {

	public static final int ANCHO_MAXIMO = 5000;
	public static final int ALTO_MAXIMO = 5000;

	private int ancho;
	private int alto;
	private Color matrixBit[][];

	public ReadImage(String fileImage) throws IOException {
		matrixBit = new Color[ANCHO_MAXIMO][ALTO_MAXIMO];
		cargarImagen(fileImage);
	}

	private void cargarImagen(String pathImage) throws IOException {

		File file = new File(pathImage);
		BufferedImage bmp;

		try {
			bmp = ImageIO.read(file);
		} catch (IOException e) {
			throw new IOException("No se encuentra la imagen");
		}

		if (bmp.getWidth() < ANCHO_MAXIMO)
			ancho = bmp.getWidth();
		else
			ancho = ANCHO_MAXIMO;

		if (bmp.getHeight() < ALTO_MAXIMO)
			alto = bmp.getHeight();
		else
			alto = ALTO_MAXIMO;

		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				matrixBit[i][j] = new Color(bmp.getRGB(j, i));
			}
	}

	public Color darColorPixel(int x, int y) {
		if (x >= ancho || y >= alto)
			return null;
		else
			return matrixBit[y][x];
	}

	public void convertirAGrises() {
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				int rgbGris = (matrixBit[i][j].getBlue() + matrixBit[i][j].getGreen() + matrixBit[i][j].getRed()) / 3;
				matrixBit[i][j] = new Color(rgbGris, rgbGris, rgbGris);
			}
	}

	public BufferedImage darImagenBuffer() {
		BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				imagen.setRGB(j, i, matrixBit[i][j].getRGB());
			}
		return imagen;
	}
}
