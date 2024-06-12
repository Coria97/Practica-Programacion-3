package parcial_15_6_2022;

public class Estacion {
  private String estacion;
  private int kilometro;

  public Estacion(String estacion, int kilometro){
    this.estacion = estacion;
    this.kilometro = kilometro;
  }

  public String getEstacion(){
    return this.estacion;
  }

  public int getKilometro(){
    return this.kilometro;
  }
}

