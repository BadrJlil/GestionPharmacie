package Project;

public class Personne {

    private String CIN, prénom, nom, ville, cptType;
    private String username, password;

    public Personne(String prénom, String nom, String ville, String username, String password) {
        this.prénom = prénom;
        this.nom = nom;
        this.ville = ville;
        this.username = username;
        this.password = password;
    }

    public String getCIN() {
        return CIN;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public void setCptType(String cptType) {
        this.cptType = cptType;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCptType() {
        return cptType;
    }
    public boolean Opérations(){
        return true;
    }

}
