/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca;

class Aresta {

    private Vertice a, b;
    private double peso;
    private boolean direcionado;

    public Aresta(Vertice a, Vertice b, double peso) {
        this.a = a;
        this.b = b;
        this.peso = peso;
    }

    public Aresta(Vertice a, Vertice b, boolean direcionado) {
        this.a = a;
        this.b = b;
        this.direcionado = direcionado;
    }

    public Vertice getA() {
        return a;
    }

    public void setA(Vertice a) {
        this.a = a;
    }

    public Vertice getB() {
        return b;
    }

    public void setB(Vertice b) {
        this.b = b;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isDirecionado() {
        return direcionado;
    }

    public void setDirecionado(boolean direcinado) {
        this.direcionado = direcinado;
    }

}
