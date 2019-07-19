package korSpaceInvaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

/**
 * Wywoluje co okreslony interwal czasowy metody aktualizujace pozyzje obiektow (Gracza, WrogichStatkow i Pociskow ) w oknie
 */
public class Animacja {
	/**
	 * kazde "odswiezenie", aktualizacja pozycji zwieksza ta zmienna o jeden. Wskazuje liczbe odswiezen od uruchomienia programu
	 */
	private static int ktoraKlatka=0;
	/**
	 * Specjalna klasa zajmujaca sie wywolywaniem wskazanych metod/funkcji co okreslony interwal czasowy (Juz gotowa w JAVA)
	 */
	Timer timer;
	

	public Animacja(final Kontroler kontroler, final PanelGry panelGry) {
		timer = new Timer(30, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				kontroler.update();
				panelGry.repaint();
				ktoraKlatka++;
			}
		});
		
		timer.start();
		
	}
	
	/**
	 * Niezbyt elegancka metoda. Slozy do wykonywanie danego fragmentu kodu co iles klatek/odswiezen/aktualizacji. 
	 * Stosuje, gdy dany fragment kodu trzeba wykonac mniej niz raz w poszczegolnej klatce.
	 * Na przyklad, gdy chcemy poruszyc statkiem o mniej niz 1px.
	 * <pre>
	 * if (Animacja.wykonujCo(10)){
	 * 	INSTRUKCJE WYKONYWANE RAZ NA 10 KLATEK
	 * }
	 * </pre>
	 * @param coIleKlatek
	 * @return
	 */
	public static boolean wykonujCo(int coIleKlatek) {
		if (ktoraKlatka%coIleKlatek==0) {
			return true;
		}else {
			return false;
		}
	}
}
