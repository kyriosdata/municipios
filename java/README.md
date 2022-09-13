## Municípios e estados

Biblioteca para acesso a 
municípios (nomes e código IBGE) e estados (nomes e capitais).

Esta biblioteca também estabelece um código único sequencial, de 0 a
5570, para cada município. Assim como também estabelece um código 
único de 0 a 26 a cada um dos estados.

## Gradle 

```groovy
dependencies {
	implementation 'com.github.kyriosdata:municipios:1.0.6'
}
```


## Desenvolvedores (token e deploy)

Criar token a ser fornecido em settings.xml a partir de Settings (usuário),
Developer Settings, Personal Access Tokens. 

- `mvn --batch-mode deploy`
