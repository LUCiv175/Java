package Controller;

import Model.Garage;
import Model.Veicolo;

public class Controller {
    private Garage garage;

    public Controller(){
        garage=new Garage();
    }

    public void add(Veicolo v,int ora,int minuti){
        garage.ingressoVeicolo(v,ora,minuti);
    }

    public String statoPosizioni(){
        return garage.statoPosizioni();
    }

    public double remove(int pos,int ora,int minuti){
        return garage.uscitaVeicolo(pos,ora,minuti);
    }
}
