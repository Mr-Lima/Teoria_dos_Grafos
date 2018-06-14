package aquecimento;

import java.util.HashSet;
import java.util.Set;

public class Grafo implements IGrafo {

    private final Set<Vertice> vertices;
    private Set<Aresta> arestas;

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    @Override
    public boolean ehCompleto() {
        //METODO PARA QUALQUER GRAFO
        int c = 0, cvert = 0;
        boolean condicao = false;

        for (Aresta ars : arestas) {
            if (ars.getA() != null)
                c++;
            if (ars.getB() != null)
                c++;
        }

        for (Vertice vrt : vertices) {
            cvert++;
        }
        int q = 0;
        Vertice[] cadavrt = new Vertice[cvert];
        for (Vertice vrt : vertices) {
            cadavrt[q] = vrt;
            q++;
        }

        Vertice[] vetor = new Vertice[c];
        int[] repete = new int[cvert];
        int a = 0, b = c / 2;
        Vertice procurador;

        for (Aresta ars : arestas) {
            // for (Vertice vrt : vertices) {
            vetor[a] = ars.getA();
            a++;
        }
        for (Aresta ars : arestas) {
            vetor[b] = ars.getB();
            b++;
        }

        for (int i = 0, k = 0; i < cadavrt.length; i++, k++) {
            int contarpt = 0;
            procurador = cadavrt[i];
            for (Vertice aVetor : vetor) {
                if (procurador.equals(aVetor)) {
                    contarpt = contarpt + 1;
                }
            }
            repete[k] = contarpt;
        }
        int primeiroElemento = repete[0];
        for (int i = 1; i < repete.length; i++) {
            if (repete[i] == primeiroElemento) {
                condicao = true;
            } else {
                condicao = false;
                break;
            }
        }

        return condicao;
    }

    @Override
    public Set<Vertice> getAdjacentes(Vertice v) {
        Set<Vertice> adjacentes = new HashSet<>();

        for (Aresta ars : arestas) {

            for (Vertice vrt : vertices) {

                if (vrt.equals(ars.getA())) {

                    if (vrt.equals(v)) {

                    } else {

                        adjacentes.add(ars.getA());

                    }

                }

                if (vrt.equals(ars.getB())) {

                    if (vrt.equals(v)) {

                    } else {

                        adjacentes.add(ars.getB());

                    }

                }

            }
        }

        return adjacentes;
    }

    @Override
    public String toString() {

        StringBuilder retorno = new StringBuilder();

        for (Vertice v : vertices) {
            retorno.append(v.toString()).append("[ ");

            Set<Vertice> adjacentes = this.getAdjacentes(v);

            for (Vertice adj : adjacentes) {
                retorno.append(adj.toString()).append(" ");
            }

            retorno.append("]\n");

        }

        return retorno.toString();
    }

}
