package spel;

/*
 * Wakkenspel Frame
 * @author Daan Rosendal
 * @since 5-6-2019
 */

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * De klasse <code>SpelPaneel</code> representeert het paneel van het spel
 * 
 * @author Daan Rosendal 97059531
 * @since 1-6-2019
 * @version 2.2
 * @see Frame
 * @see Dobbelsteen
 * @see Handleiding
 *
 */

@SuppressWarnings("serial")
class SpelPaneel extends JPanel {
	private JTextField wakVak, ijsbeerVak, pinguinVak, dAantalVak, wakOpVak, ijsbeerOpVak, pinguinOpVak,
			aantalGegooidVak, aantalGoedVak, aantalFoutVak, tipVak1, tipVak2, tipVak3, tipVak4;
	private JLabel wakLabel, ijsbeerLabel, pinguinLabel, dAantalLabel, wakOpLabel, ijsbeerOpLabel, pinguinOpLabel,
			aantalGegooidLabel, aantalGoedLabel, aantalFoutLabel;
	private JButton controleerKnop, werpKnop, opKnop, resetKnop, hKnop;
	private int worpAantal, gokWakken, gokIjsberen, gokPinguins, aWakken, aIjsberen, aPinguins, totaalGegooid,
			totaalGoed, totaalFout, beurtFout;
	private boolean magGooien = true;
	String tips[] = { "- Kies een aantal van 3 tot en met 12 dobbelstenen.",
			"- Kies een aantal van 0 tot en met 12 wakken.", "- Kies een aantal van 0 tot en met 48 ijsberen.",
			"- Kies een aantal van 1 tot en met 72 pinguins" };

	// Roep 12 dobbelstenen aan als objecten
	private Dobbelsteen dbl1 = new Dobbelsteen(20, 20);
	private Dobbelsteen dbl2 = new Dobbelsteen(150, 20);
	private Dobbelsteen dbl3 = new Dobbelsteen(280, 20);
	private Dobbelsteen dbl4 = new Dobbelsteen(410, 20);
	private Dobbelsteen dbl5 = new Dobbelsteen(540, 20);
	private Dobbelsteen dbl6 = new Dobbelsteen(670, 20);
	private Dobbelsteen dbl7 = new Dobbelsteen(20, 130);
	private Dobbelsteen dbl8 = new Dobbelsteen(150, 130);
	private Dobbelsteen dbl9 = new Dobbelsteen(280, 130);
	private Dobbelsteen dbl10 = new Dobbelsteen(410, 130);
	private Dobbelsteen dbl11 = new Dobbelsteen(540, 130);
	private Dobbelsteen dbl12 = new Dobbelsteen(670, 130);

	/**
	 * Constructor voor de klasse SpelPaneel
	 */
	public SpelPaneel() {
		// Schakel lay-outmanager uit
		setLayout(null);

		// Achtergrond lichtblauw maken
		Color lichtblauw = new Color(0, 191, 255);
		setBackground(lichtblauw);
		Font font = new Font("Dialog", Font.BOLD, 12);

		// Inputvakken
		wakVak = new JTextField();
		ijsbeerVak = new JTextField();
		pinguinVak = new JTextField();
		wakVak.setEditable(false);
		ijsbeerVak.setEditable(false);
		pinguinVak.setEditable(false);
		dAantalVak = new JTextField();
		dAantalVak.setForeground(lichtblauw);
		dAantalVak.setFont(font);
		dAantalVak.addActionListener(new Werp());
		wakVak.setForeground(lichtblauw);
		wakVak.setFont(font);
		ijsbeerVak.setForeground(lichtblauw);
		ijsbeerVak.setFont(font);
		pinguinVak.setForeground(lichtblauw);
		pinguinVak.setFont(font);

		// Controleerknop
		controleerKnop = new JButton("Controleren");
		controleerKnop.setBackground(Color.WHITE);
		controleerKnop.setForeground(lichtblauw);
		controleerKnop.setFocusPainted(false);
		controleerKnop.setBorderPainted(false);
		controleerKnop.setEnabled(false);
		controleerKnop.addActionListener(new Controleren());

		// Werpknop
		werpKnop = new JButton("Werpen");
		werpKnop.setBackground(Color.WHITE);
		werpKnop.setForeground(lichtblauw);
		werpKnop.setFocusPainted(false);
		werpKnop.setBorderPainted(false);
		werpKnop.addActionListener(new Werp());

		// Oplossingknop
		opKnop = new JButton("De Oplossing");
		opKnop.setBackground(Color.WHITE);
		opKnop.setForeground(lichtblauw);
		opKnop.setFocusPainted(false);
		opKnop.setBorderPainted(false);
		opKnop.setEnabled(false);
		opKnop.addActionListener(new Oplossing());

		// Resetknop
		resetKnop = new JButton("Reset");
		resetKnop.setBackground(Color.WHITE);
		resetKnop.setForeground(lichtblauw);
		resetKnop.setFocusPainted(false);
		resetKnop.setBorderPainted(false);
		resetKnop.setEnabled(false);
		resetKnop.addActionListener(new Resetten());

		// Handleidingknop
		hKnop = new JButton("Handleiding");
		hKnop.setBackground(Color.WHITE);
		hKnop.setForeground(lichtblauw);
		hKnop.setFocusPainted(false);
		hKnop.setBorderPainted(false);
		hKnop.addActionListener(new Handleid());

		// Tipvakken
		tipVak1 = new JTextField();
		tipVak1.setBackground(lichtblauw);
		tipVak1.setBorder(null);
		tipVak1.setEditable(false);
		tipVak1.setForeground(Color.WHITE);
		tipVak1.setFont(font);
		tipVak1.setText(tips[0]);
		tipVak1.setVisible(false);
		tipVak2 = new JTextField();
		tipVak2.setBackground(lichtblauw);
		tipVak2.setBorder(null);
		tipVak2.setEditable(false);
		tipVak2.setForeground(Color.WHITE);
		tipVak2.setFont(font);
		tipVak2.setText(tips[1]);
		tipVak2.setVisible(false);
		tipVak3 = new JTextField();
		tipVak3.setBackground(lichtblauw);
		tipVak3.setBorder(null);
		tipVak3.setEditable(false);
		tipVak3.setForeground(Color.WHITE);
		tipVak3.setFont(font);
		tipVak3.setText(tips[2]);
		tipVak3.setVisible(false);
		tipVak4 = new JTextField();
		tipVak4.setBackground(lichtblauw);
		tipVak4.setBorder(null);
		tipVak4.setEditable(false);
		tipVak4.setForeground(Color.WHITE);
		tipVak4.setFont(font);
		tipVak4.setText(tips[3]);
		tipVak4.setVisible(false);

		// De outputvakken onder oplossing, setEnabled(false) zodat de gebruiker er niet
		// in kan typen
		wakOpVak = new JTextField(2);
		wakOpVak.setEditable(false);
		wakOpVak.setForeground(lichtblauw);
		wakOpVak.setBackground(Color.WHITE);
		wakOpVak.setFont(font);
		ijsbeerOpVak = new JTextField(2);
		ijsbeerOpVak.setEditable(false);
		ijsbeerOpVak.setForeground(lichtblauw);
		ijsbeerOpVak.setBackground(Color.WHITE);
		ijsbeerOpVak.setFont(font);
		pinguinOpVak = new JTextField(2);
		pinguinOpVak.setEditable(false);
		pinguinOpVak.setForeground(lichtblauw);
		pinguinOpVak.setBackground(Color.WHITE);
		pinguinOpVak.setFont(font);
		aantalGegooidVak = new JTextField(2);
		aantalGegooidVak.setEditable(false);
		aantalGegooidVak.setForeground(lichtblauw);
		aantalGegooidVak.setBackground(Color.WHITE);
		aantalGegooidVak.setFont(font);
		aantalGoedVak = new JTextField(2);
		aantalGoedVak.setEditable(false);
		aantalGoedVak.setForeground(Color.BLACK);
		aantalGoedVak.setBackground(Color.GREEN);
		aantalGoedVak.setFont(font);
		aantalFoutVak = new JTextField(2);
		aantalFoutVak.setEditable(false);
		aantalFoutVak.setForeground(Color.BLACK);
		aantalFoutVak.setBackground(Color.RED);
		aantalFoutVak.setFont(font);

		// Labels met witte letters maken
		wakLabel = new JLabel("Wakken:");
		wakLabel.setForeground(Color.WHITE);
		ijsbeerLabel = new JLabel("Ijsberen:");
		ijsbeerLabel.setForeground(Color.WHITE);
		pinguinLabel = new JLabel("Pinguïns:");
		pinguinLabel.setForeground(Color.WHITE);
		dAantalLabel = new JLabel("Aantal dobbelstenen:");
		dAantalLabel.setForeground(Color.WHITE);
		wakOpLabel = new JLabel("Wakken:");
		wakOpLabel.setForeground(Color.WHITE);
		ijsbeerOpLabel = new JLabel("Ijsberen:");
		ijsbeerOpLabel.setForeground(Color.WHITE);
		pinguinOpLabel = new JLabel("Pinguïns:");
		pinguinOpLabel.setForeground(Color.WHITE);
		aantalGegooidLabel = new JLabel("Aantal keer gegooid:");
		aantalGegooidLabel.setForeground(Color.WHITE);
		aantalGoedLabel = new JLabel("Aantal keer goed geraden:");
		aantalGoedLabel.setForeground(Color.WHITE);
		aantalFoutLabel = new JLabel("Aantal keer fout geraden:");
		aantalFoutLabel.setForeground(Color.WHITE);

		// Plaats en afmeting
		wakVak.setBounds(70, 260, 20, 20);
		wakLabel.setBounds(20, 260, 120, 20);
		ijsbeerVak.setBounds(145, 260, 20, 20);
		ijsbeerLabel.setBounds(95, 260, 120, 20);
		pinguinVak.setBounds(225, 260, 20, 20);
		pinguinLabel.setBounds(170, 260, 120, 20);
		controleerKnop.setBounds(340, 260, 120, 20);
		dAantalLabel.setBounds(504, 260, 140, 20);
		dAantalVak.setBounds(624, 260, 20, 20);
		werpKnop.setBounds(665, 260, 100, 20);
		opKnop.setBounds(465, 315, 120, 20);
		resetKnop.setBounds(600, 315, 80, 20);
		hKnop.setBounds(138, 420, 120, 20);
		wakOpVak.setBounds(515, 340, 20, 20);
		wakOpLabel.setBounds(465, 340, 120, 20);
		ijsbeerOpVak.setBounds(590, 340, 20, 20);
		ijsbeerOpLabel.setBounds(540, 340, 120, 20);
		pinguinOpVak.setBounds(670, 340, 20, 20);
		pinguinOpLabel.setBounds(615, 340, 120, 20);
		aantalGegooidVak.setBounds(582, 370, 20, 20);
		aantalGegooidLabel.setBounds(465, 370, 120, 20);
		aantalGoedVak.setBounds(616, 395, 20, 20);
		aantalGoedLabel.setBounds(465, 395, 160, 20);
		aantalFoutVak.setBounds(609, 420, 20, 20);
		aantalFoutLabel.setBounds(465, 420, 160, 20);
		tipVak1.setBounds(20, 335, 300, 15);
		tipVak2.setBounds(20, 355, 300, 15);
		tipVak3.setBounds(20, 375, 300, 15);
		tipVak4.setBounds(20, 395, 300, 15);

		// Invoer, uitvoer en tipvakken toevoegen aan het paneel
		add(wakVak);
		add(ijsbeerVak);
		add(pinguinVak);
		add(dAantalVak);
		add(wakOpVak);
		add(ijsbeerOpVak);
		add(pinguinOpVak);
		add(aantalGegooidVak);
		add(aantalGoedVak);
		add(aantalFoutVak);
		add(tipVak1);
		add(tipVak2);
		add(tipVak3);
		add(tipVak4);

		// Labels toevoegen aan het paneel
		add(wakLabel);
		add(ijsbeerLabel);
		add(pinguinLabel);
		add(dAantalLabel);
		add(wakOpLabel);
		add(ijsbeerOpLabel);
		add(pinguinOpLabel);
		add(aantalGegooidLabel);
		add(aantalGoedLabel);
		add(aantalFoutLabel);

		// Knoppen toevoegen aan het paneel
		add(controleerKnop);
		add(werpKnop);
		add(opKnop);
		add(resetKnop);
		add(hKnop);

		// De handleiding
		Handleiding.showHandleiding();
	}

	/*
	 * De paintComponent tekent de omlijningen en de dobbelstenen
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;
		// Dit maakt de rondingen van de Rects smoother
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// De borders tekenen
		graphics.setColor(Color.WHITE);
		// Dobbelsteenvak
		graphics.drawRoundRect(10, 10, 765, 225, 15, 15);
		// invoer- en spelinformatievak
		graphics.drawRoundRect(10, 245, 765, 50, 15, 15);
		// tipsvak
		graphics.setFont(new Font("Dialog", Font.PLAIN, 24));
		graphics.drawString("Tips:", 175, 330);
		graphics.drawRoundRect(10, 305, 380, 140, 15, 15);
		// resultaten- en oplossingvak
		graphics.drawRoundRect(395, 305, 380, 140, 15, 15);

		// Als magGooien true is en worpAantal gezet is in de actionListener van
		// werpKnop,
		// genereert deze switch nieuwe waardes voor het aantal gegooide dobbelstenen
		if (magGooien) {
			switch (worpAantal) {
			case 3:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.reset();
				dbl5.reset();
				dbl6.reset();
				dbl7.reset();
				dbl8.reset();
				dbl9.reset();
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 4:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.reset();
				dbl6.reset();
				dbl7.reset();
				dbl8.reset();
				dbl9.reset();
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 5:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.reset();
				dbl7.reset();
				dbl8.reset();
				dbl9.reset();
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 6:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.reset();
				dbl8.reset();
				dbl9.reset();
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 7:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl7.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.teken(graphics);
				dbl8.reset();
				dbl9.reset();
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 8:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl7.dobbel();
				dbl8.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.teken(graphics);
				dbl8.teken(graphics);
				dbl9.reset();
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 9:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl7.dobbel();
				dbl8.dobbel();
				dbl9.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.teken(graphics);
				dbl8.teken(graphics);
				dbl9.teken(graphics);
				dbl10.reset();
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 10:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl7.dobbel();
				dbl8.dobbel();
				dbl9.dobbel();
				dbl10.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.teken(graphics);
				dbl8.teken(graphics);
				dbl9.teken(graphics);
				dbl10.teken(graphics);
				dbl11.reset();
				dbl12.reset();
				magGooien = false;
				break;
			case 11:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl7.dobbel();
				dbl8.dobbel();
				dbl9.dobbel();
				dbl10.dobbel();
				dbl11.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.teken(graphics);
				dbl8.teken(graphics);
				dbl9.teken(graphics);
				dbl10.teken(graphics);
				dbl11.teken(graphics);
				dbl12.reset();
				magGooien = false;
				break;
			case 12:
				dbl1.dobbel();
				dbl2.dobbel();
				dbl3.dobbel();
				dbl4.dobbel();
				dbl5.dobbel();
				dbl6.dobbel();
				dbl7.dobbel();
				dbl8.dobbel();
				dbl9.dobbel();
				dbl10.dobbel();
				dbl11.dobbel();
				dbl12.dobbel();
				dbl1.teken(graphics);
				dbl2.teken(graphics);
				dbl3.teken(graphics);
				dbl4.teken(graphics);
				dbl5.teken(graphics);
				dbl6.teken(graphics);
				dbl7.teken(graphics);
				dbl8.teken(graphics);
				dbl9.teken(graphics);
				dbl10.teken(graphics);
				dbl11.teken(graphics);
				dbl12.teken(graphics);
				magGooien = false;
				break;
			}
		}
		// Als magGooien true is, tel alle wakken, ijsberen en pinguins bij elkaar op en
		// stop het in een variabele
		aWakken = dbl1.getWakken() + dbl2.getWakken() + dbl3.getWakken() + dbl4.getWakken() + dbl5.getWakken()
				+ dbl6.getWakken() + dbl7.getWakken() + dbl8.getWakken() + dbl9.getWakken() + dbl10.getWakken()
				+ dbl11.getWakken() + dbl12.getWakken();
		aIjsberen = dbl1.getIJsberen() + dbl2.getIJsberen() + dbl3.getIJsberen() + dbl4.getIJsberen()
				+ dbl5.getIJsberen() + dbl6.getIJsberen() + dbl7.getIJsberen() + dbl8.getIJsberen() + dbl9.getIJsberen()
				+ dbl10.getIJsberen() + dbl11.getIJsberen() + dbl12.getIJsberen();
		aPinguins = dbl1.getPinguins() + dbl2.getPinguins() + dbl3.getPinguins() + dbl4.getPinguins()
				+ dbl5.getPinguins() + dbl6.getPinguins() + dbl7.getPinguins() + dbl8.getPinguins() + dbl9.getPinguins()
				+ dbl10.getPinguins() + dbl11.getPinguins() + dbl12.getPinguins();
		// Print de antwoorden naar de console (om af te kijken hehe)
		if (worpAantal != 0) {
			System.out.println("Worp: " + totaalGegooid + " | Wakken: " + aWakken + " | Ijsberen: " + aIjsberen
					+ " | Pinguins: " + aPinguins);
		}
	}

	// Als de user op de werpKnop drukt, wordt de switch in de paintComponent
	// aangeroepen en worden de dobbelstenen getekend
	class Werp implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				magGooien = true;
				if (dAantalVak.getText().equals("")) {
					tipVak1.setVisible(true);
				} else {
					String a = dAantalVak.getText();
					int worpA = Integer.parseInt(a);
					worpAantal = worpA;
					if (worpA == 3 || worpA == 4 || worpA == 5 || worpA == 6 || worpA == 7 || worpA == 8 || worpA == 9
							|| worpA == 10 || worpA == 11 || worpA == 12) {
						Color lichtblauw = new Color(0, 191, 255);
						wakVak.setBackground(Color.WHITE);
						ijsbeerVak.setBackground(Color.WHITE);
						pinguinVak.setBackground(Color.WHITE);
						wakVak.setForeground(lichtblauw);
						ijsbeerVak.setForeground(lichtblauw);
						pinguinVak.setForeground(lichtblauw);
						wakVak.setText("");
						ijsbeerVak.setText("");
						pinguinVak.setText("");
						wakOpVak.setText("");
						ijsbeerOpVak.setText("");
						pinguinOpVak.setText("");
						controleerKnop.setEnabled(true);
						opKnop.setEnabled(true);
						werpKnop.setEnabled(false);
						wakVak.setEditable(true);
						ijsbeerVak.setEditable(true);
						pinguinVak.setEditable(true);
						dAantalVak.setEnabled(false);
						resetKnop.setEnabled(true);

						beurtFout = 0;
						totaalGegooid = totaalGegooid + 1;
						String totaalStringGegooid = Integer.toString(totaalGegooid);
						aantalGegooidVak.setText(totaalStringGegooid);

						tipVak1.setVisible(false);

						repaint();
					} else {
						dAantalVak.setText("");
						tipVak1.setVisible(true);
					}
				}
			} catch (Exception error) {
				tipVak1.setVisible(true);
				dAantalVak.setText("");
			}
		}
	}

	// Als de user op de opKnop drukt, laat dan de oplossing zien
	class Oplossing implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String bericht = "Je krijgt er een fout bij als je de oplossing wilt zien, weet je zeker dat je de oplossing wilt zien?";
			String titel = "Oplossing laten zien";
			int reply = JOptionPane.showConfirmDialog(null, bericht, titel, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				String aantalWaks = Integer.toString(aWakken);
				String aantalIjsbeers = Integer.toString(aIjsberen);
				String aantalPinguinen = Integer.toString(aPinguins);
				wakOpVak.setText(aantalWaks);
				ijsbeerOpVak.setText(aantalIjsbeers);
				pinguinOpVak.setText(aantalPinguinen);

				controleerKnop.setEnabled(false);
				opKnop.setEnabled(false);
				werpKnop.setEnabled(true);

				wakVak.setEditable(false);
				ijsbeerVak.setEditable(false);
				pinguinVak.setEditable(false);
				dAantalVak.setEnabled(true);
				dAantalVak.setText("");

				totaalFout = totaalFout + 1;
				String totaalStringFout = Integer.toString(totaalFout);
				aantalFoutVak.setText(totaalStringFout);
				magGooien = true;
			}
		}
	}

	// Als de user op de controleerKnop drukt, worden de antwoorden gecontroleerd
	class Controleren implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				gokWakken = Integer.parseInt(wakVak.getText());
				gokIjsberen = Integer.parseInt(ijsbeerVak.getText());
				gokPinguins = Integer.parseInt(pinguinVak.getText());

				// Logica om het antwoord van de gebruiker te controleren
				if (gokWakken == aWakken) {
					wakVak.setBackground(Color.GREEN);
					wakVak.setForeground(Color.BLACK);
				} else {
					wakVak.setBackground(Color.RED);
					wakVak.setForeground(Color.BLACK);
				}
				if (gokIjsberen == aIjsberen) {
					ijsbeerVak.setBackground(Color.GREEN);
					ijsbeerVak.setForeground(Color.BLACK);
				} else {
					ijsbeerVak.setBackground(Color.RED);
					ijsbeerVak.setForeground(Color.BLACK);
				}
				if (gokPinguins == aPinguins) {
					pinguinVak.setBackground(Color.GREEN);
					pinguinVak.setForeground(Color.BLACK);
				} else {
					pinguinVak.setBackground(Color.RED);
					pinguinVak.setForeground(Color.BLACK);
				}

				if (gokWakken == aWakken && gokIjsberen == aIjsberen && gokPinguins == aPinguins) {
					totaalGoed = totaalGoed + 1;
					String totaalStringGoed = Integer.toString(totaalGoed);
					aantalGoedVak.setText(totaalStringGoed);
				} else {
					totaalFout = totaalFout + 1;
					String totaalStringFout = Integer.toString(totaalFout);
					aantalFoutVak.setText(totaalStringFout);
				}

				// De oplossingen laten zien zodat de gebruiker kan vergelijken met zijn eigen
				// antwoorden
				String aantalWaks = Integer.toString(aWakken);
				String aantalIjsbeers = Integer.toString(aIjsberen);
				String aantalPinguinen = Integer.toString(aPinguins);
				wakOpVak.setText(aantalWaks);
				ijsbeerOpVak.setText(aantalIjsbeers);
				pinguinOpVak.setText(aantalPinguinen);

				controleerKnop.setEnabled(false);
				opKnop.setEnabled(false);
				werpKnop.setEnabled(true);

				wakVak.setEditable(false);
				ijsbeerVak.setEditable(false);
				pinguinVak.setEditable(false);
				dAantalVak.setEnabled(true);
				dAantalVak.setText("");
				tipVak2.setVisible(false);
				tipVak3.setVisible(false);
				tipVak4.setVisible(false);
				magGooien = true;
				// Als er een error voorkomt in de controlering, doe er een fout bij en laat
				// tips zien, na 3 fouten opnieuw gooien.
			} catch (Exception error) {
				tipVak2.setVisible(true);
				tipVak3.setVisible(true);
				tipVak4.setVisible(true);
				beurtFout = beurtFout + 1;
				if (beurtFout == 2) {
					JOptionPane.showMessageDialog(null, "Je hebt nog 1 kans om geldige waardes in te vullen",
							"Laatste kans", JOptionPane.INFORMATION_MESSAGE);
				}
				if (beurtFout >= 3) {
					JOptionPane.showMessageDialog(null, "Je hebt 3 keer een ongeldige input ingevuld, werp opnieuw.",
							"Jammer", JOptionPane.INFORMATION_MESSAGE);
					// De oplossingen laten zien zodat de gebruiker kan vergelijken met zijn eigen
					// antwoorden
					String aantalWaks = Integer.toString(aWakken);
					String aantalIjsbeers = Integer.toString(aIjsberen);
					String aantalPinguinen = Integer.toString(aPinguins);
					wakOpVak.setText(aantalWaks);
					ijsbeerOpVak.setText(aantalIjsbeers);
					pinguinOpVak.setText(aantalPinguinen);

					controleerKnop.setEnabled(false);
					opKnop.setEnabled(false);
					werpKnop.setEnabled(true);

					wakVak.setEditable(false);
					ijsbeerVak.setEditable(false);
					pinguinVak.setEditable(false);
					dAantalVak.setEnabled(true);
					dAantalVak.setText("");
					tipVak2.setVisible(false);
					tipVak3.setVisible(false);
					tipVak4.setVisible(false);
					wakVak.setText("");
					ijsbeerVak.setText("");
					pinguinVak.setText("");
					magGooien = true;

				}
				totaalFout = totaalFout + 1;
				String totaalStringFout = Integer.toString(totaalFout);
				aantalFoutVak.setText(totaalStringFout);
			}
		}
	}

	// Als de user op de resetKnop drukt, reset het gehele spel
	class Resetten implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Confirm box laten zien
			String bericht = "Weet je zeker dat je helemaal opnieuw wilt beginnen?";
			String titel = "Spel resetten";
			int reply = JOptionPane.showConfirmDialog(null, bericht, titel, JOptionPane.YES_NO_OPTION);
			// Als de gebruiker "Yes" aanklikt, reset dan het gehele spel
			if (reply == JOptionPane.YES_OPTION) {
				controleerKnop.setEnabled(false);
				opKnop.setEnabled(false);
				werpKnop.setEnabled(true);
				dAantalVak.setEnabled(true);
				dAantalVak.setText("");
				wakVak.setText("");
				ijsbeerVak.setText("");
				pinguinVak.setText("");
				wakVak.setBackground(Color.WHITE);
				ijsbeerVak.setBackground(Color.WHITE);
				pinguinVak.setBackground(Color.WHITE);
				wakVak.setEditable(false);
				ijsbeerVak.setEditable(false);
				pinguinVak.setEditable(false);
				wakOpVak.setText("");
				ijsbeerOpVak.setText("");
				pinguinOpVak.setText("");
				aantalGegooidVak.setText("");
				aantalGoedVak.setText("");
				aantalFoutVak.setText("");
				worpAantal = 0;
				totaalGegooid = 0;
				totaalGoed = 0;
				totaalFout = 0;
				resetKnop.setEnabled(false);
				magGooien = true;
				repaint();
				System.out.println("---NIEUW SPEL---");
			}
		}
	}

	// Als de user op de handleidingKnop drukt, komt de handleiding tevoorschijn
	class Handleid implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Handleiding.showHandleiding();
		}
	}
}