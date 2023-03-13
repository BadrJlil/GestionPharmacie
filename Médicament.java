package Project;
public class Médicament {
    private String ref, nom;
    private double prix;
    private int qts=0;
    private boolean ordonnance;
    Fournisseur Fournisseur;
    
    public Médicament(String ref, String nom, double prix, boolean ordonnance) {
        this.ref = ref;
        this.nom = nom;
        this.prix = prix;
        this.ordonnance = ordonnance;
    }
    
    public void AjouterFournisseur(String fPrénom, String fNom, String téléphone, String adresse){
        this.Fournisseur = new Fournisseur(fPrénom, fNom, téléphone, adresse);
        Stock.Fournisseurs.add(Fournisseur);
    }

    public void AttribuerFournisseur(int FournissuerPosition){
        this.Fournisseur = Stock.Fournisseurs.get(FournissuerPosition);
    }
    
    @Override
    public String toString() {
        return ref + "   |   " + nom + "   |   " + prix + " MAD   |   " + qts +" PCS   |";
    }
    
    public String dispo(){
        return "\nRéférence: " + ref + "\nNom: " + nom + "\nPrix: " + prix + "\nQuantité: " + qts +"\nCoordonnées du fournisseur: \n   ||"+Fournisseur.getPrénom()+
                " " + Fournisseur.getNom()+"\n   ||Téléphone: "+Fournisseur.getTéléphone()+"\n   ||Adresse: "+Fournisseur.getAdresse()+"\n";
    }

    public String getRef() {
        return ref;
    }

  
    
    

    public int getQts() {
        return qts;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    
    public void Ajouter(int qts){
        this.qts += qts ;
    }
    
    public void Retirer(int qts) {
        this.qts -= qts;
    }


    public Fournisseur getF() {
        return Fournisseur;
    }

    public boolean isOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(boolean ordonnance) {
        this.ordonnance = ordonnance;
    }
    
    
    
    
}
