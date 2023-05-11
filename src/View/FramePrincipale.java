package View;

import Controller.Controller;
import Model.Veicolo;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class FramePrincipale extends JFrame {

    private Controller controller;
    private PannelloAggiunta pannelloAggiunta;
    private TextAreaPanel textAreaPanel;
    public FramePrincipale(){
        super("nuova finestra");

        setLayout(new BorderLayout());

        controller=new Controller();

        textAreaPanel=new TextAreaPanel(controller);
        pannelloAggiunta=new PannelloAggiunta(controller,textAreaPanel);


        add(pannelloAggiunta,BorderLayout.LINE_START);
        add(textAreaPanel,BorderLayout.CENTER);
        setup();
    }

    private void setup(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);//settare dopo le impostazioni
    }

    public static void main(String[] args) {
        new FramePrincipale();
    }


}


