class Angestellter extends Thread {

    SimpleBank bank;
    int von, nach, betrag;

    public Angestellter(SimpleBank bank, int von,
                               int nach, int betrag) {
      this.bank = bank;
      this.von = von;
      this.nach = nach;
      this.betrag = betrag;
    }

    public void run() {
      // Überweisung vornehmen
      bank.überweisung(von, nach, betrag);
      // Kontostand ausgeben
      System.out.println("Nachher:");
      bank.kontostand();
    }

  }