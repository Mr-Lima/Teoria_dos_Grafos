/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca;

import java.util.*;

public class Grafo implements IGrafo {

    /*
     * Executa a busca em profundidade a partide de um vertice especifico
     */
    private final Stack<Vertice> posOrdem = new Stack<>();
    private Set<Vertice> vertices;
    private Set<Aresta> arestas = new HashSet<>();
    private List<Vertice> visitados = new ArrayList<>();
    private List<Vertice> explorados = new ArrayList<>();

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    /*
     * Verifica se um grafo e completo
     */
    @Override
    public boolean ehCompleto() {

        for (Vertice vertice : this.vertices) {
            if (this.getAdjacentes(vertice).size() == this.vertices.size() - 1) {
                continue;
            } else {
                System.out.println("Nao eh completo");
                return false;
            }
        }
        System.out.println("Eh completo");
        return true;
    }

    /*
     * Retorna a lista de vertices adjacentes de um determinado vertice
     */
    @Override
    public Set<Vertice> getAdjacentes(Vertice v) {
        Set<Vertice> adjacentes = new HashSet<>();

        for (Aresta aresta : this.arestas) {
            if (!aresta.isDirecionado()) {
                if (aresta.getA() == v) {
                    adjacentes.add(aresta.getB());
                }

                if (aresta.getB() == v) {
                    adjacentes.add(aresta.getA());
                }
            } else if (aresta.isDirecionado()) {
                if (aresta.getA() == v) {
                    adjacentes.add(aresta.getB());
                }
            }
        }
        return adjacentes;

    }

    /*
     * Retorna o proximo vertice nao visitado da lista de adjacentes
     */
    private Vertice getProximo(Set<Vertice> adjacentes) {

        Vertice verticeRetorno = null;

        for (Vertice v : adjacentes) {
            if (!v.isVisitado()) {
                verticeRetorno = v;
                break;
            }

        }
        return verticeRetorno;
    }

    @Override
    public void buscaLargura() {

        Vertice verticeInicial = this.getNaoVisitado();

        while (verticeInicial != null) {
            this.buscaEmLargura(verticeInicial);
            verticeInicial = this.getNaoVisitado();
        }

    }

    @Override
    public void buscaProfundidade() {
        Vertice verticeInicial = this.getNaoVisitado();

        while (verticeInicial != null) {
            this.buscaEmProfundidadeVertice(verticeInicial);
            verticeInicial = this.getNaoVisitado();
        }
    }

    /*
     * Retorna um vertice nao visitado do conjunto de vertices do grafo
     */
    private Vertice getNaoVisitado() {
        for (Vertice vertice : this.vertices) {
            if (!vertice.isVisitado()) {
                return vertice;
            }
        }

        return null;
    }

    private void buscaEmProfundidadeVertice(Vertice v) {
        int x = 1;
        Stack<Vertice> pilha = new Stack<>();
        v.setVisitado(true);
        this.visitados.add(v);
        pilha.push(v);

        while (!pilha.isEmpty()) {
            Set<Vertice> adjacentes = this.getAdjacentes(pilha.lastElement());
            Vertice w = getProximo(adjacentes);
            if (w != null) {
                w.setVisitado(true);
                this.visitados.add(w);
                pilha.push(w);
            } else {
                this.explorados.add(pilha.lastElement());
                pilha.peek().setValorPos(x);
                x++;
                posOrdem.push(pilha.pop());
            }
        }
    }

    private void buscaEmLargura(Vertice v) {

        Queue<Vertice> fila = new PriorityQueue<>();

        v.setVisitado(true);
        this.visitados.add(v);
        fila.add(v);

        while (!fila.isEmpty()) {
            Set<Vertice> adjacentes = this.getAdjacentes(fila.peek());
            explorados.add(fila.poll());
            for (Vertice w : adjacentes) {
                if (!(this.visitados.contains(w))) {
                    w.setVisitado(true);
                    this.visitados.add(w);
                    fila.add(w);
                } else
                    continue;
            }
        }
    }

    /*
     * Imprime o grafo
     */
    @Override
    public String toString() {

        StringBuilder retorno = new StringBuilder();

        for (Vertice v : vertices) {
            retorno.append(v.toString()).append("[ ");

            Set<Vertice> adjacentes = this.getAdjacentes(v);

            for (Vertice adj : adjacentes) {
                retorno.append(adj.toString()).append(" ");
                if (adj.isVisitado()) {
                    retorno.append("(*) ");
                } else {
                    retorno.append("( ) ");
                }
            }

            retorno.append("]\n");

        }

        retorno.append("\n");
        retorno.append("Ordem Visitados: ").append(this.visitados.toString());
        retorno.append("\n");
        retorno.append("Ordem Explorados: ").append(this.explorados.toString());

        return retorno.toString();
    }

    @Override
    public boolean ehConexo() {

        for (Vertice vertice : this.vertices) {

            if (this.getAdjacentes(vertice).size() >= 1) {

                continue;

            } else {

                System.out.println("Nao e conexo");

                return false;

            }

        }

        System.out.println("E conexo");

        return true;

    }

    @Override
    public boolean ehRegular() {

        int comp = 0;

        for (Vertice vertice : this.vertices) {

            comp = this.getAdjacentes(vertice).size();

        }

        for (Vertice vertice : this.vertices) {

            if (this.getAdjacentes(vertice).size() == comp) {

                continue;

            } else {

                System.out.println("Nao e regular");

                return false;

            }

        }

        System.out.println("E regular");

        return true;

    }

    private void resetVisitado() {
        for (Vertice x : this.vertices) {
            x.setVisitado(false);
        }
    }

    public boolean ehFort_Conexo() {
        this.buscaProfundidade();
        for (Aresta x : arestas) {
            Vertice aux = null;
            aux = x.getA();
            x.setA(x.getB());
            x.setB(aux);
        }
        this.resetVisitado();
        this.visitados.clear();
        this.explorados.clear();
        this.buscaEmProfundidadeVertice(posOrdem.peek());
        System.out.print("Fortemente conexo: ");
        return vertices.size() == explorados.size();
    }

    public List<Vertice> getOrdenacaoTopologica() {
        ArrayDeque<Vertice> queue = new ArrayDeque<>();
        List<Vertice> ordem = new ArrayList<>();
        for (Vertice x : this.vertices) {
            if (x.getPeso() == 0)
                queue.add(x);
        }
        while (!queue.isEmpty()) {
            for (Vertice x : getAdjacentes(queue.peek())) {
                x.setPeso(x.getPeso() - 1);
                if (x.getPeso() == 0) {
                    queue.add(x);
                }
            }
            ordem.add(queue.poll());

        }
        if (ordem.size() != vertices.size()) {
            System.out.println("Impossivel");
            return null;
        } else
            return ordem;
    }

    public List<List<Vertice>> grade() {
        ArrayDeque<Vertice> queue = new ArrayDeque<>();
        List<Vertice> ordem = new ArrayList<>();
        List<Vertice> semestre = new ArrayList<>();
        List<List<Vertice>> ano = new ArrayList<>();
        for (Vertice x : this.vertices) {
            if (x.getPeso() == 0)
                queue.add(x);
        }
        while (!queue.isEmpty()) {
            for (Vertice x : getAdjacentes(queue.peek())) {
                x.setPeso(x.getPeso() - 1);
                if (x.getPeso() == 0) {
                    queue.add(x);
                    ano.add(semestre);
                    semestre.clear();
                }
            }
            ordem.add(queue.peek());
            semestre.add(queue.poll());
            if (semestre.size() == 2) {
                ano.add(semestre);
            }
        }
        if (ordem.size() != vertices.size()) {
            System.out.println("Impossivel");
            return null;
        } else
            return ano;
    }
}
