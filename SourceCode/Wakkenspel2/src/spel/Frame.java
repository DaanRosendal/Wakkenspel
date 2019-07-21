package spel;

import javax.swing.JFrame;

/**
 * 
 * De klasse <code>Frame</code> representeert het frame van het spel
 * 
 * @author Daan Rosendal 97059531
 * @since 1-6-2019
 * @version 2.2
 * @see SpelPaneel
 * @see Dobbelsteen
 * @see Handleiding
 *
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new Frame();
		frame.setSize(800,490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Wakken, ijsberen en pinguins spel");
		frame.setContentPane(new SpelPaneel());
		frame.setVisible(true);
	}
}

