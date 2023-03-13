package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<Médicament> Médicaments = new ArrayList();
    static ArrayList<Fournisseur> Fournisseurs = new ArrayList<>();
    static ArrayList<Achat> Achats = new ArrayList<>();

    static public void AfficherMédicaments() {
        if (Médicaments.size() >= 1) {
            for (int i = 0; i < Médicaments.size(); i++) {
                System.out.println(Médicaments.get(i).toString());
            }
        } else {
            System.out.println("Il n'y a pas de médicament");
        }

    }

    static public void ChercherMédicament() {
        String nom;
        int choix;
        boolean MédicamentTrouvé = false;
        do {
            System.out.println("Entrer le nom ou la référence de médicament\n1: Retour");
            nom = keyboard.next();
            for (int i = 0; i < Médicaments.size(); i++) {
                if (Médicaments.get(i).getNom().toLowerCase().equals(nom.toLowerCase()) || Médicaments.get(i).getRef().toLowerCase().equals(nom.toLowerCase())) {
                    MédicamentTrouvé = true;

                    System.out.println(Médicaments.get(i).dispo());
                    System.out.println("Le médicament est disponible");
                    do {
                        System.out.println("\n1: Approvisionnement\n2: Supprimer\n3: Retour");
                        choix = keyboard.nextInt();

                        switch (choix) {
                            case 1:
                                ModifierStock(i);
                                break;
                            case 2:
                                SupprimerMédicament(i);
                                break;
                            case 3:
                                break;
                        }
                        if (choix > 3 || choix < 1) {
                            System.out.println("Choisissez la bonne option ");
                        }
                    } while (choix > 3 || choix < 1);
                }
            }
            if (MédicamentTrouvé == false && !"1".equals(nom)) {
                System.out.println("Médicament pas trouvé, réssayer");

            }
        } while (MédicamentTrouvé == false && !"1".equals(nom));
    }

    static public void AjouterMédicament() {
        String ref, nom;
        double prix;
        boolean ordonnance = false;

        System.out.print("Entrer les informations du médicament\nRéférence: ");
        ref = keyboard.next();

        for (int i = 0; i < Médicaments.size(); i++) {
            while (Médicaments.get(i).getRef().toLowerCase().equals(ref.toLowerCase())) {
                System.out.println("Une Médicament avec référence " + ref + " existe déjà\nRéssayer");
                ref = keyboard.next();
            }

        }

        System.out.print("Nom: ");
        nom = keyboard.next();
        System.out.print("Prix: ");
        prix = keyboard.nextDouble();

        do {
            System.out.println("Cette médicament necessite ordonnance? (Oui, Non) : ");
            String ord = keyboard.next();

            if ("Oui".equals(ord) || "oui".equals(ord)) {
                ordonnance = true;
                break;
            } else if ("Non".equals(ord) || "non".equals(ord)) {
                ordonnance = false;
                break;
            } else {
                System.out.println("Choisissez la bonne option ");
            }
        } while (true);

        int fPosition = 0, fChoix;
        System.out.println(Fournisseurs.size());
        if (Fournisseurs.size() >= 1) {
            System.out.println("\nChoisissiez le fournissuer: ");

            for (fPosition = 0; fPosition < Fournisseurs.size(); fPosition++) {
                System.out.println(fPosition + 1 + ": " + Fournisseurs.get(fPosition));
            }

            System.out.println(fPosition + 1 + ": Ajouter nouveau fournisseur: ");
            fChoix = keyboard.nextInt();
            while (fChoix < 1 || fChoix > fPosition + 1) {
                System.out.println("Choisir entre 1 et " + (fPosition + 1));
                fChoix = keyboard.nextInt();
            }
            if (fChoix == fPosition + 1) {
                AjouterFournisseur();
                Médicament abc = new Médicament(ref, nom, prix, ordonnance);
                abc.AttribuerFournisseur(Fournisseurs.size() - 1);
                Médicaments.add(abc);
            } else {
                Médicament abc = new Médicament(ref, nom, prix, ordonnance);
                abc.AttribuerFournisseur(fChoix - 1);
                Médicaments.add(abc);
            }

        } else {
            AjouterFournisseur();
            Médicament abc = new Médicament(ref, nom, prix, ordonnance);
            abc.AttribuerFournisseur(Fournisseurs.size() - 1);
            Médicaments.add(abc);

        }

        System.out.println("Quantité ajoutée\n");
    }

    static public void SupprimerMédicament(int i) {

        Médicaments.remove(i);
        System.out.println("Médicament supprimé");

    }

    static public void AjouterFournisseur() {
        System.out.println("Entrer les informations de fournisseur");
        System.out.print("Prénom: ");
        String Fprénom = keyboard.next();
        System.out.print("Nom: ");
        String Fnom = keyboard.next();

        for (int i = 0; i < Fournisseurs.size(); i++) {
            while (Fournisseurs.get(i).getPrénom().toLowerCase().equals(Fprénom) && Fournisseurs.get(i).getNom().toLowerCase().equals(Fnom)) {
                System.out.println("\nUn fournisseur avec cette nom existe déjà, réssayer");
                System.out.print("\nPrénom: ");
                Fprénom = keyboard.next();
                System.out.print("Nom: ");
                Fnom = keyboard.next();

            }
        }
        System.out.print("Téléphone: ");
        String Ftéléphone = keyboard.next();
        System.out.print("Adresse: ");
        keyboard.nextLine();
        String Fadresse = keyboard.nextLine();
        Fournisseurs.add(new Fournisseur(Fprénom, Fnom, Ftéléphone, Fadresse));
    }

    static public void AfficherFournisseurs() {

        if (Fournisseurs.size() >= 1) {
            for (int i = 0; i < Fournisseurs.size(); i++) {
                System.out.print("\n" + Fournisseurs.get(i).getPrénom() + " " + Fournisseurs.get(i).getNom()
                        + " - Téléphone: " + Fournisseurs.get(i).getTéléphone()
                        + " - Adresse: " + Fournisseurs.get(i).getAdresse()
                );
                boolean fresh = true;

                for (int j = 0; j < Médicaments.size(); j++) {

                    if (Médicaments.get(j).Fournisseur.getNom().equals(Fournisseurs.get(i).getNom())) {

                        if (fresh != true) {
                            System.out.print(", ");

                        } else {
                            System.out.println("\nLes produis: ");
                        }

                        System.out.print(Médicaments.get(j).getNom());
                        fresh = false;
                    }
                }
                System.out.println("");

            }
        } else {
            System.out.println("Il n'y a aucun fournisseur");
        }

    }

    static public void ModifierStock(int i) {

        int qts;

        System.out.println("\nLe médicament: " + Médicaments.get(i).getNom()
                + "\nQuantités disponibles: " + Médicaments.get(i).getQts()
                + "\nPrix: " + Médicaments.get(i).getPrix());

        System.out.println("\nEntrer la quantité: ");
        qts = keyboard.nextInt();
        Médicaments.get(i).Ajouter(qts);
        System.out.println("Quantité ajoutée");

    }

    static public void EffectuerAchat() {
        int choix = 0;
        String nom;
        boolean MédicamentTrouvé = false;
        do {
            System.out.println("Entrer le nom ou la référence de médicament\n1: Retour");
            nom = keyboard.next();
            for (int i = 0; i < Médicaments.size(); i++) {
                if (Médicaments.get(i).getNom().toLowerCase().equals(nom.toLowerCase()) || Médicaments.get(i).getRef().toLowerCase().equals(nom.toLowerCase())) {
                    MédicamentTrouvé = true;
                    int qts = 0;
                    if (Médicaments.get(i).getQts() >= 1) {

                        System.out.println(Médicaments.get(i).dispo());
                        System.out.println("Le médicament est disponible");

                        do {
                            qts = 0;
                            System.out.println("\n1 :Acheter\n2: Retour");
                            choix = keyboard.nextInt();
                            if (choix <= 2 && choix > 0) {

                                switch (choix) {
                                    case 1:
                                        System.out.print("Quantité: ");
                                        qts = keyboard.nextInt();
                                        if (Médicaments.get(i).getQts() >= qts) {
                                            Acheter(i, qts);
                                            qts -= qts;
                                            break;
                                        } else {
                                            System.out.println("Quantité insufissant, quantité disponible est: " + Médicaments.get(i).getQts());
                                        }

                                    case 2:
                                        break;
                                }
                            } else {
                                System.out.println("Choisissez la bonne option ");
                            }
                        } while (choix > 2 || choix < 0 || qts > Médicaments.get(i).getQts());

                    } else {
                        System.out.println(Médicaments.get(i).dispo());
                        System.out.println("\nLe médicament est épuisé");

                    }
                }
            }
            if (!MédicamentTrouvé) {
                System.out.println("Médicament pas trouvé, réssayer");

            }
        } while (MédicamentTrouvé == false && !"1".equals(nom));

    }

    static public void Acheter(int i, int qts) {

        System.out.println("\nLe nom complet du client: ");
        keyboard.nextLine();
        String nom = keyboard.nextLine();
        if (Médicaments.get(i).isOrdonnance() == true) {
            System.out.println("Entrer le nom de client: ");

            System.out.println("Age: ");
            int age = keyboard.nextInt();
            System.out.println("Poid: ");
            float poid = keyboard.nextFloat();
            System.out.println("Taille: ");
            int taille = keyboard.nextInt();
            System.out.println("Nom de médecin: ");
            keyboard.nextLine();
            String médicin = keyboard.nextLine();
            System.out.println("Téléphone Médecin");
            String téléphone = keyboard.next();
            System.out.println("Adresse Médecin: ");
            keyboard.nextLine();
            String adresse = keyboard.nextLine();
            System.out.println("");

            Achats.add(new Achat(qts, nom, age, poid, taille, médicin, téléphone, adresse, Médicaments.get(i)));
        } else {
            Achats.add(new Achat(qts, nom, Médicaments.get(i)));
        }
        Médicaments.get(i).Retirer(qts);

        System.out.println("Achat effectuée");

    }

    static public void TotalVent() {
        double total = 0;
        int totalqts = 0;
        for (int i = 0; i < Achats.size(); i++) {
            total += Achats.get(i).getMédicament().getPrix() * Achats.get(i).getQts();
            totalqts += Achats.get(i).getQts();
        }
        System.out.print("\nTotal des médicaments ventes: " + totalqts + "  |   Total des gains: ");
        System.out.printf("%.2f MAD\n", total);
        for (int i = 0; i < Médicaments.size(); i++) {
            double MédicamentRevenus = 0;
            int nbrMédicamentsV = 0;
            for (int j = 0; j < Achats.size(); j++) {
                if (Médicaments.get(i).getRef().equals(Achats.get(j).getMédicament().getRef())) {
                    MédicamentRevenus += Achats.get(j).getMédicament().getPrix() * Achats.get(j).getQts();
                    nbrMédicamentsV += Achats.get(j).getQts();
                }
            }
            if (nbrMédicamentsV > 0) {
                System.out.print(Médicaments.get(i).getNom() + " | " + nbrMédicamentsV + " PCS ventes   |   ");
                System.out.printf("%.2f MAD\n", MédicamentRevenus);
            }
        }
    }

    static public void AfficherClients() {
        boolean ClientTrouvé = false;
        String client;
        int clientPosition = 0;
        if (Achats.size() >= 1) {
            do {
                System.out.println("\nLe nom complet du client: \n1: Retour");
                client = keyboard.nextLine();
                for (int i = 0; i < Achats.size(); i++) {
                    if (Achats.get(i).getNom().toLowerCase().equals(client.toLowerCase())) {
                        ClientTrouvé = true;
                        clientPosition = i;
                        System.out.printf("\nDate: " + Achats.get(i).getDate() + "\nMédicament: " + Achats.get(i).getMédicament().getRef() + "  |  " + Achats.get(i).getQts() + " x " + Achats.get(i).getMédicament().getNom() + "  |  ");
                        System.out.printf("%.2f MAD\n", Achats.get(i).getQts() * Achats.get(i).getMédicament().getPrix());
                    }
                }
                if (ClientTrouvé == false) {
                    System.out.println("Client pas trouvé, réssayer");
                } else {
                    if (Achats.get(clientPosition).getMédecin() != null) {
                        System.out.println("\nNom complet: " + Achats.get(clientPosition).getNom() + ", Age: " + Achats.get(clientPosition).getAge() + ", Taille: " + Achats.get(clientPosition).getTaille() + ", Poids: " + Achats.get(clientPosition).getPoid()
                                + "\nMédecin: " + Achats.get(clientPosition).getMédecin() + ", Adresse: " + Achats.get(clientPosition).getAdresse() + ", Téléphone: " + Achats.get(clientPosition).getTéléphone());
                    }

                }
            } while (ClientTrouvé == false && !"1".equals(client));
        } else {
            System.out.println("Il n'y a pas encore d'achats");
        }

    }

}
