# Base de municípios e estados brasileiros

Aplicações que precisam consultar municípios e estados
da federação fazem, em alguns casos, uso de um banco de
dados para tal, e empregam _lookup tables_ correspondentes.

Este projeto oferece informações sobre municípios e estados
brasileiros por meio de arquivos.

**Importante**: todas as informações
aqui fornecidas foram obtidas do portal do IBGE e também
de fontes como o wikipedia.

## Esquema dos municípios

- Município (nome)
- Índice (valor único e fixo entre 0 e 5569)
- IBGE (código de 7 dígitos).
- IBGE (código de 6 dígitos).
- Gentílicos em CodeSystem.(xml|json).
