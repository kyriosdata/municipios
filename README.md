# Base de municípios e estados brasileiros

Aplicações que precisam consultar municípios e estados
da federação fazem, em alguns casos, uso de um banco de
dados para tal, e empregam _lookup tables_ correspondentes.

Este projeto oferece uma alternativa que não inclui um
banco de dados convencional. Dados são armazenados em arquivos
no próprio **jar** da presente biblioteca. Além de busca
por nome (parte do nome).

## Esquema dos municípios

- Município (nome)
- Índice (valor único e fixo entre 0 e 5569)
- IBGE (código de 7 dígitos). 
- Gentílicos em CodeSystem.(xml|json). Observe que o código de 6 dígitos,
quando acrescido do dígito verificador, forma o código de 7 dígitos.
