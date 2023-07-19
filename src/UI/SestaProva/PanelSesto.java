package UI.SestaProva;

import Data.InviaEvent;
import Data.InviaListener;
import UI.QuintaProva.QuintaProvaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSesto extends JPanel {
    JLabel sestaProva;
    JTextField write;
    JButton invia;
    InviaListener inviaListener;
    int indizioCounter = 0;
    JButton indizi;
    public PanelSesto(){
        setLayout(new BorderLayout());
        setBackground(Color.black);

        sestaProva = new JLabel("<html>Cosa c'è alla fine dell'arcobaleno, <br>al centro dell'atomo e all'inizio dell'oceano?</thml>");
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

        sestaProva.setFont(new Font("Arial", Font.PLAIN, 20));
        write.setBackground(Color.black);
        sestaProva.setBackground(Color.black);
        sestaProva.setForeground(Color.green);

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
                switch (indizioCounter){
                    case 0:
                        JOptionPane.showMessageDialog(null, "Indizo 1");
                        indizioCounter++;
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Indizio 2");
                        indizioCounter++;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Indizio 3");
                        indizioCounter++;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Indizi finiti");
                }

            }
        });

        rispostaPanel.add(indizi, FlowLayout.LEADING);

        SestaProvaModel sestaProvaModel = new SestaProvaModel();

        invia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sestaProvaModel.checkOK(write.getText())){
                    JOptionPane.showMessageDialog(null, "<html>Risposta esatta, l'indizio e': Il Cielo e' Blu!. <br> Quando sei pronto clicca OK</html>");
                    setVisible(false);
                    rispostaPanel.setVisible(false);
                    InviaEvent inviaEvent = new InviaEvent(e, true);
                    if(inviaListener != null){
                        inviaListener.checkInviaEvent(inviaEvent);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "<html>Risposta errata.<br> Riprova</html>");
                }
            }
        });

        add(sestaProva, BorderLayout.CENTER);
        add(rispostaPanel, BorderLayout.PAGE_END);
    }
    public void setInviaListener(InviaListener inviaListener) {
        this.inviaListener = inviaListener;
    }
}
