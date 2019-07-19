package korSpaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
/**
 * Caly widoczny w oknie obszar (nasze pole kosmicznej bitwy)
 */
public class PanelGry extends JPanel{
	Kontroler kontroler;

	public PanelGry(Kontroler kontroler) {
		this.kontroler=kontroler;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ustawiamy biale tlo
		g.setColor(Color.white);
		//malujac na calym obszarze wielki prostokat
		g.fillRect(0, 0, 600, 400);getSize();
		//nastepnie znowu zmieniamy kolor, na czarny
		g.setColor(Color.black);
		//i rysujemy nasze cale pole bitwy (WrogieStatki, Pociski i Gracza)
		kontroler.odmaluj(g);
	}
	

}
