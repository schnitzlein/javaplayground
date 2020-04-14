                      class SimpleBank {
    static int[] konten = {30, 50, 100};

    public void überweisung(int von, int nach, int betrag) {
      int neuerBetrag;

      neuerBetrag = konten[von];
      neuerBetrag -= betrag;
      // Inkonsistenz, da neuer Betrag noch nicht vermerkt
      try {
        Thread.sleep((int)Math.random()*1000);
      }
      catch(InterruptedException e) {
      }
      konten[von] = neuerBetrag;

      neuerBetrag = konten[nach];
      neuerBetrag += betrag;
      // dito
      konten[nach] = neuerBetrag;
    }

    public void kontostand() {
      for(int i = 0; i < konten.length; i++)
        System.out.println("Konto "+ i +": " + konten[i]);
    }
  }