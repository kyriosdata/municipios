/*
 * Copyright (c) 2021.
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.municipios.suporte;

import com.github.kyriosdata.municipios.Municipio;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Aplicação que gera arquivos empregados para busca
 * de informações sobre municípios.
 *
 * <p>Ao executar este programa será depositado no diretório
 * corrente os arquivos {@code codigos.bin}, {@code nomes.bin}
 * e {@code busca.bin}.
 * </p>
 *
 * <p>O código desta classe será executado apenas em tempo
 * de desenvolvimento.</p>
 */
public final class Preparacao {

    public static final int TOTAL = 5570;
    public static final int[] CODIGOS = new int[TOTAL];
    public static final String[] NOMES = new String[TOTAL];
    public static final String[] BUSCA = new String[TOTAL];

    public static final String ARQUIVO = "municipios-busca.csv";

    public static void prepara() {
        try {
            ClassLoader classLoader = Preparacao.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream(ARQUIVO);

            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            int indice = -1;
            while (br.ready()) {
                indice = indice + 1;
                String[] campos = br.readLine().split(";");

                CODIGOS[indice] = Integer.parseInt(campos[0]);
                NOMES[indice] = campos[1];
                BUSCA[indice] = campos[2];
            }

            saveBin(Municipio.CODIGOS_BIN, CODIGOS);
            saveBin(Municipio.NOMES_BIN, NOMES);
            saveBin(Municipio.BUSCA_BIN, BUSCA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveBin(String filename, Object codigos) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream codigosbin = new ObjectOutputStream(fos);
        codigosbin.writeObject(codigos);
    }

    public static void verifica() throws IOException, ClassNotFoundException {
        int[] codigos = (int[]) Municipio.carrega(new FileInputStream(Municipio.CODIGOS_BIN));
        String[] nomes = (String[]) Municipio.carrega(new FileInputStream(Municipio.NOMES_BIN));
        String[] busca = (String[]) Municipio.carrega(new FileInputStream(Municipio.BUSCA_BIN));

        System.out.println("Quantidade de entradas: " + codigos.length);
        System.out.println("Ultimo código: " + codigos[5569]);
        System.out.println("Ultimo nome: " + nomes[5569]);
        System.out.println("Ultimo busca: " + busca[5569]);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        prepara();
        verifica();
    }
}
