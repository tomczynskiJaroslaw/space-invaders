package korSpaceInvaders;

public class PociskGracza extends Pocisk{

	public PociskGracza(int x, int y) {
		super(x, y);
	}
	@Override
	public void update() {
		//by pocisk nie trafial w statki ktore znajduja sie poza widocznym obszarem (poza oknem)
		//[niezbyt eleganckie rozwiazanie :-(]
		if (y+wysokosc<0) x+=1000;
		y-=3;
	}
	
	public boolean czyTrafilW(ElementRuchomy element) {
		super.czyTrafilW(element);
		if (element.zycie>0) {
			return false;
		}else {
			return true;
		}
		
	};
}
