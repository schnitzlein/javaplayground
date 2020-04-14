import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 01.04.2008
  * @author Chris
  */

public class TicTacToe extends Frame implements ActionListener{
  // Anfang Variablen
  private int sp = 1;
  private String mark = "";
  private boolean status = false; // wenn er true wird ist gewonnen
  
  private Button l11 = new Button("x");
  private Button l12 = new Button();
  private Button l13 = new Button("O");
  private Button l21 = new Button("X");
  private Button l22 = new Button();
  private Button l23 = new Button("O");
  private Button l31 = new Button("x");
  private Button l32 = new Button();
  private Button l33 = new Button("O");
  
  private Button nochmal = new Button("nochmal");
  private Button ende = new Button("ende");
  private Button anzeige = new Button("Spieler 1 ist dran");
  // Ende Variablen

  public TicTacToe(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { System.exit(0); }
    });
    int frameWidth = 400;
    int frameHeight = 400;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2 ;
    setLocation(x, y);
    // Frame
    // Panel Gerüst
    Panel geruest = new Panel(new BorderLayout());
    Panel spiel = new Panel(new GridLayout(3, 4));
    this.add(geruest);
    geruest.add(spiel, BorderLayout.CENTER);

    // Schriftgröße und Farbe
    l11.setFont(new Font("SansSerif", Font.BOLD, 50));
    l12.setFont(new Font("SansSerif", Font.BOLD, 50));
    l13.setFont(new Font("SansSerif", Font.BOLD, 50));
    l21.setFont(new Font("SansSerif", Font.BOLD, 50));
    l22.setFont(new Font("SansSerif", Font.BOLD, 50));
    l23.setFont(new Font("SansSerif", Font.BOLD, 50));
    l31.setFont(new Font("SansSerif", Font.BOLD, 50));
    l32.setFont(new Font("SansSerif", Font.BOLD, 50));
    l33.setFont(new Font("SansSerif", Font.BOLD, 50));
    anzeige.setBackground(Color.white);
    nochmal.setBackground(Color.yellow);
    ende.setBackground(Color.red);
    // Anfang Komponenten
    spiel.add(l11);
    spiel.add(l12);
    spiel.add(l13);
    spiel.add(nochmal);
    spiel.add(l21);
    spiel.add(l22);
    spiel.add(l23);
    spiel.add(ende);
    spiel.add(l31);
    spiel.add(l32);
    spiel.add(l33);
    spiel.add(anzeige);

    // Listener & commands
    l11.addActionListener(this);
    l11.setActionCommand("l11");
    // Ende Komponenten


    setResizable(false);
    setVisible(true);
  }

  // Anfang Ereignisprozeduren
  public void actionPerformed(ActionEvent e){
    //Abfrage wer ist dran Spieler (1) oder Spieler (2)
    switch(sp){
      case 1: anzeige.setLabel("Spieler "+sp+" ist dran");
              mark = "X";
              if ( e.getActionCommand() == "l11" ) l11.setLabel(mark);
              if ( e.getActionCommand() == "l12" ) l12.setLabel(mark);
              if ( e.getActionCommand() == "l13" ) l13.setLabel(mark);
              if ( e.getActionCommand() == "l21" ) l21.setLabel(mark);
              if ( e.getActionCommand() == "l22" ) l22.setLabel(mark);
              if ( e.getActionCommand() == "l23" ) l23.setLabel(mark);
              if ( e.getActionCommand() == "l31" ) l31.setLabel(mark);
              if ( e.getActionCommand() == "l32" ) l32.setLabel(mark);
              if ( e.getActionCommand() == "l33" ) l33.setLabel(mark);
        break;
      case 2: anzeige.setLabel("Spieler "+sp+" ist dran");
              mark = "O";
              if ( e.getActionCommand() == "l11" ) l11.setLabel(mark);
              if ( e.getActionCommand() == "l12" ) l12.setLabel(mark);
              if ( e.getActionCommand() == "l13" ) l13.setLabel(mark);
              if ( e.getActionCommand() == "l21" ) l21.setLabel(mark);
              if ( e.getActionCommand() == "l22" ) l22.setLabel(mark);
              if ( e.getActionCommand() == "l23" ) l23.setLabel(mark);
              if ( e.getActionCommand() == "l31" ) l31.setLabel(mark);
              if ( e.getActionCommand() == "l32" ) l32.setLabel(mark);
              if ( e.getActionCommand() == "l33" ) l33.setLabel(mark);
        break;
    } // switch
    l11.setBackground(Color.green);
    //anzeige.setLabel(e.paramString());

    /*Object obj = e.getSource();

        if (obj == jbRot) cp.setBackground(Color.RED);
        if (obj == jbGelb) cp.setBackground(Color.YELLOW);
        if (obj == jbGruen) cp.setBackground(Color.GREEN);
        if (obj == jbNeutral) cp.setBackground(bgColor);
        if (obj == jbStop) System.exit(0);
        */
  }
  // Ende Ereignisprozeduren

  public static void main(String[] args) {
    new TicTacToe("TicTacToe");
  }
}

