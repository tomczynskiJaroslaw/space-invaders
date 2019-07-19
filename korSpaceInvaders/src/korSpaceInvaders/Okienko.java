package korSpaceInvaders;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Okienko extends JFrame {
	public Okienko(Kontroler kontroler, PanelGry panelGry) {
		add(panelGry);
		//powoduje zamkniecie okna po nacisnieciu krzyzyka
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ustawia rozmiar okna
		setSize(new Dimension(600, 400));
		//pojawia okienko na ekranie
		setVisible(true);
		//przekazuje na biezoco informacje o wszystkich wcisnietych klawiszach
		addKeyListener(kontroler);
	}

}
