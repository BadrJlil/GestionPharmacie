package Project;
import java.util.Scanner;
public class Gérant extends Personne {
    Scanner keyboard = new Scanner(System.in);
    
    public Gérant(String prénom, String nom, String ville, String username, String password){
        super(prénom,nom,ville,username,password);
        this.setCptType("user");
        
    }

    
    
    public boolean Opérations(){
        int choix=0;
        boolean connected = true;
        while (choix != 5 && choix != 6) {
            System.out.println("""
                    
                    1: Effectuer un achat
                    2: Afficher tous les médicaments
                    3: Afficher total des ventes
                    4: Affciher les achats d'un client
                    5: Fermez la session
                    6: Quitter
                               """);
            do {
                choix = keyboard.nextInt();
            } while (choix > 6 || choix < 1);

            switch (choix) {
                case 1:
                    Stock.EffectuerAchat();
                    break;
                case 2:
                    Stock.AfficherMédicaments();
                    break;
                case 3:
                    Stock.TotalVent();
                    break;
                case 4:
                    Stock.AfficherClients();
                    break;
                case 5:
                    connected =  false;
                case 6:
                    break;
            }
        }
        return connected;
    }
}
