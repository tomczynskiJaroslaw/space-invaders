package korSpaceInvaders;

import java.awt.Graphics;
/**
 * Pocisk lecacy wolno i raczej zadko wystrzelany, ale za to zadaje duze obrazenia
 */
public class PociskRakieta extends Pocisk {

	public PociskRakieta(int x, int y) {
		super(x-5, y);
		zadawaneObrazenia=20;
	}
	
	@Override
	public void update() {
		y+=1;
	}
	
	@Override
	public void odmaluj(Graphics g) {
		g.fillOval(x, y-2, 10, 2);
		g.fillOval(x, y, 10, 10);
	}
}
