package Project;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Achat {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String Nom, Médecin, Téléphone, Adresse;
    private int age, taille,qts;
    private float poid;
    private LocalDateTime date;
    private Médicament Médicament;

    public Achat(int qts, String Nom, int age, float poid, int taille, String Médecin, String Téléphone, String Adresse, Médicament Médicament) {
        this.qts = qts;
        this.Nom = Nom;
        this.Médecin = Médecin;
        this.Téléphone = Téléphone;
        this.Adresse = Adresse;
        this.age = age;
        this.taille = taille;
        this.poid = poid;
        this.date = LocalDateTime.now();
        this.Médicament = Médicament;
    }

    public Achat(int qts, String Nom, Médicament Médicament) {
        this.qts = qts;
        this.Nom = Nom;
        this.Médicament = Médicament;
        this.date = LocalDateTime.now();
    }

    public Médicament getMédicament() {
        return Médicament;
    }

    public int getQts() {
        return qts;
    }

    public String getNom() {
        return Nom;
    }

    public String getMédecin() {
        return Médecin;
    }

    public String getTéléphone() {
        return Téléphone;
    }

    public String getAdresse() {
        return Adresse;
    }

    public int getAge() {
        return age;
    }

    public int getTaille() {
        return taille;
    }

    public float getPoid() {
        return poid;
    }

    public String getDate() {
        return date.format(formatter);
    }

    
    
    
    
}
