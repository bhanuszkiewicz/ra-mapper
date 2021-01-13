package com.bartoszhanuszkiewicz.ramapper.infrastructure;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bartoszhanuszkiewicz.ramapper.domain.MappingFacade;

@RestController
public class MapperController {

    private final MappingFacade mappingFacade;

    public MapperController(MappingFacade mappingFacade) {
        this.mappingFacade = mappingFacade;
    }

    @GetMapping("/{mappingName}/map")
    ResponseEntity<MappingResultRestDto> findDivisorsAndMap(@PathVariable String mappingName, @RequestBody MappingReqestDto mappingReqestDto){
        return ResponseEntity.ok(new MappingResultRestDto(mappingFacade.calculateDivisorsAndMap(mappingReqestDto.getNumbers(), mappingName)));
    }

}
