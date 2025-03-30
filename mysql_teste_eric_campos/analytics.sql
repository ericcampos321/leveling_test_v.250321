-- 3.5.1: Top 10 operadoras com maiores despesas em "EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS..."
SELECT nome_operadora, SUM(valor) AS total_despesas
FROM demonstracoes_contabeis
WHERE categoria_despesa LIKE '%EVENTOS/ SINISTROS%'
GROUP BY nome_operadora
ORDER BY total_despesas DESC
LIMIT 10;

-- 3.5.2: ... no último ano (ex: 2024)

SELECT 
o.nome_operadora,
SUM(dc.vl_saldo_final) AS total_despesas
FROM demonstracoes_contabeis dc
JOIN operadoras o ON dc.reg_ans = o.reg_ans
WHERE dc.descricao LIKE '%EVENTOS/SINISTROS CONHECIDOS%'
AND dc.ano = 2024
GROUP BY o.nome_operadora
ORDER BY total_despesas DESC
LIMIT 10;
