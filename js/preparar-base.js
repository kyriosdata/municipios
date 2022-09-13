const fs = require("fs");
const ajustar = require("./ajuste-palavra");

// Carregar
const conteudo = fs.readFileSync("../base/municipios.json", "utf-8");
const municipios = JSON.parse(conteudo);

const ajustado = municipios.map((o) => ({
  ibge: o.ibge,
  nome: o.nome,
  busca: ajustar(o.nome),
}));

const semAcento = JSON.stringify(ajustado);
fs.writeFileSync("../base/municipios-para-busca.json", semAcento);
