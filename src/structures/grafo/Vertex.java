package structures.grafo;

public class Vertex {
    private int value;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex vertex = (Vertex) obj;
        return this.value == vertex.getValue();
    }

}
