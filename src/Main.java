import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Guerrier legolas = new Guerrier("Legolas", 4);
        Guerrier orc = new Guerrier("Ugluk", 3);

        afficher("Initialisation", legolas, orc);

        legolas.attaquer(orc);

        afficher("Attaque de Legolas vers Ugluk mais n'a pas d'arme et ne fait aucun dégât", legolas, orc);

        Arc arcElfique = new Arc(2, 1);
        legolas.prendreArc(arcElfique);

        afficher("Legolas a pris l'arc elfique", legolas, orc);

        legolas.attaquer(orc);

        afficher("Legolas attaque Ugluk avec l'arc elfique, il fait 2 dégâts à Ugluk", legolas, orc);

        legolas.attaquer(orc);

        afficher("Legolas attaque Ugluk mais n'a plus de flèches", legolas, orc);

        Arc orcArc = new Arc(5, 3);
        orc.prendreArc(orcArc);

        afficher("Ugluk prend un arc", legolas, orc);

        orc.attaquer(legolas);

        afficher("Ugluk attaque Legolas et est blessé", legolas, orc);

        Guerrier arwen = new Guerrier("Arwen", 10);

        afficher("Arwen rejoint le combat", legolas, orc, arwen);

        arwen.prendreArc(arcElfique);
        arcElfique.recharger(1);

        afficher("Arwen prend l'arc elfique de Legolas et le recharge d'une flèche", legolas, orc, arwen);

        arwen.attaquer(orc);

        afficher("Arwen attaque Ugluk et le blesse", legolas, orc, arwen);

        orc.attaquer(arwen);

        afficher("Ugluk tente d'attaquer Arwen mais est bléssé et ne fait aucun dégâts", legolas, orc, arwen);


    }

    public static void afficher(String string, Guerrier... guerriers) {
        System.out.println("----------[" + string + "]----------");
        Arrays.stream(guerriers).forEach(System.out::println);
    }



}
