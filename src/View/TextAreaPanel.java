package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TextAreaPanel extends JPanel {

    private JTextArea textArea;
    private Controller controller;
    public TextAreaPanel(Controller c){
        controller=c;
        Border bordoInterno=BorderFactory.createTitledBorder("garage");
        Border bordoEsterno=BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale=BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        setBorder(bordoFinale);

        textArea=new JTextArea();

        setLayout(new BorderLayout());

        //add(textArea,BorderLayout.CENTER);  //senza barra di scorrimento
        add(new JScrollPane(textArea),BorderLayout.CENTER);  //con barra di scorrimento
        textArea.setEditable(false);
        textArea.append(controller.statoPosizioni());
    }

    public void reset(){
        textArea.setText("");
        textArea.append(controller.statoPosizioni());

    }

}
