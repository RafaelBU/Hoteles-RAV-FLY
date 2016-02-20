package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase que representa un panel "padre" del que van a poder heredar panales mas especificos
 * 
 *
 */
public class PanelPadre extends JPanel{
	
	Color color = new Color(222, 231, 249); 
	private static final long serialVersionUID = 1L;
	
	protected String url;
	protected ImageIcon imagen;
	protected Graphics g;
	
	/**
	 * Constructor de la clase padre
	 * 
	 * @param url String que indica la ruta de la imagen
	 */
	public PanelPadre(String url)
	{
		this.url = url;
	}
	
	/**
	 * Método encargado de "pintar" el panel con la imagen proporcionada en la url
	 */
	public void paint(Graphics g)
	{
		this.g = g;
		this.setBackground(color);
		Dimension tamano = getSize();
		this.imagen = new ImageIcon(getClass().getResource(this.url));
		this.g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(this.g);
	}

}
