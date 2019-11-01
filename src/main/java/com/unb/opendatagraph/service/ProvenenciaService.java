package com.unb.opendatagraph.service;

import com.unb.opendatagraph.domain.CKAN;
import com.unb.opendatagraph.domain.Proveniencia;
import com.unb.opendatagraph.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvenenciaService {

    private final CKANRepository ckanRepository;

    public ProvenenciaService( CKANRepository ckanRepository)
    {
        this.ckanRepository = ckanRepository;
    }

    public void generateGraph(List<Proveniencia> provenanceData) {
        provenanceData.stream().forEach(
                provenance -> {
                    provenance.getEtl().setExtractionSoftwareWasAssociatedWith(provenance.getExtractionSoftware());
                    provenance.getEtl().setInformationSystemsUsed(provenance.getInformationSystems());

                    provenance.getDw().setEtlWasGeneratedBy(provenance.getEtl());
                    provenance.getDw().setInformationSystemsWasDerivedFrom(provenance.getInformationSystems());

                    provenance.getDataPublication().setRdfUsed(provenance.getRdf());
                    provenance.getDataPublication().setUnBGOLDWasAssociatedWith(provenance.getUnbGOLD());

                    provenance.getCsv().setDataRequestWasGeneratedBy(provenance.getDataRequest());
                    provenance.getCsv().setDwWasDerivedFrom(provenance.getDw());

                    provenance.getSemanticIndexing().setCsvUsed(provenance.getCsv());
                    provenance.getSemanticIndexing().setUnBGOLDWasAssociatedWith(provenance.getUnbGOLD());

                    provenance.getRdf().setCsvWasDerivedFrom(provenance.getCsv());
                    provenance.getRdf().setSemanticIndexingWasGeneratedBy(provenance.getSemanticIndexing());

                    provenance.getDataPublication().setRdfUsed(provenance.getRdf());
                    provenance.getDataPublication().setUnBGOLDWasAssociatedWith(provenance.getUnbGOLD());

                    provenance.getCkan().setDataPublicationWasGeneratedBy(provenance.getDataPublication());
                    provenance.getCkan().setRdfWasDerivedFrom(provenance.getRdf());

                    ckanRepository.save(provenance.getCkan());
                }
        );
    }
}
