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
      // �berweisung vornehmen
      bank.�berweisung(von, nach, betrag);
      // Kontostand ausgeben
      System.out.println("Nachher:");
      bank.kontostand();
    }

  }