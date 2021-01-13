package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import java.util.List;

import com.bartoszhanuszkiewicz.ramapper.domain.MappingResult;

public class MappingResultRestDto {

    private List<MappingResult> mappingResults;

    public MappingResultRestDto(List<MappingResult> mappingResults) {
        this.mappingResults = mappingResults;
    }

    public List<MappingResult> getMappingResults() {
        return mappingResults;
    }
}
