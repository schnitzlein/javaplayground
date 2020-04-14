import java.io.Writer;
import java.io.*;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;


/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 22.11.2009
  * @author
  */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DateiSchreiben{
    public void zeichen4(){
      char[] puzzle = new char[4];
      try{
            PrintWriter pWriter = new PrintWriter(new FileWriter("zeichen4.txt", true),true);

          // alle immer gleich
          for (int i=97; i<123; i++){
            for(int j=0; j<3;j++){   // alle 4 stellen a - z
              puzzle[j] = (char)i;
              //System.out.println(""+puzzle[0]+""+""+puzzle[1]+""+""+puzzle[2]+""+""+puzzle[3]);
              pWriter.println(""+puzzle[0]+""+""+puzzle[1]+""+""+puzzle[2]+""+""+puzzle[3]);
            }
          }
          
       int kleinbuch = 97; // a
       while(kleinbuch < 123){

          puzzle[0] = (char)kleinbuch;
          for (int i=97; i<123; i++){
            for(int k=1; k<4;k++){
              puzzle[k] = (char)i;   // erste stelle fest
//              System.out.println(""+puzzle[0]+""+""+puzzle[1]+""+""+puzzle[2]+""+""+puzzle[3]);
                pWriter.println(""+puzzle[0]+""+""+puzzle[1]+""+""+puzzle[2]+""+""+puzzle[3]);
            }
          }

          kleinbuch++;

       }

          
            /*for (int i=0;i<10000;i++){
              if ( i > 0 && i < 23 ) puzzle = "aaa"+puzzle String. pWriter.println(puzzle+i);
              if ( i > 99 && i < 1000 ) pWriter.println("0"+i);
              if ( i > 999 ) pWriter.println(""+i);
              if ( i < 10 ) pWriter.println("000"+i);
            } */

            pWriter.flush();
      }catch(IOException ioe){
            ioe.printStackTrace();
      }
    }

    public void zahlen4(){
      try{
            PrintWriter pWriter = new PrintWriter(new FileWriter("zahlen4.txt", true),true);
            for (int i=0;i<10000;i++){
              if ( i > 9  && i < 100 ) pWriter.println("00"+i);
              if ( i > 99 && i < 1000 ) pWriter.println("0"+i);
              if ( i > 999 ) pWriter.println(""+i);
              if ( i < 10 ) pWriter.println("000"+i);
            }

             pWriter.flush();
      }catch(IOException ioe){
            ioe.printStackTrace();
      }
    }
    
    
    public void zahlen5(){
      try{
            PrintWriter pWriter = new PrintWriter(new FileWriter("zahlen5.txt", true),true);
            for (int i=0;i<100000;i++){
              if ( i > 9  && i < 100 ) pWriter.println("000"+i);
              if ( i > 99 && i < 1000 ) pWriter.println("00"+i);
              if ( i > 999 && i < 10000 ) pWriter.println("0"+i);
              if ( i > 9999 ) pWriter.println(""+i);
              if ( i < 10 ) pWriter.println("0000"+i);
            }

             pWriter.flush();
      }catch(IOException ioe){
            ioe.printStackTrace();
      }
    }

    // TODO den einlese char in einen String um bauen und equals dann welche alph oder digits
    public static void main(String[] args){
      DateiSchreiben dsr = new DateiSchreiben();
      char cmd = ' ';
      System.out.println("Fuer zahlentext bitte die Anzahl der Stellen eingeben \n"+
                         "Bsp.: Bitte geben Sie die Anzahl der Stellen ein: 4 \n"+
                         "folgt eine Textdatei mit fuer 4 stellige Zahlen");
      System.out.println("");
      Scanner in = new Scanner(System.in);

        while(cmd != 'e'){
          System.out.println("Zum beenden e eingeben");
          System.out.print("Bitte geben Sie die Anzahl der Stellen ein: ");
          cmd = in.next().charAt(0);
          switch(cmd){
            case 'e': System.exit(0); break;
            case '4': dsr.zahlen4(); break;
            case '5': dsr.zahlen5(); break;
            case 'a': dsr.zeichen4(); break;
          }
        }
    }
}