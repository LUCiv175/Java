public abstract class Veicolo {
    private int annoImmatricolazione;
    private String marca;
    private String modello;
    private String tipoAlimentazione;
    private int cilindrata;

    public Veicolo(int annoImmatricolazione, String marca, String modello, String tipoAlimentazione, int cilindrata) {
        this.annoImmatricolazione = annoImmatricolazione;
        this.marca = marca;
        this.modello = modello;
        this.tipoAlimentazione = tipoAlimentazione;
        this.cilindrata = cilindrata;
    }

    public Veicolo(Veicolo v) {
        this.annoImmatricolazione = v.annoImmatricolazione;
        this.marca = v.marca;
        this.modello = v.modello;
        this.tipoAlimentazione = v.tipoAlimentazione;
        this.cilindrata = v.cilindrata;
    }

    private void setAnnoImmatricolazione(int annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    private void setModello(String modello) {
        this.modello = modello;
    }

    private void setTipoAlimentazione(String tipoAlimentazione) {
        this.tipoAlimentazione = tipoAlimentazione;
    }

    private void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getTipoAlimentazione() {
        return tipoAlimentazione;
    }

    @Override
    public String toString() {
        return "anno immatricolazione: " + annoImmatricolazione + "; marca: " + marca + "; modello: " + modello
                + "; tipo alimentazione: " + tipoAlimentazione + "; cilindrata: " + cilindrata + ";";
    }

}