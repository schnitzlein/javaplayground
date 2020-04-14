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
Mit der Methode sleep() kann die Ausführung eines Threads für einen
 bestimmten Zeitraum ausgesetzt werden. Während dieser Zeit kann er von einem
  anderen Thread durch Aufruf von interrupt() unterbrochen und wieder in den
   rechenwilligen Zustand versetzt werden. Die vorzeitige Unterbrechung wird dem
    Thread durch eine InterruptedException signalisiert, damit er die Unterbrechung
     von der normalen Beendigung der sleep()-Methode unterscheiden und gegebenenfalls
      erforderliche Aktionen ausführen kann. Im schlafenden Zustand behält ein Thread alle Monitore, die er besitzt.
      
In den blockierten Zustand kommt ein Thread dann, wenn er sich mit einem anderen
 Thread synchronisieren oder auf eine benötigte Ressource warten muss.
  Die Synchronisation erfolgt entweder auf das Ende eines anderen Threads (join())
   oder auf ein bestimmtes Ereignis hin (wait()), dessen Eintritt mit notify() signalisiert wird.
    Bezüglich interrupt() gilt das zuvor Gesagte.                          */
