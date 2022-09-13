/*
 * Copyright (c) 2021.
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.municipios;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstadoTest {

    @Test
    void verificarIndice() {
        assertEquals(0, Estado.AC.indice());
        assertEquals("Acre", Estado.AC.nome());
        assertEquals(12, Estado.AC.ibge());
        assertEquals(1200401, Estado.AC.capital());

        assertEquals(1, Estado.AL.indice());
        assertEquals("Alagoas", Estado.AL.nome());

        assertEquals(2, Estado.AP.indice());
        assertEquals("Amapá", Estado.AP.nome());

        assertEquals(3, Estado.AM.indice());
        assertEquals(4, Estado.BA.indice());
        assertEquals(5, Estado.CE.indice());
        assertEquals(6, Estado.DF.indice());
        assertEquals(7, Estado.ES.indice());
        assertEquals(8, Estado.GO.indice());
        assertEquals(9, Estado.MA.indice());
        assertEquals(10, Estado.MT.indice());
        assertEquals(11, Estado.MS.indice());
        assertEquals(12, Estado.MG.indice());
        assertEquals(13, Estado.PA.indice());
        assertEquals(14, Estado.PB.indice());
        assertEquals(15, Estado.PR.indice());
        assertEquals(16, Estado.PE.indice());
        assertEquals(17, Estado.PI.indice());
        assertEquals(18, Estado.RJ.indice());
        assertEquals(19, Estado.RN.indice());
        assertEquals(20, Estado.RS.indice());
        assertEquals(21, Estado.RO.indice());
        assertEquals(22, Estado.RR.indice());
        assertEquals(23, Estado.SC.indice());
        assertEquals(24, Estado.SE.indice());
        assertEquals(25, Estado.SP.indice());
        assertEquals(26, Estado.TO.indice());
    }

    @Test
    void totalDeEstados() {
        assertEquals(27, Estado.TOTAL_ESTADOS);
    }

    @Test
    void recuperacaoCorretaDeEstadoPorIndice() {
        Arrays.stream(Estado.values())
                .forEach(e ->
                        assertEquals(e, Estado.fromIndice(e.indice())));
    }

    @Test
    void localizarComValueOfExigeMaiusculas() {
        assertEquals(Estado.GO, Estado.valueOf("GO"));
        assertThrows(IllegalArgumentException.class, () -> Estado.valueOf("go"));
    }

    @Test
    void localizarComFromString() {
        assertEquals(Estado.GO, Estado.fromString("GO"));
        assertEquals(Estado.GO, Estado.fromString("go"));
    }

    @Test
    void estadoNaoLocalizadoCodigoER() {
        assertEquals(Estado.ERRO, Estado.fromString("g"));
        assertEquals(Estado.ERRO, Estado.fromString(""));
        assertEquals(Estado.ERRO, Estado.fromString(null));
    }
}
