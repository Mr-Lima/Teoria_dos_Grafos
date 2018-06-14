package aquecimento;

public class Vertice implements Comparable<Vertice> {

    private final String nome;

    public Vertice(String nome) {
        this.nome = nome;
    }

    private String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.getNome();
    }

    public int compareTo(Vertice vertice) {
        return this.getNome().compareTo(vertice.getNome());
    }

}

