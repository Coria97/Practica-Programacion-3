package structures.grafo;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {
    private List<Vertex> vertexs;
    private List<Edge> edges;
    
    public DirectedGraph() {
        this.vertexs = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
    }

    public Vertex getVertex(int value) {
        for (Vertex vertex : this.vertexs){
            if (vertex.getValue() == value)
                return vertex;
        }
        return null;
    }

    public boolean containsVertex(Vertex vertex) {
        return this.vertexs.contains(vertex);
    }

    public void addVertex(Vertex vertex) {
        if (!this.containsVertex(vertex))
            this.vertexs.add(vertex);
    }

    public boolean containsEdge(Edge edge) {
        return this.edges.contains(edge);
    }

    public void addEdge(Edge edge) {
        if (!this.containsEdge(edge))
            this.edges.add(edge);
    }

    public void removeEdge(Edge edge) {
        if (!this.containsEdge(edge))
            this.edges.remove(edge);
    }

    public void removeVertex(Vertex vertex) {
        if (!this.containsVertex(vertex))
            this.vertexs.remove(vertex);
            List<Edge> edgesToDelete = this.getEdges(vertex);
            if (!edgesToDelete.isEmpty())
                for(Edge edgeToDelete : edgesToDelete)
                    this.edges.remove(edgeToDelete);
    }

    public List<Edge> getEdges(Vertex vertex) {
        List<Edge> aux = new ArrayList<Edge>();
        for(Edge edge : this.edges)
            if (edge.existsVertex(vertex))
                aux.add(edge);
        return aux;
    }

    public List<Edge> getEdgesByOrigin(Vertex origin) {
        List<Edge> aux = new ArrayList<Edge>();
        for(Edge edge : this.edges)
            if (edge.isVertexOrigin(origin))
                aux.add(edge);
        return aux;
    }

    public int size(){
        return this.vertexs.size();
    }

    public List<Vertex> getVertexs() {
        return new ArrayList<>(vertexs);
    }
    
    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }
}
