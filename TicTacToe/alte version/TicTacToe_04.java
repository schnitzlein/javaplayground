import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

/**
  *
  * Beschreibung
  *
  * @version 1.4 vom 01.04.2008
  * @author Chris
  */

public class TicTacToe_04 extends Frame
implements ActionListener,MouseListener{
  // Anfang Variablen
  private int sp = 1;
  private String mark = "";
  private boolean status = false; // wenn er true wird ist gewonnen
  
  private Button l11 = new Button();
  private Button l12 = new Button();
  private Button l13 = new Button();
  private Button l21 = new Button();
  private Button l22 = new Button();
  private Button l23 = new Button();
  private Button l31 = new Button();
  private Button l32 = new Button();
  private Button l33 = new Button();
  
  private Button nochmal = new Button("nochmal");
  private Button ende = new Button("ende");
  private Button anzeige = new Button("Spieler 1 ist dran");
  // Ende Variablen

  public TicTacToe_04(String title) {
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

    // Listener
    l11.addActionListener(this);
    l12.addActionListener(this);
    l13.addActionListener(this);
    l21.addActionListener(this);
    l22.addActionListener(this);
    l23.addActionListener(this);
    l31.addActionListener(this);
    l32.addActionListener(this);
    l33.addActionListener(this);

    l11.addMouseListener(this);
    l12.addMouseListener(this);
    l13.addMouseListener(this);
    l21.addMouseListener(this);
    l22.addMouseListener(this);
    l23.addMouseListener(this);
    l31.addMouseListener(this);
    l32.addMouseListener(this);
    l33.addMouseListener(this);
    // Ende Komponenten


    setResizable(false);
    setVisible(true);
  }

  // Anfang Ereignisprozeduren
  public void mouseExited(MouseEvent md){}
  public void mouseEntered(MouseEvent me){}
  public void mouseReleased(MouseEvent e) {

  }
  public void mouseClicked(MouseEvent e) {
    anzeige.setLabel("test");
    if (pruefe() == true){
      anzeige.setLabel(sp+" hat gewonnen!");
      //l11.setActionCommand("off");
    } else {
      anzeige.setLabel("Status ist "+status);
    }
  }
  public void mousePressed(MouseEvent e) {  }
  
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();

    //Abfrage wer ist dran Spieler (1) oder Spieler (2) und Markieren
    switch(sp){
      case 1:
              mark = "X";
              if ( obj == l11 ) l11.setLabel(mark);        //killt irgendwie alle action listener kein plan
              if ( obj == l12 ) l12.setLabel(mark);
              if ( obj == l13 ) l13.setLabel(mark);
              if ( obj == l21 ) l21.setLabel(mark);
              if ( obj == l22 ) l22.setLabel(mark);
              if ( obj == l23 ) l23.setLabel(mark);
              if ( obj == l31 ) l31.setLabel(mark);
              if ( obj == l32 ) l32.setLabel(mark);
              if ( obj == l33 ) l33.setLabel(mark);
              sp=2;     // nach gesetzter Markierung wird gewechselt
                        // hier muss noch erfolgen das dass markierte feld nich mehr benutzt werden kann.
        break;
      case 2:
              mark = "O";
              if ( obj == l11 ) l11.setLabel(mark);
              if ( obj == l12 ) l12.setLabel(mark);
              if ( obj == l13 ) l13.setLabel(mark);
              if ( obj == l21 ) l21.setLabel(mark);
              if ( obj == l22 ) l22.setLabel(mark);
              if ( obj == l23 ) l23.setLabel(mark);
              if ( obj == l31 ) l31.setLabel(mark);
              if ( obj == l32 ) l32.setLabel(mark);
              if ( obj == l33 ) l33.setLabel(mark);
              sp=1;
        break;
    } // switch
    if (obj == ende) System.exit(0);
    //l11.setBackground(Color.green);
    //anzeige.setLabel(e.paramString());

    /*Object obj = e.getSource();

        if (obj == jbRot) cp.setBackground(Color.RED);
        if (obj == jbGelb) cp.setBackground(Color.YELLOW);
        if (obj == jbGruen) cp.setBackground(Color.GREEN);
        if (obj == jbNeutral) cp.setBackground(bgColor);
        if (obj == jbStop) System.exit(0);
        */
  }
  public boolean pruefe(){

       /*waagerecht || w || w || senkrecht || s || s || diagonal || d */
      if ((l11.getLabel()=="X" && l12.getLabel()=="X" && l13.getLabel()=="X")||(l21.getLabel()=="X"
       && l22.getLabel()=="X" && l23.getLabel()=="X") || (l31.getLabel()=="X" && l32.getLabel()=="X"
        && l33.getLabel()=="X") || (l11.getLabel()=="X" && l21.getLabel()=="X" && l31.getLabel()=="X") || (l12.getLabel()=="X"
         && l22.getLabel()=="X" && l32.getLabel()=="X")|| (l13.getLabel()=="X" && l23.getLabel()=="X"
          && l33.getLabel()=="X")|| (l11.getLabel()=="X" && l22.getLabel()=="X" && l33.getLabel()=="X")||(l13.getLabel()=="X"
           && l22.getLabel()=="X" && l31.getLabel()=="X")) {
             sp=1;
             status=true;
           }

              /*waagerecht || w || w || senkrecht || s || s || diagonal || d */
      if ((l11.getLabel()=="O" && l12.getLabel()=="O" && l13.getLabel()=="O")||(l21.getLabel()=="O"
       && l22.getLabel()=="O" && l23.getLabel()=="O") || (l31.getLabel()=="O" && l32.getLabel()=="O"
        && l33.getLabel()=="O") || (l11.getLabel()=="O" && l21.getLabel()=="O" && l31.getLabel()=="O") || (l12.getLabel()=="O"
         && l22.getLabel()=="O" && l32.getLabel()=="O")|| (l13.getLabel()=="O" && l23.getLabel()=="O"
          && l33.getLabel()=="O")|| (l11.getLabel()=="O" && l22.getLabel()=="O" && l33.getLabel()=="O")||(l13.getLabel()=="O"
           && l22.getLabel()=="O" && l31.getLabel()=="O")) {
             sp=2;
             status=true;
           }

    return status;
  }
  // Ende Ereignisprozeduren
  public static void main(String[] args) {
    TicTacToe_04 game = new TicTacToe_04("TicTacToe_04");

  }
}

