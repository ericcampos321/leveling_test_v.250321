
# 🚀 Nivelamento Técnico - Java - Web Scraper & Transformação CSV

## 📄 Descrição

Projeto realizado para avaliação técnica, composto por duas etapas:

### Teste 1 - Web Scraper
- Realiza scraping no site da ANS.
- Faz download dos arquivos PDF do Anexo I e II.
- Salva os arquivos na pasta `downloads/`.
- Compacta os arquivos em `.zip` na pasta `zips/`.

### Teste 2 - Transformação CSV
- Extrai dados de um arquivo `.zip` contendo planilhas.
- Converte os dados extraídos para `.csv`.
- Salva o arquivo `.csv` na raiz do projeto.

---

## Estrutura do Projeto

```
├── downloads/                 # PDFs baixados
├── zips/                      # Arquivos ZIP gerados
├── src/
│   └── main/
│       └── java/
│           └── br/com/eric/scraper/
│               ├── controller/           # Controllers dos endpoints
│               ├── service/              # Lógicas de negócio
│               └── utils/                # Utilitários (CSV, ZIP)
├── target/                     # Build gerado
├── pom.xml                     # Dependências Maven
└── README.md                   # Instruções do projeto
```

---

## Como executar

### Pré-requisitos

- Java 17+
- Maven

### Rodando o projeto

1. Clone o repositório:

```bash
git clone <https://github.com/ericcampos321/leveling_test_v.250321.git>
cd leveling_test_v.250321
```

2. Execute o projeto:

Com Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Ou com Maven instalado:

```bash
mvn spring-boot:run
```

O servidor estará disponível em:
```
http://localhost:8080
```

---

## Endpoints

### Teste 1 - Scraper

| Método | Rota                       | Descrição                                        |
|:-----:|:---------------------------:|:-----------------------------------------------:|
| POST  | `/scraper/download`        | Realiza o scraping e download dos arquivos PDF  |

Exemplo:
```http
POST http://localhost:8080/scraper/download
```

### Teste 2 - Transformação CSV

| Método | Rota                          | Descrição                                    |
|:-----:|:------------------------------:|:--------------------------------------------:|
| POST  | `/scraper/transform`          | Extrai e transforma dados ZIP → CSV         |

Exemplo:
```http
POST http://localhost:8080/scraper/transform
```

---

## Funcionalidades

- ✅ Download automático dos PDFs da ANS.
- ✅ Compactação dos arquivos em `.zip`.
- ✅ Extração e conversão dos dados do `.zip` para `.csv`.
- ✅ Organização de código utilizando boas práticas de Java & Spring Boot.

---

## Saídas

- PDFs baixados → `downloads/`
- Arquivo ZIP → `zips/`
- Arquivo CSV → `Anexos_Extraidos.csv` na raiz do projeto

---
