# Teste SQL - Intuitlive

## Descrição
Scripts SQL para importação e análise de dados da ANS com base nos demonstrativos contábeis e cadastro de operadoras.

## Estrutura

- `create_tables.sql`: Criação das tabelas.
- `import_data.sql`: Importação dos arquivos CSV.
- `analytics.sql`: Query que retorna o top 10 operadoras com maiores despesas em eventos médicos.

## Como executar

1. Crie um banco no MySQL:
```sql
CREATE DATABASE ans;
USE ans;

2. Executar os scripts
-Criação das tabelas
Execute o script de criação das tabelas:

sql
source /caminho/para/create_tables.sql;
-Importação dos dados
Você pode realizar a importação de duas formas:

➤ Opção 1 - Via arquivo SQL
Utilizando os comandos prontos no arquivo:

sql
source /caminho/para/import_data.sql;
Esse arquivo contém comandos LOAD DATA INFILE apontando para:

Demonstrativos contábeis:
1T2023.csv, 2T2023.csv, 3T2023.csv, 4T2023.csv, 1T2024.csv, 2T2024.csv, 3T2024.csv, 4T2024.csv

Cadastro de operadoras:
Relatorio_cadop.csv

 'Importante'
Verifique se a variável secure_file_priv do MySQL permite leitura de arquivos externos:

sql
SHOW VARIABLES LIKE 'secure_file_priv';
Se estiver configurado, os CSVs devem estar na pasta indicada por ele.
Caso contrário, ajuste as permissões ou utilize a importação manual.

➤ Opção 2 - Importação Manual (MySQL Workbench)
Você também pode importar os dados pelo próprio MySQL Workbench:

Clique em:
Server → Data Import → Import from CSV File

Selecione o arquivo CSV.

Faça o mapeamento das colunas.

Marque a opção "First row contains column names".

Execute a importação.

Essa opção pode ser usada caso não tenha permissão para rodar LOAD DATA INFILE.

Consultas Analíticas
-arquivo analytics.sql você encontrará duas queries para responder:

Quais as 10 operadoras com maiores despesas em "EVENTOS/SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MÉDICO HOSPITALAR" no último trimestre.

Quais as 10 operadoras com maiores despesas nessa categoria no último ano.

Para executar:
sql
source /caminho/para/analytics.sql;

Observação
Os arquivos CSV devem estar no caminho correto indicado no script import_data.sql ou no caminho configurado pelo MySQL (secure_file_priv).

Caso opte pela importação manual, configure corretamente o mapeamento das colunas.

Verifique se o encoding dos arquivos CSV está em UTF-8.