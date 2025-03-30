package br.com.eric.scraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eric.scraper.service.TransformService;

@RestController
@RequestMapping("/transform")
public class TransformController {

    @Autowired
    private TransformService service;

    @PostMapping("/dados")
    public ResponseEntity<String> transformarDados() {
        service.processarTransformacao();
        return ResponseEntity.ok("Transformação concluída e arquivo zip gerado.");
    }
}
