
# Teste SQL - Intuitlive

## Descrição

Scripts SQL para importação e análise de dados da ANS com base nos demonstrativos contábeis e cadastro de operadoras.

---

## Estrutura

- `create_tables.sql`: Criação das tabelas necessárias.
- `import_data.sql`: Importação dos arquivos CSV para o banco.
- `analytics.sql`: Consultas analíticas para identificar operadoras com maiores despesas.

---

## Como Executar

### 1️Criar Banco de Dados

Execute os comandos abaixo no MySQL:

```sql
CREATE DATABASE ans;
USE ans;
```

---

### 2️ Executar os Scripts

#### Criação das Tabelas

Execute o script:

```sql
source /caminho/para/create_tables.sql;
```

####  Importação dos Dados

Você pode importar de duas formas:

### ➤ Opção 1 - Via arquivo SQL

Execute:

```sql
source /caminho/para/import_data.sql;
```

**Arquivos CSV esperados:**
- Demonstrativos contábeis:  
  `1T2023.csv, 2T2023.csv, 3T2023.csv, 4T2023.csv, 1T2024.csv, 2T2024.csv, 3T2024.csv, 4T2024.csv`
- Cadastro de operadoras:  
  `Relatorio_cadop.csv`

**Atenção:** Verifique se a variável `secure_file_priv` do MySQL permite leitura de arquivos externos:

```sql
SHOW VARIABLES LIKE 'secure_file_priv';
```

Caso configurado, posicione os CSVs na pasta indicada.

---

### ➤ Opção 2 - Importação Manual (MySQL Workbench)

Você também pode importar pelo Workbench:

1. Acesse:  
   `Server → Data Import → Import from CSV File`
2. Selecione o arquivo CSV.
3. Faça o mapeamento das colunas.
4. Marque **First row contains column names**.
5. Execute a importação.

---

##  Consultas Analíticas

O arquivo `analytics.sql` contém duas queries para análise:

1. Top 10 operadoras com maiores despesas em **EVENTOS/SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MÉDICO HOSPITALAR** no **último trimestre**.
2. Top 10 operadoras com maiores despesas nesta categoria no **último ano**.

### 📥 Para executar:

```sql
source /caminho/para/analytics.sql;
```

---

## ⚠️ Observações

- Certifique-se de que os arquivos `.csv` estão no local correto e com encoding **UTF-8**.
- Caso use a importação via `LOAD DATA INFILE`, garanta que o MySQL tenha permissão para ler os arquivos.

---

## Autor

Desenvolvido por **Eric Campos** – Projeto de Nivelamento Técnico.
