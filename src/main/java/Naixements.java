public class Naixements {

    public int any;
    public int codi_Districte;
    public String nom_Districte;
    public int codi_Barri;
    public String nom_Barri;
    public String lloc_de_naixement;
    public int nombre;

    public Naixements(){}
    public Naixements(int any, int codi_districte, String nom_districte, int codi_barri, String nom_barri, String lloc_de_naixement, int nombre) {
        super();
        this.any = any;
        this.codi_Districte = codi_districte;
        this.nom_Districte = nom_districte;
        this.codi_Barri = codi_barri;
        this.nom_Barri = nom_barri;
        this.lloc_de_naixement = lloc_de_naixement;
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Naixements{" +
                "any=" + any +
                ", codi_Districte=" + codi_Districte +
                ", nom_Districte='" + nom_Districte + '\'' +
                ", codi_Barri=" + codi_Barri +
                ", nom_Barri='" + nom_Barri + '\'' +
                ", lloc_de_naixement='" + lloc_de_naixement + '\'' +
                ", nombre=" + nombre +
                '}';
    }


    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getCodi_Districte() {
        return codi_Districte;
    }

    public void setCodi_Districte(int codi_Districte) {
        this.codi_Districte = codi_Districte;
    }

    public String getNom_Districte() {
        return nom_Districte;
    }

    public void setNom_Districte(String nom_Districte) {
        this.nom_Districte = nom_Districte;
    }

    public int getCodi_Barri() {
        return codi_Barri;
    }

    public void setCodi_Barri(int codi_Barri) {
        this.codi_Barri = codi_Barri;
    }

    public String getNom_Barri() {
        return nom_Barri;
    }

    public void setNom_Barri(String nom_Barri) {
        this.nom_Barri = nom_Barri;
    }

    public String getLloc_de_naixement() {
        return lloc_de_naixement;
    }

    public void setLloc_de_naixement(String lloc_de_naixement) {
        this.lloc_de_naixement = lloc_de_naixement;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }





}
