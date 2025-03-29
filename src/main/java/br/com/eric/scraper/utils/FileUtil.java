package br.com.eric.scraper.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    public static void gerarZip(List<File> arquivos, File destino) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(destino); ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            for (File arquivo : arquivos) {
                try (FileInputStream fis = new FileInputStream(arquivo)) {
                    ZipEntry zipEntry = new ZipEntry(arquivo.getName());
                    zipOut.putNextEntry(zipEntry);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                }
            }
        }
    }
}
