const fs = require("fs");

// Carregar
const conteudo = fs.readFileSync("../ms.csv", "utf-8");
const linhas = conteudo.split("\n");

const conceitos = [];

linhas.forEach((l) => {
  let campos = l.trim().split(" - ");
  conceitos.push({
    display: campos[0],
    valueString: campos[1],
  });
});

console.log(JSON.stringify(conceitos));
