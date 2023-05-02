public class Motocicletta extends Veicolo {
    private int tempiMotore;

    public Motocicletta(int annoImmatricolazione, String marca, String modello, String tipoAlimentazione,
            int cilindrata, int tempiMotore) {
        super(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata);
        this.tempiMotore = tempiMotore;
    }

    public Motocicletta(Veicolo v, int tempiMotore) {
        super(v);
        this.tempiMotore = tempiMotore;
    }

    public void setTempiMotore(int tempiMotore) {
        this.tempiMotore = tempiMotore;
    }

    public int getTempiMotore() {
        return tempiMotore;
    }

    @Override
    public String toString() {
        return (super.toString() + " tempi motore: " + tempiMotore + ";");
    }
}
