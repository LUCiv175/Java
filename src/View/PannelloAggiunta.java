package View;
import Model.*;
import Controller.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;

public class PannelloAggiunta  extends JPanel {
    private static String[] tipiMacchina={"autovettura","furgone","motocicletta"};
    private JLabel labelAnno;
    private JSpinner spinnerAnno;

    private JLabel labelMarca;
    private JLabel labelModello;
    private JTextField fieldMarca;
    private JTextField fieldModello;
    private JLabel labelAlimentazione;
    private JComboBox comboBoxAlimentazione;
    private JLabel labelCilindrata;
    private JSlider sliderCilindrata;
    private JLabel labelTipo;
    private JComboBox comboTipo;
    private JLabel labelCapacita;
    private JLabel labelTempi;
    private JLabel labelPosti;
    private JSpinner spinnerPosti;
    private JList<TempiMoto> jListTempiMoto;
    private JButton bottoneAggiungi;

    private JTextField fieldCapacità;
    private JButton buttonRimuovi;
    private JLabel labelRimuovi;
    private JSpinner spinnerRimuovi;
    public PannelloAggiunta(Controller controller,TextAreaPanel textAreaPanel){
        setLayout(new GridBagLayout());
        Dimension dimensione= getPreferredSize();
        dimensione.width=350;
        setPreferredSize(dimensione);


        Border bordoInterno=BorderFactory.createTitledBorder("aggiungi automobile");
        Border bordoEsterno=BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale=BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        setBorder(bordoFinale);//documentazione jborder

        buttonRimuovi=new JButton("rimuovi");
        buttonRimuovi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value=0;
                Date d=new Date();
                try {
                    int pos=((Integer) spinnerRimuovi.getValue());
                    value = controller.remove(pos, d.getHours(), d.getMinutes());

                    textAreaPanel.reset();

                    JDialog dialog = new JDialog();
                    dialog.setVisible(true);
                    dialog.setSize(200, 100);
                    dialog.setLocationRelativeTo(null);
                    JTextArea areaPrezzo = new JTextArea();
                    areaPrezzo.setEditable(false);
                    areaPrezzo.append("prezzo: " + value);
                    dialog.add(areaPrezzo);
                }catch (NullPointerException exception){
                    System.out.println("errorew");
                }

            }
        });

        labelRimuovi=new JLabel("posizione:");
        labelMarca=new JLabel("marca:");
        fieldMarca=new JTextField(20);
        //legiamo la label e il field per usare il mnemonic sulla label per selezionare la casella di scrittura
        labelMarca.setLabelFor(fieldMarca);
        labelMarca.setDisplayedMnemonic(KeyEvent.VK_M);

        labelModello=new JLabel("modello:");
        fieldModello=new JTextField(20);
        labelModello.setLabelFor(fieldModello);
        labelModello.setDisplayedMnemonic(KeyEvent.VK_O);

        bottoneAggiungi=new JButton("add!");

        bottoneAggiungi.setMnemonic(KeyEvent.VK_A);





        labelAlimentazione=new JLabel("alimentazione: ");
        String[] tipiAlimentazione={"benzina","diesel","elettrica","GPL"};
        comboBoxAlimentazione=new JComboBox();
        DefaultComboBoxModel modelComboBox=new DefaultComboBoxModel(tipiAlimentazione);
        comboBoxAlimentazione.setModel(modelComboBox);
        comboBoxAlimentazione.setSelectedIndex(1);

        labelTipo=new JLabel("tipo: ");

        comboTipo=new JComboBox();
        DefaultComboBoxModel modelComboBox1=new DefaultComboBoxModel(tipiMacchina);
        comboTipo.setModel(modelComboBox1);
        comboTipo.setSelectedIndex(-1);
        comboTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboAggiornata();
            }
        });



        labelCilindrata=new JLabel("cilindrata: ");
        sliderCilindrata=new JSlider(1000,2000);
        sliderCilindrata.setMajorTickSpacing(300);
        sliderCilindrata.setMinorTickSpacing(50);
        sliderCilindrata.setPaintTicks(true);
        sliderCilindrata.setPaintLabels(true);
        sliderCilindrata.setSnapToTicks(true);//aggancia alla tacca più vicina

        labelTempi=new JLabel("tempi:");
        labelCapacita=new JLabel("capacità:");
        labelPosti=new JLabel("posti:");

        spinnerPosti=new JSpinner();
        SpinnerNumberModel spinnerNumberModel=new SpinnerNumberModel(5,1,9,1);
        spinnerPosti.setModel(spinnerNumberModel);
        spinnerPosti.setPreferredSize(new Dimension(30,30));

        spinnerRimuovi=new JSpinner();
        SpinnerNumberModel spinnerNumberModel1=new SpinnerNumberModel(0,0,25,1);
        spinnerRimuovi.setModel(spinnerNumberModel1);
        spinnerRimuovi.setPreferredSize(new Dimension(30,30));

        /*spinnerTempi=new JSpinner();
        SpinnerNumberModel spinnerNumberModel1=new SpinnerNumberModel(2,2,4,2);
        spinnerTempi.setModel(spinnerNumberModel1);
        spinnerTempi.setPreferredSize(new Dimension(30,30));*/


        spinnerAnno=new JSpinner();
        SpinnerNumberModel spinnerNumberModel2=new SpinnerNumberModel(2023,1950,2023,1);
        spinnerAnno.setModel(spinnerNumberModel2);
        spinnerAnno.setPreferredSize(new Dimension(60,30));

        labelAnno=new JLabel("anno:");

        jListTempiMoto=new JList();
        //listBagagliaio.setPreferredSize(new Dimension(170,55));
        //la lista si basa sul pattern mvc perciò bisogna creare il model
        DefaultListModel modelMoto=new DefaultListModel();
        modelMoto.addElement(new TempiMoto(2,"2 tempi"));
        modelMoto.addElement(new TempiMoto(4,"4 tempi"));
        jListTempiMoto.setModel(modelMoto);
        jListTempiMoto.setBorder(BorderFactory.createEtchedBorder());

        fieldCapacità=new JTextField(20);


        bottoneAggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String marca=fieldMarca.getText();
                String modello=fieldModello.getText();

                int anno= (int) spinnerAnno.getValue();

                String alimentazione= (String) comboBoxAlimentazione.getSelectedItem();

                int cilindrata=sliderCilindrata.getValue();
                Veicolo v=null;

                if(comboTipo.getSelectedItem().equals(tipiMacchina[0])){//autovettura
                    int numPosti= (int) spinnerPosti.getValue();
                    v=new Autovettura(anno,marca,modello,alimentazione,cilindrata,numPosti);


                }else if(comboTipo.getSelectedItem().equals(tipiMacchina[1])) {//furgone
                    Float capacita= Float.valueOf(fieldCapacità.getText());
                    v=new Furgone(anno,marca,modello,alimentazione,cilindrata,capacita);
                }else{
                    int tempi=jListTempiMoto.getSelectedValue().getId();
                    v=new Motocicletta(anno,marca,modello,alimentazione,cilindrata,tempi);
                }


                Date date=new Date();
                controller.add(v,date.getHours(),date.getMinutes());
                textAreaPanel.reset();
            }
        });

        reset();

        //documentazione gridbag layout
        GridBagConstraints gbc=new GridBagConstraints();

        //riga 0:label marca
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.insets=new Insets(0,0,5,5);
        add(labelMarca,gbc);

        //riga 0:field marca
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx=0.1;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets=new Insets(0,0,5,0);
        add(fieldMarca,gbc);

        //riga 1:label modello
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weightx=0.1;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelModello,gbc);

        //riga 1:field modello
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets=new Insets(0,0,5,0);
        add(fieldModello,gbc);


        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weightx=0.1;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelAnno,gbc);


        gbc.gridx=1;
        gbc.gridy=2;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,0);
        add(spinnerAnno,gbc);

        //riga 6:label cilindrata
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.weightx=0.1;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelCilindrata,gbc);

        //riga 6:jslider cilindrata
        gbc.gridx=1;
        gbc.gridy=6;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.insets=new Insets(0,0,10,5);
        add(sliderCilindrata,gbc);



        //riga 8:label alimentazione
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.weightx=0.1;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelAlimentazione,gbc);

        //riga 8:menu alimentazione
        gbc.gridx=1;
        gbc.gridy=8;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.insets=new Insets(0,0,5,5);
        add(comboBoxAlimentazione,gbc);

        //riga 9:label alimentazione
        gbc.gridx=0;
        gbc.gridy=9;
        gbc.weightx=0.1;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelTipo,gbc);

        //riga 9:menu alimentazione
        gbc.gridx=1;
        gbc.gridy=9;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.insets=new Insets(0,0,5,5);
        add(comboTipo,gbc);



        gbc.gridx=0;
        gbc.gridy=10;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelCapacita,gbc);
        add(labelPosti,gbc);
        add(labelTempi,gbc);



        gbc.gridx=1;
        gbc.gridy=10;
        gbc.weightx=0.3;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(spinnerPosti,gbc);
        add(jListTempiMoto,gbc);
        add(fieldCapacità,gbc);





        //ultima riga:bottone
        gbc.gridx=0;
        gbc.gridy=11;
        gbc.weightx=0.0;
        gbc.weighty=1.0;
        gbc.gridwidth=2;//quante colonne occupa
        //gbc.gridheight=2;//quante righe occupa
        gbc.anchor=GridBagConstraints.PAGE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        //gbc.ipadx=30;  //ridimesiona l'elemento per x
        //gbc.ipady=30;  //ridimesiona l'elemento per y
        add(bottoneAggiungi,gbc);

        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=12;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,5);
        add(labelRimuovi,gbc);

        gbc.gridx=1;
        gbc.gridy=12;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.NONE;
        gbc.insets=new Insets(0,0,5,0);
        add(spinnerRimuovi,gbc);

        gbc.gridx=0;
        gbc.gridy=13;
        gbc.weightx=0.0;
        gbc.weighty=1.0;
        gbc.gridwidth=2;//quante colonne occupa
        //gbc.gridheight=2;//quante righe occupa
        gbc.anchor=GridBagConstraints.PAGE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        //gbc.ipadx=30;  //ridimesiona l'elemento per x
        //gbc.ipady=30;  //ridimesiona l'elemento per y
        add(buttonRimuovi,gbc);

    }

    private void reset(){
        labelCapacita.setVisible(false);
        labelTempi.setVisible(false);
        labelPosti.setVisible(false);
        spinnerPosti.setVisible(false);
        jListTempiMoto.setVisible(false);
        fieldCapacità.setVisible(false);
    }

    private void comboAggiornata(){
        if(comboTipo.getSelectedItem().equals(tipiMacchina[0])){//autovettura
            reset();
            labelPosti.setVisible(true);
            spinnerPosti.setVisible(true);


        }else if(comboTipo.getSelectedItem().equals(tipiMacchina[1])) {//furgone
            reset();
            labelCapacita.setVisible(true);
            fieldCapacità.setVisible(true);
        }else{
            reset();
            labelTempi.setVisible(true);
            jListTempiMoto.setVisible(true);
        }
    }



}



// int tempi motore per motocicletta
// float capacitàcarico furgone
// int numeroposti per autovettura
