package br.com.eric.scraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eric.scraper.service.ScrapingService;

@RestController
@RequestMapping("/scraper")
public class ScrapingController {

    @Autowired
    private ScrapingService service;

    @PostMapping("/download")
    public ResponseEntity<?> downloadAnexos() {
        service.processarScraping();
        return ResponseEntity.ok("Scraping e compactação concluídos.");
    }
}
