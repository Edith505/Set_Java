package formatif7a;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Maison {
    public static final double TAUX_BEAUPORT_CHARLESBOURG_SILLERY = 0.8430;
    public static final double TAUX_CAP_ROUGE = 0.8969;
    public static final double TAUX_QUEBEC = 0.8926;
    public static final double TAUX_SAINTE_FOY = 0.8439;
    public static final double MNT_AQUEDUC = 280;
    public static final double MNT_MAT_RESID = 171;
    public static final double MIN_MNT = 0;
    public static final double MIN_NB_LOGEMENTS = 1;
    public static final double MAX_NB_LOGEMENTS = 6;

    private String proprio;
    private double mntEvaluation;
    private int nbLogements;
    private String secteur;

    private double valeur;
    private String adresse;
    public final static Collection<String> SECTEURS_VALIDES = Arrays.asList(
            "Beauport", "Charlesbourg",
            "Sillery", "Cap-Rouge",
            "Québec", "Sainte-Foy");

    public Maison() {
        proprio = "";
        secteur = "";
        mntEvaluation = 0;
        nbLogements = 0;
    }

    public Maison(String pProprio, String pAdresse, double pValeur) {
        proprio = pProprio;
        adresse = pAdresse;
        valeur = pValeur;
    }

    public Maison(String pProprio, double pMntEvaluation, int pNbLogements, String pSecteur) {
        setProprio(pProprio);
        setMntEvaluation(pMntEvaluation);
        setSecteur(pSecteur);
        setNbLogements(pNbLogements);
    }

    public String getProprio() {
        return proprio;
    }

    public void setProprio(String pProprio) {
        assert pProprio != null : "proprio null";
        assert pProprio.length() > 0 : "proprio vide";

        System.out.println("Le nom de propriétaire est invalide.");

    }

    public double getMntEvaluation() {
        return mntEvaluation;
    }

    public void setMntEvaluation(double pMntEvaluation) {
        assert pMntEvaluation >= MIN_MNT : "montant évaluation négatif";

        System.out.println("Le montant d'évaluation est invalide.");

    }

    public int getNbLogements() {
        return nbLogements;
    }

    public void setNbLogements(int pNbLogements) {
        assert pNbLogements >= MIN_NB_LOGEMENTS : "manque de logements";
        assert pNbLogements <= MAX_NB_LOGEMENTS : "trop de logements";

        System.out.println("Le nombre de logements est invalide.");

    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String pSecteur) {

        assert valideSecteur(secteur) : "Secteur non valide";

        this.secteur = pSecteur;
    }

    public String toString() {
        return "La maison appartenant à " + getProprio() + " avec " + getNbLogements()
                + " logement, située à " + getSecteur()
                + ", dont l'évaluation municipale est de "
                + MethodesUtiles.arrondirEtFormaterPrix(getMntEvaluation())
                + " aura une facture de taxes municipales de "
                + MethodesUtiles.arrondirEtFormaterPrix(calculerMntTaxes());
    }

    public double recupererTaux() {
        double taux = 0;
        if (secteur.equalsIgnoreCase("Beauport") ||
                secteur.equalsIgnoreCase("Charlesbourg") ||
                secteur.equalsIgnoreCase("Sillery")) {
            taux = TAUX_BEAUPORT_CHARLESBOURG_SILLERY;
        } else if (secteur.equalsIgnoreCase("Cap-Rouge")) {
            taux = TAUX_CAP_ROUGE;
        } else if (secteur.equalsIgnoreCase("Québec")) {
            taux = TAUX_QUEBEC;
        } else if (secteur.equalsIgnoreCase("Sainte-Foy")) {
            taux = TAUX_SAINTE_FOY;
        }
        return taux;
    }

    private boolean valideSecteur(String secteur) {
        return SECTEURS_VALIDES.contains(secteur);
    }

    public double calculerMntTaxes() {
        double mntTaxes = 0;
        //Montant taxes = [(Eval. municipale / 100) * Taux combiné] + (Frais de services * nb logements)
        mntTaxes = ((getMntEvaluation() / 100) * recupererTaux()) + ((MNT_AQUEDUC + MNT_MAT_RESID) * getNbLogements());
        return mntTaxes;
    }

    public double getValeur() {
        return valeur;
    }



}
