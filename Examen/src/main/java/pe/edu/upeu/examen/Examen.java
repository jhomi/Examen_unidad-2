/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pe.edu.upeu.examen;

import pe.edu.upeu.examen.gui.ControllerGame;
import pe.edu.upeu.examen.gui.Vista;
import pe.edu.upeu.examen.gui.ModelGame;

/**
 *
 * @author HP
 */
public class Examen {

    public static void main(String[] args) {
        ModelGame model = new ModelGame();
        Vista view = new Vista();
        ControllerGame controlador = new ControllerGame(view, model);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
