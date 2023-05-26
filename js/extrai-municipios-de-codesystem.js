const fs = require("fs");

// Carregar
const conteudo = fs.readFileSync("../base/ValueSet.json", "utf-8");
const valueSet = JSON.parse(conteudo);

console.log(valueSet.compose.include[0].concept.length);

for (let indice in valueSet.compose.include[0].concept) {
  // Para remover propriedade obtida de CodeSystem
  // delete valueSet.concept[indice].property;

  // Para converter alguns valores numéricos para String
  let valor = valueSet.compose.include[0].concept[indice].code;
  if (typeof valor !== "string") {
    valor = valor.toString();
  }

  valueSet.compose.include[0].concept[indice].code = valor;
}

let atualizado = JSON.stringify(valueSet);

fs.writeFileSync("../base/ValueSet.json", atualizado);
