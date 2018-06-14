package aquecimento;

class Aresta {

    private final Vertice a;
    private final Vertice b;
    private final double peso;

    public Aresta(Vertice a, Vertice b, double peso) {
        this.a = a;
        this.b = b;
        this.peso = peso;
    }

    public Vertice getA() {
        return a;
    }

    public Vertice getB() {
        return b;
    }

    public double getPeso() {
        return peso;
    }

}
