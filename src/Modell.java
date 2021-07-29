/**
 * Hat alle Daten eines Flugzeugmodells
 *
 * @author Malo Jaboulet
 * @version 1.0
 * @since 20.4.2020
 */

public class Modell {
    Einleser einleser = new Einleser();

    private String name;
    private double laenge;
    private double hoehe;
    private double fluegelspannweite;
    private int geschwindigkeit;
    private int reichweite;

    /**
     * Der Modellname wird übergeben.
     *
     * @param name Der Modellname wird eingetragen.
     */
    public Modell(String name) {
        this.name = name;
    }


    /**
     * Alle Spezifikationen werden eingetragen.
     *
     * @param laenge            Die gesamt Länge des Flugzeugs.
     * @param hoehe             Die gesamt Höhe des Flugzeugs.
     * @param fluegelspannweite Die gesamte Flügelspannweite des Flugzeugs.
     * @param geschwindigkeit   Die Reisegeschwindigkeit des Flugzeugs.
     * @param reichweite        Die gesamt Reichweite des Flugzeugs.
     */
    public void flugzeugHinzufuegen(double laenge, double hoehe, double fluegelspannweite, int geschwindigkeit,
                                    int reichweite) {
        this.laenge = laenge;
        this.hoehe = hoehe;
        this.fluegelspannweite = fluegelspannweite;
        this.geschwindigkeit = geschwindigkeit;
        this.reichweite = reichweite;
    }


    /**
     * Die Flugzeugspezifikationen werden in einem bestimmten Muster angezeigt.
     */
    public void flugzeugAnzeigen() { //Zeigt das Flugzeug an.
        System.out.println("\nSie haben den " + name + " ausgewählt.");
        System.out.println("Länge:\t\t\t\t " + getLaenge() + " Meter\nHöhe:\t\t\t\t " + getHoehe() + " Meter\n" +
                "Flügelspannweite:\t " + getFluegelspannweite() + " Meter\nGeschwindigkeit:\t "
                + getGeschwindigkeit() + " km/h\nReichweite:\t\t\t " + getReichweite() + " Kilometer\n\n");
    }


    /**
     * Die Flugzeugspezifikationen werden in einem bestimmten Muster auf Englisch angezeigt.
     */
    public void flugzeugAnzeigenEnglisch() { //Zeigt das Flugzeug an.
        System.out.println("\nYou have selected the " + name + ".");
        System.out.println("Lenth:\t\t\t\t " + getLaenge() + " meter\nHeight:\t\t\t\t " + getHoehe() + " meter\n" +
                "Wingspan:\t\t\t " + getFluegelspannweite() + " meter\nSpeed:\t\t\t\t "
                + getGeschwindigkeit() + " km/h\nRange:\t\t\t\t " + getReichweite() + " kilometer\n\n");
    }


    /**
     * Alle Daten eines FLugzeugs werden eingegeben, überprüft und gespeicher.
     */
    public void flugzeugDatenHinzufuegen() {

        System.out.print("Länge eingeben: \n");
        setLaenge(einleser.readDouble());

        System.out.print("Höhe eingeben: \n");
        setHoehe(einleser.readDouble());

        System.out.print("Flügelspannweite eingeben: \n");
        setFluegelspannweite(einleser.readDouble());

        System.out.print("Geschwindigkeit eingeben: \n");
        setGeschwindigkeit(einleser.readInt());

        System.out.print("Reichweite eingeben: \n");
        setReichweite(einleser.readInt());
    }


    /**
     * Alle Daten eines FLugzeugs werden auf Englisch eingegeben, überprüft und gespeicher.
     */
    public void flugzeugDatenHinzufuegenEnglisch() {

        System.out.print("Enter lenght: \n");
        setLaenge(einleser.readDoubleEnglisch());

        System.out.print("Enter height: \n");
        setHoehe(einleser.readDoubleEnglisch());

        System.out.print("Enter wingspan: \n");
        setFluegelspannweite(einleser.readDoubleEnglisch());

        System.out.print("Enter speed: \n");
        setGeschwindigkeit(einleser.readIntEnglisch());

        System.out.print("Enter range: \n");
        setReichweite(einleser.readIntEnglisch());
    }


    public String getName() {
        return name;
    }

    public double getLaenge() {
        return laenge;
    }

    public double getHoehe() {
        return hoehe;
    }

    public double getFluegelspannweite() {
        return fluegelspannweite;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getReichweite() {
        return reichweite;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public void setFluegelspannweite(double fluegelspannweite) {
        this.fluegelspannweite = fluegelspannweite;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void setReichweite(int reichweite) {
        this.reichweite = reichweite;
    }


}

