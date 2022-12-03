
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import pe.edu.upeu.examen.conx.ConnS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class conns {

    private static volatile ConnS instance;
    private static volatile Connection connection;

    private conns() {

        try {
            //Llama al drive de sqlite
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnS.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }

        if (connection != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }

    }

    public static ConnS getInstance() {
        if (instance == null) {
            synchronized (ConnS.class) {
                if (instance == null) {
                    instance = new ConnS();
                    System.out.println("Primera instancia");
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            synchronized (ConnS.class) {
                if (connection == null) {
                    try {
                        String dbUrl = "jdbc:sqlite:data/3enraya?foreign_keys=on;";
                        connection = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

}
