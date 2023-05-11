package Model;

public class VeicoloInGarage {
    private int oraArrivo;
    private int minutiArrivo;
    private Veicolo v;

    // get e set
    public int getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(int oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public int getMinutiArrivo() {
        return minutiArrivo;
    }

    public void setMinutiArrivo(int minutiArrivo) {
        this.minutiArrivo = minutiArrivo;
    }

    public Veicolo getV() {
        return v;
    }

    public void setV(Veicolo v) {
        this.v = v;
    }

    
    public VeicoloInGarage(int oraArrivo, int minutiArrivo, Veicolo v) {
        this.oraArrivo = oraArrivo;
        this.minutiArrivo = minutiArrivo;
        this.v = v;
    }
    
    @Override
    public String toString() {
        return ("Ora di arrivo: " + oraArrivo + ":" + minutiArrivo + "; " + v.toString());
    }
}
