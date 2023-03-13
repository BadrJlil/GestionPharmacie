package Project;
import java.util.ArrayList; 
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean connected = false, wrongAccount=false;
        ArrayList<Personne> compte = new ArrayList();
        
        
        Admin Badr = new Admin("Badr", "JLIL", "Casablanca", "admin", "admin");
        Gérant Yassir = new Gérant("Salah", "Allouch", "Mohammedia", "user", "user");
        compte.add(Badr);
        compte.add(Yassir);
        
//        Médicament médicament01 = new Médicament("A1239875", "Aspro", 26.63, false);
//        médicament01.AjouterFournisseur("Salim", "Omari", "0610964820", "Rabat");
//        médicament01.qts += 1 ;
//        Stock.Médicaments.add(médicament01);
//        
//        Médicament médicament02 = new Médicament("A155647", "Doliprane", 14.30, true);
//        médicament02.AjouterFournisseur("Taha", "Issaoui", "0613255412", "Tangier");
//        médicament02.qts += 5 ;
//        Stock.Médicaments.add(médicament02);
//        
//        Médicament médicament03 = new Médicament("B152254", "Calsidose", 28.16, false);
//        médicament03.AttribuerFournisseur(1);
//        médicament03.qts += 5 ;
//        Stock.Médicaments.add(médicament03);
//        
//        Médicament médicament04 = new Médicament("PL9654", "Rennie", 50.32, false);
//        médicament04.AjouterFournisseur("Oussama", "Rafik", "0633998541", "Casablanca Maarif");
//        médicament04.qts += 5 ;
//        Stock.Médicaments.add(médicament04);
        
        
        do {
            System.out.println("Entrez votre nom d'utilisateur: ");
            String username = keyboard.next();
            System.out.println("Entrez votre  de passe: ");
            String password = keyboard.next();
            for (int i = 0; i < compte.size(); i++) {
            if (compte.get(i).getUsername().equals(username) && compte.get(i).getPassword().equals(password)) {

                if (compte.get(i).getCptType().equals("admin")) {

                    connected = true;
                    wrongAccount=false;
                    System.out.println("Connecté en tant qu'adminstateur\n****************************************\n");
                    connected = compte.get(i).Opérations();
                } else {
                    connected = true;
                    wrongAccount=false;
                    System.out.println("Connecté en tant que utilisateur\n****************************************\n");
                    connected = compte.get(i).Opérations();
                }
                break;
            }else{
                wrongAccount=true;
            }
        }
        if (!connected && wrongAccount) {

            System.out.println("\n\nNom d'utilisateur ou le mot de passe est incorrect, réssayer\n");
        }

        } while (!connected);
        
        
    }
    
}
