public class Garage {
    private VeicoloInGarage[] p;
    private final int nPosti = 25;
    private final double costoFurgone = 2.0;
    private final double costoMotocicletta = 1.0;
    private final double costoAuto = 1.5;

    Garage() {
        p = new VeicoloInGarage[nPosti];
    }

    // get e set
    public int getnPosti() {
        return nPosti;
    }

    public int ingressoVeicolo(Veicolo veicolo, int ora, int minuti) {
        for (int i = 0; i < nPosti; i++) {
            if (p[i] == null) {
                p[i] = new VeicoloInGarage(ora, minuti, veicolo);
                return i;
            }
        }
        System.out.println("il parcheggio è pieno");
        return -1;
    }

    public double uscitaVeicolo(int posizione, int ora, int minuti, char tipo) {
        try {
            double tempo = (float)(-p[posizione].getMinutiArrivo() - p[posizione].getOraArrivo() * 60 + ora * 60+ minuti) / 60;
            double costo = 0.0;
            switch (tipo) {
                case 'm':
                    costo = tempo * costoMotocicletta;
                    break;
                case 'a':
                    costo = tempo * costoAuto;
                    break;
                case 'f':
                    costo = tempo * costoFurgone;
                    break;
                default:
                    throw new NullPointerException("404");
            }
            return costo;
        } catch (NullPointerException e) {
            System.out.println("Elemento non trovato");
            return 0;
        }
    }

    public void statoPosizioni() {
        for (int i = 0; i < p.length; i++) {
            if (p[i]==null) {
                System.out.println("Il posto " + (i + 1) + " e' libero");
            } else {
                System.out.println("Il posto " + (i + 1) + " e' occupato da " + p[i].toString());
            }
        }
    }

}
