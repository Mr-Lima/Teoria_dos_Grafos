/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca;

import java.util.Set;

interface IGrafo {

    //Retorna true se o grafo for completo e false caso contrário
    boolean ehCompleto();

    //Retorna true se o grafo for conexo e false caso contrario
    boolean ehConexo();

    //Retorna true se o grafo for regular e false caso contrario
    boolean ehRegular();

    //Retorna um conjunto com todos os adjancetes de um vértice
    Set<Vertice> getAdjacentes(Vertice v);

    /*
        Retorna uma string que representa o grafo na forma:

        v2 [ v1 v3 ]
        v1 [ v2 v3 ]
        v3 [ v2 v1 ]

        Por exemplo, nesse caso V2 é adjacente a v1 e v3.
        
     */
    String toString();

    // Executa a busca em Largura
    void buscaLargura();

    //Executa a busca em profundidade
    void buscaProfundidade();

}
