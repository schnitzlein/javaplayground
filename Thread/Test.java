/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.06.2011
  * @author
  */

public class Test extends Thread{


    public void run() {
      for (int i=0;i<100;i++){
        System.out.print(i+" ");
      }
    }
}
