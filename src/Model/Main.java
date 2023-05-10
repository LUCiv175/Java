package Model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Scanner s = new Scanner(System.in);
        int input = 0;
        do {
            try {
                System.out.println("1)aggiungi 2)rimuovi 3)statoPosizioni 10)esci");
                input = Integer.parseInt(s.nextLine());
                int stato;
                switch (input) {
                    case 1 -> {
                        System.out.println("anno immatricolazione: ");
                        int annoImmatricolazione = Integer.parseInt(s.nextLine());
                        System.out.println("marca: ");
                        String marca = s.nextLine();
                        System.out.println("modello: ");
                        String modello = s.nextLine();
                        System.out.println("tipo alimentazione: ");
                        String tipoAlimentazione = s.nextLine();
                        System.out.println("cilindrata: ");
                        int cilindrata = Integer.parseInt(s.nextLine());
                        System.out.println("1)autovettura 2)motocicletta 3)furgone");
                        int tipo = Integer.parseInt(s.nextLine());
                        if (tipo == 1) {
                            System.out.println("numero posti: ");
                            int numeroPosti = Integer.parseInt(s.nextLine());
                            Autovettura a = new Autovettura(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata, numeroPosti);
                            System.out.println("ora ingresso: ");
                            int oraIngresso = Integer.parseInt(s.nextLine());
                            System.out.println("minuto ingresso: ");
                            int minutoIngresso = Integer.parseInt(s.nextLine());
                            stato = garage.ingressoVeicolo(a, oraIngresso, minutoIngresso);
                        } else if (tipo == 2) {
                            System.out.println("numero tempi:");
                            int numeroTempi = Integer.parseInt(s.nextLine());
                            Motocicletta m = new Motocicletta(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata, numeroTempi);
                            System.out.println("ora ingresso: ");
                            int oraIngresso = Integer.parseInt(s.nextLine());
                            System.out.println("minuto ingresso: ");
                            int minutoIngresso = Integer.parseInt(s.nextLine());
                            stato = garage.ingressoVeicolo(m, oraIngresso, minutoIngresso);
                        } else if (tipo == 3) {
                            System.out.println("capacita' di carico: ");
                            int capacita = Integer.parseInt(s.nextLine());
                            Furgone f = new Furgone(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata, capacita);
                            System.out.println("ora ingresso: ");
                            int oraIngresso = Integer.parseInt(s.nextLine());
                            System.out.println("minuto ingresso: ");
                            int minutoIngresso = Integer.parseInt(s.nextLine());
                            stato = garage.ingressoVeicolo(f, oraIngresso, minutoIngresso);
                        } else {
                            throw new NumberFormatException();
                        }
                        if (stato == -1) {
                            System.out.println("garage pieno");
                        } else {
                            System.out.println("il parcheggio e' stato effettuato in posizione " + stato);
                        }
                    }
                    case 2 -> {
                        System.out.println("ora uscita: ");
                        int oraUscita = Integer.parseInt(s.nextLine());
                        System.out.println("minuto uscita: ");
                        int minutoUscita = Integer.parseInt(s.nextLine());
                        System.out.println("posizione: ");
                        int posizione = Integer.parseInt(s.nextLine());
                        double importoDaPagare = garage.uscitaVeicolo(posizione, oraUscita, minutoUscita);
                        System.out.println("importo da pagare: " + importoDaPagare);
                    }
                    case 3 -> System.out.println(garage.statoPosizioni());
                }
            } catch (NumberFormatException e) {
                System.out.println("errore nell'inserimento!");
            }
        } while (input != 10);
    }
}


