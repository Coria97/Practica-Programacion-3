import java.util.List;
import java.util.ArrayList;

import parcial_15_6_2022.Estacion;
import parcial_15_6_2022.Exercise1;
import parcial_15_6_2022.Exercise2;
import parcial_15_6_2022.Exercise3;
import structures.grafo.DirectedGraph;
import structures.grafo.Edge;
import structures.grafo.Vertex;

public class App {



    public static void parcial_15_6_2022(){
        System.out.println("-----------Ejercicio 1----------");
        Vertex v1 = new Vertex(0);
        Vertex v2 = new Vertex(1);
        Vertex v3 = new Vertex(2);
        Vertex v4 = new Vertex(3);
        Vertex v5 = new Vertex(4);
        Vertex v6 = new Vertex(5);

        Edge edge_v1_v2 = new Edge(7, v1, v2);
        Edge edge_v1_v3 = new Edge(3, v1, v3);
        Edge edge_v2_v3 = new Edge(1, v2, v3);
        Edge edge_v2_v4 = new Edge(6, v2, v4);
        Edge edge_v3_v5 = new Edge(8, v3, v5);
        Edge edge_v4_v3 = new Edge(3, v4, v3);
        Edge edge_v4_v6 = new Edge(2, v4, v6);
        Edge edge_v5_v4 = new Edge(2, v5, v4);
        Edge edge_v5_v6 = new Edge(8, v5, v6);

        DirectedGraph graph = new DirectedGraph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addEdge(edge_v1_v2);
        graph.addEdge(edge_v1_v3);
        graph.addEdge(edge_v2_v3);
        graph.addEdge(edge_v2_v4);
        graph.addEdge(edge_v3_v5);
        graph.addEdge(edge_v4_v3);
        graph.addEdge(edge_v4_v6);
        graph.addEdge(edge_v5_v4);
        graph.addEdge(edge_v5_v6);

        Exercise1 exc1 = new Exercise1();
        exc1.solution(graph, 13);

        System.out.println("-----------Ejercicio 2----------");
        // Candidatos: estaciones
        // La estrategia es tomar la estacion que mayor distacia me permita recorrer sin llenar el tanque.

        List<Estacion> estaciones = new ArrayList<Estacion>();
        Estacion origen = new Estacion("Buenos Aires", 0);
        Estacion destino = new Estacion("Ushuaia", 2750);
        estaciones.add(origen);
        estaciones.add(new Estacion("Chascomus", 120));
        estaciones.add(new Estacion("Mar del Plata", 400));
        estaciones.add(new Estacion("Bahia Blanca", 700));
        estaciones.add(new Estacion("Viedma", 950));
        estaciones.add(new Estacion("San Antonio Oeste", 1100));
        estaciones.add(new Estacion("Puerto Madryn", 1400));
        estaciones.add(new Estacion("Trelew", 1600));
        estaciones.add(new Estacion("Comodoro Rivadavia", 1800));
        estaciones.add(new Estacion("Rio Gallegos", 2250));
        estaciones.add(destino);

        int tanque = 500;
        
        System.out.println("--------------------------------");
        Exercise2 exc2 = new Exercise2();
        List<Estacion> solucionExercise2 = exc2.solucion(estaciones, tanque, destino);
        for(Estacion estacion : solucionExercise2)
        if (estacion.getEstacion().equals(destino.getEstacion()))
            System.out.println(estacion.getEstacion() + " km " + estacion.getKilometro());
        else
            System.out.print(estacion.getEstacion() + " km " + estacion.getKilometro() + " --> ");
        System.out.println("--------------------------------");
 
        System.out.println("-----------Ejercicio 3----------");
        Exercise3 exc3 = new Exercise3();
        List<Estacion> solucionExercise3 = new ArrayList<Estacion>();
        List<Estacion> solucionParcialExercise3 = new ArrayList<Estacion>();
        exc3.solucion(estaciones, solucionExercise3, solucionParcialExercise3, origen, destino, tanque);
        for(Estacion estacion : solucionExercise3)
            if (estacion.getEstacion().equals(destino.getEstacion()))
                System.out.println(estacion.getEstacion() + " km " + estacion.getKilometro());
            else
                System.out.print(estacion.getEstacion() + " km " + estacion.getKilometro() + " --> ");
        System.out.println("--------------------------------");

    }

    public static void main(String[] args) throws Exception {        
        parcial_15_6_2022();
    }
}
