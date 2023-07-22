package UI.PrimeProva;

import Data.InviaEvent;
import Data.InviaListener;
import UI.SecondaProva.PanelSecondo;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrimo extends JPanel {
    JLabel primaProva;
    JTextField write;
    JButton invia;
    JPanel indizziPanel;
    //JLabel indizi;
    int indizioCounter = 0;
    int answerCounter = 0;
    JButton indizi;

    UIManager UI;

    InviaListener inviaListener;
    public PanelPrimo(){
        setLayout(new BorderLayout());
        setBackground(Color.black);
        UI = new UIManager();
        PrimaProvaModel primaProvaModel = new PrimaProvaModel();
        invia = new JButton("Invia");
        invia.setBackground(Color.black);
        invia.setForeground(Color.green);

        /*
        indizziPanel = new JPanel();
        indizi = new JLabel("Indizi:");
        indizziPanel.setLayout(new BorderLayout());
        indizziPanel.add(indizi, BorderLayout.PAGE_START);
        indizziPanel.setBackground(Color.black);
        indizi.setForeground(Color.green);
        indizi.setFont(new Font("Arial", Font.PLAIN, 20));


         */
        write = new JTextField();
        write.setColumns(100);
        write.setForeground(Color.green);
        //Prima prova
        primaProva = new JLabel("<html> In alto vive,<br> "+
                "tra le nuvole sospese,<br>"+
                "con le ali aperte,<br>"+
                "sempre in volo l'ho visto.<br>"+
                "<br>"+
                "Il suo canto è melodioso,<br>"+
                "elegante e coinvolgente,<br>"+
                "ma se lo cerchi sulla terra,<br>"+
                "non lo troverai mai presente.<br>"+
                "<br>"+
                "Chi è costui che vola in cielo,<br>"+
                "e ci riempie di meraviglia e stupore,<br>"+
                "che ci fa volare con la mente,<br>"+
                "e ci fa sognare senza limite né confine?<br><html>");
        primaProva.setFont(new Font("Arial", Font.PLAIN, 20));
        write.setBackground(Color.black);
        primaProva.setBackground(Color.black);
        primaProva.setForeground(Color.green);
        add(primaProva, BorderLayout.LINE_START);
        JPanel rispostaPanel = new JPanel();
        rispostaPanel.setBackground(Color.black);
        rispostaPanel.setLayout(new FlowLayout());
        JLabel rispondiLabel = new JLabel("Inserisci Risposta: ");
        rispondiLabel.setForeground(Color.green);
        rispondiLabel.setBackground(Color.black);
        rispostaPanel.add(rispondiLabel, FlowLayout.LEFT);
        rispostaPanel.add(write, FlowLayout.CENTER);
        rispostaPanel.add(invia, FlowLayout.RIGHT);

        indizi = new JButton("Indizi");
        indizi.setBackground(Color.black);
        indizi.setForeground(Color.green);
        indizi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);

                if(answerCounter == 3){
                    switch (indizioCounter){
                        case 0:
                            JOptionPane.showMessageDialog(null, "E' spesso solitario");
                            indizioCounter++;
                            answerCounter = 0;
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Piccolo pennuto marroncino");
                            indizioCounter++;
                            answerCounter = 0;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Indizi finiti");
                            answerCounter = 0;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Non ci sono indizi per ora!");
                }



            }
        });

        rispostaPanel.add(indizi, FlowLayout.LEADING);

        invia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);
                if(!write.getText().isEmpty()){
                    answerCounter++;

                    if(primaProvaModel.checkRisposta(write.getText())){

                        JOptionPane.showMessageDialog(null, "<html>Risposta esatta, l'indizio e': Guarda sotto il materasso!. <br> Quando sei pronto clicca OK</html>");
                        setVisible(false);
                        rispostaPanel.setVisible(false);
                        InviaEvent inviaEvent = new InviaEvent(e, true);
                        if(inviaListener != null){
                            inviaListener.checkInviaEvent(inviaEvent);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "<html>Risposta errata.<br> Riprova</html>");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Risposta vuota!");
                }

            }
        });

        add(rispostaPanel, BorderLayout.PAGE_END);
       // add(indizziPanel, BorderLayout.CENTER);
    }

    public void setInviaListener(InviaListener inviaListener) {
        this.inviaListener = inviaListener;
    }
}
