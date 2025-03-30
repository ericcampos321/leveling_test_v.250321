package br.com.eric.scraper.service;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import br.com.eric.scraper.utils.CsvUtil;

@Service
public class TransformService {

    private final File pdfAnexo = new File("downloads/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf");
    private final File zipFile = new File("zips/Eric_Campos.zip");

    public void processarTransformacao() {
        try (PDDocument document = PDDocument.load(pdfAnexo)) {
            //extract text from pdf
            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(document);

            //transform into structure
            List<String[]> dados = CsvUtil.extrairTabela(texto);

            //correct abbreviations
            CsvUtil.corrigirAbreviacoes(dados);

            //generate csv
            try (FileOutputStream fos = new FileOutputStream(zipFile); ZipOutputStream zos = new ZipOutputStream(fos); ByteArrayOutputStream baos = new ByteArrayOutputStream(); OutputStreamWriter writer = new OutputStreamWriter(baos, StandardCharsets.UTF_8); BufferedWriter bw = new BufferedWriter(writer)) {

                //write csv to memory
                for (String[] linha : dados) {
                    bw.write(String.join(";", linha));
                    bw.newLine();
                }
                bw.flush();

                //add entry to ZIP file
                ZipEntry entry = new ZipEntry("dados.csv");
                zos.putNextEntry(entry);
                zos.write(baos.toByteArray());
                zos.closeEntry();
            }

            System.out.println("Transformação concluída e arquivo zip gerado.");

        } catch (Exception e) {
            System.err.println("Erro ao processar transformação: " + e.getMessage());
        }
    }
}
