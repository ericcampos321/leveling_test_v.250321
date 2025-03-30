-- Data: 2025-03-30
-- Autor: Eric Campos

-- Importação dos dados contábeis
LOAD DATA INFILE 'C:/projetos/repositorio/LEVELING_TEST_V.250321/mysql_teste_eric_campos/csv/2023/1T2023.csv'
INTO TABLE demonstracoes_contabeis
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ano, trimestre, data, reg_ans, cd_conta_contabil, descricao, vl_saldo_inicial, vl_saldo_final);
-- (Faça o mesmo para 2T2023 3T2023.csv, 4T2023.csv, 1T2024.csv, 1T2024.csv, 2T2024.csv, 3T2024.csv, 4T2024.csv etc.)

-- Atenção
-- O arquivo CSV deve estar no mesmo diretório do arquivo SQL
LOAD DATA INFILE 'C:/projetos/repositorio/LEVELING_TEST_V.250321/mysql_teste_eric_campos/csv/relatorio/Relatorio_cadop.csv'
INTO TABLE operadoras
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(reg_ans, cnpj_operadora, nome_operadora, nome_fantasia, modalidade, logradouro, numero, complemento, bairro, cidade, uf, cep, ddd, telefone, fax, endereco_eletronico, representante, cargo_representante, regiao_comercializacao, data_registro_ans);


-- Importação dos dados das operadoras
LOAD DATA INFILE 'C:/projetos/repositorio/LEVELING_TEST_V.250321/mysql_teste_eric_campos/csv/relatorio/Relatorio_cadop.csv'
INTO TABLE operadoras
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(reg_ans, cnpj_operadora, nome_operadora, modalidade, logradouro, numero, complemento, bairro, cidade, uf, cep, ddd, telefone, fax, endereco_eletronico, representante, cargo_representante, regiao_comercializacao, data_registro_ans);
