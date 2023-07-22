package UI.TerzaProva;

import Data.InviaEvent;
import Data.InviaListener;
import UI.SecondaProva.SecondaProvaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTerzo extends JPanel {
    JLabel terzaProva;
    JTextField write;
    JButton invia;
    InviaListener inviaListener;
    int answerCounter = 0;
    int indizioCounter = 0;
    JButton indizi;
    public PanelTerzo(){
        setLayout(new BorderLayout());
        setBackground(Color.black);

        terzaProva = new JLabel("<html>Quando sono a 5 e ne aggiungo 6 divento 11,<br> ma quado sono 6  aggiungo 7 divento 1</html>");
        JPanel rispostaPanel = new JPanel();
        rispostaPanel.setBackground(Color.black);
        rispostaPanel.setLayout(new FlowLayout());

        write = new JTextField();
        write.setColumns(100);
        write.setForeground(Color.green);

        invia = new JButton("Invia");
        invia.setBackground(Color.black);
        invia.setForeground(Color.green);

        JLabel rispondiLabel = new JLabel("Inserisci Risposta: ");
        rispondiLabel.setForeground(Color.green);
        rispondiLabel.setBackground(Color.black);

        rispostaPanel.add(rispondiLabel, FlowLayout.LEFT);
        rispostaPanel.add(write, FlowLayout.CENTER);
        rispostaPanel.add(invia, FlowLayout.RIGHT);

        terzaProva.setFont(new Font("Arial", Font.PLAIN, 20));
        write.setBackground(Color.black);
        terzaProva.setBackground(Color.black);
        terzaProva.setForeground(Color.green);

        indizi = new JButton("Indizi");
        indizi.setBackground(Color.black);
        indizi.setForeground(Color.green);
        indizi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);

                if(answerCounter == 3){
                    switch (indizioCounter){
                        case 0:
                            JOptionPane.showMessageDialog(null, "Spesso sono tondo");
                            answerCounter = 0;
                            indizioCounter++;
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "A volte vengo anche portato in giro");
                            answerCounter = 0;
                            indizioCounter++;
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Il mio passato è analogico, il mio futuro digitale");
                            answerCounter = 0;
                            indizioCounter++;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Indizi finiti");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Non ci sono indizi per ora!");
                }


            }
        });

        rispostaPanel.add(indizi, FlowLayout.LEADING);

        TerzaProvaModel terzaProvaModel = new TerzaProvaModel();

        invia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);

                if(!write.getText().isEmpty()){
                    answerCounter++;
                    if(terzaProvaModel.checkOK(write.getText())){

                        JOptionPane.showMessageDialog(null, "<html>Risposta esatta, l'indizio e': Indizio  III - 42. <br> Quando sei pronto clicca OK</html>");
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

        add(terzaProva, BorderLayout.CENTER);
        add(rispostaPanel, BorderLayout.PAGE_END);
    }
    public void setInviaListener(InviaListener inviaListener) {
        this.inviaListener = inviaListener;
    }

}
