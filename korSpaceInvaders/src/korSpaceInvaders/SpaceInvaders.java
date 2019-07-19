package korSpaceInvaders;

public class SpaceInvaders {
	public static void main(String[] args) {
		Kontroler kontroler = new Kontroler();
		PanelGry panelGry = new PanelGry(kontroler);
		new Okienko(kontroler,panelGry);
		new Animacja(kontroler,panelGry);
	}
}
