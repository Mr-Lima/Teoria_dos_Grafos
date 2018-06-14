package busca;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Vertice> vertices = new HashSet<>();
        Set<Aresta> arestas = new HashSet<>();

        Vertice v1 = new Vertice("B02", 3);
        Vertice v2 = new Vertice("B01", 0);
        Vertice v3 = new Vertice("A01", 0);
        Vertice v4 = new Vertice("A02", 0);
        Vertice v5 = new Vertice("A03", 0);
        Vertice v6 = new Vertice("C01", 2);

        Aresta aresta1 = new Aresta(v3, v1, true);
        Aresta aresta2 = new Aresta(v4, v1, true);
        Aresta aresta3 = new Aresta(v5, v1, true);
        Aresta aresta4 = new Aresta(v2, v6, true);
        Aresta aresta5 = new Aresta(v1, v6, true);
        
        
        /*
        Vertice v1 = new Vertice("Joao",2);
        Vertice v2 = new Vertice("Maria",1);
        Vertice v3 = new Vertice("Jose",1);
        Vertice v4 = new Vertice("Tadeu",0);
        Vertice v5 = new Vertice("Ricardo",0);
        
        Aresta aresta1 = new Aresta(v4, v2, true);
        Aresta aresta2 = new Aresta(v5, v1, true);
        Aresta aresta3 = new Aresta(v2, v1, true);
        Aresta aresta4 = new Aresta(v1, v3, true);
        */
        
        /*
        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Vertice v4 = new Vertice("v4");
        
        Aresta aresta1 = new Aresta(v1, v2, 0);
        Aresta aresta2 = new Aresta(v3, v4, 0);
        
        */
        
      /*  
        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Vertice v4 = new Vertice("v4");

        Aresta aresta1 = new Aresta(v1, v2, true);
        Aresta aresta2 = new Aresta(v1, v4, false);
        Aresta aresta3 = new Aresta(v1, v3, false);
        Aresta aresta4 = new Aresta(v3, v4, true);
        Aresta aresta5 = new Aresta(v2, v4, true);


        */

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);

        arestas.add(aresta1);
        arestas.add(aresta2);
        arestas.add(aresta3);
        arestas.add(aresta4);
        arestas.add(aresta5);

        Grafo grafo = new Grafo(vertices, arestas);

        //APENAS NAO COMENTE A OPCAO QUE QUEIRA VER
        grafo.buscaProfundidade();
        //grafo.buscaLargura();
        //grafo.ehCompleto();
        //grafo.ehConexo();
        //grafo.ehRegular();
        //System.out.println(grafo.ehFort_Conexo());
        //System.out.println(grafo.getOrdenacaoTopologica().toString());

        System.out.println(grafo.grade().toString());

        System.out.println(grafo.toString());

    }

}
