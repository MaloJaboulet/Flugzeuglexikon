import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Es macht die verbindung zwischen dem Benutzer und dem Programm.
 * Es hat alle Daten der Flugzeuge, Modelle und Hersteller.
 *
 * @author Malo Jaboulet
 * @version 1.0
 * @since 20.4.2020
 */
public class FlugzeugLexikon {

    Katalog katalog;
    Einleser einleser;

    public FlugzeugLexikon() {
        einleser = new Einleser();
        katalog = new Katalog();

        fileSammlung();
    }

    /**
     * starts the execution
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FlugzeugLexikon flugzeugLexikon = new FlugzeugLexikon();
        flugzeugLexikon.run();
    }


    /**
     * Run ist die Hauptmethode. Der Benutzer interagiret mit dieser Methode.
     */
    private void run() {
        Einleser einleser = new Einleser();

        char auswahlBuchstabe = ' ';
        char auswahlSprache = ' ';

        System.out.println("Willkommen beim Flugzeuglexikon. Welcome to the Airplane lexicon.");
        System.out.print("«e» for English\n«d» für Deutsch\n");
        auswahlSprache = einleser.readCharFuerSprache();

        if (auswahlSprache == 'e') {
            while (auswahlBuchstabe != 'b') {
                einleser.linieZeichnen();

                System.out.print("\nWhat do you want to select: " +
                        "\npress «f» to see the planes." +
                        "\npress «n» to add a new aircraft." +
                        "\npress «h» to add a new manufacturer of aircrafts." +
                        "\npress «l» to delete an aircraft or a manufacturer." +
                        "\npress «s» to save all data."+
                        "\npress «b» to exit the program.\n");

                auswahlBuchstabe = einleser.readCharEnglisch();

                if (auswahlBuchstabe == 'f') {
                    flugzeugAuswahlAnzeigenEnglisch();
                } else if (auswahlBuchstabe == 'n') {
                    flugzeugHinzufuegenEnglisch();
                } else if (auswahlBuchstabe == 'h') {
                    herstellerHinzufuegenEnglisch();
                } else if (auswahlBuchstabe == 'l') {   //Ein Hersteller oder ein Flugzeug wird gelöscht.
                    herstellerFlugzeugloeschenEnglisch();
                }else if (auswahlBuchstabe == 's'){
                    fileSpeichernSammlung();            //Speichert alle Daten.
                    System.out.println("All data has been saved.");
                } else if (auswahlBuchstabe == 'b') {   //Programm wird beendet.
                    fileSpeichernSammlung();
                    System.out.println("All date has benn saved. The program has been terminated. Goodbye, until " +
                            "next time.");
                }
            }
        } else if (auswahlSprache == 'd') {

            while (auswahlBuchstabe != 'b') {

                einleser.linieZeichnen();
                System.out.print("\nWas möchten Sie auswählen: " +
                        "\n«f» drücken, um die Flugzeuge zu sehen." +
                        "\n«n» drücken, um ein neues Flugzeug hinzuzufügen." +
                        "\n«h» drücken, um einen neuen Hersteller von Flugzeugen hinzuzufügen." +
                        "\n«l» drücken, um ein Flugzeug oder einen Hersteller zu löschen. " +
                        "\n«s» drücken, um alle Daten zu speichern."+
                        "\n«b» drücken, um das Programm zu beenden.\n");


                auswahlBuchstabe = einleser.readChar();

                if (auswahlBuchstabe == 'f') {
                    flugzeugAuswahlAnzeigen();
                } else if (auswahlBuchstabe == 'n') {
                    flugzeugHinzufuegen();
                } else if (auswahlBuchstabe == 'h') {
                    herstellerHinzufuegen();
                } else if (auswahlBuchstabe == 'l') {   //Ein Hersteller oder ein Flugzeug wird gelöscht.
                    herstellerFlugzeugloeschen();
                }else if (auswahlBuchstabe =='s'){
                    fileSpeichernSammlung();            //Alle Daten werden gespeicher.
                    System.out.println("Alle Daten wurden gespeichert.");
                } else if (auswahlBuchstabe == 'b') {   //Programm wird beendet.
                    fileSpeichernSammlung();
                    System.out.println("Alle Daten wurden gespeichert. Das Programm wurde beendet. Auf wiedersehen, " +
                            "bis zum nächsten Mal.");
                }
            }
        }
    }


    /**
     * Es wird der Hersteller, das Modell und die Spezifikationen werden angezeigt. Die Eingaben des Benutzers werden
     * überprüft und gespeichert.
     */
    private void flugzeugAuswahlAnzeigen() {
        System.out.println("\nSie haben das Anschauen von Flugzeugen gewählt. Sie können jetzt den Hersteller des " +
                "Flugzeugs wählen. Was wählen Sie:");
        katalog.herstellerAnzeigen();

        int auswahlZahlHersteller;
        while (true) {
            auswahlZahlHersteller = einleser.readInt();

            if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                    Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                System.out.print("Bitte eine Zahl eingeben, die zur Auswahl steht. Zahl erneut eingeben.\n");
            } else {
                break;
            }
        }
        Hersteller hersteller = katalog.getHersteller(auswahlZahlHersteller);/* Schaut ob die gewählte Zahl zur Auswahl
         steht. Returnt das Modell, welches auf der gewählten Zahl basiert.
         */
        if (hersteller.getModellAnzahl() <= 0) {
            System.out.println("Es sind keine Modelle vorhanden.\n\n");
        } else {
            System.out.println("Sie haben den Hersteller " + hersteller.getHerstellerName() + " gewählt. Sie sehen " +
                    "jetzt die Modelle " +
                    "von " + hersteller.getHerstellerName() + ".\nWählen Sie ein Modell aus und Sie sehen die " +
                    "Spezifikationen des Modells:\n");
            hersteller.modelleAnzeigen();

            int auswahlZahlModell;
            while (true) {
                auswahlZahlModell = einleser.readInt();

                if (auswahlZahlModell > (hersteller.getModellAnzahl() - 1) || auswahlZahlModell < 0) {
                    /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Bitte eine Zahl eingeben, die zur Auswahl steht. Zahl erneut eingeben.\n");
                } else {
                    Modell modell = hersteller.getModell(auswahlZahlModell);//Das ausgewählte Modell wird geholt.
                    modell.flugzeugAnzeigen();
                    break;
                }
            }
        }
    }


    /**
     * Es wird der Hersteller, das Modell und die Spezifikationen werden auf Englisch angezeigt. Die Eingaben des
     * Benutzers werden
     * überprüft und gespeichert.
     */
    private void flugzeugAuswahlAnzeigenEnglisch() {
        System.out.println("\nYou have chosen to look at airplanes. You can now select the manufacturer of the " +
                "aircraft. What do you choose:");
        katalog.herstellerAnzeigen();

        int auswahlZahlHersteller;
        while (true) {
            auswahlZahlHersteller = einleser.readIntEnglisch();

            if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                    Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                System.out.print("Please enter a number which is available for selection. Enter a number again:\n");
            } else {
                break;
            }
        }
        Hersteller hersteller = katalog.getHerstellerEnglisch(auswahlZahlHersteller);/* Schaut ob die gewählte Zahl zur
        Auswahl steht. Returnt das Modell, welches auf der gewählten Zahl basiert.
         */
        if (hersteller.getModellAnzahl() <= 0) {
            System.out.println("There are no models available.\n\n");
        } else {
            System.out.println("You have chosen the manufacturer " + hersteller.getHerstellerName() + ". You can now " +
                    "see the models " +
                    "of " + hersteller.getHerstellerName() + ".\nSelect a model and you will see the specifications of " +
                    "the model:\n");
            hersteller.modelleAnzeigen();

            int auswahlZahlModell;
            while (true) {
                auswahlZahlModell = einleser.readIntEnglisch();

                if (auswahlZahlModell > (hersteller.getModellAnzahl() - 1) || auswahlZahlModell < 0) {
                    /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Please enter a number which is available for selection. Enter a number again:\n");
                } else {
                    Modell modell = hersteller.getModellEnglisch(auswahlZahlModell);//Das ausgewählte Modell wird geholt.
                    modell.flugzeugAnzeigenEnglisch();
                    break;
                }
            }
        }
    }


    /**
     * Ein Flugzeug wird hinzugefügt. Die Eingabe des Benutzers wird überprüft und gespeichert.
     * Wenn der Benutzer etwas falsches eingibt kommt eine Fehlermeldung und der Benutzer kann ernuet eingeben.
     */
    private void flugzeugHinzufuegen() {
        System.out.println("\nSie haben sich dafür entschieden, ein neues Flugzeug hinzuzufügen. Sie können nun " +
                "den Hersteller des Flugzeugs auswählen. Was wählen Sie aus:");
        katalog.herstellerAnzeigen();

        int auswahlZahlHersteller;
        while (true) {
            auswahlZahlHersteller = einleser.readInt();

            if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                System.out.print("Bitte eine Zahl eingeben, die zur Auswahl steht. Zahl erneut eingeben.\n");
            } else {
                break;
            }
        }

        Hersteller hersteller = katalog.getHersteller(auswahlZahlHersteller);
        System.out.print("\nGeben Sie den Namen des Modells ein:\n");

        Modell mod1 = new Modell(einleser.readString());/*Neues Flugzeug wird kreiert und einen Namen gegeben.
         Die Eingabe wird überprüft, falls nötig wird eine Fehlermeldung anzezeigt und gespeichert.
         */
        mod1.flugzeugDatenHinzufuegen();
        hersteller.modellHinzufuegen(mod1);//Das Flugzeug wird ins Modell gespeichert.

        System.out.println("Das Flugzeug " + mod1.getName() + " und seine Daten wurden gespeichert.\n\n");
    }


    /**
     * Ein Flugzeug wird auf Englisch hinzugefügt. Die Eingabe des Benutzers wird überprüft und gespeichert.
     * Wenn der Benutzer etwas falsches eingibt kommt eine Fehlermeldung und der Benutzer kann ernuet eingeben.
     */
    private void flugzeugHinzufuegenEnglisch() {
        System.out.println("\nYou have chosen to add a new aircraft. You can now select the manufacturer of the " +
                "aircraft. What do you choose:");
        katalog.herstellerAnzeigen();

        int auswahlZahlHersteller;
        while (true) {
            auswahlZahlHersteller = einleser.readIntEnglisch();

            if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                System.out.print("Please enter a number that is available for selection. Enter a number again.\n");
            } else {
                break;
            }
        }

        Hersteller hersteller = katalog.getHerstellerEnglisch(auswahlZahlHersteller);
        System.out.print("\nEnter the name of the model: \n");

        Modell mod1 = new Modell(einleser.readStringEnglisch());/*Neues Flugzeug wird kreiert und einen Namen gegeben.
         Die Eingabe wird überprüft, falls nötig wird eine Fehlermeldung anzezeigt und gespeichert.
         */
        mod1.flugzeugDatenHinzufuegenEnglisch();
        hersteller.modellHinzufuegen(mod1);//Das Flugzeug wird ins Modell gespeichert.

        System.out.println("The plane " + mod1.getName() + " and its data have been stored.\n\n");
    }


    /**
     * Ein Hersteller wird hinzugefügt.
     */
    private void herstellerHinzufuegen() {
        System.out.print("Sie haben das Hinzufügen von einem neuen Hersteller gewählt. \n" +
                "Geben Sie den Namen des Herstellers ein:\n");

        Hersteller her1 = new Hersteller(einleser.readString());//Neuer Hersteller wird kreiert und einen Namen gegeben.
        katalog.herstellerHinzufuegen(her1);

        System.out.println("Der Hersteller " + her1.getHerstellerName() + " wurde gespeichert.\n\n");

    }

    /**
     * Ein Hersteller wird hinzugefügt auf Englisch.
     */
    private void herstellerHinzufuegenEnglisch() {
        System.out.print("You have chosen to add a new manufacturer. Enter the name of the manufacturer:\n");

        Hersteller her1 = new Hersteller(einleser.readStringEnglisch());//Neuer Hersteller wird kreiert und einen Namen
        // gegeben.
        katalog.herstellerHinzufuegen(her1);

        System.out.println("The manufacturer " + her1.getHerstellerName() + " has been saved.\n\n");

    }

    /**
     * Ein Flugzeug oder ein Hersteller wird gelöscht. Der Benutzer muss auswählen, was es löschen will.
     * Wenn der Benutzer etwas falsches eingibt kommt eine Fehlermeldung und der Benutzer muss nochmals eingben.
     */
    private void herstellerFlugzeugloeschen() {
        System.out.print("\nMöchten Sie ein Flugzeug oder ein Hersteller löschen:\n" +
                "«f» für das Löschen eines Flugzeugs\n" +
                "«h» für das Löschen eines Herstellers\n");

        char loeschBuchstabe = einleser.readCharLoeschenDeutsch();

        //"f" ist für das Löschen eines Flugzeugs.
        if (loeschBuchstabe == 'f') {
            System.out.println("Wählen Sie bitte den Hersteller des Flugzeugs aus, den Sie löschen wollen:");
            katalog.herstellerAnzeigen();

            int auswahlZahlHersteller;
            while (true) {
                auswahlZahlHersteller = einleser.readInt();

                if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                    /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Bitte eine Zahl eingeben, die zur Auswahl steht. Zahl erneut eingeben.\n");
                } else {
                    break;
                }
            }

            Hersteller hersteller = katalog.getHersteller(auswahlZahlHersteller);   /* Schaut ob die gewählte Zahl
             zur Auswahl steht. Returnt das Modell, welches auf der gewählten Zahl basiert.
             */

            if (hersteller.getModellAnzahl() <= 0) {    // Wenn keine Modelle vorhanden sind kommt eine Fehlermeldung
                System.out.println("Es sind keine Modelle vorhanden.\n");
            } else {
                System.out.println("Sie haben den Hersteller " + hersteller.getHerstellerName() + " gewählt. " +
                        "Sie sehen jetzt die Modelle " +
                        "von " + hersteller.getHerstellerName() + ".\nWählen Sie ein Modell aus, welches Sie " +
                        "löschen wollen:\n");
                hersteller.modelleAnzeigen();
                while (true) {
                    int auswahlZahlModell = einleser.readInt();

                    if (auswahlZahlModell > (hersteller.getModellAnzahl() - 1) || auswahlZahlModell < 0) {
                     /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Modelle oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                        System.out.print("Bitte eine Zahl eingeben, die zur Auswahl steht. Zahl erneut eingeben.\n");
                    } else {
                        hersteller.modellLoeschen(auswahlZahlModell);       //Löscht das ausgewählte Modell.
                        System.out.println("Das Modell mit der Nummer " + auswahlZahlModell + " wurde gelöscht.\n\n");
                        break;
                    }
                }
            }

        } else if (loeschBuchstabe == 'h') {        //"h" ist für das Löschen eines Herstellers.
            System.out.println("Wählen Sie bitte den Hersteller aus, den Sie löschen wollen:");
            katalog.herstellerAnzeigen();

            int auswahlZahlHersteller;
            while (true) {
                auswahlZahlHersteller = einleser.readInt();

                if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                    /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Herstller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Bitte eine Zahl eingeben, die zur Auswahl steht. Zahl erneut eingeben.\n");
                } else {
                    katalog.herstellerLoeschen(auswahlZahlHersteller);  //Löscht den ausgewählten Hersteller.
                    System.out.println("Der Hersteller mit der Nummer " + auswahlZahlHersteller + " wurde gelöscht." +
                            "\n\n");
                    break;
                }
            }
        }
    }


    /**
     * Ein Flugzeug oder ein Hersteller wird auf Englisch gelöscht. Der Benutzer muss auswählen, was es löschen will.
     * Wenn der Benutzer etwas falsches eingibt kommt eine Fehlermeldung und der Benutzer muss nochmals eingben.
     */
    private void herstellerFlugzeugloeschenEnglisch() {
        System.out.print("\nYou want to delete an aircraft or a manufacturer:\n" +
                "«f» to delete an aircraft\n" +
                "«h» for delete a manufacturer\n");

        char loeschBuchstabe = einleser.readCharLoeschenEnglisch();

        //"f" ist für das Löschen eines Flugzeugs.
        if (loeschBuchstabe == 'f') {
            System.out.println("Please select the manufacturer of the aircraft you want to delete:");
            katalog.herstellerAnzeigen();

            int auswahlZahlHersteller;
            while (true) {
                auswahlZahlHersteller = einleser.readIntEnglisch();

                if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                    /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Hersteller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Please enter a number that is available for selection. Enter a number again.\n");
                } else {
                    break;
                }
            }

            Hersteller hersteller = katalog.getHerstellerEnglisch(auswahlZahlHersteller);   /* Schaut ob die gewählte
            Zahl zur Auswahl steht. Returnt das Modell, welches auf der gewählten Zahl basiert.
             */

            if (hersteller.getModellAnzahl() <= 0) {    // Wenn keine Modelle vorhanden sind kommt eine Fehlermeldung
                System.out.println("There are no models available.\n\n");
            } else {
                System.out.println("You have chosen the manufacturer " + hersteller.getHerstellerName() + ". " +
                        "Now you see the models of " + hersteller.getHerstellerName() + ".\nSelect the model you " +
                        "want to delete:\n");
                hersteller.modelleAnzeigen();
            }

            while (true) {
                int auswahlZahlModell = einleser.readIntEnglisch();

                if (auswahlZahlModell > (hersteller.getModellAnzahl() - 1) || auswahlZahlModell < 0) {
                     /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Modelle oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Please enter a number that is available for selection. Enter a number again.\n");
                } else {
                    hersteller.modellLoeschen(auswahlZahlModell);       //Löscht das ausgewählte Modell.
                    System.out.println("The model with number " + auswahlZahlModell + " was deleted.\n\n");
                    break;
                }
            }


        } else if (loeschBuchstabe == 'h') {        //"h" ist für das Löschen eines Herstellers.
            System.out.println("Please select the manufacturer you want to delete:");
            katalog.herstellerAnzeigen();

            int auswahlZahlHersteller;
            while (true) {
                auswahlZahlHersteller = einleser.readIntEnglisch();

                if (auswahlZahlHersteller > (katalog.getAnzahlHersteller() - 1) || auswahlZahlHersteller < 0) {
                    /*Schaut ob die Eingabe des Benutzers korrekt ist. Wenn die eingegebene Zahl grösser als die
                     Anzahl von Herstller oder kleiner als 0 ist, kommt eine Fehlermeldung.
                     */
                    System.out.print("Please enter a number that is available for selection. Enter a number again.\n");
                } else {
                    katalog.herstellerLoeschen(auswahlZahlHersteller);  //Löscht den ausgewählten Hersteller.
                    System.out.println("The manufacturer with number " + auswahlZahlHersteller + " was deleted." +
                            "\n\n");
                    break;
                }
            }
        }
    }

    /**
     * Hier werden alle Daten beim Abschluss des Programms gespeichert. 
     */
    private void fileSpeichernSammlung(){
        try {
            FileWriter herstellerListe = new FileWriter("HerstellerListe.txt");//macht einen neuen Schreiber
            for (int i = 0; i < katalog.getAnzahlHersteller(); i++) {//schreibt alle Hersteller in das File.
                Hersteller myHersteller = katalog.getHersteller(i);
                String herstellerName = myHersteller.getHerstellerName();

                herstellerListe.write(herstellerName+"\n");//schreibt den Herstellernamen in die Herstellerliste

                FileWriter modellListe = new FileWriter(herstellerName+".txt");//macht einen neuen Schreiber
                for (int y = 0; y < myHersteller.getModellAnzahl(); y++) {
                    // schreibt alle Flugzeugdaten in das File
                    Modell myModell = myHersteller.getModell(y);
                    modellListe.write(myModell.getName()+",");
                    modellListe.write(myModell.getLaenge()+",");
                    modellListe.write(myModell.getHoehe()+",");
                    modellListe.write(myModell.getFluegelspannweite()+",");
                    modellListe.write(myModell.getGeschwindigkeit()+",");
                    modellListe.write(myModell.getReichweite()+",\n");

                }
                modellListe.close();
            }
            herstellerListe.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Es werden alle vorgespeicherten Flugzeugemodelle, Hersteller aufgerufen. Alle Daten sind in mehreren Files.
     */
    private void fileSammlung() {

        try {
            File herstellerListe = new File("HerstellerListe.txt");
            Scanner myReaderHerstellerName = new Scanner(herstellerListe);//macht einen neuen Scanner
            while (myReaderHerstellerName.hasNextLine()){
                String herstellerName = myReaderHerstellerName.nextLine();//list den Namen des Herstellers
                Hersteller hersteller = new Hersteller(herstellerName);

                File herstellerFile = new File(herstellerName+".txt");
                Scanner myReaderHersteller = new Scanner(herstellerFile).useDelimiter(",");


                while (myReaderHersteller.hasNextLine()){
                    String modellName = myReaderHersteller.next();
                    Modell modell = new Modell(modellName);

                    //holt alle Daten von dem File und speichert diese in das Programm
                    double laenge = myReaderHersteller.nextDouble();
                    double hoehe = myReaderHersteller.nextDouble();
                    double fluegelSpannWeite = myReaderHersteller.nextDouble();
                    int geschwindigkeit = myReaderHersteller.nextInt();
                    int reichweite = myReaderHersteller.nextInt();
                    myReaderHersteller.nextLine();
                    modell.flugzeugHinzufuegen(laenge,hoehe,fluegelSpannWeite,geschwindigkeit,reichweite);
                    hersteller.modellHinzufuegen(modell);
                }
                katalog.herstellerHinzufuegen(hersteller);
                myReaderHersteller.close();
            }
            myReaderHerstellerName.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}