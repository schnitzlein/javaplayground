public class primezahlen
{
	public static void main(String[] args)
	{
		int limit = 1000;
		int zahl;							// Zu überprüfende Zahl
		int zaehler;							// Durch diese Zahl soll geteilt werden
		int teiler;							// Anzahl der möglichen Teiler
		int zahl2;							// Rest bei der Division
		for (zahl = 1; zahl <= limit; zahl++)				// zahl <= x   ist der zu überprüfende Zahlenraum
		{
			if (zahl == 1)						// Ausschluss der Zahl 1 als Primzahl
				System.out.println("");
			else
			{
				teiler = 0;
				for (zaehler = 1; zaehler <= limit; zaehler++)
				{
					zahl2 = zahl % zaehler;			// Division der Ausgangszahl durch eine weitere und ablegen in der Variabel zahl2
					if (zahl2 == 0)				// Falls der Rest gleich 0 ist ist ein Teiler gefunden
						teiler++;


				}
				if (teiler == 2)				// Wenn die Zahl genau 2 Teiler hat ist sie eine Primzahl
					System.out.println(zahl+" ist eine Primzahl, da sie genau "+teiler+" Teiler hat");
				/*else						// Andernfalls ist sie keine Primzahl
					System.out.println(zahl+" ist KEINE Primzahl");*/
			}
		}
	}
}