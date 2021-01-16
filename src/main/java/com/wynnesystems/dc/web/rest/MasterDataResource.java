package com.wynnesystems.dc.web.rest;

import com.wynnesystems.dc.service.MasterDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/master-data")
@Slf4j
public class MasterDataResource {

    private MasterDataService masterDataService;

    public MasterDataResource(MasterDataService masterDataService) {
        this.masterDataService = masterDataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Map<String, Object>>> executeSQL(@PathVariable("id") Long id) {
        log.info("Execute Master Data With Id {}", id);
        final List<Map<String, Object>> body = this.masterDataService.executeMasterDataById(id);
        return ResponseEntity.ok(body);
    }

}
