package korSpaceInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
/**
 * 
 */
public class Statek extends ElementRuchomy{
	Vector<Pocisk> pociski = new Vector<Pocisk>();
	
	public void update() {
		//Jesli statek zlecial na sam dol "teleportowany" jest z powrotem na gore
		if (y>600) y=-50;
		//Dopoki statek jest poza oknem nie strzela pociskami
		if (y<0) pociski.clear();
		//aktualizujemy pozycje pociskow
		for (Pocisk pocisk : pociski) {
			pocisk.update();
		}
	}
	/**
	 * Sprawdzamy czy ktorykolwiek z pociskow wystrzelonych przez ten statek w cos trafil
	 */
	@Override
	public boolean czyTrafilW(ElementRuchomy prostokat) {
		for (Iterator<Pocisk> i=pociski.iterator();i.hasNext();) {
			if (i.next().czyTrafilW(prostokat)) {
				i.remove();
			}
		}
		return super.czyTrafilW(prostokat);
	}

	public void odmaluj(Graphics g) {
		super.odmaluj(g);
		for (Pocisk pocisk : pociski) {
			pocisk.odmaluj(g);
		}
	}
	
}
