package Project;

import java.util.Scanner;

public class Admin extends Personne {
    Scanner keyboard = new Scanner(System.in);
    
    public Admin(String prénom, String nom, String ville, String username, String password) {
        super(prénom, nom, ville, username, password);
        this.setCptType("admin");
    }

    
    
    public boolean Opérations() {
        int choix = 0;
        boolean connected=true;
        while (choix != 6 && choix != 7) {
            
            System.out.println("""
                    \n1: Ajouter un médicament
                    2: Chercher un médicament
                    3: Afficher tous les médicaments
                    4: Ajouter un fourniseeur
                    5: Afficher tous les fourniseeurs
                    6: Fermez la session
                    7: Quitter
                               """);
            do {
                choix = keyboard.nextInt();
            } while (choix > 7 || choix < 1);

            switch (choix) {
                case 1:
                    Stock.AjouterMédicament();
                    break;
                case 2:
                    Stock.ChercherMédicament();
                    break;
                case 3:
                    Stock.AfficherMédicaments();
                    break;
                case 4:
                    Stock.AjouterFournisseur();
                    break;
                case 5:
                    Stock.AfficherFournisseurs();
                    break;
                case 6:
                    connected = false;
                    break;
                case 7:
                    break;
            }
        }
        return connected;
    }
    
}
