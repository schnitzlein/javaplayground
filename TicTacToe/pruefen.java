/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 01.04.2008
  * @author Chris
  */

public class pruefen {
  int ueberpruefe(){

    // waagerecht gewonnen
        if ( Feld[0][0] == 'X' && Feld[0][1] == 'X' && Feld[0][2] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[1][0] == 'X' && Feld[1][1] == 'X' && Feld[1][2] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[2][0] == 'X' && Feld[2][1] == 'X' && Feld[2][2] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[0][0] == 'O' && Feld[0][1] == 'O' && Feld[0][2] == 'O'){
             gewonnen = 2;
             }
        if ( Feld[1][0] == 'O' && Feld[1][1] == 'O' && Feld[1][2] == 'O'){
             gewonnen = 2;
             }
        if ( Feld[2][0] == 'O' && Feld[2][1] == 'O' && Feld[2][2] == 'O'){
             gewonnen = 2;
             }

     // senkrecht gewonnen
        if ( Feld[0][0] == 'X' && Feld[1][0] == 'X' && Feld[2][0] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[1][1] == 'X' && Feld[2][1] == 'X' && Feld[0][1] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[0][2] == 'X' && Feld[1][2] == 'X' && Feld[2][2] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[0][0] == 'O' && Feld[1][0] == 'O' && Feld[2][0] == 'O'){
             gewonnen = 2;
             }
        if ( Feld[1][1] == 'O' && Feld[2][1] == 'O' && Feld[0][1] == 'O'){
             gewonnen = 2;
             }
        if ( Feld[0][2] == 'O' && Feld[1][2] == 'O' && Feld[2][2] == 'O'){
             gewonnen = 2;
             }

    // diagonal gewonnen
        if ( Feld[0][0] == 'X' && Feld[1][1] == 'X' && Feld[2][2] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[2][0] == 'X' && Feld[1][1] == 'X' && Feld[0][2] == 'X'){
             gewonnen = 1;
             }
        if ( Feld[0][0] == 'O' && Feld[1][1] == 'O' && Feld[2][2] == 'O'){
             gewonnen = 2;
             }
        if ( Feld[2][0] == 'O' && Feld[1][1] == 'O' && Feld[0][2] == 'O'){
             gewonnen = 2;
             }
    // draw Game
     for(i=0;i<3;i++){
      for(j=0;j<3;j++){
       if (Feld[i][j] != ' '){ // Wenn alle Felder voll sind liefert dieser Term gewonnen = 0 und nur dann!
        gewonnen = 0;
    } else {
      gewonnen = 3;
      }
       }
     }

        // Programm beenden
        if ( gewonnen == 2 ) {
             return 2;        //Spieler2 gewinnt
             }
      if ( gewonnen == 1 ) {
             return 1;        //Spieler 1 gewinnt
             }
    if ( gewonnen == 0 ) {
         return 0;        //Draw Game
       }
    /*else {
         return 3;       // normale Rückgabe
      }*/
        }
  public static void main(String[] args) {

  }
}

