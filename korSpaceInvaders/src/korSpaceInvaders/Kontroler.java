package korSpaceInvaders;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
/**
 * Zajmuje sie wczytywaniem poziomu, a nastepnie wywolywaniem metod {@link ElementAnimowany#update()} i {@link ElementAnimowany#odmaluj(Graphics)} 
 * Aktualizujac w ten sposob posrednio wszystkie elementy na planszy.
 */
public class Kontroler extends KeyAdapter implements ElementAnimowany{
	private Vector<ElementRuchomy> listaWrogichStatkow = new Vector<ElementRuchomy>();
	private Gracz gracz;
	private int poziom=0;
	
	public Kontroler() {
		gracz = new Gracz();
	}
	
	public void czyGraczTrafiony() {
		for (Iterator<ElementRuchomy> wrogiStatek = listaWrogichStatkow.iterator();wrogiStatek.hasNext();) {
			if (wrogiStatek.next().czyTrafilW(gracz)) {
				wrogiStatek.remove();
			}
		}
	}
	
	
	public void update() {
		if (wszystkieWrogieStatkiZestrzelone()) nowyPoziom();
		czyGraczTrafiony();
		//przechodzimy po wszystkich wrogrchStatkacz
		for (Iterator<ElementRuchomy> wrogiStatekI = listaWrogichStatkow.iterator();wrogiStatekI.hasNext();) {
			//UWAGA: Uzywamy "iteratora" poniewaz przechodzac po liscie usuwamy z niej w trakcie niektore elmenty
			ElementRuchomy wrogiStatek = wrogiStatekI.next();
			//aktualizujemy ich pozycje
			wrogiStatek.update();
			//oraz sprawdzamy czy nie zostaly trafione
			if( gracz.czyTrafilW(wrogiStatek)) {
				//a jesli tak to usuwamy wrogiStatek z programu
				wrogiStatekI.remove();
			}
			
		}
		gracz.update();
		
	}

	public void odmaluj(Graphics g) {
		for (ElementRuchomy elementRuchomy : listaWrogichStatkow) {
			elementRuchomy.odmaluj(g);
		}
		gracz.odmaluj(g);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("POZIOM: "+poziom, 0, 40);
		if (wszystkieWrogieStatkiZestrzelone()&&poziom==5) {
			g.drawString("WYGRALES", 0, 200);
		}
	}
	
	private boolean wszystkieWrogieStatkiZestrzelone() {
		return listaWrogichStatkow.size()==0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		gracz.steruj(e);
	}
	
	
	private void nowyPoziom() {
		System.out.println(poziom);
		gracz=new Gracz();
		poziom++;
		switch(poziom) {
			case 1:{
				Random r = new Random();
				listaWrogichStatkow.addElement(new WrogiStatekMatka(300, 50));
				for (int i=0;i<3;i++) {
					WrogiStatek wrogiStatek = new WrogiStatek(r.nextInt(500), -r.nextInt(100));
					listaWrogichStatkow.add(wrogiStatek);
				}
				break;
			}
			case 2:{
				Random r = new Random();
				for (int i=0;i<10;i++) {
					WrogiStatek wrogiStatek = new WrogiStatek(r.nextInt(500), -r.nextInt(500));
					listaWrogichStatkow.add(wrogiStatek);
				}
				for (int i=0;i<10;i++) {
					Statek wrogiStatek = new WrogiStatekChudy(r.nextInt(500), -r.nextInt(500));
					listaWrogichStatkow.add(wrogiStatek);
				}
				break;
			}
			case 3:{
				Random r = new Random();
				for (int i=0;i<20;i++) {
					WrogiStatek wrogiStatek = new WrogiStatek(r.nextInt(500), -r.nextInt(1000));
					listaWrogichStatkow.add(wrogiStatek);
				}
				for (int i=0;i<3;i++) {
					Statek wrogiStatek = new WrogiStatekChudy(r.nextInt(500), -r.nextInt(1000));
					listaWrogichStatkow.add(wrogiStatek);
				}
				for (int i=0;i<5;i++) {
					Statek wrogiStatek = new WrogiStatekMatka(r.nextInt(500), -r.nextInt(1000));
					listaWrogichStatkow.add(wrogiStatek);
				}
				break;
			}
			case 4:{
				Random r = new Random();
				for (int i=0;i<3;i++) {
					WrogiStatek wrogiStatek = new WrogiStatek(r.nextInt(500), -r.nextInt(1000));
					listaWrogichStatkow.add(wrogiStatek);
				}
				for (int i=0;i<15;i++) {
					Statek wrogiStatek = new WrogiStatekChudy(r.nextInt(500), -r.nextInt(1000));
					listaWrogichStatkow.add(wrogiStatek);
				}
				for (int i=0;i<10;i++) {
					Statek wrogiStatek = new WrogiStatekMatka(r.nextInt(500), -r.nextInt(5000));
					listaWrogichStatkow.add(wrogiStatek);
				}
				break;
			}
		}
		
	}
	
}
