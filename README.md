
# Spring Boot - Web Scraper

## Como rodar

1. Abra o terminal na raiz do projeto
2. Rode o comando:

```bash
./mvnw spring-boot:run
```

Ou com Maven instalado:

```bash
mvn spring-boot:run
```

## Testar via Postman

- Método: POST
- URL: `http://localhost:8080/scraper/download`

## O que faz

- Acessa o site da ANS
- Faz download dos arquivos PDF do Anexo I e II
- Salva em `downloads/`
- Compacta em `zips/name.zip`

