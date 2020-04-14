import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

/**
  *
  * Beschreibung
  *
  * @version 1.7 vom 01.04.2008
  * @author Chris
  */
// TODO: Es fehlt graphische anzeige beim Win und natürlich eine KI, dazu kommt noch Draw Bedindung vergessen
public class TicTacToe extends Frame
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
  private Button anzeige = new Button(werIst()+" ist am Zug.");
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
    l11.setFont(new Font("SansSerif", Font.BOLD, 60));
    l12.setFont(new Font("SansSerif", Font.BOLD, 60));
    l13.setFont(new Font("SansSerif", Font.BOLD, 60));
    l21.setFont(new Font("SansSerif", Font.BOLD, 60));
    l22.setFont(new Font("SansSerif", Font.BOLD, 60));
    l23.setFont(new Font("SansSerif", Font.BOLD, 60));
    l31.setFont(new Font("SansSerif", Font.BOLD, 60));
    l32.setFont(new Font("SansSerif", Font.BOLD, 60));
    l33.setFont(new Font("SansSerif", Font.BOLD, 60));
    ende.setFont(new Font("SansSerif", Font.BOLD, 25));
    nochmal.setFont(new Font("SansSerif", Font.BOLD, 25));
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
    
    ende.addActionListener(this);
    nochmal.addActionListener(this);
    
    // Ende Komponenten


    setResizable(false);
    setVisible(true);
  }

  // Anfang Ereignisprozeduren
  public void mouseExited(MouseEvent md){
    anzeige.setLabel("test");
    if (pruefe() == true){
      anzeige.setLabel(werIst()+" hat gewonnen!");
    } else {
      anzeige.setLabel(werIst()+" ist am Zug.");
    }
  }
  public void mouseEntered(MouseEvent me){
    anzeige.setLabel("test");
    if (pruefe() == true){
      anzeige.setLabel(werIst()+" hat gewonnen!");
    } else {
      anzeige.setLabel(werIst()+" ist am Zug.");
    }
  }
  public void mouseReleased(MouseEvent e) {
     anzeige.setLabel("test");
    if (pruefe() == true){
      anzeige.setLabel(werIst()+" hat gewonnen!");
    } else {
      anzeige.setLabel(werIst()+" ist am Zug.");
    }
  } //bisher eher nicht erfolgreich gewesen
  public void mouseClicked(MouseEvent e) {
     // ebenso ergaben die Tests mist
     if (pruefe() == true){
      anzeige.setLabel(werIst()+" hat gewonnen!");
    } else {
      anzeige.setLabel(werIst()+" ist am Zug.");
    }
  }
  public void mousePressed(MouseEvent e) {  // hier nur sehr bedingt hilfreich zur überprüfung der Bedingungen
    anzeige.setLabel("test");
    if (pruefe() == true){
      anzeige.setLabel(werIst()+" hat gewonnen!");
    } else {
      anzeige.setLabel(werIst()+" ist am Zug.");
    }
  }
  
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    // verhinderung der mehrfachbenutzung der felder
    if ( e.getActionCommand() == "off"){
      anzeige.setLabel(sp+" ist dran");
    } else
    //Abfrage wer ist dran Spieler (1) oder Spieler (2) und Markieren
    switch(sp){
      case 1:
              mark = "X";
              sp=2;
        break;
      case 2:
              mark = "O";
              sp=1;
        break;
    } // switch
       // nach gesetzter Markierung wird gewechselt
              if ( obj == l11 ){
                l11.setActionCommand("off");
                l11.setLabel(mark);
              }
              if ( obj == l12 ){
                l12.setActionCommand("off");
                l12.setLabel(mark);
              }
              if ( obj == l13 ){
                l13.setActionCommand("off");
                l13.setLabel(mark);
              }
              if ( obj == l21 ){
                l21.setActionCommand("off");
                l21.setLabel(mark);
              }
              if ( obj == l22 ){
                l22.setActionCommand("off");
                l22.setLabel(mark);
              }
              if ( obj == l23 ){
                l23.setActionCommand("off");
                l23.setLabel(mark);
              }
              if ( obj == l31 ){
                l31.setActionCommand("off");
                l31.setLabel(mark);
              }
              if ( obj == l32 ){
                l32.setActionCommand("off");
                l32.setLabel(mark);
              }
              if ( obj == l33 ){
                l33.setActionCommand("off");
                l33.setLabel(mark);
              }
     // da sonst nur bei bewegung der Maus angezeigt wird wer aktuell dran ist.
     if (pruefe() == true){
       anzeige.setForeground(Color.red);
       einfaerben();
       anzeige.setLabel(werIst()+" hat gewonnen!");
       //weiterspielen unterbinden mit
       l11.removeActionListener(this);
       l12.removeActionListener(this);
       l13.removeActionListener(this);
       l21.removeActionListener(this);
       l22.removeActionListener(this);
       l23.removeActionListener(this);
       l31.removeActionListener(this);
       l32.removeActionListener(this);
       l33.removeActionListener(this);
     }  else {
       anzeige.setLabel(werIst()+" ist am Zug.");
     }
    //Zusatzbuttons
    if (obj == ende) System.exit(0);
    if (obj == nochmal) {
      this.dispose();
      new TicTacToe("TicTacToe");
    }

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
           
           //Draw
           if (l11.getLabel()!="" && l12.getLabel()!="" && l13.getLabel()!=""
              && l21.getLabel()!="" && l22.getLabel()!="" && l23.getLabel()!=""
              && l31.getLabel()!="" && l32.getLabel()!="" && l33.getLabel()!=""){
                sp=0;
                status=false;
              }

    return status;
  }
  public String werIst(){
    if( sp == 1 ){
      mark = "X";
    }
    if( sp == 2 ){
      mark = "O";
    }
    if( sp == 0 ){
      mark = "DRAW";
    }
    return mark;
  }
  public void einfaerben(){
    //Buttons Feldern zuweisen um diese dann einzufärben
    // wenn gewonnen
    switch(sp){
      case 1:
              mark = "X";
        break;
      case 2:
              mark = "O";
        break;
    } // switch
    if (l11.getLabel()==mark && l12.getLabel()==mark && l13.getLabel()==mark) {
      l11.setBackground(Color.green); l12.setBackground(Color.green); l13.setBackground(Color.green);
    }
    if (l21.getLabel()==mark && l22.getLabel()==mark && l23.getLabel()==mark){
      l21.setBackground(Color.green); l22.setBackground(Color.green); l23.setBackground(Color.green);
    }
    if (l31.getLabel()==mark && l32.getLabel()==mark && l33.getLabel()==mark){
      l31.setBackground(Color.green); l32.setBackground(Color.green); l33.setBackground(Color.green);
    }
    if (l11.getLabel()==mark && l21.getLabel()==mark && l31.getLabel()==mark){
      l11.setBackground(Color.green); l21.setBackground(Color.green); l31.setBackground(Color.green);
    }
    if (l12.getLabel()==mark && l22.getLabel()==mark && l32.getLabel()==mark){
      l12.setBackground(Color.green); l22.setBackground(Color.green); l32.setBackground(Color.green);
    }
    if (l13.getLabel()==mark && l23.getLabel()==mark && l33.getLabel()==mark){
      l13.setBackground(Color.green); l23.setBackground(Color.green); l33.setBackground(Color.green);
    }
    if (l11.getLabel()==mark && l22.getLabel()==mark && l33.getLabel()==mark){
      l11.setBackground(Color.green); l22.setBackground(Color.green); l33.setBackground(Color.green);
    }
    if (l13.getLabel()==mark && l22.getLabel()==mark && l31.getLabel()==mark){
      l13.setBackground(Color.green); l22.setBackground(Color.green); l31.setBackground(Color.green);
    }
  }
  public void KiAuswahl(){
    int pos[] = new int[9];
    
  }
  // Ende Ereignisprozeduren
  public static void main(String[] args) {
    TicTacToe game = new TicTacToe("TicTacToe");

  }
}// TicTacToe

