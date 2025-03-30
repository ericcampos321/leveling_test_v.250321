package br.com.eric.scraper.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.eric.scraper.utils.FileUtil;

@Service
public class ScrapingService {

    private static final Logger logger = LoggerFactory.getLogger(ScrapingService.class);

    private final String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    private final File pastaDownloads = new File("downloads");

    public void processarScraping() {
        try {
            pastaDownloads.mkdirs();
            Document doc = Jsoup.connect(url).get();
            List<File> arquivos = new ArrayList<>();

            for (Element link : doc.select("a[href$=.pdf]")) {
                String texto = link.text().toLowerCase();
                if (texto.contains("anexo i") || texto.contains("anexo ii")) {
                    String href = link.absUrl("href");
                    File arquivo = baixarPdf(href);
                    arquivos.add(arquivo);
                }
            }

            FileUtil.gerarZip(arquivos, new File("zips/Anexos_Extraidos.zip"));
            logger.info("Scraping e compactação concluídos!");

        } catch (IOException e) {
            logger.error("Erro durante o scraping ou download dos arquivos", e);
        }
    }

    private File baixarPdf(String link) throws IOException {
        URL PDFUrl = new URL(link);
        String nome = link.substring(link.lastIndexOf("/") + 1);
        File arquivo = new File(pastaDownloads, nome);

        try (InputStream in = PDFUrl.openStream(); OutputStream out = new FileOutputStream(arquivo)) {
            byte[] buffer = new byte[1024];
            int lido;
            while ((lido = in.read(buffer)) != -1) {
                out.write(buffer, 0, lido);
            }
        }

        logger.info("⬇ PDF Baixado: {}", nome);
        return arquivo;
    }
}
