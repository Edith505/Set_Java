package formatif7a;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MethodesUtiles {
    public static String REGEX_DECIMAL = "^-?\\d*\\.\\d+$";
    public static String REGEX_INTEGER = "^-?\\d+$";
    public static String REGEX_DOUBLE = REGEX_DECIMAL + "|" + REGEX_INTEGER;

    /**
     * Méthode permettant de formater un montant d'argent pour affichage (incluant le signe de $).
     * @param pPrix Prix à formater
     * @return Chaîne de caractères avec le prix formaté
     */
    public static String arrondirEtFormaterPrix(double pPrix) {
        String prixFormate = "";
        double prixArrondi = Math.round(pPrix * 100.0) / 100.0;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        prixFormate = format.format(prixArrondi);
        return prixFormate;
    }

    public static int recupererEntierConsole(String pQuestion) {
        Scanner sc = new Scanner(System.in); //Déclaration et instanciation du Scanner
        String reponse = "";
        int entier = 0;
        boolean estValide;
        do {
            estValide = true;
            System.out.println(pQuestion);

            reponse = sc.nextLine();
            if (!reponse.matches(REGEX_INTEGER)) {
                estValide = false;
                System.out.println("****Le nombre entré n'est pas un entier.****");
            }
        } while(!estValide);

        entier = Integer.parseInt(reponse);
        return entier;
    }


    public static double recupererDoubleConsole(String pQuestion) {
        Scanner sc = new Scanner(System.in); //Déclaration et instanciation du Scanner
        String reponse = "";
        double nombre = 0;
        boolean estValide = true;
        do {
            estValide = true;
            System.out.println(pQuestion);
            reponse = sc.nextLine();
            //Convertir la virgule en point
            reponse = reponse.replaceAll(",", ".");
            if (!(reponse.matches(REGEX_DOUBLE))) {
                estValide = false;
                System.out.println("****Le nombre entré n'est pas un nombre flottant.****");
            }
        } while(estValide == false);

        nombre = Double.parseDouble(reponse);
        return nombre;
    }

    public static String recupererStringConsole(String pQuestion) {
        Scanner sc = new Scanner(System.in); //Déclaration et instanciation du Scanner
        System.out.println(pQuestion);
        String reponse = sc.nextLine();
        return reponse;
    }

}
