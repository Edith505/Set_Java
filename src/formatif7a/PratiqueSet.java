package formatif7a;

import java.util.*;

public class PratiqueSet {

    private Set<Character> voyelles;

    public PratiqueSet() {
        //TODO 1 L'attribut voyelle doit contenir un set avec toutes les voyelles (minusucles et majuscules)
        this.voyelles = new HashSet<> (Arrays.asList('a','e','i','o','u','y','A','E','I','O','U','Y'));

    }

    private Set<Character> convertToCharSet(String phrase) {
        Set<Character> retSet = new HashSet<>();
        //TODO 2 en utilisant la méthode de String toCharArray, convertissez à l'aide d'une boulce la chaine de caractères en Set de char
        for (char c : phrase.toCharArray()) {
            retSet.add(c);
        }
        return retSet;
    }

    public int compteUniqueCaracter(String phrase) {
        //TODO 3 Comptez le nombre de caractères différent dans la phrase en utilisant la méthode convertToCharSet
        return 0;
    }

    public int compteVoyelles(Set<Character> phrase) {
        //On copie le Set pour ne pas modifier le Set original
        Set<Character> retSet = new HashSet<>(phrase);

        //TODO 4 On ne conserve que les lettres qui sont dans l'ensemble de voyelles
        retSet.retainAll(voyelles);

        //On retourne le nombre de lettres trouvées.
        return retSet.size();
    }

    public int compteVoyelles(String phrase) {
        //On convertit la phrase en set de lettre.
        return compteVoyelles(convertToCharSet(phrase));
    }

    public int compteConsonnes(Set<Character> phrase) {
        //On copie le Set pour ne pas modifier le Set original
        Set<Character> retSet = new HashSet<>(phrase);

        //TODO 5 On ne conserve que les lettres qui sont dans l'ensemble de consonnes
        retSet.removeAll(voyelles);

        //On retourne le nombre de lettres trouvées.
        return retSet.size();
    }

    public int compteConsonnes(String phrase) {
        //On convertit la phrase en set de lettre.
        return compteConsonnes(convertToCharSet(phrase));
    }

    public Set<Character> combineSet(Set<Character>... ensembles) {
        Set<Character> retSet = new HashSet<>();
        //TODO 6 Écrivez une méthode qui combine plusieurs Set en un seul Set


        return retSet;
    }

    String concat(String... chaines) {
        String retChaine = "";
        for (String chaine : chaines) {
            retChaine += chaine;
        }
        return retChaine;
    }

    public static void main(String[] args) {


        float val = 0.45f;

        PratiqueSet setAnalyseur = new PratiqueSet();

        String[] chaines = {"asdf","asdf","asdf"};
        setAnalyseur.concat(chaines);
        setAnalyseur.concat("asdf","asdf");


        Set<Character>[] tab = new Set[5];
        tab[0] = null;
        setAnalyseur.combineSet(new HashSet(), new HashSet<>());
        setAnalyseur.combineSet(tab);
        //On analyse la phrase
        String phrase = MethodesUtiles.recupererStringConsole("Saisissez une phrase");

        System.out.println(phrase);
        System.out.println("La phrase compte: " + setAnalyseur.compteUniqueCaracter(phrase) + " lettres différentes");
        System.out.println("La phrase compte: " + setAnalyseur.compteVoyelles(phrase) + " voyelles différentes");
        System.out.println("La phrase compte: " + setAnalyseur.compteConsonnes(phrase) + " consonnes différentes");


        String phrase1 = "La première phrase";
        String phrase2 = " est combinée avec ";
        String phrase3 = "la seconde.";
        //TODO 7  convertissez les 3 phrases en Set de caractères


        //TODO 8 combiner les 3 sets à l'aide de la méthode combineSet

        //TODO 9 Calculer le nombre de voyelles différentes dans les 3 phrases
        // int nombreDeVoyelles =???;


        // System.out.println(" Les trois phrases contiennent:"+nombreDeVoyelles+" voyelles");


        System.out.println("\n Opération sur des ensembles");
        {
            Collection<Long> col1 = new HashSet<>(Arrays.asList(1l, 2l, 3l, 4l, 5l));
            Collection<Long> col2 = new HashSet<>(Arrays.asList(2l, 4l, 6l, 8l, 10l));
            Collection<Long> col3 = new HashSet<>(Arrays.asList(4l, 5l, 6l, 7l, 8l));

            // TODO 10 trouvez ce qui est dans col1 et col2. Intersection


            // TODO 11  Trouvez ce qu'il y a dans col2 ou col3. Union


            // TODO 12 Trouvez ce qui est dans col3 qui n'est pas dans col1. Différence


            // TODO 13 Trouvez ce qui est commun au trois collections:  Intersection


            // TODO 14 trouvez ce qui est dans 1 et 2 mais pas dans 3   -> 21


        }
    }
}
