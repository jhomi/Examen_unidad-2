
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import pe.edu.upeu.enraya.Dao.ResultadoDaoI;
import pe.edu.upeu.enraya.Modelo.ResultadoTO;
import pe.edu.upeu.enraya.util.ErrorLogger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class ResultadoDAO implements ResultadoDaoI {

    Statement stmt = null;
    Vector columnNames;
    Vector visitdata;
    Connection connection = ConnS.getInstance().getConnection();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ResultadoDAO.class.getName());
    ResultSet rs = null;

    public ResultadoDAO() {
        columnNames = new Vector();
        visitdata = new Vector();

    }

    public int create(ResultadoTO) {
        @Override
        int create (ResultadoTO
        
        
            ) {
        int rsId = 0;
            String[] returns = {"id_resultado"};
            String sql = "INSERT INTO resulta \"dos(nombre_partida,nombre_jugador1, nombre_jugador2,ganador, punto, estado) "
                    + "VALUES(?,?,?,?,?,?)";
            int i = 0;
            try {
                ps = connection.prepareStatement(sql, returns);
                ps.setString(++i,.getNombrePartida()
                );
            ps.setString(++i,.getNombreJugador1()
                );
            ps.setString(++i,.getNombreJugador2()
                );
            ps.setString(++i,.getGanador()
                );
            ps.setInt(++i,.getPunto()
                );
            ps.setString(++i,.getEstado()
                );
            rsId = ps.executeUpdate();// 0 no o 1 si commit
                try ( ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        rsId = rs.getInt(1);
                    }
                    rs.close();
                }
            } catch (SQLException ex) {
                //System.err.println("create:" + ex.toString());
                log.log(Level.SEVERE, "create", ex);
            }
            return rsId;
        }

    
    

    

    public int update(ResultadoTO) {
        System.out.println("actualizar d.getNombre_partida: " + d.getNombrePartida());
        int comit = 0;
        String sql = "UPDATE resultados SET "
                + "nombre_partida=?, "
                + "nombre_jugador1=?, "
                + "nombre_jugador2=?, "
                + "ganador=?, "
                + "punto=?, "
                + "estado=? "
                + "WHERE nombre_partida=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, .getNombrePartida()
            );
            ps.setString(++i, .getNombreJugador1()
            );
            ps.setString(++i, .getNombreJugador2()
            );
            ps.setString(++i, .getGanador()
            );
            ps.setInt(++i, .getPunto()
            );
            ps.setString(++i, .getEstado()
            );
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public List<ResultadoTO> listCmb(String filter) {
        List<ResultadoTO> ls = new ArrayList();
        ls.add(new ResultadoTO());
        ls.addAll(listarResultado());
        return ls;
    }
}

public List<ResultadoTO> listarResultado() {
List<ResultadoTO> listarresultado = new ArrayList<>();
        String sql = "SELECT * FROM resultados";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ResultadoTO cli = new ResultadoTO();
                cli.setNombrePartida(rs.getString("nombre_partida"));
                cli.setNombreJugador1(rs.getString("nombre_jugador1"));
                cli.setNombreJugador2(rs.getString("nombre_jugador2"));
                cli.setGanador(rs.getString("ganador"));
                cli.setPunto(rs.getInt("punto"));
                cli.setEstado(rs.getString("estado"));
                
                cli.setIdResultado(rs.getInt("id_resultado"));
                listarresultado.add(cli);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarresultado;}
    }
}
