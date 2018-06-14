/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca;

public class Vertice implements Comparable<Vertice> {

    private final String nome;
    private boolean visitado;
    private int ordem;
    private int valorPos;
    private int peso;

    private Vertice(String nome) {
        this.nome = nome;
    }

    public Vertice(String nome, int peso) {
        this(nome);
        this.peso = peso;
    }

    private String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.getNome();
    }

    public boolean isVisitado() {
        return this.visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getOrdem() {
        return this.ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int compareTo(Vertice outro) {
        return this.getNome().compareTo(outro.getNome());
    }

    public int getValorPos() {
        return valorPos;
    }

    public void setValorPos(int valorPos) {
        this.valorPos = valorPos;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
