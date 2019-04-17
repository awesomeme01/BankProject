package com.example.demo.controller;

import com.example.demo.model.Credit;
import com.example.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(CreditController.url)
public class CreditController {
    public static final String url = "/api/credits";
    @Autowired
    private CreditService creditService;
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Credit> getCredits(){
        return this.creditService.getCredits();
    }
    @GetMapping(path = "/paidCredits",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Credit> getPaidCredits(){
        return this.creditService.getPaidCredits();
    }
    @GetMapping(path = "/unPaidCredits",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Credit> getUnPaidCredits(){
        return this.creditService.getUnPaidCredits();
    }
    @GetMapping(path = "/outDatedCredits",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Credit> getOutDatedCredits(){
        return this.creditService.getOutDatedCredits();
    }
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Credit getCreditById(@PathVariable Long id){
        return this.creditService.getCreditById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Credit createCredit(@RequestBody Credit credit){
        return this.creditService.createCredit(credit);
    }

    
}
