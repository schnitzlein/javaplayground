import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import java.math.*;
//TODO überflüssige Pakete entfernen
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.event.ItemListener;
import javax.swing.JFrame;



/**
  *
  * Beschreibung
  *
  * @version 1.8 vom 04.03.2011
  * @author Chris
  */
// TODO: Es fehlt graphische anzeige beim Win und natürlich eine KI, den DRAW Fall auslagern als MEthode wegen Mehrfachverwendung
// TODO: Die Auslagerungsmethode in den MouseEvents implementieren: Anzeige,beiwin und  lost zeugs und ki
public class TicTacToe_bak
implements ActionListener, ItemListener{
  // Anfang Variablen
  private int sp = 1;
  private String mark = "";
  private boolean status = false; // wenn er true wird ist gewonnen
  private String pos[] = new String[9];
  private int zufall = 0;
  private int welche;
  private int count=1;
  
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
  
  private JRadioButton s1Button = new JRadioButton("Spieler 1" ,false);
  private JRadioButton s2Button = new JRadioButton("Spieler 2" ,false);
  private JRadioButton rButton = new JRadioButton("Zufall", false);

  ButtonGroup bgroup = new ButtonGroup();
  Border border;
  
  private ActionEvent event;
  
  final JPanel geruest, spiel, menue;
  JFrame frame;
  // Ende Variablen

  public TicTacToe_bak(String title) {
    erzeugeFrame(title);
    // Panel
    geruest = new JPanel(new BorderLayout());
    spiel = new JPanel(new GridLayout(3, 4,2,2));
    menue = new JPanel(new GridLayout(5,1,2,2));
    frame.add(geruest);

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
    

    
    // Anfang Komponenten Spiel
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

    // Anfang Komponenten Menue
    menue.add(s1Button);
    menue.add(s2Button);
    menue.add(rButton);


    border = BorderFactory.createTitledBorder("Wer soll beginnen?");
    menue.setBorder(border);
    bgroup.add(s1Button);
    bgroup.add(s2Button);
    bgroup.add(rButton);

    //menue ins gerüst hängen
    geruest.add(menue);

    // Listener
    s1Button.addItemListener(this);
    s2Button.addItemListener(this);
    rButton.addItemListener(this);

    
    l11.addActionListener(this);
    l12.addActionListener(this);
    l13.addActionListener(this);
    l21.addActionListener(this);
    l22.addActionListener(this);
    l23.addActionListener(this);
    l31.addActionListener(this);
    l32.addActionListener(this);
    l33.addActionListener(this);
    
    ende.addActionListener(this);
    nochmal.addActionListener(this);
    
    // Ende Komponenten
    status = false;


  }
  
  public void erzeugeFrame(String title){
    // Frame-Initialisierung
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int frameWidth = 150;
    int frameHeight = 150;
    frame.setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - frame.getSize().width) / 2;
    int y = (d.height - frame.getSize().height) / 2 ;
    frame.setLocation(x, y);
    frame.setResizable(false);
    frame.setVisible(true);
    // Frame
  }

  //menue ItemStateChanged Listener
  public void itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == ItemEvent.SELECTED) {
      if (e.getItem().equals(s1Button)) sp = 1;
      if (e.getItem().equals(s2Button)) sp = 2;
      if (e.getItem().equals(rButton)) {
        sp = (Zufall()%2);
        if (sp == 0) sp = 2;

      }
      geruestAendern();
    }
    //System.out.println(sp);
  }

  public void geruestAendern(){
    geruest.remove(menue);
      //SpielFeld ins Gerüst hängen
      geruest.add(spiel, BorderLayout.CENTER);
      frame.setSize(400,400);
      geruest.revalidate();
      //geruest.getRootPane().revalidate();
  }

  // Anfang Ereignisprozeduren
  
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    String commands;
    
    if (sp == 2){
      KiDings();
      platzSparen();
    }
    // verhinderung der mehrfachbenutzung der felder
    if ( e.getActionCommand() == "off"){
      anzeige.setLabel(sp+" ist dran"); //nur anzeige bei klick, kein Spielerwechsel
    } else {
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
                l11.removeActionListener(this);    // hä
                l11.setLabel(mark);
              }
              if ( obj == l12 ){
                l12.setActionCommand("off");
                l12.removeActionListener(this);
                l12.setLabel(mark);
              }
              if ( obj == l13 ){
                l13.setActionCommand("off");
                l13.removeActionListener(this);
                l13.setLabel(mark);
              }
              if ( obj == l21 ){
                l21.setActionCommand("off");
                l21.removeActionListener(this);
                l21.setLabel(mark);
              }
              if ( obj == l22 ){
                l22.setActionCommand("off");
                l22.removeActionListener(this);
                l22.setLabel(mark);
              }
              if ( obj == l23 ){
                l23.setActionCommand("off");
                l23.removeActionListener(this);
                l23.setLabel(mark);
              }
              if ( obj == l31 ){
                l31.setActionCommand("off");
                l31.setLabel(mark);
              }
              if ( obj == l32 ){
                l32.setActionCommand("off");
                l32.removeActionListener(this);
                l32.setLabel(mark);
              }
              if ( obj == l33 ){
                l33.setActionCommand("off");
                l33.removeActionListener(this);
                l33.setLabel(mark);
              }
    }

//        KiUnmoeglich();
//        KiZufall();
        //KiMeineWahl();

    //Zusatzbuttons
    if (obj == ende) System.exit(0);
    if (obj == nochmal) {
      frame.dispose();
      new TicTacToe_bak("TicTacToe_bak");
    }
    if (status == true) {
      return;
    } else {
      KiDings();
      // da sonst nur bei bewegung der Maus angezeigt wird wer aktuell dran ist.
      platzSparen();
    }
  }
  //prüft ob ein sieg vorliegt
  public boolean pruefe(){
        if (status == true) return status; //Terminationsbedingung, damit compi nicht nochmal spielt
       /*waagerecht || w || w || senkrecht || s || s || diagonal || d */
      if ((l11.getLabel()=="X" && l12.getLabel()=="X" && l13.getLabel()=="X")||(l21.getLabel()=="X"
       && l22.getLabel()=="X" && l23.getLabel()=="X") || (l31.getLabel()=="X" && l32.getLabel()=="X"
        && l33.getLabel()=="X") || (l11.getLabel()=="X" && l21.getLabel()=="X" && l31.getLabel()=="X") || (l12.getLabel()=="X"
         && l22.getLabel()=="X" && l32.getLabel()=="X")|| (l13.getLabel()=="X" && l23.getLabel()=="X"
          && l33.getLabel()=="X")|| (l11.getLabel()=="X" && l22.getLabel()=="X" && l33.getLabel()=="X")||(l13.getLabel()=="X"
           && l22.getLabel()=="X" && l31.getLabel()=="X")) {
             sp=1;          //gewonnen hat spieler 1
             status=true;
           }

              /*waagerecht || w || w || senkrecht || s || s || diagonal || d */
      if ((l11.getLabel()=="O" && l12.getLabel()=="O" && l13.getLabel()=="O")||(l21.getLabel()=="O"
       && l22.getLabel()=="O" && l23.getLabel()=="O") || (l31.getLabel()=="O" && l32.getLabel()=="O"
        && l33.getLabel()=="O") || (l11.getLabel()=="O" && l21.getLabel()=="O" && l31.getLabel()=="O") || (l12.getLabel()=="O"
         && l22.getLabel()=="O" && l32.getLabel()=="O")|| (l13.getLabel()=="O" && l23.getLabel()=="O"
          && l33.getLabel()=="O")|| (l11.getLabel()=="O" && l22.getLabel()=="O" && l33.getLabel()=="O")||(l13.getLabel()=="O"
           && l22.getLabel()=="O" && l31.getLabel()=="O")) {
             sp=2;  //gewonnen hat spieler 2
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
  //macht das Zeichen auf den Buttons
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
  public void platzSparen(){
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
  }
  public String lesePos(int nummer){
    return pos[nummer];
  }
  //Computer Hilfsfunktion
  public void schreibePos(int welcher){
    switch(welcher){
      case 0: l11.setLabel("O");
           pos[0]=l11.getLabel();
           l11.removeActionListener(this);
        break;
      case 1: l12.setLabel("O");
           pos[1]=l12.getLabel();
           l12.removeActionListener(this);
        break;
      case 2: l13.setLabel("O");
           pos[2]=l13.getLabel();
           l13.removeActionListener(this);
        break;
      case 3: l21.setLabel("O");
           pos[3]=l21.getLabel();
           l21.removeActionListener(this);
        break;
      case 4: l22.setLabel("O");
           pos[4]=l22.getLabel();
           l22.removeActionListener(this);
        break;
      case 5: l23.setLabel("O");
           pos[5]=l23.getLabel();
           l23.removeActionListener(this);
        break;
      case 6: l31.setLabel("O");
           pos[6]=l31.getLabel();
           l31.removeActionListener(this);
        break;
      case 7: l32.setLabel("O");
           pos[7]=l32.getLabel();
           l32.removeActionListener(this);
        break;
      case 8: l33.setLabel("O");
           pos[8]=l33.getLabel();
           l33.removeActionListener(this);
        break;
    }
  }
  public void KiUnmoeglich(){
    switch (sp) {
      case 1: //nichts tun

        break;
      case 2:
        // Felder ermitteln
        if (kannWin() == 9){ // erster Zug oder kein Problem
          for(int i=0;i<9;i++){
           if ( lesePos(i)=="O" || lesePos(i)=="X" ){
             // schon besetzt
             int jochen = Zufall();
             if(jochen!=i){
                schreibePos(jochen);
                sp=1;
                return;  //Hier Abbruch der Zählschleife
             } else {
                // Fehler hier gehts noch nicht wetier
                sp=1;
             return;
             }

           }
           else {
             schreibePos(Zufall());
             sp=1;
             return;  //Hier Abbruch der Zählschleife
           }
          }

          
        } else {
          schreibePos(kannWin());
          sp=1;
        }

        break;
      default:

    }
  }
  public void KiDings() {
    int tmp;
    if (status == true) return; //billiger abbruch
      if ( sp == 2 && status == false){
        platzSparen();
        //aussicht das der pc gewinnen kann
        if ( compWin() > -1 && compWin() < 9) {
          schreibePos(compWin());
//          System.out.print(compWin()+" ");
          sp=1; //damit endet Ki Runde
          return;
        }
        //aussicht den spieler zu blocken
        if ( kannWin() > -1 && kannWin() < 9) {
          schreibePos(kannWin());
          System.out.print(kannWin()+" ");
          sp=1; //damit endet Ki Runde
          return;
        }

        /*//standart fall    TODO: noch uncool
        tmp = Zufall();
        if (lesePos(tmp) == "") {
          schreibePos(tmp); sp=1; return; //damit endet Ki Runde
        } */

        if ( lesePos(4) == "" ) {schreibePos(4); sp=1; return; }
        if ( lesePos(0) == "" )  {schreibePos(0); sp=1; return; }//damit endet Ki Runde
        if ( lesePos(2) == "" ) {schreibePos(2); sp=1; return; }
        if ( lesePos(6) == "" ) {schreibePos(6); sp=1; return; }
        if ( lesePos(8) == "" ) {schreibePos(8); sp=1; return; }
        if ( lesePos(1) == "" ) {schreibePos(1); sp=1; return; }
        if ( lesePos(3) == "" ) {schreibePos(3); sp=1; return; }
        if ( lesePos(5) == "" ) {schreibePos(5); sp=1; return; }
        if ( lesePos(7) == "" ) {schreibePos(7); sp=1; return; }
        //TODO: 0,2,6,8 random machen*/

      }

  }
  public int kannWin(){
    int tmp;
    if (lesePos(3)=="" && lesePos(4)=="X" && lesePos(5)=="X"){       // 22,23
      tmp = 3;
      return tmp;
    }
    if (lesePos(3)=="X" && lesePos(4)=="X" && lesePos(5)==""){       // 21,22
      tmp = 5;
      return tmp;
    }
    if (lesePos(3)=="X" && lesePos(4)=="" && lesePos(5)=="X"){       // 22,12
      tmp = 4;
      return tmp;
    }
    if (lesePos(1)=="X" && lesePos(4)=="X" && lesePos(7)==""){       // 12,22
      tmp = 7;
      return tmp;
    }
    if (lesePos(1)=="" && lesePos(4)=="X" && lesePos(7)=="X"){       // 22,32
      tmp = 1;
      return tmp;
    }
    if (lesePos(1)=="X" && lesePos(4)=="" && lesePos(7)=="X"){       // 12,32
      tmp = 4;
      return tmp;
    }
    if (lesePos(0)=="X" && lesePos(4)=="X" && lesePos(8)==""){       // 11,22
      tmp = 8;
      return tmp;
    }
    if (lesePos(0)=="" && lesePos(4)=="X" && lesePos(8)=="X"){       // 22,33
      tmp = 0;
      return tmp;
    }
    if (lesePos(0)=="X" && lesePos(4)=="" && lesePos(8)=="X"){       // 11,33
      tmp = 4;
      return tmp;
    }
    if (lesePos(4)=="X" && lesePos(2)=="X" && lesePos(6)==""){       // 22,13
      tmp = 6;
      return tmp;
    }
    if (lesePos(4)=="X" && lesePos(2)=="" && lesePos(6)=="X"){       // 22,31
      tmp = 2;
      return tmp;
    }
    if (lesePos(4)=="" && lesePos(2)=="X" && lesePos(6)=="X"){       // 31,13
      tmp = 4;
      return tmp;
    }
    if (lesePos(0)=="X" && lesePos(3)=="X" && lesePos(6)==""){       // 11,21
      tmp = 6;
      return tmp;
    }
    if (lesePos(0)=="" && lesePos(3)=="X" && lesePos(6)=="X"){       // 31,21
      tmp = 0;
      return tmp;
    }
    if (lesePos(0)=="X" && lesePos(3)=="" && lesePos(6)=="X"){       // 11,31
      tmp = 3;
      return tmp;
    }
    if (lesePos(1)=="X" && lesePos(4)=="X" && lesePos(7)==""){       // 12,22
      tmp = 7;
      return tmp;
    }
    if (lesePos(1)=="" && lesePos(4)=="X" && lesePos(7)=="X"){       // 22,32
      tmp = 1;
      return tmp;
    }
    if (lesePos(1)=="X" && lesePos(4)=="" && lesePos(7)=="X"){       // 12,32
      tmp = 4;
      return tmp;
    }
    if (lesePos(2)=="X" && lesePos(5)=="X" && lesePos(8)==""){       // 13,23
      tmp = 8;
      return tmp;
    }
    if (lesePos(2)=="" && lesePos(5)=="X" && lesePos(8)=="X"){       // 33,23
      tmp = 2;
      return tmp;
    }
    if (lesePos(2)=="X" && lesePos(5)=="" && lesePos(8)=="X"){       // 13,33
      tmp = 5;
      return tmp;
    }
    if (lesePos(6)=="X" && lesePos(8)=="X" && lesePos(7)==""){
      tmp = 7;
      return tmp;
    }
    if (lesePos(6)=="X" && lesePos(8)=="" && lesePos(7)=="X"){
      tmp = 8;
      return tmp;
    }
    if (lesePos(6)=="" && lesePos(8)=="X" && lesePos(7)=="X"){
      tmp = 6;
      return tmp;
    }
    return -1;
  }
  public int compWin(){
    int tmp;
    if (lesePos(3)=="" && lesePos(4)=="O" && lesePos(5)=="O"){       // 22,23
      tmp = 3;
      return tmp;
    }
    if (lesePos(3)=="O" && lesePos(4)=="O" && lesePos(5)==""){       // 21,22
      tmp = 5;
      return tmp;
    }
    if (lesePos(3)=="O" && lesePos(4)=="" && lesePos(5)=="O"){       // 22,12
      tmp = 4;
      return tmp;
    }
    if (lesePos(1)=="O" && lesePos(4)=="O" && lesePos(7)==""){       // 12,22
      tmp = 7;
      return tmp;
    }
    if (lesePos(1)=="" && lesePos(4)=="O" && lesePos(7)=="O"){       // 22,32
      tmp = 1;
      return tmp;
    }
    if (lesePos(1)=="O" && lesePos(4)=="" && lesePos(7)=="O"){       // 12,32
      tmp = 4;
      return tmp;
    }
    if (lesePos(0)=="O" && lesePos(3)=="O" && lesePos(6)==""){
      tmp = 6;
      return tmp;
    }
    if (lesePos(0)=="O" && lesePos(4)=="O" && lesePos(8)==""){       // 11,22
      tmp = 8;
      return tmp;
    }
    if (lesePos(0)=="" && lesePos(4)=="O" && lesePos(8)=="O"){       // 22,33
      tmp = 0;
      return tmp;
    }
    if (lesePos(0)=="O" && lesePos(4)=="" && lesePos(8)=="O"){       // 11,33
      tmp = 4;
      return tmp;
    }
    if (lesePos(4)=="O" && lesePos(2)=="O" && lesePos(6)==""){       // 22,13
      tmp = 6;
      return tmp;
    }
    if (lesePos(4)=="O" && lesePos(2)=="" && lesePos(6)=="O"){       // 22,31
      tmp = 2;
      return tmp;
    }
    if (lesePos(4)=="" && lesePos(2)=="O" && lesePos(6)=="O"){       // 31,13
      tmp = 4;
      return tmp;
    }
    if (lesePos(0)=="O" && lesePos(3)=="O" && lesePos(6)==""){       // 11,21
      tmp = 6;
      return tmp;
    }
    if (lesePos(0)=="" && lesePos(3)=="O" && lesePos(6)=="O"){       // 31,21
      tmp = 0;
      return tmp;
    }
    if (lesePos(0)=="O" && lesePos(3)=="" && lesePos(6)=="O"){       // 11,31
      tmp = 3;
      return tmp;
    }
    if (lesePos(1)=="O" && lesePos(4)=="O" && lesePos(7)==""){       // 12,22
      tmp = 7;
      return tmp;
    }
    if (lesePos(1)=="" && lesePos(4)=="O" && lesePos(7)=="O"){       // 22,32
      tmp = 1;
      return tmp;
    }
    if (lesePos(1)=="O" && lesePos(4)=="" && lesePos(7)=="O"){       // 12,32
      tmp = 4;
      return tmp;
    }
    if (lesePos(2)=="O" && lesePos(5)=="O" && lesePos(8)==""){       // 13,23
      tmp = 8;
      return tmp;
    }
    if (lesePos(2)=="" && lesePos(5)=="O" && lesePos(8)=="O"){       // 33,23
      tmp = 2;
      return tmp;
    }
    if (lesePos(2)=="O" && lesePos(5)=="" && lesePos(8)=="O"){       // 13,33
      tmp = 5;
      return tmp;
    }
    if (lesePos(0)=="O" && lesePos(1)=="O" && lesePos(2)==""){
      return 2;
    }
    if (lesePos(0)=="O" && lesePos(2)=="O" && lesePos(1)==""){
      tmp = 1;
      return tmp;
    }
    return -1;
  }
  public int Zufall(){
    zufall = (int)(Math.random() * 8);
    if(zufall >= 0 && zufall <9){
     return zufall;
    } else {
      return Zufall();
    }
  }
  public void KiZufall(){
    switch(sp){
      case 1: //nichts tun
        break;
      case 2:
        // Auf ein Feld setzen was frei ist
        // Auswahl per Zufall
        zufall = (int)(Math.random() * 8);
        //Hier muss noch der Draw check rein
        if(zufall <= 8){
          if(lesePos(zufall)==""){
            schreibePos(zufall);
            sp=1;
          } else {
            KiZufall();
          }
        }else{
          KiZufall();
        }
    }
  }
  public void KiMeineWahl(){
    int meineWahl=2;
    switch(sp){
      case 1: //nichts tun
        break;
      case 2:
        // Auf ein Feld setzen was frei ist
      switch(count){
        case 1: meineWahl=2;
          if(lesePos(meineWahl)==""){
            schreibePos(meineWahl);
          } else if(lesePos(6)==""){
            schreibePos(6);
          }
         break;
        case 2: meineWahl=6;
         if(lesePos(meineWahl)==""){
            schreibePos(meineWahl);
          } else if(lesePos(0)==""){
            schreibePos(0);
          } else if(lesePos(8)==""){
            schreibePos(8);
          }
         break;
         case 3: meineWahl=0;
         if(lesePos(meineWahl)==""){
            schreibePos(meineWahl);
          } else if(lesePos(4)==""){
            schreibePos(4);
          } else if(lesePos(8)==""){
            schreibePos(8);
          }
         break;
         case 4: meineWahl=1;
           if ( siegMoeglichkeit()==true ){
             schreibePos(welche);
           } else if(lesePos(meineWahl)==""){
            schreibePos(meineWahl);
          } else {
            for(int i=0;i<9;i++){
              if( lesePos(i) == "" ){
                schreibePos(i);
              }
            }
          } break;
      }//count switch
      count++;
      sp=1; //damit endet Ki Runde
    }
  }
  public boolean siegMoeglichkeit(){
    boolean canwin=false;
    if (lesePos(0)=="O" && lesePos(2)=="O" && lesePos(1)==""){
      welche=1;
       canwin=true;
    }
    if (lesePos(0)=="O" && lesePos(6)=="O" && lesePos(3)==""){
      welche=3;
       canwin=true;
    }
    if (lesePos(6)=="O" && lesePos(8)=="O" && lesePos(7)==""){
      welche=7;
       canwin=true;
    }
    if (lesePos(2)=="O" && lesePos(8)=="O" && lesePos(5)==""){
      welche=5;
       canwin=true;
    }
    if (lesePos(0)=="O" && lesePos(8)=="O" && lesePos(4)==""){
      welche=4;
       canwin=true;
    }
    if (lesePos(6)=="O" && lesePos(2)=="O" && lesePos(4)==""){
      welche=4;
       canwin=true;
    }
    return canwin;
  }
  //Siegmoeglichkeit verhindert fehlt noch
 /* public boolean gegnerSieg(){
    boolean siegstoppen=false;
    for(int i=0;i<9;i++){
      if (i==0){
        if( lesePos(i)=="X" && lesePos(i+1)=="X" && lesePos(i+2)==""){
          siegstoppen=true; welche = i+2
        }
        if( lesePos(i+1)=="X" && lesePos(i+2)=="X" && lesePos(i)=="")
      } else if(i==3){
        if( lesePos(i)=="X" && lesePos(i+1)=="X" ){
          siegstoppen=true; welche = i+2
        }
      }
    }
  }  */
  // Ende Ereignisprozeduren
  public static void main(String[] args) {
    TicTacToe_bak game = new TicTacToe_bak("TicTacToe_bak");

  }
}// TicTacToe_bak

