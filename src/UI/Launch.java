package UI;

import Data.InviaEvent;
import Data.InviaListener;
import UI.PrimeProva.PanelPrimo;
import UI.QuartaProva.PanelQuarto;
import UI.QuintaProva.PanelQuinto;
import UI.SecondaProva.PanelSecondo;
import UI.SestaProva.PanelSesto;
import UI.TerzaProva.PanelTerzo;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Launch extends JFrame {

    PanelPrimo panelPrimo;
    PanelSecondo panelSecondo;
    PanelTerzo panelTerzo;
    PanelQuarto panelQuarto;
    PanelQuinto panelQuinto;
    PanelSesto panelSesto;
    JLabel printMessage;
    JPanel titolo;
    JButton start;
    JButton regole;
    public Launch() throws MalformedURLException {

        super("Hacinking");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.black);
       // PlayAudio playAudio = new PlayAudio();
        titolo = new JPanel();
        titolo.setLayout(new FlowLayout());
        panelPrimo = new PanelPrimo();
        panelSecondo = new PanelSecondo();
        printMessage = new JLabel("<html>Avete subito un attacco hacker, risolvete le prove e forse vincerete!!<br>" +
                "Ogni volta per procederete dovrete superare una prova, buona fortuna!!</html>");
        printMessage.setFont(new Font("Arial", Font.PLAIN, 15));
        regole = new JButton("Regole");
        regole.setForeground(Color.green);
        regole.setBackground(Color.black);

        regole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background",Color.black);
                UI.put("OptionPane.messageForeground", Color.green);
                UI.put("Panel.background",Color.black);
                JOptionPane.showMessageDialog(null, "<html>Regole:<br>" +
                        "1- Non usare caratteri speciali nelle risposte, niente accenti o lettere strane<br>" +
                        "2- Rispondi nel modo più semplice possibile, dai solo risposte semplici e chiare<br>" +
                        "3- Segna tutto quello che il computer ti dice, non scordarti niente, neanche una lettera<br>" +
                        "4- Potrai avere a disposizione un numero limitato di indizi se clicchi sul pulsante apposito<br>" +
                        "5- Per dare la risposta dovrai scriverla nella casella apposita<br>" +
                        "6- Per inviare la risposta clicca sul tasto apposito<br><br>" +
                        "BUONA FORTUNA");
            }
        });

        start = new JButton("Iniziamo");
        printMessage.setForeground(Color.green);
        printMessage.setBackground(Color.black);
        titolo.setBackground(Color.black);
        titolo.add(printMessage, FlowLayout.LEFT);
        titolo.add(regole, FlowLayout.CENTER);
        add(titolo, BorderLayout.PAGE_START);

        start.setBackground(Color.black);
        start.setForeground(Color.green);
        add(start, BorderLayout.CENTER);

        panelTerzo = new PanelTerzo();
        panelQuarto = new PanelQuarto();
        panelQuinto = new PanelQuinto();
        panelSesto = new PanelSesto();

        panelSesto.setInviaListener(new InviaListener() {
            @Override
            public void checkInviaEvent(InviaEvent inviaEvent) {
                JLabel fine = new JLabel("Avete concluso le prove");
                fine.setForeground(Color.green);
                fine.setBackground(Color.black);
                add(fine, BorderLayout.CENTER);
            }
        });

        panelQuinto.setInviaListener(new InviaListener() {
            @Override
            public void checkInviaEvent(InviaEvent inviaEvent) {
                if(inviaEvent.isCheckOk()){
                    panelPrimo.setVisible(false);
                    JLabel fine = new JLabel("Avete concluso le prove");
                    fine.setForeground(Color.green);
                    fine.setBackground(Color.black);
                    add(fine, BorderLayout.CENTER);

                }else{

                    panelPrimo.setVisible(false);
                    add(panelSesto, BorderLayout.CENTER);
                }
            }
        });

        panelQuarto.setInviaListener(new InviaListener() {
            @Override
            public void checkInviaEvent(InviaEvent inviaEvent) {
                if(inviaEvent.isCheckOk()){
                    panelPrimo.setVisible(false);
                    add(panelQuinto, BorderLayout.CENTER);
                }
            }
        });

        panelTerzo.setInviaListener(new InviaListener() {
            @Override
            public void checkInviaEvent(InviaEvent inviaEvent) {
                if(inviaEvent.isCheckOk()){
                    panelPrimo.setVisible(false);
                    add(panelQuarto, BorderLayout.CENTER);
                }
            }
        });

        panelSecondo.setInviaListener(new InviaListener() {
            @Override
            public void checkInviaEvent(InviaEvent inviaEvent) {
                if(inviaEvent.isCheckOk()){
                    panelPrimo.setVisible(false);
                    add(panelTerzo, BorderLayout.CENTER);
                }
            }
        });

        panelPrimo.setInviaListener(new InviaListener() {
            @Override
            public void checkInviaEvent(InviaEvent inviaEvent) {
                if(inviaEvent.isCheckOk()){
                    panelPrimo.setVisible(false);
                    add(panelSecondo, BorderLayout.CENTER);
                }
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                add(panelPrimo, BorderLayout.CENTER);
            }
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setSize(400, 300);


        setResizable(true);
        setVisible(true);
    }
}
