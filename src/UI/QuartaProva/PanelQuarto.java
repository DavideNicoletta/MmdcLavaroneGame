package UI.QuartaProva;

import Data.InviaEvent;
import Data.InviaListener;
import UI.TerzaProva.TerzaProvaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelQuarto extends JPanel {
    JLabel quartaProva;
    JTextField write;
    JButton invia;
    InviaListener inviaListener;
    int indizioCounter = 0;
    JButton indizi;
    public PanelQuarto(){
        setLayout(new BorderLayout());
        setBackground(Color.black);

        quartaProva = new JLabel("<html>Quanti 9 ci sono da 0 a 500?</html>");
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

        quartaProva.setFont(new Font("Arial", Font.PLAIN, 20));
        write.setBackground(Color.black);
        quartaProva.setBackground(Color.black);
        quartaProva.setForeground(Color.green);

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
                JOptionPane.showMessageDialog(null, "Non ci sono indizi, conta!");

            }
        });

        rispostaPanel.add(indizi, FlowLayout.LEADING);

        QuartaProvaModel quartaProvaModel = new QuartaProvaModel();

        invia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);
                if(quartaProvaModel.checkOK(write.getText())){
                    JOptionPane.showMessageDialog(null, "<html>Risposta esatta, l'indizio e': Guarda dentro l'armadio <br> Quando sei pronto clicca OK</html>");
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

        add(quartaProva, BorderLayout.CENTER);
        add(rispostaPanel, BorderLayout.PAGE_END);
    }
    public void setInviaListener(InviaListener inviaListener) {
        this.inviaListener = inviaListener;
    }
}
