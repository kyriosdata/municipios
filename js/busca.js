const fs = require("fs");

// Carregar
const conteudo = fs.readFileSync("../base/municipios.json", "utf-8");
const municipios = JSON.parse(conteudo);

// Buscar por substring (nome)
const substring = municipios.filter((m) => m.nome.includes("ait"));
console.log(substring);

// Buscar por código IBGE
const codigo = municipios.find((m) => m.ibge === 530010);
console.log(codigo);
