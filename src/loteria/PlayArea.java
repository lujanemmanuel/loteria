package loteria;

import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import static loteria.Selector.cartMaq;
import static loteria.Selector.jugador;
import static loteria.Selector.seleccionada;

public class PlayArea extends javax.swing.JFrame {

    public TimerTask tarea;
    public int contador = 0;
    static List pasadas = new ArrayList();
    static int ganarjugador = 0, ganamaquina = 0;
    public static Timer timer;
    public List<String> Carta_maquina = new ArrayList();
    Music reproduce;
    Thread play;
    public boolean musicafondo = true;
    public static String voz = "WomanAVoices";

    public PlayArea() {
        this.reproduce = new Music();
        this.play = new Thread(reproduce);
        play.start();
        initComponents();
        jJugador.setText(jugador);

        jug1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[0][0] + ".png")));
        jug2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[0][1] + ".png")));
        jug3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[0][2] + ".png")));
        jug4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[0][3] + ".png")));
        jug5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[1][0] + ".png")));
        jug6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[1][1] + ".png")));
        jug7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[1][2] + ".png")));
        jug8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[1][3] + ".png")));
        jug9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[2][0] + ".png")));
        jug10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[2][1] + ".png")));
        jug11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[2][2] + ".png")));
        jug12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[2][3] + ".png")));
        jug13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[3][0] + ".png")));
        jug14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[3][1] + ".png")));
        jug15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[3][2] + ".png")));
        jug16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + seleccionada[3][3] + ".png")));

        maq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[0][0] + ".png")));
        maq2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[0][1] + ".png")));
        maq3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[0][2] + ".png")));
        maq4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[0][3] + ".png")));
        maq5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[1][0] + ".png")));
        maq6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[1][1] + ".png")));
        maq7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[1][2] + ".png")));
        maq8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[1][3] + ".png")));
        maq9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[2][0] + ".png")));
        maq10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[2][1] + ".png")));
        maq11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[2][2] + ".png")));
        maq12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[2][3] + ".png")));
        maq13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[3][0] + ".png")));
        maq14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[3][1] + ".png")));
        maq15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[3][2] + ".png")));
        maq16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Thumbnails/" + cartMaq[3][3] + ".png")));
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                Carta_maquina.add(cartMaq[a][b]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jJugador = new javax.swing.JLabel();
        jug2 = new javax.swing.JButton();
        jug3 = new javax.swing.JButton();
        jug4 = new javax.swing.JButton();
        jug5 = new javax.swing.JButton();
        jug6 = new javax.swing.JButton();
        jug7 = new javax.swing.JButton();
        jug8 = new javax.swing.JButton();
        jug9 = new javax.swing.JButton();
        jug10 = new javax.swing.JButton();
        jug11 = new javax.swing.JButton();
        jug12 = new javax.swing.JButton();
        jug13 = new javax.swing.JButton();
        jug14 = new javax.swing.JButton();
        jug15 = new javax.swing.JButton();
        jug16 = new javax.swing.JButton();
        jug1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        maq1 = new javax.swing.JButton();
        maq2 = new javax.swing.JButton();
        maq5 = new javax.swing.JButton();
        maq9 = new javax.swing.JButton();
        maq13 = new javax.swing.JButton();
        maq3 = new javax.swing.JButton();
        maq4 = new javax.swing.JButton();
        maq6 = new javax.swing.JButton();
        maq7 = new javax.swing.JButton();
        maq8 = new javax.swing.JButton();
        maq10 = new javax.swing.JButton();
        maq11 = new javax.swing.JButton();
        maq12 = new javax.swing.JButton();
        maq14 = new javax.swing.JButton();
        maq15 = new javax.swing.JButton();
        maq16 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bara = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        restl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jJugador.setFont(new java.awt.Font("Cooper Black", 2, 18)); // NOI18N
        jJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jJugador.setText("Jugador");

        jug2.setPreferredSize(new java.awt.Dimension(100, 148));
        jug2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug2ActionPerformed(evt);
            }
        });

        jug3.setPreferredSize(new java.awt.Dimension(140, 172));
        jug3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug3ActionPerformed(evt);
            }
        });

        jug4.setPreferredSize(new java.awt.Dimension(140, 172));
        jug4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug4ActionPerformed(evt);
            }
        });

        jug5.setPreferredSize(new java.awt.Dimension(140, 172));
        jug5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug5ActionPerformed(evt);
            }
        });

        jug6.setPreferredSize(new java.awt.Dimension(140, 172));
        jug6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug6ActionPerformed(evt);
            }
        });

        jug7.setPreferredSize(new java.awt.Dimension(140, 172));
        jug7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug7ActionPerformed(evt);
            }
        });

        jug8.setPreferredSize(new java.awt.Dimension(140, 172));
        jug8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug8ActionPerformed(evt);
            }
        });

        jug9.setPreferredSize(new java.awt.Dimension(140, 172));
        jug9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug9ActionPerformed(evt);
            }
        });

        jug10.setPreferredSize(new java.awt.Dimension(140, 172));
        jug10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug10ActionPerformed(evt);
            }
        });

        jug11.setPreferredSize(new java.awt.Dimension(140, 172));
        jug11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug11ActionPerformed(evt);
            }
        });

        jug12.setPreferredSize(new java.awt.Dimension(140, 172));
        jug12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug12ActionPerformed(evt);
            }
        });

        jug13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug13ActionPerformed(evt);
            }
        });

        jug14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug14ActionPerformed(evt);
            }
        });

        jug15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug15ActionPerformed(evt);
            }
        });

        jug16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug16ActionPerformed(evt);
            }
        });

        jug1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jug1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jug13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jug9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jug10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jug14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jug11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug15, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jug4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug16, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jug3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jug4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jug7, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jug6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jug11, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jug10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jug12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jug16, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jug14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jug13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jug15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jJugador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Cooper Black", 2, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Máquina");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(maq13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(maq9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maq2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq14, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maq3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maq11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(maq15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(maq4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(maq8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maq12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(maq16, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maq4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(maq3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maq6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq8, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maq10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq12, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maq13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maq16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setLayout(null);

        bara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton2.setFont(new java.awt.Font("Cooper Black", 2, 12)); // NOI18N
        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loteria/texture_1.jpg"))); // NOI18N

        restl.setFont(new java.awt.Font("Cooper Black", 2, 18)); // NOI18N
        restl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Cooper Black", 2, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Voz");

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(restl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bara, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(426, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(452, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bara, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(7, 7, 7)
                        .addComponent(restl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton2)
                        .addContainerGap(15, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void Reproducir_sonido(String sonido) {
        String Son;
        try {

            Son = System.getProperty("user.dir") + "/src/Sound/" + voz + "/" + sonido + ".mp3";
            FileInputStream fis;
            Player player;
            fis = new FileInputStream(Son);

            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buscar_carta(String pasada) {
        int a = 0, bot = 0;
        while (a < Carta_maquina.size()) {
            if (pasada.equals(Carta_maquina.get(a))) {
                bot = a + 1;
                a = Carta_maquina.size();
            }
            a++;
        }
        if (bot == 1) {
            maq1.setEnabled(false);
            ganamaquina++;
        } else if (bot == 2) {
            maq2.setEnabled(false);
            ganamaquina++;
        } else if (bot == 3) {
            maq3.setEnabled(false);
            ganamaquina++;
        } else if (bot == 4) {
            maq4.setEnabled(false);
            ganamaquina++;
        } else if (bot == 5) {
            maq5.setEnabled(false);
            ganamaquina++;
        } else if (bot == 6) {
            maq6.setEnabled(false);
            ganamaquina++;
        } else if (bot == 7) {
            maq7.setEnabled(false);
            ganamaquina++;
        } else if (bot == 8) {
            maq8.setEnabled(false);
            ganamaquina++;
        } else if (bot == 9) {
            maq9.setEnabled(false);
            ganamaquina++;
        } else if (bot == 10) {
            maq10.setEnabled(false);
            ganamaquina++;
        } else if (bot == 11) {
            maq11.setEnabled(false);
            ganamaquina++;
        } else if (bot == 12) {
            maq12.setEnabled(false);
            ganamaquina++;
        } else if (bot == 13) {
            maq13.setEnabled(false);
            ganamaquina++;
        } else if (bot == 14) {
            maq14.setEnabled(false);
            ganamaquina++;
        } else if (bot == 15) {
            maq15.setEnabled(false);
            ganamaquina++;
        } else if (bot == 16) {
            maq16.setEnabled(false);
            ganamaquina++;
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int velocidad = 4000;
        contador = 0;

        tarea = new TimerTask() {
            List barajeada = Barajear();

            @Override
            public void run() {
                Icon icono;
                String pasada;
                String carta;
                switch (contador) {

                    case 0:
                        contador = 1;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(0) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(0));
                        pasada = (String) barajeada.get(0);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(0);
                        Reproducir_sonido(carta);
                        break;
                    case 1:
                        contador = 2;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(1) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(1));
                        pasada = (String) barajeada.get(1);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(1);
                        Reproducir_sonido(carta);
                        break;
                    case 2:
                        contador = 3;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(2) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(2));
                        pasada = (String) barajeada.get(2);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(2);
                        Reproducir_sonido(carta);
                        break;
                    case 3:
                        contador = 4;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(3) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(3));
                        pasada = (String) barajeada.get(3);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(3);
                        Reproducir_sonido(carta);
                        break;
                    case 4:
                        contador = 5;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(4) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(4));
                        pasada = (String) barajeada.get(4);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(4);
                        Reproducir_sonido(carta);
                        break;
                    case 5:
                        contador = 6;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(5) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(5));
                        pasada = (String) barajeada.get(5);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(5);
                        Reproducir_sonido(carta);
                        break;
                    case 6:
                        contador = 7;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(6) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(6));
                        pasada = (String) barajeada.get(6);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(6);
                        Reproducir_sonido(carta);
                        break;
                    case 7:
                        contador = 8;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(7) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(7));
                        pasada = (String) barajeada.get(7);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(7);
                        Reproducir_sonido(carta);
                        break;
                    case 8:
                        contador = 9;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(8) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(8));
                        pasada = (String) barajeada.get(8);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(8);
                        Reproducir_sonido(carta);
                        break;
                    case 9:
                        contador = 10;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(9) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(9));
                        pasada = (String) barajeada.get(9);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(9);
                        Reproducir_sonido(carta);
                        break;
                    case 10:
                        contador = 11;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(10) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(10));
                        pasada = (String) barajeada.get(10);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(0);
                        carta = (String) barajeada.get(10);
                        Reproducir_sonido(carta);
                        break;
                    case 11:
                        contador = 12;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(11) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(11));
                        pasada = (String) barajeada.get(11);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(11);
                        Reproducir_sonido(carta);
                        break;
                    case 12:
                        contador = 13;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(12) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(12));
                        pasada = (String) barajeada.get(12);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(12);
                        Reproducir_sonido(carta);
                        break;
                    case 13:
                        contador = 14;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(13) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(13));
                        pasada = (String) barajeada.get(13);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(13);
                        Reproducir_sonido(carta);
                        break;
                    case 14:
                        contador = 15;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(14) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(14));
                        pasada = (String) barajeada.get(14);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(14);
                        Reproducir_sonido(carta);
                        break;
                    case 15:
                        contador = 16;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(15) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(15));
                        pasada = (String) barajeada.get(15);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(15);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 16:
                        contador = 17;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(16) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(16));
                        pasada = (String) barajeada.get(16);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(16);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 17:
                        contador = 18;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(17) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(17));
                        pasada = (String) barajeada.get(17);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(17);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 18:
                        contador = 19;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(18) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(18));
                        pasada = (String) barajeada.get(18);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(18);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 19:
                        contador = 20;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(19) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(19));
                        pasada = (String) barajeada.get(19);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(19);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 20:
                        contador = 21;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(20) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(20));
                        pasada = (String) barajeada.get(20);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(20);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 21:
                        contador = 22;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(21) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(21));
                        pasada = (String) barajeada.get(21);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(21);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 22:
                        contador = 23;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(22) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(22));
                        pasada = (String) barajeada.get(22);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(22);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 23:
                        contador = 24;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(23) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(23));
                        pasada = (String) barajeada.get(23);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(23);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 24:
                        contador = 25;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(24) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(24));
                        pasada = (String) barajeada.get(24);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(24);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 25:
                        contador = 26;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(25) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(25));
                        pasada = (String) barajeada.get(25);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(25);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 26:
                        contador = 27;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(26) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(26));
                        pasada = (String) barajeada.get(26);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(26);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 27:
                        contador = 28;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(27) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(27));
                        pasada = (String) barajeada.get(27);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(27);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 28:
                        contador = 29;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(28) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(28));
                        pasada = (String) barajeada.get(28);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(28);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 29:
                        contador = 30;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(29) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(29));
                        pasada = (String) barajeada.get(29);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(29);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 30:
                        contador = 31;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(30) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(30));
                        pasada = (String) barajeada.get(30);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(30);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 31:
                        contador = 32;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(31) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(31));
                        pasada = (String) barajeada.get(31);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(31);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 32:
                        contador = 33;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(32) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(32));
                        pasada = (String) barajeada.get(32);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(32);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 33:
                        contador = 34;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(33) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(33));
                        pasada = (String) barajeada.get(33);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(33);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 34:
                        contador = 35;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(34) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(34));
                        pasada = (String) barajeada.get(34);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(34);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 35:
                        contador = 36;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(35) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(35));
                        pasada = (String) barajeada.get(35);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(35);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 36:
                        contador = 37;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(36) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(36));
                        pasada = (String) barajeada.get(36);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(36);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 37:
                        contador = 38;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(37) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(37));
                        pasada = (String) barajeada.get(37);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(37);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 38:
                        contador = 39;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(38) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(38));
                        pasada = (String) barajeada.get(38);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(38);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 39:
                        contador = 40;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(39) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(39));
                        pasada = (String) barajeada.get(39);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(39);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 40:
                        contador = 41;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(40) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(40));
                        pasada = (String) barajeada.get(40);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(40);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 41:
                        contador = 42;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(41) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(41));
                        pasada = (String) barajeada.get(41);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(41);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 42:
                        contador = 43;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(42) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(42));
                        pasada = (String) barajeada.get(42);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(42);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 43:
                        contador = 44;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(43) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(43));
                        pasada = (String) barajeada.get(43);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(43);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 44:
                        contador = 45;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(44) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(44));
                        pasada = (String) barajeada.get(44);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(44);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 45:
                        contador = 46;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(45) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(45));
                        pasada = (String) barajeada.get(45);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(45);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 46:
                        contador = 47;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(46) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(46));
                        pasada = (String) barajeada.get(46);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(46);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 47:
                        contador = 48;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(47) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(47));
                        pasada = (String) barajeada.get(47);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(47);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 48:
                        contador = 49;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(48) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(48));
                        pasada = (String) barajeada.get(48);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(48);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 49:
                        contador = 50;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(49) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(49));
                        pasada = (String) barajeada.get(49);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(49);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 50:
                        contador = 51;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(50) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(50));
                        pasada = (String) barajeada.get(50);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(50);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 51:
                        contador = 52;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(51) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(51));
                        pasada = (String) barajeada.get(51);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(51);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 52:
                        contador = 53;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(52) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(52));
                        pasada = (String) barajeada.get(52);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(52);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                    case 53:
                        contador = 54;
                        restl.setText("Cartas restantes: " + String.valueOf(54 - contador));
                        icono = new ImageIcon(getClass().getResource("/Image/Deck/c" + barajeada.get(53) + ".png"));
                        bara.setIcon(icono);
                        pasadas.add(barajeada.get(53));
                        pasada = (String) barajeada.get(53);
                        buscar_carta(pasada);
                        carta = (String) barajeada.get(53);
                        Reproducir_sonido(carta);
                        Verificar_ganador();
                        break;
                }

            }

        };
        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velocidad, velocidad);

    }//GEN-LAST:event_jButton2ActionPerformed

    public void Verificar_ganador() {
        if (ganarjugador == 16) {
            timer.cancel();
            String text = "Ha ganado " + jJugador.getText();
            JOptionPane.showMessageDialog(rootPane, text, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            play.stop();
            Selector obj = new Selector();
            obj.setVisible(true);
            ganarjugador = 0;
            ganamaquina = 0;
            pasadas.clear();

        } else if (ganamaquina == 16) {
            timer.cancel();
            JOptionPane.showMessageDialog(rootPane, "Ha ganado la máquina", "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            play.stop();
            Selector obj = new Selector();
            obj.setVisible(true);
            ganarjugador = 0;
            ganamaquina = 0;
            pasadas.clear();
        }
    }

    public List<String> Barajear() {
        int im, a = 0;
        String ims;
        List<String> barajeada = new ArrayList<String>();
        while (a < 54) {
            im = (int) (54 * Math.random() + 0);
            ims = Integer.toString(im);
            if (a == 0) {
                barajeada.add(ims);
                a++;
            } else {
                if (!barajeada.contains(ims)) {
                    barajeada.add(ims);
                    a++;
                }
            }
        }

        return barajeada;
    }
    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged
    public boolean verificar_seleccion(String car) {
        boolean esta;
        if (pasadas.contains(car)) {
            return true;
        } else {
            return false;
        }
    }

    private void jug1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug1ActionPerformed
        if (verificar_seleccion(seleccionada[0][0]) == true) {
            jug1.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug1ActionPerformed

    private void jug2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug2ActionPerformed
        if (verificar_seleccion(seleccionada[0][1]) == true) {
            jug2.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug2ActionPerformed

    private void jug3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug3ActionPerformed
        if (verificar_seleccion(seleccionada[0][2]) == true) {
            jug3.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug3ActionPerformed

    private void jug4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug4ActionPerformed
        if (verificar_seleccion(seleccionada[0][3]) == true) {
            jug4.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug4ActionPerformed

    private void jug5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug5ActionPerformed
        if (verificar_seleccion(seleccionada[1][0]) == true) {
            jug5.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug5ActionPerformed

    private void jug6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug6ActionPerformed
        if (verificar_seleccion(seleccionada[1][1]) == true) {
            jug6.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug6ActionPerformed

    private void jug7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug7ActionPerformed
        if (verificar_seleccion(seleccionada[1][2]) == true) {
            jug7.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug7ActionPerformed

    private void jug8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug8ActionPerformed
        if (verificar_seleccion(seleccionada[1][3]) == true) {
            jug8.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug8ActionPerformed

    private void jug9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug9ActionPerformed
        if (verificar_seleccion(seleccionada[2][0]) == true) {
            jug9.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug9ActionPerformed

    private void jug10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug10ActionPerformed
        if (verificar_seleccion(seleccionada[2][1]) == true) {
            jug10.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug10ActionPerformed

    private void jug11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug11ActionPerformed
        if (verificar_seleccion(seleccionada[2][2]) == true) {
            jug11.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug11ActionPerformed

    private void jug12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug12ActionPerformed
        if (verificar_seleccion(seleccionada[2][3]) == true) {
            jug12.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug12ActionPerformed

    private void jug13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug13ActionPerformed
        if (verificar_seleccion(seleccionada[3][0]) == true) {
            jug13.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug13ActionPerformed

    private void jug14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug14ActionPerformed
        if (verificar_seleccion(seleccionada[3][1]) == true) {
            jug14.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug14ActionPerformed

    private void jug15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug15ActionPerformed
        if (verificar_seleccion(seleccionada[3][2]) == true) {
            jug15.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug15ActionPerformed

    private void jug16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jug16ActionPerformed
        if (verificar_seleccion(seleccionada[3][3]) == true) {
            jug16.setEnabled(false);
            ganarjugador += 1;
        }
    }//GEN-LAST:event_jug16ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        voz = "WomanAVoices";
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        voz = "WomanBVoices";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        voz = "ManVoices";
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayArea().setVisible(true);

                if (ganarjugador == 16) {
                    timer.cancel();

                    JOptionPane.showMessageDialog(null, "Juego Terminado"
                            + "Ha ganado el Usuario");
                } else if (ganamaquina == 16) {
                    timer.cancel();

                    JOptionPane.showMessageDialog(null, "Juego Terminado"
                            + "Ha ganado el la máquina");

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bara;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jug1;
    private javax.swing.JButton jug10;
    private javax.swing.JButton jug11;
    private javax.swing.JButton jug12;
    private javax.swing.JButton jug13;
    private javax.swing.JButton jug14;
    private javax.swing.JButton jug15;
    private javax.swing.JButton jug16;
    private javax.swing.JButton jug2;
    private javax.swing.JButton jug3;
    private javax.swing.JButton jug4;
    private javax.swing.JButton jug5;
    private javax.swing.JButton jug6;
    private javax.swing.JButton jug7;
    private javax.swing.JButton jug8;
    private javax.swing.JButton jug9;
    private javax.swing.JButton maq1;
    private javax.swing.JButton maq10;
    private javax.swing.JButton maq11;
    private javax.swing.JButton maq12;
    private javax.swing.JButton maq13;
    private javax.swing.JButton maq14;
    private javax.swing.JButton maq15;
    private javax.swing.JButton maq16;
    private javax.swing.JButton maq2;
    private javax.swing.JButton maq3;
    private javax.swing.JButton maq4;
    private javax.swing.JButton maq5;
    private javax.swing.JButton maq6;
    private javax.swing.JButton maq7;
    private javax.swing.JButton maq8;
    private javax.swing.JButton maq9;
    private javax.swing.JLabel restl;
    // End of variables declaration//GEN-END:variables

    private Graphics setIcon(ImageIcon icon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
