package UI.QuintaProva;

import Data.InviaEvent;
import Data.InviaListener;
import UI.SecondaProva.SecondaProvaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelQuinto extends JPanel{

    JLabel quintaProva;
    JTextField write;
    JButton invia;
    InviaListener inviaListener;
    int indizioCounter = 0;
    JButton indizi;
    public PanelQuinto(){
        setLayout(new BorderLayout());
        setBackground(Color.black);

        quintaProva = new JLabel("<html>Una principessa viene rapita da un orco e un cavaliere corre a salvarla.<bn> " +
                "L’orco indica al cavaliere due porte e spiega: “In una c’è la principessa, nell’altra una tigre affamata”.<bn>" +
                "Sulla porta di sinistra c'è un cartello che dice “In questa porta c’è la tigre”. Sulla porta di destra un<bn>" +
                "altro cartello recita: “In una porta c’è la principessa”. L’orco aggiunge: “Solo uno dei cartelli è vero”.<bn>" +
                "In quale porta c’è la principessa: destra o sinistra?</thml>");
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

        quintaProva.setFont(new Font("Arial", Font.PLAIN, 20));
        write.setBackground(Color.black);
        quintaProva.setBackground(Color.black);
        quintaProva.setForeground(Color.green);

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
                JOptionPane.showMessageDialog(null, "Non ci sono indizi, ragiona!");

            }
        });

        rispostaPanel.add(indizi, FlowLayout.LEADING);

        QuintaProvaModel quintaProvaModel = new QuintaProvaModel();

        invia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);
                if(quintaProvaModel.checkOK(write.getText())){
                    JOptionPane.showMessageDialog(null, "<html>Risposta esatta, l'indizio e': Il sole e' Giallo!. <br> Quando sei pronto clicca OK</html>");
                    setVisible(false);
                    rispostaPanel.setVisible(false);
                    InviaEvent inviaEvent = new InviaEvent(e, true);
                    if(inviaListener != null){
                        inviaListener.checkInviaEvent(inviaEvent);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "<html>Risposta errata.<br> Cambiamo Prova</html>");
                    setVisible(false);
                    rispostaPanel.setVisible(false);
                    InviaEvent inviaEvent = new InviaEvent(e, false);
                    if(inviaListener != null){
                        inviaListener.checkInviaEvent(inviaEvent);
                    }
                }
            }
        });

        add(quintaProva, BorderLayout.CENTER);
        add(rispostaPanel, BorderLayout.PAGE_END);
    }
    public void setInviaListener(InviaListener inviaListener) {
        this.inviaListener = inviaListener;
    }
}
