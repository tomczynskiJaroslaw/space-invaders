package korSpaceInvaders;

import java.awt.Graphics;
/**
 * Interfejs zawierajacy dwie glowne metody
 */
public interface ElementAnimowany {
	/**
	 * Zajmuje sie "techniczna strona". Zmienia pozycje obiektow. Jesli jakies wartosci w obiekcie
	 * sa zmieniane, to sa zmieniane tutaj.
	 * </br>
	 * Wywolywana w kazdej klatce
	 * @see Animacja
	 */
	abstract void update();
	/**
	 * Odmalowuje dany obiekt, decyduje o jego wygladzie.
	 * </br>
	 * Wywolywana w kazdej klatce. 
	 * @see Animacja
	 */
	abstract void odmaluj(Graphics g);
}
