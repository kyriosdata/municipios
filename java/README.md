## Municípios e estados

Biblioteca para acesso a 
municípios (nomes e código IBGE) e estados (nomes e capitais).

Esta biblioteca também estabelece um código único sequencial, de 0 a
5569 para os municípios. Assim como também estabelece um código 
único de 0 a 26 para os estados.

## Gradle 

```groovy
dependencies {
	implementation 'com.github.kyriosdata:municipios:1.0.6'
}
```


## Desenvolvedores (token e deploy)

Criar token a ser fornecido em **settings.xml** a partir de _Settings_ (usuário),
_Developer Settings_ e _Personal Access Tokens_. 

Comando para efetuar _deploy_ (disponibilizar _package_ no Github): 

- `mvn --batch-mode deploy`

## Orientações gerais para gerar a biblioteca

- A aplicação (Preparacao) gera a base de dados empregada para as consultas.
Arquivos gerados (.bin) devem ser depositados no diretório **resources**. Execute
esta aplicação para atualizar os arquivos.
- Copie os arquivos gerados para o diretório **src/main/resources**.
- Execute o comando `mvn package` para gerar a biblioteca (**municipios)