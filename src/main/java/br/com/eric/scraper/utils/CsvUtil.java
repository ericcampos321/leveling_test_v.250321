package br.com.eric.scraper.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvUtil {

    public static List<String[]> extrairTabela(String texto) {
        List<String[]> linhas = new ArrayList<>();
        String[] todasLinhas = texto.split("\n");

        for (String linha : todasLinhas) {
            if (linha.contains("OD") || linha.contains("AMB")) { //ajust layout
                String[] colunas = linha.trim().split("\\s{2,}");
                linhas.add(colunas);
            }
        }
        return linhas;
    }

    public static void corrigirAbreviacoes(List<String[]> dados) {
        for (String[] linha : dados) {
            for (int i = 0; i < linha.length; i++) {
                linha[i] = linha[i].replace("OD", "Operadora de Saúde");
                linha[i] = linha[i].replace("AMB", "Associação Médica Brasileira");
            }
        }
    }

    public static void salvarCsv(List<String[]> dados, File arquivo) throws Exception {
        try (FileWriter writer = new FileWriter(arquivo); CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (String[] linha : dados) {
                printer.printRecord((Object[]) linha);
            }
        }
    }
}
