/*
 * Copyright (c) 2021.
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.municipios;

import java.util.Arrays;

/**
 * Identifica um estado da federação do Brasil.
 * Os índices viabilizam uso de vetor para manter
 * informação por estado.
 */
public enum Estado {

    /**
     * Acre
     */
    AC("Acre", 0, 12, 1200401),

    /**
     * Alagoas
     */
    AL("Alagoas", 1, 27, 2704302),

    /**
     * Amapá
     */
    AP("Amapá", 2, 16, 1600303),

    /**
     * Amazonas
     */
    AM("Amazonas", 3, 13, 1302603),

    /**
     * Bahia
     */
    BA("Bahia", 4, 29, 2927408),

    /**
     * Ceará
     */
    CE("Ceará", 5, 23, 2304400),

    /**
     * Distrito Federal
     */
    DF("Distrito Federal", 6, 53, 5300108),

    /**
     * Espírito Santo
     */
    ES("Espírito Santo", 7, 32, 3205309),

    /**
     * Goiás
     */
    GO("Goiás", 8, 52, 5208707),

    /**
     * Maranhão
     */
    MA("Maranhão", 9, 21, 2111300),

    /**
     * Mato Grosso
     */
    MT("Mato Grosso", 10, 51, 5103403),

    /**
     * Mato Grosso do Sul
     */
    MS("Mato Grosso do Sul", 11, 50, 5002704),

    /**
     * Minas Gerais
     */
    MG("Minas Gerais", 12, 31, 3106200),

    /**
     * Pará
     */
    PA("Pará", 13, 15, 1501402),

    /**
     * Paraíba
     */
    PB("Paraíba", 14, 25, 2507507),

    /**
     * Paraná
     */
    PR("Paraná", 15, 41, 4106902),

    /**
     * Pernambuco
     */
    PE("Pernambuco", 16, 26, 2611606),

    /**
     * Piauí
     */
    PI("Piauí", 17, 22, 2211001),

    /**
     * Rio de Janeiro
     */
    RJ("Rio de Janeiro", 18, 33, 3304557),

    /**
     * Rio Grande do Norte
     */
    RN("Rio Grande do Norte", 19, 24, 2408102),

    /**
     * Rio Grande do Sul
     */
    RS("Rio Grande do Sul", 20, 43, 4314902),

    /**
     * Rondônia
     */
    RO("Rondônia", 21, 11, 1100205),

    /**
     * Roraima
     */
    RR("Roraima", 22, 14, 1400100),

    /**
     * Santa Catarina
     */
    SC("Santa Catarina", 23, 42, 4205407),

    /**
     * Sergipe
     */
    SE("Sergipe", 24, 28, 2800308),

    /**
     * São Paulo
     */
    SP("São Paulo", 25, 35, 3550308),

    /**
     * Tocantins
     */
    TO("Tocantins",26, 17, 1721000),

    /**
     * Indica situação extraordinária, estado não identificado.
     */
    ERRO("ERRO", 27, -1, -1);

    /**
     * Total de estados da federação.
     */
    public static final int TOTAL_ESTADOS = 27;

    /**
     * O nome do estado.
     */
    private final String nome;

    /**
     * Valor numérico atribuído a um estado correspondente
     * a um possível vetor iniciado por 0, este é um possível
     * uso deste valor.
     */
    private final int indice;

    /**
     * Código IBGE do estado.
     */
    private final int ibge;

    /**
     * O código IBGE da capital do estado.
     */
    private final int capital;

    /**
     * O índice único atribuído ao um estado, pela presente classe,
     * um valor de 0 a 26, inclusive.
     *
     * @return O valor (índice) único atribuído ao estado.
     */
    public int indice() {
        return indice;
    }

    /**
     * Recupera o nome do estado.
     *
     * @return O nome do estado.
     */
    public String nome() {
        return nome;
    }

    /**
     * Recupera o código IBGE do estado.
     *
     * @return O código IBGE do estado.
     */
    public int ibge() {
        return ibge;
    }

    /**
     * Recupera o código IBGE (7 dígitos) da capital.
     *
     * @return O código IBGE da capital do estado.
     */
    public int capital() {
        return capital;
    }

    /**
     * Cria um estado associado ao índice único fornecido.
     *
     * @param indice  O índice único atribuído ao estado.
     * @param ibge    O código IBGE do estado.
     * @param capital O código IBGE da capital do estado.
     */
    Estado(String nome, int indice, int ibge, int capital) {
        this.nome = nome;
        this.indice = indice;
        this.ibge = ibge;
        this.capital = capital;
    }

    /**
     * Recupera enum correspondente à sequência de caracteres.
     *
     * @param sigla Sigla de duas letras para o estado da federação.
     * @return Enum correspodente à sigla.
     */
    public static Estado fromString(String sigla) {
        if (sigla == null) {
            return ERRO;
        }

        try {
            return valueOf(sigla.toUpperCase());
        } catch (IllegalArgumentException exp) {
            return ERRO;
        }
    }

    /**
     * Recupera o estado correspondente ao índice fornecido.
     *
     * @param indice O índice do estado.
     *
     * @return O estado correspondente ao índice.
     */
    public static Estado fromIndice(int indice) {
        return Arrays.stream(values()).filter(e -> e.indice == indice)
                .findFirst().orElse(Estado.ERRO);
    }
}
