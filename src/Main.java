import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Scanner s = new Scanner(System.in);
        int input = 0;
        do {
            try {
                System.out.println("1)aggiungi 2)rimuovi 3)statoPosizioni 10)esci");
                input = s.nextInt();
                switch (input) {
                    case 1: {
                        boolean errore = false;
                        int ore = 0;

                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("ore: ");
                                ore = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);

                        int minuti = 0;
                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("minuti: ");
                                minuti = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);

                        Veicolo v = leggi();
                        garage.ingressoVeicolo(v, ore, minuti);
                    }
                    break;
                    case 2: {
                        boolean errore = false;

                        int posizione = 0;

                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("posizione: ");
                                posizione = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);

                        int ore = 0;

                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("ore: ");
                                ore = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);

                        int minuti = 0;
                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("minuti: ");
                                minuti = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);

                        char tipo=' ';

                        do{
                            try {
                                System.out.println("1)furgone 2)motocicletta 3)autovettura");
                                errore=false;
                                s = new Scanner(System.in);
                                input = s.nextInt();
                                switch (input) {
                                    case 1: {
                                        tipo='f';
                                    }
                                    break;
                                    case 2: {
                                        tipo='m';
                                    }
                                    break;
                                    case 3: {
                                        tipo='a';
                                    }
                                    break;
                                    default:{
                                        errore=true;
                                        System.out.println("errore nell'inserimento!");
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("errore nell'inserimento!");
                            }
                        }while(errore);

                        System.out.println("prezzo: "+garage.uscitaVeicolo(posizione,ore,minuti,tipo));
                    }
                    break;
                    case 3: {
                        garage.statoPosizioni();
                    }
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("errore nell'inserimento!");
            }
        } while (input != 10);
    }

    public static Veicolo leggi() {
        int input = 0;
        while (true){
            try {
                System.out.println("1)furgone 2)motocicletta 3)autovettura");
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
                switch (input) {
                    case 1: {
                        Veicolo v = leggiGenerico();
                        boolean errore = false;
                        float capacitaCarico = 0;
                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("capacita' carico: ");
                                capacitaCarico = s.nextFloat();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);
                        return new Furgone(v, capacitaCarico);
                    }
                    case 2: {
                        Veicolo v = leggiGenerico();
                        boolean errore = false;
                        int tempimotore = 0;
                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("tempi motore: ");
                                tempimotore = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);
                        return new Motocicletta(v, tempimotore);
                    }
                    case 3: {
                        Veicolo v = leggiGenerico();
                        boolean errore = false;
                        int numeroPosti = 0;
                        do {
                            try {
                                errore=false;
                                s=new Scanner(System.in);
                                System.out.println("numero posti: ");
                                numeroPosti = s.nextInt();
                            }catch(InputMismatchException e){
                                errore=true;
                                System.out.println("errore nell'inserimento");
                            }
                        }while (errore);
                        return new Autovettura(v, numeroPosti);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("errore nell'inserimento!");
            }
        }
    }

    public static Veicolo leggiGenerico() {
        Scanner scanner = new Scanner(System.in);
        boolean errore=false;
        int annoImmatricolazione = 0;
        do {
            try {
                errore=false;
                Scanner s=new Scanner(System.in);
                System.out.println("inserire l'anno di immatricolazione: ");
                annoImmatricolazione = s.nextInt();
            }catch(InputMismatchException e){
                errore=true;
                System.out.println("errore nell'inserimento");
            }
        }while (errore);


        System.out.println("inserire la marca: ");
        String marca = scanner.nextLine();

        System.out.println("inserire il modello: ");
        String modello = scanner.nextLine();

        System.out.println("inserire il tipo di alimentazione: ");
        String tipoAlimentazione = scanner.nextLine();

        int cilindrata = 0;
        do {
            try {
                errore=false;
                Scanner s=new Scanner(System.in);
                System.out.println("inserire la cilindrata: ");
                annoImmatricolazione = s.nextInt();
            }catch(InputMismatchException e){
                errore=true;
                System.out.println("errore nell'inserimento");
            }
        }while (errore);

        return new Veicolo(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata);
    }
}

