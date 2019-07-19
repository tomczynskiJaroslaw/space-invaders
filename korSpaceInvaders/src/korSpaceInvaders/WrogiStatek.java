package korSpaceInvaders;
import java.util.Random;

public class WrogiStatek extends Statek{
	static Random r = new Random();
	public WrogiStatek(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		szerokosc=40;
		wysokosc=10;
		zadawaneObrazenia=5;
	}
	
	public void update() {
		super.update();
		y+=1;
		if (Animacja.wykonujCo(50+r.nextInt(10))) strzal();
	}

	private void strzal() {
		pociski.add(new Pocisk(x+szerokosc/2, y));
	}
	
	
	
}
