package spel;

import java.awt.Color;
import java.awt.Graphics;

/**
 * De klasse <code>Dobbelsteen</code> maakt 1 dobbelsteen.
 * 
 * @author Daan
 * @version 2.2
 * @see SpelPaneel
 * @see Frame
 * @see Handleiding
 */
public class Dobbelsteen {
	
	private int radius, diameter, left, center, right, top, middle, bottom, worp, x, y, size, borderRadius, borderWidth, wakken, ijsberen, pinguins;
	
	/**
	 *  Constructor voor de klasse Dobbelsteen.
	 * @param x x coördinaat
	 * @param y y coördinaat
	 */
	public Dobbelsteen(int x, int y) {
		this.x = x;
		this.y = y;
		size = 95;
		
		radius = size/10;
		diameter = radius*2;
		
		borderRadius = size/5;
		borderWidth = size/50;
		
		top = left = size / 5;
		middle = center = size / 2;
		bottom = right = size / 5 * 4;
	}
	
	/**
	 * genereer een willekeurig getal tussen 1 en 6 en bepaal het aantal wakken ijsberen en pinguins
	 */
	public void dobbel() {
		worp = (int) ( 6 * Math.random() +1 );
		
		if(worp == 1){
			wakken = 1;
			ijsberen = 0;
			pinguins = 7 - worp;
		}
		if(worp == 2){
			wakken = 0;
			ijsberen = 0;
			pinguins = 7 - worp;
		}
		if(worp == 3){
			wakken = 1;
			ijsberen = 2;
			pinguins = 7 - worp;
		}
		if(worp == 4){
			wakken = 0;
			ijsberen = 0;
			pinguins = 7 - worp;
		}
		if(worp == 5){
			wakken = 1;
			ijsberen = 4;
			pinguins = 7 - worp;
		}
		if(worp == 6){
			wakken = 0;
			ijsberen = 0;
			pinguins = 7 - worp;
		}
	}
	
	/**
	 * Haal het resultaat van de worp op
	 * @return het getal dat geworpen is
	 */
	public int getWorp() {
		return worp;
	}
	
	/**
	 * Haal het aantal wakken op
	 * @return het aantal wakken
	 */
	public int getWakken(){
		return wakken;
	}
	
	/**
	 * Haal het aantal ijsberen op
	 * @return het aantal ijsberen
	 */
	public int getIJsberen(){
		return ijsberen;
	}
	
	/**
	 * Haal het aantal pinguïns op
	 * @return het aantal pinguïns
	 */
	public int getPinguins(){
		return pinguins;
	}
	
	/**
	 * Reset het aantal wakken, ijsberen en pinguins
	 */
	public void reset() {
		wakken = 0;
		ijsberen = 0;
		pinguins = 0;
	}
	
	public void teken(Graphics g) {
		// Teken lijn
		g.setColor(Color.BLACK);
		g.fillRoundRect(x-borderWidth, y-borderWidth, size+(borderWidth*2), size+(borderWidth*2), borderRadius+(borderWidth*2), 
				borderRadius+(borderWidth*2)   );
		g.setColor(Color.WHITE);
		g.fillRoundRect( x, y, size, size, borderRadius, borderRadius );
		
		// Teken ogen
		g.setColor(Color.BLACK);
		
		if(worp == 1 || worp == 3 || worp == 5) {
			// centerMiddle
			g.fillOval(x + center - radius, y + middle - radius, diameter, diameter);
		}
		if(worp == 2 || worp == 3 || worp == 4 || worp == 5 || worp == 6) {
			// topRight
			g.fillOval(x + right - radius, y + top - radius, diameter, diameter);
		}
		if(worp == 2 || worp == 3 || worp == 4 || worp == 5 || worp == 6) {
			// bottomLeft
			g.fillOval(x + left - radius, y + bottom - radius, diameter, diameter);
		}
		if(worp == 4 || worp == 5 || worp == 6) {
			// topLeft
			g.fillOval(x + left - radius, y + top - radius, diameter, diameter);	
			// bottomRight
			g.fillOval(x + right - radius, y + bottom - radius, diameter, diameter);
		}
		if(worp == 6) {
			// leftMiddle
			g.fillOval(x + left - radius, y + middle - radius, diameter, diameter);
			// rightMiddle
			g.fillOval(x + right - radius, y + middle - radius, diameter, diameter);
		}
	}
	
}