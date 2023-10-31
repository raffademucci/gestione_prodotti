import java.util.ArrayList;
import java.util.Scanner;

class Prodotto {
    String nome;
    double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
}

class Utente {
    String username;
    String password;

    public Utente(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class Maina {
    public static void main(String[] args) {
        Scanner mioc=new Scanner(System.in);

        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ArrayList<Utente> utenti = new ArrayList<>();

        prodotti.add(new Prodotto("Prodotto 1", 19.99));
        prodotti.add(new Prodotto("Prodotto 2", 29.99));
        prodotti.add(new Prodotto("Prodotto 3", 9.99));

        Utente utente = new Utente("utente", "password123");
        utenti.add(utente);

        while (true) {
            System.out.println("Menu di accesso:");
            System.out.println("1. Accedi come Utente");
            System.out.println("2. Esci");

            int scelta = mioc.nextInt();

            if (scelta == 1) {
                System.out.println("Nome utente: ");
                String nomeUtente = mioc.next();
                System.out.println("Password: ");
                String password = mioc.next();

                boolean accessoConsentito = false;
                for (Utente u : utenti) {
                    if (u.username.equals(nomeUtente) && u.password.equals(password)) {
                        accessoConsentito = true;
                        break;
                    }
                }

                if (accessoConsentito) {
                    while (true) {
                        System.out.println("\nMenu Utente:");
                        System.out.println("1. Visualizza Prodotti");
                        System.out.println("2. Esci");
                        int sceltaUtente = mioc.nextInt();

                        if (sceltaUtente == 1) {
                            System.out.println("Elenco dei prodotti:");
                            for (Prodotto prodotto : prodotti) {
                                System.out.println(prodotto.nome + " - Prezzo: $" + prodotto.prezzo);
                            }
                        }
                        else{
                            if (sceltaUtente == 2) {
                                break;
                            } 
                            else {
                                System.out.println("Scelta non valida.");
                            }
                        }
                    }
                } 
                else {
                    System.out.println("Credenziali non valide. Riprova.");
                }
            } 
            else{
                if(scelta==2){
                    System.out.println("Uscita dal sistema");
                    break;
                }
                else{
                    System.out.println("Scelta non valida.");
                } 
            } 
        }
    }
}
