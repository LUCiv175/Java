public class Furgone extends Veicolo {
    private float capacitaCarico;

    public Furgone(int annoImmatricolazione, String marca, String modello, String tipoAlimentazione, int cilindrata,
            float capacitaCarico) {
        super(annoImmatricolazione, marca, modello, tipoAlimentazione, cilindrata);
        this.capacitaCarico = capacitaCarico;
    }

    public Furgone(Veicolo v, float capacitaCarico) {
        super(v);
        this.capacitaCarico = capacitaCarico;
    }

    private void setCapacitaCarico(float capacitaCarico) {
        this.capacitaCarico = capacitaCarico;
    }

    public float getCapacitaCarico() {
        return capacitaCarico;
    }

    @Override
    public String toString() {
        return (super.toString() + " capacita' carico: " + capacitaCarico + ";");
    }
}
