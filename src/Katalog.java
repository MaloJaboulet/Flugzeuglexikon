/**
 * Alle Hersteller werden aufgelistet.
 *
 * @author Malo Jaboulet
 * @version 1.0
 * @since 20.4.2020
 */

public class Katalog {

    private Hersteller[] herstellers;
    private final int MAX_ANZAHLHERSTELLER = 25;
    private int anzahlHersteller;


    /**
     * Es wird ein Array mit maximal 25 Plätzen gemacht.
     */
    public Katalog() {
        herstellers = new Hersteller[MAX_ANZAHLHERSTELLER]; // Macht eine Array von Hersteller.
        anzahlHersteller = 0;
    }


    /**
     * Es wird der Hersteller zu einem Arrayplatz hinzugefügt.
     *
     * @param hersteller der Hersteller wird eingetragen.
     */
    public void herstellerHinzufuegen(Hersteller hersteller) {
        herstellers[anzahlHersteller] = hersteller;
        anzahlHersteller++;
    }


    /**
     * Alle Hersteller werden in einem bestimmten Muster gezeigt.
     */
    public void herstellerAnzeigen() { //Zeigt alle Hersteller an.
        for (int i = 0; i < anzahlHersteller; i++) {
            System.out.println("«" + i + "» für " + herstellers[i].getHerstellerName());
        }
    }


    /**
     * Der ausgewählte Hersteller wird gelöscht. ALle Daten im Hersteller werden gleichzeitig gelöscht.
     *
     * @param nummer Der ausgewählte Hersteller.
     */
    public void herstellerLoeschen(int nummer) {
        Hersteller[] neueHerstellers = new Hersteller[MAX_ANZAHLHERSTELLER];
        System.arraycopy(herstellers, 0, neueHerstellers, 0, nummer);/*Mach ein neues Array bis zum
        ausgewählten Hersteller, ohne den ausgewählten Hersteller
        */
        System.arraycopy(herstellers, nummer + 1, neueHerstellers, nummer, anzahlHersteller - nummer - 1);
        //Macht eine neues Array eine Stelle nach dem ausgewälten Hersteller bis zum ende.

        herstellers = neueHerstellers;//Die Copy wird zum normalen Array.
        anzahlHersteller--;
    }


    /**
     * Schaut ob der ausgewählte Hersteller zur Auswahl steht. Wenn nicht kommt eine Fehlermeldung.
     *
     * @param nummer Der ausgewählte Hersteller.
     * @return Der ausgewählte Hersteller.
     */
    public Hersteller getHersteller(int nummer) {
        if (nummer > anzahlHersteller || nummer < 0) {  //Schaut ob der ausgewählte Hersteller zur Auswahl steht.
            System.out.println("Eine Zahl eingeben, die zur Auswahl steht. Zahl nochmals eingeben:");
            return null;
        } else {
            return herstellers[nummer]; //Der ausgewählte Hersteller.
        }
    }


    /**
     * Schaut ob der ausgewählte Hersteller zur Auswahl steht. Wenn nicht kommt eine Fehlermeldung auf Englisch.
     *
     * @param nummer Der ausgewählte Hersteller.
     * @return Der ausgewählte Hersteller.
     */
    public Hersteller getHerstellerEnglisch(int nummer) {
        if (nummer > anzahlHersteller || nummer < 0) {  //Schaut ob der ausgewählte Hersteller zur Auswahl steht.
            System.out.println("Enter a number which is available for selection. Enter number again:\n");
            return null;
        } else {
            return herstellers[nummer]; //Der ausgewählte Hersteller.
        }
    }

    public int getAnzahlHersteller() {
        return anzahlHersteller;
    }
}
