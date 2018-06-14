package aquecimento;

import java.util.Set;


interface IGrafo {

    //Retorna true se o grafo for completo e false caso contrario
    boolean ehCompleto();

    //Retorna um conjunto com todos os adjancetes de um vertice
    Set<Vertice> getAdjacentes(Vertice v);

    /*
          Retorna uma string que representa o grafo na forma:

          v2 [ v1 v3 ]
          v1 [ v2 v3 ]
          v3 [ v2 v1 ]

          Por exemplo, nesse caso V2 e adjacente a v1 e v3.

    */
    String toString();

}
