package pe.edu.upeu.examen.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultadoTO {

    public int idResultado, punto;
    public String nombrePartida, nombreJugador1, nombreJugador2, ganador, estado;

}
