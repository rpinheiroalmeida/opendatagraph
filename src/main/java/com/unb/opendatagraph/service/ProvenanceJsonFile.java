package com.unb.opendatagraph.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.unb.opendatagraph.domain.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProvenanceJsonFile {
    private static final int DEFAULT_SIZE = 1;

    public List<Proveniencia> readProvenanceData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream fileInputStream = new FileInputStream("proveniencia.json");
        List<Proveniencia> proveniencia = Arrays.asList(mapper.readValue(fileInputStream, Proveniencia[].class));

        return proveniencia;
    }

    public void generateJsonFile(Integer size) throws IOException {
        List<Proveniencia> proveniencias = gerarProveniencia(size == null ? DEFAULT_SIZE : size);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        FileOutputStream fileOutputStream = new FileOutputStream("proveniencia.json");
        mapper.writeValue(fileOutputStream, proveniencias);
        fileOutputStream.close();

    }

    private List<Proveniencia> gerarProveniencia(Integer size) {

        List<Proveniencia> proveniencias = new ArrayList<Proveniencia>();

        for(int i = 0; i < size; i++) {
            Proveniencia proveniencia = new Proveniencia();

            ExtractionSoftware extractionSoftware = new ExtractionSoftware();
            extractionSoftware.setName("Extraction Software "+i);
            extractionSoftware.setOrganization("UnB");
            extractionSoftware.setDescription("Data extraction from Graduation Systems");
            extractionSoftware.setOperador("Luiz Martins");
            extractionSoftware.setNotes("Not applicable");
            proveniencia.setExtractionSoftware(extractionSoftware);


            UnBGOLD unBGOLD = new UnBGOLD();
            unBGOLD.setName("UnBGOLD "+i);
            unBGOLD.setOrganization("UnB");
            unBGOLD.setDescription("Perform semantic indexing of data");
            unBGOLD.setOperator("Luiz Martins");
            unBGOLD.setNotes("Not applicable");
            proveniencia.setUnbGOLD(unBGOLD);

            ETL etl = new ETL();
            etl.setName("Enviroment ETL "+i);
            etl.setProgram("Pentaho PDI");
            etl.setVersion("7.1");
            etl.setDescription("Extract, Clean of DB SIGRA");
            etl.setStartAtTime("2018-03-10 20:21:27");
            etl.setEndAtTime("2018-03-10 20:24:29");
            etl.setSoftware("MS SQL Server");
            etl.setNotes("Not applicable");
            proveniencia.setEtl(etl);


            DataRequest dataRequest = new DataRequest();
            dataRequest.setName("Data Request "+i);
            dataRequest.setProgram("UnBGOLD");
            dataRequest.setVersion("0.9 Beta");
            dataRequest.setDescription("CSV request for indexing");
            dataRequest.setStartAtTime("2018-03-10 20:30:23");
            dataRequest.setEndAtTime("2018-03-10 20:30:38");
            dataRequest.setSoftware("Java");

            List<String> requests = new ArrayList<String>();
            requests.add("http://servicos.unb.br/dadosabertos/departamentos");
            requests.add("http://servicos.unb.br/dadosabertos/cursos");
            requests.add("http://servicos.unb.br/dadosabertos/professores");
            requests.add("http://servicos.unb.br/dadosabertos/disciplinas");
            requests.add("http://servicos.unb.br/dadosabertos/oferta");
            requests.add("http://servicos.unb.br/dadosabertos/fluxo");
            dataRequest.setRequest(requests);

            proveniencia.setDataRequest(dataRequest);

            SemanticIndexing semanticIndexing = new SemanticIndexing();
            semanticIndexing.setName("Semantic Indexing "+i);
            semanticIndexing.setProgram("UnBGOLD");
            semanticIndexing.setVersion("0.9 Beta");
            semanticIndexing.setDescription("Uses CSV for indexing and generates RDF");
            semanticIndexing.setStartAtTime("2018-03-10 20:32:23");
            semanticIndexing.setEndAtTime("2018-03-10 20:32:54");
            semanticIndexing.setSoftware("Application Server");

            List<String> controledVocabulary = new ArrayList<String>();
            requests.add("FOAF");
            requests.add("DC");
            requests.add("GCIEO");
            requests.add("LUBM");
            requests.add("AIISO");
            semanticIndexing.setControledVocabulary(controledVocabulary);

            proveniencia.setSemanticIndexing(semanticIndexing);


            DataPublication dataPublication = new DataPublication();
            dataPublication.setName("Data Publication "+i);
            dataPublication.setProgram("CKAN");
            dataPublication.setVersion("0.9 Beta");
            dataPublication.setDescription("Publication in the CKAN instance");
            dataPublication.setStartAtTime("2018-03-10 20:35:20");
            dataPublication.setEndAtTime("2018-03-10 20:36:20");
            dataPublication.setSoftware("CKAN");
            dataPublication.setCkanInstance("Dados Abertos da UnB");

            proveniencia.setDataPublication(dataPublication);

            InformationSystems informationSystems = new InformationSystems();
            informationSystems.setName("Information Systems "+i);
            informationSystems.setSize("15 GB");
            informationSystems.setDescription("DB of graduation Systems");
            informationSystems.setLocation("SIGRA");
            informationSystems.setNotes("Not Applicable");

            proveniencia.setInformationSystems(informationSystems);


            DW dw = new DW();
            dw.setName("DW "+i);
            dw.setSize("4,2 GB");
            dw.setDescription("DB generated from the ETL process on SIGRA");
            dw.setLocation("MS SQL Server");
            dw.setNotes("Not Applicable");

            proveniencia.setDw(dw);

            CSV csv = new CSV();
            csv.setName("CSV/JSON "+i);
            csv.setSize("112 k");
            csv.setDescription("CSV file extracted");
            csv.setLocation("Application Server");
            csv.setNotes("Not Applicable");

            proveniencia.setCsv(csv);

            RDF rdf = new RDF();
            rdf.setName("RDF "+i);
            rdf.setSize("140 k");
            rdf.setDescription("RDF file generated");
            rdf.setLocation("Application Server");
            rdf.setNotes("Not Applicable");

            proveniencia.setRdf(rdf);

            CKAN ckan = new CKAN();
            ckan.setName("CKAN "+i);
            ckan.setSize("Not Applicable");
            ckan.setDescription("Data published on the plataform");
            ckan.setLocation("CKAN");
            ckan.setNotes("Not Applicable");

            proveniencia.setCkan(ckan);

            proveniencias.add(proveniencia);

        }

        return proveniencias;
    }

}
