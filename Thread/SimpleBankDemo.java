public class SimpleBankDemo {

    public static void main(String[] args) {
      Angestellter A1, A2, A3;
      SimpleBank b = new SimpleBank();

      System.out.println("Vorher:");
      b.kontostand();

      // Eine ringförmige Überweisung
      A1 = new Angestellter(b, 0, 1, 20);
      A2 = new Angestellter(b, 1, 2, 20);
      A3 = new Angestellter(b, 2, 0, 20);

      A1.start();
      A2.start();
      A3.start();
    }

  }