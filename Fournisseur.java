package Project;

public class Fournisseur {

    String prénom, nom, téléphone,adresse;

    public Fournisseur(String prénom, String nom, String téléphone, String adresse) {
        this.prénom = prénom;
        this.nom = nom;
        this.téléphone = téléphone;
        this.adresse = adresse;
    }

    

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTéléphone(String téléphone) {
        this.téléphone = téléphone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getNom() {
        return nom;
    }

    public String getTéléphone() {
        return téléphone;
    }

    public String getAdresse() {
        return adresse;
    }
    
    @Override
    public String toString() {
        return prénom + " " + nom + "   |   " + téléphone + "   |   " + adresse;
    }
    
    
    
}
