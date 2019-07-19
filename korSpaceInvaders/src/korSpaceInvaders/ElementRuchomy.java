package korSpaceInvaders;

import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Dowolny byt wyswietlany na planszy (Statek,Pocisk, ...) 
 */
public abstract class ElementRuchomy implements ElementAnimowany{
	protected int x;
	protected int y;
	protected int szerokosc;
	protected int wysokosc;
	protected int zadawaneObrazenia=1;
	protected int zycie=1;
	
	/**
	 * Sprawdza czy ten obiekt "zderzyl sie", z obiektem podanym jako parametr.
	 * Jesli tak, to zmniejsza poziom zycia elementu trafionego o zadawane przez nas obrazenia.
	 * </br>
	 * <u>Tu warto zaznaczyc ze ta informacja czy nastapilo zderzenie(trafienie), jest wykorzystywana do usuniecia, 
	 * nas, elementu trafionego, lub obu, w miejscu w ktorym ta metoda zostala wywolana. 
	 * </u>
	 * @param element ktorego zycie zmniejszamy
	 * @return czy nastapilo zderzenie
	 */
	public boolean czyTrafilW(ElementRuchomy element) {
		Rectangle a = new Rectangle(x, y, szerokosc, wysokosc);
		Rectangle b = new Rectangle(element.x, element.y, element.szerokosc, element.wysokosc);
		if (a.intersects(b)) {
			element.zycie-=zadawaneObrazenia;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Odmalowuje w domyslny sposob, czyli po prostu rysuje czarny prostokat o naszych wymiarach i wspolrzednych
	 */
	public void odmaluj(Graphics g) {
		g.fillRect(x, y, szerokosc, wysokosc);
	}

	
}
