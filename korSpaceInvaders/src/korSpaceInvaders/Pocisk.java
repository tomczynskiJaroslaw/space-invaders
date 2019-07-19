package korSpaceInvaders;

import java.awt.Graphics;

public class Pocisk extends ElementRuchomy{

	public Pocisk(int x,int y) {
		this.x=x;
		this.y=y;
		szerokosc=2;
		wysokosc=5;
		zadawaneObrazenia=1;
	}
	

	public void update() {
		y+=2;
	}

	public void odmaluj(Graphics g) {
		g.fillRect(x, y, szerokosc, wysokosc);
	}
	
}
