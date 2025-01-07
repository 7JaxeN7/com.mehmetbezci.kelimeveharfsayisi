package com.mehmetbezci.kelimeveharfsayisi;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KelimeveHarfSayisi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel kelime_alani;
    private JLabel harf_alani;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KelimeveHarfSayisi frame = new KelimeveHarfSayisi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public KelimeveHarfSayisi() {
        setTitle("Kelime ve Harf Sayısı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 855, 511);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea yazi_alani = new JTextArea();
        yazi_alani.setBounds(85, 56, 603, 250);
        contentPane.add(yazi_alani);

        JButton goster = new JButton("Kelime ve Harf Sayısı Göster");
        goster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String yazi = yazi_alani.getText();
                int karakter_sayisi = 0;
                int kelime_sayisi = 0;

                for (int i = 0; i < yazi.length(); i++) {
                    if (yazi.charAt(i) != ' ') {
                        karakter_sayisi++;
                    }
                }

                String[] kelime_array = yazi.split("\\s+");
                for (String kelime : kelime_array) {
                    if (!kelime.isEmpty()) {
                        kelime_sayisi++;
                    }
                }

                kelime_alani.setText("Kelime sayisi : " + kelime_sayisi);
                harf_alani.setText("Harf sayisi : " + karakter_sayisi);
            }
        });
        goster.setBounds(267, 349, 297, 23);
        contentPane.add(goster);

        kelime_alani = new JLabel("Kelime Sayısı : ");
        kelime_alani.setBounds(117, 25, 200, 23);
        contentPane.add(kelime_alani);

        harf_alani = new JLabel("Harf Sayısı : ");
        harf_alani.setBounds(587, 25, 200, 23);
        contentPane.add(harf_alani);
    }
}
