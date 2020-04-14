/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 23.03.2011
  * @author
  */
  
import java.math.*;

public class zufall {
  private int zufall;
  
  public zufall(){
    zufall = 0;
  }
  
  public int ausgabe(){
    zufall = (int)(Math.random() * 49);
    if(zufall >= 0 && zufall <50){
     return zufall;
    } else {
      return ausgabe();
    }
  }
  public static void main(String[] args) {
    zufall z = new zufall();

    int[] ary = new int[6];
    
    for (int i=0;i<6;i++){
      ary[i] = z.ausgabe();
    }
    
    for (int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        if (ary[i] != ary[j]){
        //kein duplikat   funzt net!!
        } else {
          ary[i] = z.ausgabe();
        }
      }
      System.out.println("Zufallszahl fuer Lotto "+ary[i]);
    }

  }
}
