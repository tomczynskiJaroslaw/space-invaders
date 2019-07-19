package korSpaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Powolny ale strzela pociskami we wszystkie strony trzeba go wielokrotnie trafic aby zestrzelic, a jak by tego bylo male co jakis czas wypuszcza {@link PociskRakieta}
 */
public class WrogiStatekMatka extends Statek{
	
	public WrogiStatekMatka(int x,int y) {
		this.x=x;
		this.y=y;
		this.szerokosc=20;
		this.wysokosc=20;
		zadawaneObrazenia=30;
		zycie=100;
	}
	
	@Override
	public void update() {
		super.update();
		if (Animacja.wykonujCo(10)) y+=1;
		if (Animacja.wykonujCo(200)) strzal();
		if (Animacja.wykonujCo(600)) strzal2();
		
	}
	

	public void strzal() {
		pociski.add(new PociskUkierunkowany(x, y, -2, 1));
		pociski.add(new PociskUkierunkowany(x, y, -1, 2));
		pociski.add(new PociskUkierunkowany(x, y, 1, 2));
		pociski.add(new PociskUkierunkowany(x, y, 2, 1));
	}
	
	public void strzal2() {
		pociski.add(new PociskRakieta(x+szerokosc/2, y));
	}
	
	@Override
	public void odmaluj(Graphics g) {
		super.odmaluj(g);
		g.setColor(Color.white);
		g.setColor(Color.black);
		g.fillOval(x-10, y-10, szerokosc+20, wysokosc+20);
	}

}
