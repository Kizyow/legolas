/*
 * Classe Arc
 */

public class Arc {

    /*
     * Attributs de la classe Arc
     */
    private int degats;
    private int fleches;

    /**
     * Constructeur par defaut (3 fleches faisant 5 degats chacune)
     */
    public Arc() {
        this.degats = 5;
        this.fleches = 3;
    }

    /**
     * Constructeur avec deux paramètres
     *
     * @param dg Le nombre de degats par fleche
     * @param fl Le nombre de fleche dans le carquois de l'arc
     */
    public Arc(int dg, int fl) {
        if (dg < 0) dg = 0;
        if (fl < 0) fl = 0;

        this.degats = dg;
        this.fleches = fl;
    }

    /**
     * Recupere le nombre de degats
     *
     * @return Le nombre de degats de l'arc
     */
    public int getDegats() {
        return this.degats;
    }

    /**
     * Recupere le nombre de fleche dans le carquois de l'arc
     *
     * @return Le nombre de fleche restante dans la carquois de l'arc
     */
    public int getFleches() {
        return this.fleches;
    }

    /**
     * Permet d'ajouter des fleches dans le carquois de l'arc
     *
     * @param nFleches Le nombre de fleche a ajouter en plus dans le carquois
     */
    public void recharger(int nFleches) {
        if (nFleches < 0) return;
        this.fleches += nFleches;
    }

    /**
     * Permet d'utiliser l'arc en retirant une fleche du carquois et qui retourne le nombre de degats
     *
     * @return Le nombre de degats lors de l'utilisation de l'arc
     */
    public int utiliser() {
        if (this.fleches == 0) return 0;

        this.fleches -= 1;
        return this.degats;
    }

    /**
     * Recupere l'etat de la classe Arc au cours de son execution
     *
     * @return Un String qui contient le nombre de degats de l'arc et le nombre de fleches restante dans le carquois
     */
    @Override
    public String toString() {
        return "-arc(d:" + this.degats + ", f:" + this.fleches + ')';
    }

}
