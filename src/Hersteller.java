/**
 * Alle Modelle eines Hersteller werden aufgelistet.
 *
 * @author Malo Jaboulet
 * @version 1.0
 * @since 20.4.2020
 */
public class Hersteller {

    private Modell[] modells;
    private final int MAX_ANZAHLMODELLE = 50;
    private String herstellerName;
    private int modellAnzahl;


    /**
     * Es wird ein Array gemacht mit maximal 50 Modellen pro Hersteller.
     *
     * @param herstellerName Der Herstellername wird übergeben.
     */
    public Hersteller(String herstellerName) {
        modells = new Modell[MAX_ANZAHLMODELLE];
        this.herstellerName = herstellerName;
        modellAnzahl = 0;
    }


    /**
     * Ein Modell wird zu einem Arrayplatz hinzugefügt.
     *
     * @param modell Der Modellname wird eingetragen.
     */
    public void modellHinzufuegen(Modell modell) {
        modells[modellAnzahl] = modell;
        modellAnzahl++;
    }


    /**
     * Es werden alle Flugzeugmodelle nach einem bestimmten Muster angezeigt.
     */
    public void modelleAnzeigen() { //Zeigt alle Modelle an.
        for (int i = 0; i < modellAnzahl; i++) {
            System.out.println("«" + i + "» für " + modells[i].getName());
        }
    }


    /**
     * Löscht das gewählte Modell.
     *
     * @param nummer Das gewählte Modell.
     */
    public void modellLoeschen(int nummer) {
        Modell[] neueModells = new Modell[MAX_ANZAHLMODELLE];
        System.arraycopy(modells, 0, neueModells, 0, nummer);/*Mach ein neues Array bis zum
        ausgewählten Modell, ohne das ausgewählte Modell.
        */
        System.arraycopy(modells, nummer + 1, neueModells, nummer, modellAnzahl - nummer - 1);
        //Macht eine neues Array eine Stelle nach dem ausgewälten Hersteller bis zum ende.

        modells = neueModells;//Die Copy wird zum normalen Array.
        modellAnzahl--;
    }


    /**
     * Schaut ob das ausgewählte Modell zur Auswahl steht. Wenn nicht kommt eine Fehlermeldung.
     *
     * @param nummer Der ausgewählte Hersteller.
     * @return Der ausgewählte Hersteller.
     */
    public Modell getModell(int nummer) {
        if (nummer > modellAnzahl || nummer < 0) { //Schaut ob das ausgewählte Modell zur Auswahl steht.
            System.out.println("Eine Zahl eingeben, die zur Auswahl steht. Zahl nochmals eingeben:\n");
            return null;
        } else {
            return modells[nummer]; //Der ausgewählte Modell.
        }

    }


    /**
     * Schaut ob das ausgewählte Modell zur Auswahl steht. Wenn nicht kommt eine Fehlermeldung auf Englisch.
     *
     * @param nummer Der ausgewählte Hersteller.
     * @return Der ausgewählte Hersteller.
     */
    public Modell getModellEnglisch(int nummer) {
        if (nummer > modellAnzahl || nummer < 0) { //Schaut ob das ausgewählte Modell zur Auswahl steht.
            System.out.println("Enter a number which is available for selection. Enter number again:\n");
            return null;
        } else {
            return modells[nummer]; //Der ausgewählte Modell.
        }
    }

    public String getHerstellerName() {
        return herstellerName;
    }

    public int getModellAnzahl() {
        return modellAnzahl;
    }

}

