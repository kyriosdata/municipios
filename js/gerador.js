// Programa que gera CSV usado em carga para buscas

const fs = require("fs");

// Carregar
const conteudo = fs.readFileSync("../base/municipios-para-busca.json", "utf-8");
const municipios = JSON.parse(conteudo);

// Apenas códigos e ordenados
const codigos = municipios.map((o) => o.ibge);
codigos.sort((a, b) => a - b);

const prontos = codigos.map((c) => {
  return municipios.find((e) => e.ibge === c);
});

const csv = prontos.map((p) => `${p.ibge};${p.nome};${p.busca}`);

const dados = csv.join("\n");
fs.writeFileSync("../base/municipios-busca.csv", dados);
