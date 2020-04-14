import java.io.*;
/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 03.04.2008
  * @author Chris
  */

public class test {

  public static void main(String[] args) {
    BufferedReader lies = new BufferedReader(new InputStreamReader(System.in));
    int eingabe=0;
    try {
      System.out.print("(1) zum abbrechen, andere Zahl zum weiteren Testen: ");
      eingabe = Integer.parseInt(lies.readLine());
      System.out.println("");
    } catch (IOException ioe){
      System.out.println("Fehler: "+ioe);
    }

    while(eingabe != 1){
      int zufall = (int)(Math.random() * 10);               //unsicher ob die 9 ohne *10 auftaucht
      System.out.println("Zufallszahl ist: "+zufall);
      zufall = (int)(Math.random() * 9);                     //h‰ufigkeit der zahl 9 ist ‰uﬂert gering im vergleich mit *10
      System.out.println("Zufallszahl ist: "+zufall);
      zufall = (int)(Math.random() * 9);
      System.out.println("Zufallszahl ist: "+zufall);
      zufall = (int)(Math.random() * 9);
      System.out.println("Zufallszahl ist: "+zufall);
      zufall = (int)(Math.random() * 9);
      System.out.println("Zufallszahl ist: "+zufall);
      /*try{
        //lies.read();
        eingabe = Integer.parseInt(lies.readLine());
      } catch(IOException ioe){

      } */
    }

    
  }
}

