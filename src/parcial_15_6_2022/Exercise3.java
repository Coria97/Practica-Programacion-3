package parcial_15_6_2022;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
  public void solucion(List<Estacion> estaciones, List<Estacion> solucion, List<Estacion> solucion_parcial, Estacion origen, Estacion destino, int tanque){
    if (this.comparadorEstaciones(origen, destino) && (solucion.isEmpty() || (solucion.size() > solucion_parcial.size()))){
      solucion.clear();
      solucion.addAll(new ArrayList<>(solucion_parcial));
    }
    else
      {
        if (solucion_parcial.isEmpty())
          solucion_parcial.add(origen);

        for(Estacion estacion : estaciones){
          if (origen.getKilometro() <= estacion.getKilometro() && !this.comparadorEstaciones(origen, destino)){
            int distancia = this.distance(origen, estacion);
            if(distancia > 0 && distancia <= tanque){
              solucion_parcial.add(estacion);
              solucion(estaciones, solucion, solucion_parcial, estacion, destino, tanque);
              solucion_parcial.remove(estacion);
            }
          }
        }
      }
  }

  private int distance(Estacion a, Estacion b){
    return b.getKilometro() - a.getKilometro();
  }

  private boolean comparadorEstaciones(Estacion origen, Estacion destino){
    return origen.getEstacion().equals(destino.getEstacion());
  }
}
