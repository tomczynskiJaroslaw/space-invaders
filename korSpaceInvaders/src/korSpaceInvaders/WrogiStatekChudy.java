package korSpaceInvaders;

import java.util.Random;
/**
 * Statek niezbyt grozny, ale trudny do trafienia
 */
public class WrogiStatekChudy extends Statek{

	public WrogiStatekChudy(int x, int y) {
		this.x=x;
		this.y=y;
		szerokosc=10;
		wysokosc= 30;
		zadawaneObrazenia=10;
	}
	
	public void strzal() {
		pociski.add(new PociskFala(x+szerokosc/2, y+wysokosc));
	}
	@Override
	public void update() {
		super.update();
		y+=1;
		if (Animacja.wykonujCo(10)) y+=new Random().nextInt(4);
		if (Animacja.wykonujCo(200))strzal();
	}
}
