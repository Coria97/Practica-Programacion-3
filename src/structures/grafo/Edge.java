package structures.grafo;

public class Edge {
    private int cost;
    private Vertex vertice1;
    private Vertex vertice2;

    public Edge(int cost, Vertex vertice1, Vertex vertice2) {
        this.cost = cost;
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex getOrigin() {
        return this.vertice1;
    }

    public Vertex getDestiny() {
        return this.vertice2;
    }

    public void setVertexs(Vertex vertice1, Vertex vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    @Override
    public boolean equals(Object obj) {
        Edge edge = (Edge) obj;
        return this.getOrigin() == edge.getOrigin() && this.getDestiny() == edge.getDestiny();
    }

    public boolean existsVertex(Vertex vertex) {
        return this.getOrigin() == vertex || this.getDestiny() == vertex;
    }

    public boolean isVertexOrigin(Vertex origin){
        return this.getOrigin() == origin;
    }

    @Override
    public String toString(){
        return "De " + this.getOrigin().getValue() + " a " + this.getDestiny().getValue() + " con un coste de " + this.getCost();
    }
}

