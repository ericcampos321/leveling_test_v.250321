-- Tabela demonstracoes_contabeis
CREATE TABLE demonstracoes_contabeis (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ano INT,
    trimestre VARCHAR(10),
    data DATE,
    reg_ans INT,
    cd_conta_contabil VARCHAR(20),
    descricao TEXT,
    vl_saldo_inicial DECIMAL(18,2),
    vl_saldo_final DECIMAL(18,2)
);

-- Tabela operadoras
CREATE TABLE operadoras_ativas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reg_ans INT,
    cnpj_operadora VARCHAR(20),
    nome_operadora VARCHAR(255),
    nome_fantasia VARCHAR(255),
    modalidade VARCHAR(100),
    logradouro VARCHAR(255),
    numero VARCHAR(20),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    cep VARCHAR(20),
    ddd VARCHAR(5),
    telefone VARCHAR(50),
    fax VARCHAR(50),
    endereco_eletronico VARCHAR(255),
    representante VARCHAR(100),
    cargo_representante VARCHAR(100),
    regiao_comercializacao VARCHAR(100),
    data_registro_ans DATE
);