/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.enraya.gui;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ControllerGame {

    private inicio view;
    private ModelGame model;
    private JLabel[][] casillas;

    public ControllerGame(inicio view, ModelGame model) {
        this.view = view;
        this.model = model;
        casillas = view.getCasillas();
        agregarListeners();
        crearJugadores();
    }

    private void agregarListeners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                agregarEventoMouse(i, j);
            }
        }
        JButton botonReset = view.getBotonReset();
        botonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.resetGame(casillas);
            }
        });

        JButton botonAnular = view.getBotonAnular();
        botonAnular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.AnularGame(casillas);
            }
        });
    }

    private void agregarEventoMouse(int i, int j) {
        JLabel casillaActual = casillas[i][j];
        casillaActual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.marcarCasilla(i, j, casillas);
            } 
        });
    }

    private void crearJugadores() {
        JLabel j1 = view.getVictoriasJ1();
        JLabel j2 = view.getVictoriasJ2();
        model.setJugadores(j1, j2);
    }

}
