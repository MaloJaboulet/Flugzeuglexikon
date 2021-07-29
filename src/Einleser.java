import java.util.Scanner;

/**
 * Die Methoden lesen von der Kommandozeile ab.
 *
 * @author Malo Jaboulet
 * @version 1
 * @since 2020-03-31
 */

public class Einleser {

    static Scanner scanner;

    public Einleser() {
        scanner = new Scanner(System.in);
    }


    /**
     * Liest von der Kommandozeile und schaut ob es ein double ist. Wenn es kein double ist kommt eine Fehlermeldung
     * und der Benutzer kann wieder etwas eingben.
     *
     * @return was es von der Kommandozeile gelesen hat.
     */
    public double readDouble() {
        System.out.print(">");
        while (!scanner.hasNextDouble()) {
            System.out.print("Bitte eine Zahl eingeben. Nochmals eingeben:\n>");
            scanner.next();                     //leert den Scanner für das nächste Mal
        }
        double zahl = scanner.nextDouble();
        scanner.nextLine();
        return zahl;
    }


    /**
     * Liest von der Kommandozeile und schaut ob es ein double ist. Wenn es kein double ist kommt eine Fehlermeldung
     * und der Benutzer kann wieder etwas eingben. Die Fehlermeldung ist auf Englisch.
     *
     * @return was es von der Kommandozeile gelesen hat.
     */
    public double readDoubleEnglisch() {
        System.out.print(">");
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a number. Enter again:\n>");
            scanner.next();                     //leert den Scanner für das nächste Mal
        }
        double zahl = scanner.nextDouble();
        scanner.nextLine();
        return zahl;
    }

    /**
     * Liest von der Kommandozeile und schaut ob es ein int ist.Wenn es kein Int ist kommt eine Fehlermeldung
     * und der Benutzer kann wieder etwas eingben.
     *
     * @return was es von der Kommandozeile gelesen hat.
     */

    public int readInt() {
        System.out.print(">");
        while (!scanner.hasNextInt()) {
            System.out.print("Bitte eine Zahl eingeben. Nochmals eingeben:\n>");
            scanner.next();                                              //leert den Scanner für das nächste Mal
        }
        int zahl = scanner.nextInt();
        scanner.nextLine();
        return zahl;
    }


    /**
     * Liest von der Kommandozeile und schaut ob es ein int ist.Wenn es kein Int ist kommt eine Fehlermeldung
     * und der Benutzer kann wieder etwas eingben. Die Fehlermeldung ist auf Englisch.
     *
     * @return was es von der Kommandozeile gelesen hat.
     */

    public int readIntEnglisch() {
        System.out.print(">");
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number. Enter again:\n>");
            scanner.next();                                              //leert den Scanner für das nächste Mal
        }
        int zahl = scanner.nextInt();
        scanner.nextLine();
        return zahl;
    }


    /**
     * Liest von der Kommandozeile und schaut ob es ein String ist. Wenn es kein String ist kommt eine Fehlermeldung
     * und der Benutzer kann wieder etwas eingben.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public String readString() {
        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            System.out.print("Keine Eingabe gemacht. Bitte etwas eingeben.\n");
            return readString();
        } else {
            String text = eingabe;

            return text;
        }
    }

    /**
     * Liest von der Kommandozeile und schaut ob es ein String ist. Wenn es kein String ist kommt eine Fehlermeldung
     * und der Benutzer kann wieder etwas eingben. Die Fehlermeldung ist auf Englisch.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public String readStringEnglisch() {

        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            System.out.print("No input made. Please enter something.");
            return readStringEnglisch();
        } else {
            String text = eingabe;

            return text;
        }
    }


    /**
     * Liest von der Kommandozeile und schaut ob es ein char ist, was zur Auswahl steht. Wenn nichts eingegeben wurde,
     * kommt eine Fehlermeldung.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public char readChar() {

        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {//schaut ob die Eingabe leer ist oder etwas drin ist
            System.out.println("Keine Eingabe gemacht. Bitte etwas eingeben.");
            return readChar();
        } else {
            char buchstabe = eingabe.charAt(0);
            while (buchstabe != 'f' && buchstabe != 'n' && buchstabe != 'h' && buchstabe != 'l' && buchstabe != 's' &&
                    buchstabe != 'b') {

                System.out.print("Bitte f, n, h, l, s oder b eingeben. Erneut eingeben:\n>");

                String text  = scanner.nextLine();
                if(text.isEmpty()){//schaut ob die Eingabe leer ist oder etwas drin ist
                    System.out.println("Keine Eingabe gemacht. Bitte etwas eingeben.");
                    return readChar();
                }else {
                    buchstabe = text.charAt(0);
                }
            }
            return buchstabe;
        }
    }


    /**
     * Liest von der Kommandozeile und schaut ob es ein char ist, was zur Auswahl steht, auf Englisch. Wenn nichts
     * eingegeben wurde kommt eine Fehlermeldung.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public char readCharEnglisch() {

        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            System.out.println("No input made. Please enter something.");
            return readCharEnglisch();
        } else {
            char buchstabe = eingabe.charAt(0);
            while (buchstabe != 'f' && buchstabe != 'n' && buchstabe != 'h' && buchstabe != 'l' && buchstabe != 's' &&
                    buchstabe != 'b') {

                System.out.print("Please enter f, n, h, l, s or b. Enter again:\n>");

                String text  = scanner.nextLine();
                if(text.isEmpty()){//schaut ob die Eingabe leer ist oder etwas drin ist
                    System.out.println("No input made. Please enter something.");
                    return readCharEnglisch();
                }else {
                    buchstabe = text.charAt(0);
                }
            }
            return buchstabe;
        }
    }

    /**
     * Liest von der Kommandozeile und schaut ob es ein char ist, was zur Auswahl steht. Wenn nichts eingegeben wurde,
     * kommt eine Fehlermeldung.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public char readCharFuerSprache() {

        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            System.out.println("Keine Eingabe gemacht.\nNo input made.");
            return readCharFuerSprache();
        } else {
            char buchstabe = eingabe.charAt(0);
            while (buchstabe != 'e' && buchstabe != 'd') {

                System.out.print("Bitte e oder d eingeben.\nPlease enter e or d.\n>");

                String text  = scanner.nextLine();
                if(text.isEmpty()){//schaut ob die Eingabe leer ist oder etwas drin ist
                    System.out.println("Keine Eingabe gemacht.\nNo input made.");
                    return readCharFuerSprache();
                }else {
                    buchstabe = text.charAt(0);
                }
            }
            return buchstabe;
        }
    }

    /**
     * Liest von der Kommandozeile und schaut ob es ein char ist, was zur Auswahl steht. Wenn nichts eingegeben wurde,
     * kommt eine Fehlermeldung.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public char readCharLoeschenDeutsch(){
        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            System.out.println("Keine Eingabe gemacht.\n");
            return readCharFuerSprache();
        } else {
            char buchstabe = eingabe.charAt(0);
            while (buchstabe != 'f' && buchstabe != 'h') {

                System.out.print("Bitte f oder h eingeben.\n>");

                String text  = scanner.nextLine();
                if(text.isEmpty()){//schaut ob die Eingabe leer ist oder etwas drin ist
                    System.out.println("Keine Eingabe gemacht.");
                    return readCharLoeschenDeutsch();
                }else {
                    buchstabe = text.charAt(0);
                }
            }
            return buchstabe;
        }
    }

    /**
     * Liest von der Kommandozeile und schaut ob es ein char ist, was zur Auswahl steht, auf Englisch. Wenn nichts
     * eingegeben wurde kommt eine Fehlermeldung.
     *
     * @return was es von der Kommanodzeile gelesen hat.
     */
    public char readCharLoeschenEnglisch(){
        System.out.print(">");
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            System.out.println("No input made.\n");
            return readCharFuerSprache();
        } else {
            char buchstabe = eingabe.charAt(0);
            while (buchstabe != 'f' && buchstabe != 'h') {

                System.out.print("Please enter f or h.\n>");

                String text  = scanner.nextLine();
                if(text.isEmpty()){//schaut ob die Eingabe leer ist oder etwas drin ist
                    System.out.println("No input made.");
                    return readCharLoeschenEnglisch();
                }else {
                    buchstabe = text.charAt(0);
                }
            }
            return buchstabe;
        }
    }

    /**
     * Zeichnet eine Linie.
     */
    public void linieZeichnen() {
        System.out.println("\n************************************************************************************" +
                "******");
    }


}
