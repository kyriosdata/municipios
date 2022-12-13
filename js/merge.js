const fs = require("fs");

function removeDigitoVerificador(codigo) {
  return Math.floor(codigo / 10);
}

// Carregar
const conteudo = fs.readFileSync("../base/municipios.csv", "utf-8");
const linhas = conteudo.split("\n");

const baianos = [];

linhas.forEach((l) => {
  let campos = l.trim().split(";");
  if (campos[0].startsWith("23"))
    baianos.push({
      code: removeDigitoVerificador(campos[0]),
      display: campos[1],
      property: [{ code: "type", valueCode: "city" }],
    });
});

console.log(JSON.stringify(baianos));
