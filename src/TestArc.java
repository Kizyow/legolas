import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

import libtest.*;

/******************
 * test classe Arc
 *******************/
public class TestArc {

    /**
     * methode de lancement des tests
     */
    public static void main(String[] args) {
        lancer(new TestArc(), args);
    }

    /**
     * verifie que les méthodes sont bien appelée
     */
    public void test_arc_methodes() {
        Arc arc = new Arc(3, 5);
        assertEquals("ordre parametres est mauvais", 3, arc.getDegats());
        assertEquals("ordre parametres est mauvais", 5, arc.getFleches());

        arc.recharger(5);
        int dg = arc.utiliser();
        String s = arc.toString();
    }

    /**
     * quand l'arc est recharge correctement
     */
    public void test_recharger_OK() {
        // preparation des donnees
        Arc arc = new Arc(3, 5);

        // methode testee
        arc.recharger(2);

        // verifications
        assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
        assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
    }

    /**
     * quand l'arc est recharge avec un nombre de fleches negatif
     */
    public void test_recharger_negatif() {
        // preparation des donnees
        Arc arc = new Arc(3, 5);

        // methode testee
        arc.recharger(-2);

        // verifications
        assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
        assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
    }


    //... autres tests de la classe Arc

    /**
     * quand l'arc est construit par defaut
     */
    public void test_constructeur_parDefaut() {
        // preparation des donnees
        Arc arc = new Arc();

        // verifications
        assertEquals("arc doit faire 5 degats", 5, arc.getDegats());
        assertEquals("arc doit avoir 3 fleches", 3, arc.getFleches());
    }

    /**
     * quand l'arc est construit avec des degats et fleches correctement
     */
    public void test_constructeur_OK() {
        // preparation des donnees
        Arc arc = new Arc(10, 25);

        // verifications
        assertEquals("arc doit faire 10 degats", 10, arc.getDegats());
        assertEquals("arc doit avoir 25 fleches", 25, arc.getFleches());
    }

    /**
     * quand l'arc est construit avec des degats et fleches negatives
     */
    public void test_constructeur_negatif() {
        // preparation des donnees
        Arc arc = new Arc(-3, -5);

        // verifications
        assertEquals("arc doit faire 0 degat", 0, arc.getDegats());
        assertEquals("arc doit avoir 0 fleche", 0, arc.getFleches());
    }

    /**
     * quand l'arc est utilise correctement
     */
    public void test_utiliser_OK() {
        // preparation des donnees
        Arc arc = new Arc(3, 5);

        // methode testee
        int degatsUtilisation = arc.utiliser();

        // verifications
        assertEquals("utilisation de l'arc doit faire 3 degats", 3, degatsUtilisation);
        assertEquals("arc doit avoir 4 fleches", 4, arc.getFleches());
    }

    /**
     * quand l'arc est utilise avec aucune fleche dans le carquois
     */
    public void test_utiliser_carquoisVide() {
        // preparation des donnees
        Arc arc = new Arc(3, 0);

        // methode testee
        int degatsUtilisation = arc.utiliser();

        // verifications
        assertEquals("utilisation de l'arc doit faire 0 degat", 0, degatsUtilisation);
        assertEquals("arc doit toujours avoir 0 fleche", 0, arc.getFleches());
    }

}