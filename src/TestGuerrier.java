import libtest.Test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 */
public class TestGuerrier {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestGuerrier(), args);
	}

	/**
	 * test des methodes de guerrier
	 */
	@Test
	public void test_guerrier_methodes() {
		Guerrier guerrier = new Guerrier("Toto",10);

		int pv = guerrier.getPv();
		Arc arc = guerrier.getArc();
		String nom = guerrier.getNom();

		boolean b = guerrier.etreBlesse();
		guerrier.subirDegats(1);

		Arc arcN =new Arc();
		boolean resPrendre = guerrier.prendreArc(arcN);
		Arc resPoser =guerrier.poserArc();

		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);

		String guerrierS = guerrier.toString();
	}

	public void test_constructeur_nom(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// verifications
		assertEquals("guerrier doit s'appeler 'Legolas'", "Legolas", guerrier.getNom());
		assertEquals("guerrier doit avoir 10 pv", 10, guerrier.getPv());
		assertEquals("guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	public void test_constructeur_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas", 50);

		// verifications
		assertEquals("guerrier doit s'appeler 'Legolas'", "Legolas", guerrier.getNom());
		assertEquals("guerrier doit avoir 50 pv", 50, guerrier.getPv());
		assertEquals("guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	public void test_constructeur_pvNegatif(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas", -50);

		// verifications
		assertEquals("guerrier doit s'appeler 'Legolas'", "Legolas", guerrier.getNom());
		assertEquals("guerrier doit avoir 1 pv", 1, guerrier.getPv());
		assertEquals("guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	public void test_subirDegats_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		guerrier.subirDegats(8);

		// verifications
		assertEquals("guerrier doit avoir 2 pv", 2, guerrier.getPv());
	}

	public void test_subirDegats_negatif(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		guerrier.subirDegats(-10);

		// verifications
		assertEquals("guerrier doit toujours avoir 10 pv", 10, guerrier.getPv());
	}

	public void test_subirDegats_plusGrandQuePv(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		guerrier.subirDegats(15);

		// verifications
		assertEquals("guerrier doit etre a 0 pv", 0, guerrier.getPv());
	}

	public void test_etreBlesse_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		boolean blesse = guerrier.etreBlesse();

		// verifications
		assertEquals("guerrier ne doit pas etre blesse", false, blesse);
	}

	public void test_etreBlesse_apresSubirDegats(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas", 10);

		// methode testee
		guerrier.subirDegats(10);
		boolean blesse = guerrier.etreBlesse();

		// verifications
		assertEquals("guerrier doit etre blesse", true, blesse);
	}

	public void test_prendreArc_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		Arc arc = new Arc();
		boolean aPrisArc = guerrier.prendreArc(arc);

		// verifications
		assertEquals("guerrier doit avoir pris l'arc", true, aPrisArc);
	}

	public void test_prendreArc_null(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		boolean aPrisArc = guerrier.prendreArc(null);

		// verifications
		assertEquals("guerrier doit avoir rien fait car l'arc est null", false, aPrisArc);
	}

	public void test_prendreArc_aDejaArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		Arc arc1 = new Arc(10, 2);
		guerrier.prendreArc(arc1);

		// methode testee
		Arc arc2 = new Arc(5, 3);
		boolean aPrisArc = guerrier.prendreArc(arc2);

		// verifications
		assertEquals("guerrier doit avoir rien fait car a deja un arc", false, aPrisArc);
	}

	public void test_prendreArc_estBlesse(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		guerrier.subirDegats(10);

		// methode testee
		Arc arc = new Arc();
		boolean aPrisArc = guerrier.prendreArc(arc);

		// verifications
		assertEquals("guerrier doit avoir rien fait car est blesse", false, aPrisArc);
	}

	public void test_poserArc_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc();
		guerrier.prendreArc(arc);

		// methode testee
		Arc arcPosee = guerrier.poserArc();

		// verifications
		assertEquals("guerrier doit avoir pose son arc", arc, arcPosee);
	}

	public void test_poserArc_null(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		Arc arcPosee = guerrier.poserArc();

		// verifications
		assertEquals("guerrier doit avoir rien fait car n'a pas d'arc", null, arcPosee);
	}

	public void test_poserArc_estBlesse(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		guerrier.subirDegats(10);

		// methode testee
		Arc arcPosee = guerrier.poserArc();

		// verifications
		assertEquals("guerrier doit avoir rien fait car est blesse", null, arcPosee);
	}

	public void test_attaquer_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc();
		guerrier.prendreArc(arc);

		// methode testee
		Guerrier victime = new Guerrier("Victime");
		boolean attaque = guerrier.attaquer(victime);

		// verifications
		assertEquals("guerrier doit avoir attaquer victime", true, attaque);
		assertEquals("victime doit avoir 5 pv", 5, victime.getPv());
		assertEquals("guerrier doit avoir 2 fleche", 2, guerrier.getArc().getFleches());
	}

	public void test_attaquer_victimeNull(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc();
		guerrier.prendreArc(arc);

		// methode testee
		boolean attaque = guerrier.attaquer(null);

		// verifications
		assertEquals("guerrier doit avoir rien fait car victime n'existe pas", false, attaque);
		assertEquals("guerrier doit avoir 3 fleche", 3, guerrier.getArc().getFleches());
	}

	public void test_attaquer_arcNull(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");

		// methode testee
		Guerrier victime = new Guerrier("Victime");
		boolean attaque = guerrier.attaquer(victime);

		// verifications
		assertEquals("guerrier doit avoir rien fait car n'a pas d'arc", false, attaque);
		assertEquals("victime doit avoir 10 pv", 10, victime.getPv());

	}

	public void test_attaquer_estBlesse(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		guerrier.subirDegats(10);

		// methode testee
		Guerrier victime = new Guerrier("Victime");
		boolean attaque = guerrier.attaquer(victime);

		// verifications
		assertEquals("guerrier doit avoir rien fait car est blesse", false, attaque);
		assertEquals("victime doit avoir 10 pv", 10, victime.getPv());
		assertEquals("guerrier doit avoir 3 fleches", 3, guerrier.getArc().getFleches());

	}

	public void test_attaquer_aucunDegat(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc(0, 10);
		guerrier.prendreArc(arc);

		// methode testee
		Guerrier victime = new Guerrier("Victime");
		boolean attaque = guerrier.attaquer(victime);

		// verifications
		assertEquals("guerrier doit avoir rien fait car son arc fait 0 degat", false, attaque);
		assertEquals("victime doit avoir 10 pv", 10, victime.getPv());
		assertEquals("guerrier doit avoir 9 fleches", 9, guerrier.getArc().getFleches());
	}

	public void test_attaquer_aucuneFleche(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Legolas");
		Arc arc = new Arc(10, 0);
		guerrier.prendreArc(arc);

		// methode testee
		Guerrier victime = new Guerrier("Victime");
		boolean attaque = guerrier.attaquer(victime);

		// verifications
		assertEquals("guerrier doit avoir rien fait car n'a plus de fleche", false, attaque);
		assertEquals("victime doit avoir 10 pv", 10, victime.getPv());
		assertEquals("guerrier doit avoir 0 fleche", 0, guerrier.getArc().getFleches());
	}




}
