/*
 * Classe Guerrier
 */

public class Guerrier {

    private String nom;
    private int pv;
    private Arc arc;

    public Guerrier(String pNom) {
        this.nom = pNom;
        this.pv = 10;
        this.arc = null;
    }

    public Guerrier(String pNom, int p) {
        if (p < 1) p = 1;

        this.nom = pNom;
        this.pv = p;
        this.arc = null;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPv() {
        return this.pv;
    }

    public Arc getArc() {
        return this.arc;
    }

    public boolean etreBlesse() {
        return this.pv == 0;
    }

    public void subirDegats(int degat) {
        if (degat < 0) return;
        if (this.pv - degat < 0) this.pv = 0;
        else this.pv -= degat;
    }

    public boolean prendreArc(Arc arc) {
        if (this.etreBlesse() || this.arc != null || arc == null) return false;
        this.arc = arc;
        return true;
    }

    public Arc poserArc() {
        if (this.etreBlesse() || this.arc == null) return null;
        Arc vArc = this.arc;
        this.arc = null;
        return vArc;
    }

    public boolean attaquer(Guerrier victime) {
        if (victime == null || this.arc == null || this.etreBlesse()) return false;
        int degatsAttaque = this.arc.utiliser();
        victime.subirDegats(degatsAttaque);
        return degatsAttaque > 0;
    }

    @Override
    public String toString() {
        String response = this.nom + "(" + this.pv + ")";
        if (this.arc != null) response += "-arc(d:" + this.arc.getDegats() + ", f:" + this.arc.getFleches() + ")";
        return response;
    }

}
