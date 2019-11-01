package com.unb.opendatagraph.controller;

import com.unb.opendatagraph.domain.Proveniencia;
import com.unb.opendatagraph.service.ProvenanceJsonFile;
import com.unb.opendatagraph.service.ProvenenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProvenanceController {


    private final ProvenenciaService provenenciaService;
    private final ProvenanceJsonFile provenanceJsonFile;

    public ProvenanceController(ProvenenciaService provenenciaService, ProvenanceJsonFile provenanceJsonFile) {
        this.provenenciaService = provenenciaService;
        this.provenanceJsonFile = provenanceJsonFile;
    }

    @GetMapping("/hello")
    public @ResponseBody String getSentence() {
        return "Hello World";
    }

    @PostMapping("/create")
    public void createGraph() throws IOException {
        List<Proveniencia> provenanceData = provenanceJsonFile.readProvenanceData();
        provenenciaService.generateGraph(provenanceData);
    }

    @PostMapping("/generate-json-file")
    public void generateJsonFile(@RequestParam(required = false) Integer size) throws IOException {
        provenanceJsonFile.generateJsonFile(size);
    }

}
