-- 3.5.1: Top 10 operadoras com maiores despesas em "EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS..."
SELECT 
    o.nome_operadora,
    SUM(dc.vl_saldo_final) AS total_despesas
FROM demonstracoes_contabeis dc
JOIN operadoras o ON dc.reg_ans = o.reg_ans
WHERE dc.categoria_despesa IN (
    'EVENTOS/ SINISTROS CONHECIDOS',
    'AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
)
GROUP BY o.nome_operadora
ORDER BY total_despesas DESC
LIMIT 10;

-- 3.5.2: ... no último ano (ex: 2024)

SELECT 
    o.nome_operadora,
    SUM(dc.vl_saldo_final) AS total_despesas
FROM demonstracoes_contabeis dc
JOIN operadoras o ON dc.reg_ans = o.reg_ans
WHERE dc.categoria_despesa IN (
    'EVENTOS/ SINISTROS CONHECIDOS',
    'AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
)
AND dc.ano = 2024
AND dc.trimestre = '4T'
GROUP BY o.nome_operadora
ORDER BY total_despesas DESC
LIMIT 10;
