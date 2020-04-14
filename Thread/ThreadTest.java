/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.06.2011
  * @author
  */

public class ThreadTest {

  public static void main(String[] args) {
     Test t1 = new Test();
     Test t2 = new Test();
     Test t3 = new Test();
     
     t1.start();
     t2.start();
     /*try {
       t1.sleep(3000);
     } catch (InterruptedException ie){

     } */

     t2.interrupt();

  }
}
