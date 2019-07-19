package korSpaceInvaders;

import java.awt.Graphics;
/**
 * specyficzny pocisk, a bardziej "fala uderzeniowa", ktora rozchodzi sie (robi sie wieksza i wieksza ...), ale za to zadaje coraz mniej obrazen
 */
public class PociskFala extends Pocisk{

	public PociskFala(int x, int y) {
		super(x, y);
		szerokosc=10;
		wysokosc=1;
		zadawaneObrazenia=10;
	}
	
	@Override
	public void update() {
		y+=3;
		//zwiekszamy szerokosc pocisku
		if (Animacja.wykonujCo(5)) {
			x-=3;
			szerokosc+=6;
		}
		//zmniejszamy zadawane obrazenia
		if (Animacja.wykonujCo(40)) zadawaneObrazenia-=1;
	}
	

	
}
