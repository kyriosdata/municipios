/*
 * Copyright (c) 2021.
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.municipios;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementação de operações de busca sobre municípios brasileiros.
 */
public final class Municipio {

    public static final String CODIGOS_BIN = "codigos.bin";
    public static final String NOMES_BIN = "nomes.bin";
    public static final String BUSCA_BIN = "busca.bin";

    /**
     * Total de municípios do Brasil.
     */
    public static final int TOTAL_MUNICIPIOS = 5570;

    /**
     * Códigos IBGE dos municípios brasileiros.
     */
    private static int[] CODIGOS = null;

    /**
     * Nomes dos municípios.
     */
    private static String[] NOMES;

    /**
     * Nomes dos municípios ajustados para busca.
     */
    private static String[] BUSCA;

    /**
     * Remove acentos e sinais de tal forma a viabilizar a busca
     * exclusivamente pelas letras.
     *
     * @param original Texto original, possivelmente com acentos.
     *
     * @return Termo correspondente ao original sem sinais e
     * acentos. Por exemplo, para a entrada "açaí", a saída
     * produzida é "acai".
     */
    public static String removeAcentos(String original) {
        String sa = Normalizer.normalize(original, Normalizer.Form.NFD);

        return sa.replaceAll("\\p{M}", "");
    }

    /**
     * Realiza busca por município cujo nome contém a sequência
     * fornecida. A busca é realizada por letra, ignorando sinais,
     * acentos e, adicionalmente, independente de ser maiúscula ou
     * minúscula.
     *
     * @param parte Sequência de caracteres que deve estar presente
     *              no nome do município desejado.
     *
     * @return Lista de municípios cujo nome inclui o argumento
     * fornecido, com ou sem acentos, usando ou não letras
     * maiúsculas/minúsculas. Os municípios são identificados
     * pelos códigos únicos.
     */
    public static List<Integer> busca(String parte) {
        String ajustado = removeAcentos(parte).toLowerCase();

        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < TOTAL_MUNICIPIOS; i++) {
            if (BUSCA[i].contains(ajustado)) {
                lista.add(i);
            }
        }

        return lista;
    }

    /*
     * Carrega arquivos previamente preparados para acelerar a
     * carga e a consulta.
     */
    static {
        try {
            ClassLoader loader = Municipio.class.getClassLoader();
            CODIGOS = (int[]) carrega(loader.getResourceAsStream(CODIGOS_BIN));
            NOMES = (String[]) carrega(loader.getResourceAsStream(NOMES_BIN));
            BUSCA = (String[]) carrega(loader.getResourceAsStream(BUSCA_BIN));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna o nome do município correspondente ao código IBGE fornecido.
     *
     * @param ibge O código IBGE do município.
     * @return O nome do município.
     */
    public static String nome(int ibge) {
        return NOMES[indice(ibge)];
    }

    /**
     * Recupera o nome do município correspondente ao índice fornecido.
     * O índice é um valor único atribuído a cada município pela
     * presente biblioteca. Este valor está na faixa de 0 a 5569,
     * inclusive. O índice pode ser recuperado a partir do
     * código IBGE corresponde. Consulte {@link #indice(int)} para
     * detalhes.
     *
     * @param indice O índice do município.
     *
     * @return O nome do município para o índice fornecido.
     */
    public static String nomePorIndice(int indice) {
        return NOMES[indice];
    }

    /**
     * Identifica o índice deste município, um valor de 0
     * a 5569, correspondente ao código IBGE fornecido (7 dígitos).
     *
     * <p>Esta relação é fixa e imutável enquanto os
     * códigos IBGE permanecerem fixos.</p>
     *
     * @param ibge Código IBGE do município cujo índice
     *             único, um valor na faixa de 0 a 5569,
     *             é desejado.
     * @return Um código único, de 0 a 5569, correspondente
     * ao código IBGE fornecido. Se o código fornecido não
     * correspondente ao código IBGE de um município, então
     * o valor retornado é {@code -1}.
     *
     * @see #ibge(int)
     */
    public static int indice(int ibge) {
        return Arrays.binarySearch(CODIGOS, ibge);
    }

    /**
     * Obtém o código IBGE para o código único, um valor
     * na faixa de 0 a 5569, fornecido como argumento.
     * Este índice é um valor atribuído a cada município
     * por esta biblioteca.
     *
     * <p>Esta função é tal que, se A é o código IBGE retornado
     * para o índice X, então a função {@link #indice(int)}
     * deverá retornar o valor X para o código A.</p>
     *
     * @param indice O índice do município.
     * @return O código IBGE associado ao valor do índice
     * fornecido.
     *
     * @throws ArrayIndexOutOfBoundsException Se o valor fornecido
     * não estiver entre 0 e 5569, inclusive.
     *
     * @see #indice(int)
     */
    public static int ibge(int indice) {
        return CODIGOS[indice];
    }

    /**
     * Carrega arquivo cujo conteúdo é objeto serializado.
     *
     * @param fis {@link InputStream} para o arquivo cujo conteúdo
     *                                   deve ser carregado.
     * @return Objeto correspondente ao conteúdo carregado.
     * @throws IOException Erro de IO.
     * @throws ClassNotFoundException Classe não encontrada.
     */
    public static Object carrega(InputStream fis) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        return objectInputStream.readObject();
    }
}
