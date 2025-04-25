package formatif7a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BasesSet {

    public static void main(String[] args) {

        //Création d'un Set avec HashSet
        Set<Maison> hashSet1 = new HashSet<>();
        hashSet1.add(new Maison("Bob",  250000, 1,"Beauport"));
        hashSet1.add(new Maison("Georges",  250000, 1,"Charlesbourg"));
        hashSet1.add(new Maison("Albert",  250000, 1,"Sillery"));

        Maison uneMaison = new Maison("Romero",  250000, 1,"Cap-Rouge");
        boolean estAjoutee = hashSet1.add(uneMaison);
        System.out.println("L'objet a été ajouté?" + estAjoutee);
        System.out.println("La taille du hashSet1 est de: " + hashSet1.size());
        estAjoutee = hashSet1.add(uneMaison); //Elle ne sera pas ajoutée une deuxième fois!
        System.out.println("L'objet a été ajouté?" + estAjoutee);
        System.out.println("La taille du hashSet1 est de: " + hashSet1.size());


        Set<Maison> hashSet2 = new HashSet<>();
        hashSet2.add(new Maison("Alphonse",  250000, 1,"Beauport"));
        hashSet2.add(new Maison("Léopold",  250000, 1,"Charlesbourg"));
        hashSet2.add(new Maison("Rosalie",  250000, 1,"Sillery"));

        //Ajout des éléments du hashSet2 dans hashSet1
        hashSet1.addAll(hashSet2);
        System.out.println("La taille du hashSet1 est de: " + hashSet1.size());


        System.out.println("Est-ce que le hashSet1 est vide?" + hashSet1.isEmpty());

        //Création d'un Set avec TreeSet
        Set<Maison> treeSet1 = new TreeSet<>();

        System.out.println("La taille du treeSet1 et de: " + treeSet1.size());
        System.out.println("Est-ce que le treeSet1 est vide?" + treeSet1.isEmpty());



        //Afficher tous les éléments d'un Set
        Iterator<Maison> it = hashSet1.iterator();
        while(it.hasNext()){
            Maison m = it.next();
            System.out.println(m);
        }

        //Enlever un élément d'un Set  -- dépend de equals() de Maison
        boolean maisonEnlevee = hashSet1.remove(uneMaison);
        System.out.println("La maison a été supprimée?" + maisonEnlevee);
        System.out.println("La taille du hashSet1 est de: " + hashSet1.size());


        boolean maisonsEnlevees = hashSet1.removeAll(hashSet2);
        System.out.println("Les maisons ont été supprimées?" + maisonsEnlevees);
        System.out.println("La taille du hashSet1 est de: " + hashSet1.size());

    }
}
