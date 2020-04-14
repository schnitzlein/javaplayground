/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.06.2011
  * @author
  */

public class UDPClientTest {

  public static void main(String[] args) {
    UDPClient c = new UDPClient();
    c.start();
    try {
      c.sleep(3000);
      c.interrupt();
      System.out.println("Thread unterbrochen");
    } catch(InterruptedException ie){

    }

  }
}

/*    http://www.dpunkt.de/java/Programmieren_mit_Java/Multithreading/4.html
Mit der Methode sleep() kann die Ausf�hrung eines Threads f�r einen
 bestimmten Zeitraum ausgesetzt werden. W�hrend dieser Zeit kann er von einem
  anderen Thread durch Aufruf von interrupt() unterbrochen und wieder in den
   rechenwilligen Zustand versetzt werden. Die vorzeitige Unterbrechung wird dem
    Thread durch eine InterruptedException signalisiert, damit er die Unterbrechung
     von der normalen Beendigung der sleep()-Methode unterscheiden und gegebenenfalls
      erforderliche Aktionen ausf�hren kann. Im schlafenden Zustand beh�lt ein Thread alle Monitore, die er besitzt.
      
In den blockierten Zustand kommt ein Thread dann, wenn er sich mit einem anderen
 Thread synchronisieren oder auf eine ben�tigte Ressource warten muss.
  Die Synchronisation erfolgt entweder auf das Ende eines anderen Threads (join())
   oder auf ein bestimmtes Ereignis hin (wait()), dessen Eintritt mit notify() signalisiert wird.
    Bez�glich interrupt() gilt das zuvor Gesagte.                          */
