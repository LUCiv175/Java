public class Autovettura extends Veicolo {
    int numeroPosti;

    Autovettura(int annoImmatricolazione, String marca, String modello, String tipoAlimentazione, int cilindrata,
            int numeroPosti) {
        super(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata);
        this.numeroPosti = numeroPosti;
    }

    public Autovettura(Veicolo v, int numeroPosti) {
        super(v);
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    @Override
    public String toString() {
        return (super.toString() + " numero posti: " + numeroPosti + ";");
    }
}