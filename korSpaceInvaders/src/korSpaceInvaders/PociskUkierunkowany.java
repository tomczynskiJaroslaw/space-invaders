package korSpaceInvaders;

import java.awt.Graphics;

/**
 * Pocisk ktory nie musi spadac pionowo. Moze leciec w dowolnym kierunku
 */
public class PociskUkierunkowany extends Pocisk{
	int kierunekX;
	int kierunekY;
	
	public PociskUkierunkowany(int x,int y,int kierunekX,int kierunekY) {
		super(x, y);
		szerokosc=5;
		wysokosc=5;
		this.kierunekX=kierunekX;
		this.kierunekY=kierunekY;
		zadawaneObrazenia=2;
	}
	
	public void update() {
		if (Animacja.wykonujCo(1)) {
//			System.out.println(y+" "+x);
			x+=kierunekX;
			y+=kierunekY;
		}
	};

}
