package korSpaceInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;
/**
 * Statek starowany przez czlowieka (gracza)
 */
public class Gracz extends Statek{
	int zestrzeloneStatki=0;
	public Gracz() {
		x=400;
		y=300;
		szerokosc=50;
		wysokosc=10;
		zycie=100;
	}
	
	/**
	 * Sterowanie za pomoca klawiatury
	 */
	public void steruj(KeyEvent e) {
		if (przegrana()) return;
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			x-=10;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			x+=10;
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			strzal();
		}
	}
	
	private boolean przegrana() {
		return zycie<=0;
	}
	

	public void strzal() {
		pociski.add( new PociskGracza(x+szerokosc/2, y));
	}
	
	/**
	 * Przechodzimy po wszystkich pociskach jakie wystrzelil gracz
	 * i sprawdzamy, czy ktorys trafil w wrogi statek.
	 * Jesli tak, to usuwamy pocisk i zwracamy ta informacje
	 */
	@Override
	public boolean czyTrafilW(ElementRuchomy wrogiStatek) {
		for (Iterator<Pocisk> i=pociski.iterator();i.hasNext();) {
			if (i.next().czyTrafilW(wrogiStatek)) {
				if (wrogiStatek.zycie<0) 
				i.remove();
				zestrzeloneStatki++;
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void odmaluj(Graphics g) {
		super.odmaluj(g);
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 100, 10);
		g.setColor(Color.black);
		g.fillRect(2, 2, zycie-2, 10-2);
		g.drawString(""+zestrzeloneStatki, 10, 20);
		if (przegrana()) {
			g.setFont(new Font("Arial", 0, 20));
			g.drawString("PRZEGRALES", 0, 200);
		}
	}
	
}
