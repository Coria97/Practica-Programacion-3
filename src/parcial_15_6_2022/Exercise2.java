package parcial_15_6_2022;

import java.util.*;

public class Exercise2 {
  public List<Estacion> solucion(List<Estacion> estaciones, int tanque, Estacion destinoFinal) {
    Estacion origen = estaciones.get(0);
    estaciones.remove(origen);
    List<Estacion> solucion = new ArrayList<Estacion>();
    solucion.add(origen);
    while(!estaciones.isEmpty() && !isSolution(origen, destinoFinal)){
      Estacion nextEstacion = this.getProximaEstacion(estaciones, origen, destinoFinal, tanque);
      solucion.add(nextEstacion);
      origen = nextEstacion;
    }

    return solucion;
  }

  private int distance(Estacion a, Estacion b){
    return b.getKilometro() - a.getKilometro();
  }

  private Estacion getProximaEstacion(List<Estacion> estaciones, Estacion origen, Estacion destinoFinal, int tanque){
    Estacion retorno = null;
    int distanciaParcial = 0;
    for(Estacion siguienteEstacion : estaciones){
      if(siguienteEstacion.getKilometro() > origen.getKilometro()){
        int distancia = distance(origen, siguienteEstacion);
        if ((distancia > 0) && (distancia <= tanque) && (distancia > distanciaParcial))
        {
          retorno = new Estacion(siguienteEstacion.getEstacion(), siguienteEstacion.getKilometro());
          distanciaParcial = distancia;
        }
      }
    }
    return retorno;
  }

  private boolean isSolution(Estacion origen, Estacion destino){
    System.out.println("origen: " + origen.getEstacion() + " ; destino: " + destino.getEstacion());
    return origen.getEstacion().equals(destino.getEstacion());
  }
}