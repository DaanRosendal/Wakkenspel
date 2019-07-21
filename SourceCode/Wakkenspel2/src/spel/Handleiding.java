package spel;

import javax.swing.JOptionPane;

/**
 * 
 * De klasse <code>Handleiding</code> representeert de handleiding van het spel
 * @author Daan Rosendal 97059531
 * @since 1-6-2019
 * @version 2.2
 * @see SpelPaneel
 * @see Dobbelsteen
 * @see Frame
 *
 */

public class Handleiding {
	static boolean eersteX = true;
	
	/*
	 * Laat de handleiding zien
	 */
	public static void showHandleiding() {
		String titel = "Handleiding";
		String bericht = "";
		if (eersteX) {
			bericht = "Welkom bij het wakken, ijsberen & pinguins spel! \n"
					+ "Op de dobbelsteen is een wak is in het midden getekend, daaromheen worden de ijsberen getekend. \n"
					+ "De dobbelsteen kantwaarde “5” vertoont bijvoorbeeld een wak in het midden, er zitten vier "
					+ "zwarte puntjes \nomheen, dit zijn de ijsberen. Als er geen puntje in het midden zit zijn er geen ijsberen. \n"
					+ "Pinguïns leven op de zuidpool. De zuidpool ligt aan de tegenovergestelde kant, "
					+ "dus aan de onderkant van de dobbelsteen. \nHet totale aantal puntjes aan de onderkanten van de dobbelstenen met wakken vormt "
					+ "daarmee het aantal pinguïns, bedenk \ndat de som van de ogen van een dobbelsteen van twee tegenover elkaar liggende zijden "
					+ "altijd 7 bedraagt. \n"
					+ "Succes en veel plezier!";
			eersteX = false;
		} else {
			bericht = "Op de dobbelsteen is een wak is in het midden getekend, daaromheen worden de ijsberen getekend. \n"
					+ "De dobbelsteen kantwaarde “5” vertoont bijvoorbeeld een wak in het midden, er zitten vier "
					+ "zwarte puntjes \nomheen, dit zijn de ijsberen. Als er geen puntje in het midden zit zijn er geen ijsberen. \n"
					+ "Pinguïns leven op de zuidpool. De zuidpool ligt aan de tegenovergestelde kant, "
					+ "dus aan de onderkant van de dobbelsteen. \nHet totale aantal puntjes aan de onderkanten van de dobbelstenen met wakken vormt "
					+ "daarmee het aantal pinguïns, bedenk \ndat de som van de ogen van een dobbelsteen van twee tegenover elkaar liggende zijden "
					+ "altijd 7 bedraagt. \n";
		}
	    JOptionPane.showMessageDialog(null, bericht, titel, JOptionPane.INFORMATION_MESSAGE);
	}
}
