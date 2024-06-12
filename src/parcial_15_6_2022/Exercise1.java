package parcial_15_6_2022;

import java.util.*;
import structures.grafo.DirectedGraph;
import structures.grafo.Vertex;
import structures.grafo.Edge;


public class Exercise1 {
  public boolean solution(DirectedGraph graph, int value){
    List<Edge> cicle = new ArrayList<Edge>();
    String [] visited = new String[graph.size()];
    for(int i = 0; i < graph.size(); i++)
      visited[i] = "NO VISITADO";

    for(Vertex vertex : graph.getVertexs())
    {
      visited[vertex.getValue()] = "ORIGEN";
      boolean isSolution = getCicle(graph, vertex, value, visited, cicle);
      if (isSolution){
        for(Edge edge : cicle)
          System.out.println(edge.toString());
        break;
      }
      else
        for(int i = 0; i < graph.size(); i++)
          visited[i] = "NO VISITADO";
    }
    return true;
  }

  public boolean getCicle(DirectedGraph graph, Vertex vertex, int value, String[] visited, List<Edge> cicle){
    List<Edge> adjacents = graph.getEdgesByOrigin(vertex);
    for(Edge adjacent : adjacents)
    {
      cicle.add(adjacent);

      if (visited[adjacent.getDestiny().getValue()] == "ORIGEN")
      {
        if (value == getSuma(cicle))
          return true;
      }
      else
        if (visited[adjacent.getDestiny().getValue()] == "NO VISITADO")
        {
          visited[adjacent.getDestiny().getValue()] = "VISITADO";
          boolean foundCycle = getCicle(graph, adjacent.getDestiny(), value, visited, cicle);
          if (foundCycle)
            return true;
          else
            visited[adjacent.getDestiny().getValue()] = "NO VISITADO";
        }
      
      cicle.remove(adjacent);
    }
    return false;
  }

  public int getSuma(List<Edge> cicle){
    int aux = 0;
    for(Edge edge : cicle)
      aux+= edge.getCost();
    return aux;
  }

}
