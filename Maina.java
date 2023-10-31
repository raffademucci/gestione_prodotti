import java.util.ArrayList;
import java.util.Scanner;

class Prodotto {
    String nome;
    double prezzo;
    int quantita;

    public Prodotto(String nome, double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }
}

class Utente {
    String username;
    String password;
    boolean isAdmin;

    public Utente(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}

public class Maina {
    public static void main(String[] args) {
        Scanner mioscanner=new Scanner(System.in);
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ArrayList<Utente> utenti = new ArrayList<>();

        prodotti.add(new Prodotto("Prodotto 1", 19.99, 10));
        prodotti.add(new Prodotto("Prodotto 2", 29.99, 5));
        prodotti.add(new Prodotto("Prodotto 3", 9.99, 15));

        Utente utente = new Utente("utente", "password123", false);
        Utente amministratore = new Utente("admin", "admin123", true);
        utenti.add(utente);
        utenti.add(amministratore);

        while (true) {
            System.out.println("Menu di accesso:");
            System.out.println("1. Accedi come Utente");
            System.out.println("2. Accedi come Amministratore");
            System.out.println("3. Esci");

            System.out.println("Inserisci la tua scelta");
            int scelta = mioscanner.nextInt();

            if (scelta == 1) {
                System.out.print("Nome utente: ");
                String nomeUtente = mioscanner.next();
                System.out.print("Password: ");
                String password = mioscanner.next();

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

                        System.out.println("Inserisci la tua scelta");
                        int sceltaUtente = mioscanner.nextInt();

                        if (sceltaUtente == 1) {
                            System.out.println("Elenco dei prodotti:");
                            for (Prodotto prodotto : prodotti) {
                                System.out.println("Nome: " + prodotto.nome + " - Prezzo: $" + prodotto.prezzo + " - Quantità disponibile: " + prodotto.quantita);
                            }
                        } else if (sceltaUtente == 2) {
                            break;
                        } else {
                            System.out.println("Scelta non valida.");
                        }
                    }
                } else {
                    System.out.println("Credenziali non valide. Riprova.");
                }
            } else if (scelta == 2) {
                System.out.print("Nome utente: ");
                String nomeUtente = mioscanner.next();
                System.out.print("Password: ");
                String password = mioscanner.next();

                boolean accessoConsentito = false;
                for (Utente u : utenti) {
                    if (u.username.equals(nomeUtente) && u.password.equals(password)) {
                        accessoConsentito = true;
                        break;
                    }
                }

                if (accessoConsentito) {
                    while (true) {
                        System.out.println("\nMenu Amministratore:");
                        System.out.println("1. Visualizza Prodotti");
                        System.out.println("2. Aggiungi Prodotto");
                        System.out.println("3. Rimuovi Prodotto");
                        System.out.println("4. Modifica Prodotto");
                        System.out.println("5. Cerca Prodotto");
                        System.out.println("6. Esci");

                        System.out.println("Inserisci la tua scelta");
                        int sceltaAdmin = mioscanner.nextInt();

                        if (sceltaAdmin == 1) {
                            System.out.println("Elenco dei prodotti:");
                            for (Prodotto prodotto : prodotti) {
                                System.out.println("Nome: " + prodotto.nome + " - Prezzo: $" + prodotto.prezzo + " - Quantità disponibile: " + prodotto.quantita);
                            }
                        } else if (sceltaAdmin == 2) {
                            System.out.print("Nome del prodotto: ");
                            String nomeProdotto = mioscanner.next();
                            System.out.print("Prezzo del prodotto: ");
                            double prezzoProdotto = mioscanner.nextDouble();
                            System.out.print("Quantità disponibile: ");
                            int quantitaProdotto = mioscanner.nextInt();

                            prodotti.add(new Prodotto(nomeProdotto, prezzoProdotto, quantitaProdotto));
                            System.out.println("Prodotto aggiunto con successo.");
                        } else if (sceltaAdmin == 3) {
                            System.out.print("Nome del prodotto da rimuovere: ");
                            String nomeProdottoRimuovere = mioscanner.next();

                            for (int i = 0; i < prodotti.size(); i++) {
                                if (prodotti.get(i).nome.equals(nomeProdottoRimuovere)) {
                                    prodotti.remove(i);
                                    System.out.println("Prodotto rimosso con successo.");
                                    break;
                                }
                            }
                        } else if (sceltaAdmin == 4) {
                            System.out.print("Nome del prodotto da modificare: ");
                            String nomeProdottoModificare = mioscanner.next();

                            boolean prodottoTrovato = false;

                            for (Prodotto prodotto : prodotti) {
                                if (prodotto.nome.equals(nomeProdottoModificare)) {
                                    System.out.print("Nuovo nome: ");
                                    prodotto.nome = mioscanner.next();
                                    System.out.print("Nuovo prezzo: ");
                                    prodotto.prezzo = mioscanner.nextDouble();
                                    System.out.print("Nuova quantità disponibile: ");
                                    prodotto.quantita = mioscanner.nextInt();
                                    System.out.println("Prodotto modificato con successo.");
                                    prodottoTrovato = true;
                                    break;
                                }
                            }

                            if (!prodottoTrovato) {
                                System.out.println("Prodotto non trovato.");
                            }

                        } else if (sceltaAdmin == 5) {
                            System.out.print("Inserisci il criterio di ricerca (nome del prodotto): ");
                            String criterioRicerca = mioscanner.next();

                            System.out.println("Risultati della ricerca:");

                            for (Prodotto prodotto : prodotti) {
                                if (prodotto.nome.contains(criterioRicerca)) {
                                    System.out.println("Nome: " + prodotto.nome + " - Prezzo: $" + prodotto.prezzo + " - Quantità disponibile: " + prodotto.quantita);
                                }
                            }
                        } else if (sceltaAdmin == 6) {
                            break;
                        } else {
                            System.out.println("Scelta non valida.");
                        }
                    }
                } else {
                    System.out.println("Credenziali non valide. Riprova.");
                }
            } else if (scelta == 3) {
                System.out.println("Uscita dal sistema.");
                break;
            } else {
                System.out.println("Scelta non valida.");
            }
        }
    }
}
