/*
 * Copyright (c) 2021.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.municipios;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class MunicipiosTest {

    @Test
    void removeSinais() {
        assertEquals("acai", Municipio.removeAcentos("açaí"));
    }

    @Test
    void nomePeloCodigoIbge() {
        assertEquals("Alta Floresta D'Oeste", Municipio.nome(1100015));
        assertEquals("Parecis", Municipio.nome(1101450));
        assertEquals("Santana", Municipio.nome(1600600));
        assertEquals("Alvarães", Municipio.nome(1300029));
    }

    @Test
    void ordemIbge() {
        assertEquals(0, Municipio.indice(1100015));
    }

    @Test
    void buscaPorAcreuna() {
        List<Integer> indices = Municipio.busca("ACREúna");
        assertEquals(1, indices.size());
    }

    @Test
    void buscaPorGoiania() {
        List<Integer> indices = Municipio.busca("gOiÂnia");
        assertEquals(3, indices.size());
        List<String> nomes = indices
                .stream().map(i -> Municipio.nomePorIndice(i))
                .collect(Collectors.toList());
        assertTrue(nomes.contains("Goiânia"));
    }

    @Test
    void cidadeDeNomeFelizNatal() {
        List<Integer> indices = Municipio.busca("FELIZ NATAL");
        assertEquals(1, indices.size());
        assertEquals("Feliz Natal", Municipio.nomePorIndice(indices.get(0)));
    }

    @Test
    void indiceInvalidoIbgeNegativo() {
        assertEquals(-1, Municipio.indice(1_000_000));
        assertEquals(-1, Municipio.indice(1_000));
        assertEquals(-1, Municipio.indice(1));
        assertEquals(-1, Municipio.indice(0));
    }

    @Test
    void indiceInvalidoIbgeGeraExcecao() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                Municipio.ibge(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                Municipio.ibge(5570));
    }

    @Test
    void capitais() {
        List<Integer> ac = Municipio.busca("Rio Branco");
        List<String> nomes =
                ac.stream().map(c -> Municipio.nomePorIndice(c)).collect(Collectors.toList());
        assertTrue(nomes.contains("Rio Branco"));
    }
}


