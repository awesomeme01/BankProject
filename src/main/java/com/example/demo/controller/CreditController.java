package com.example.demo.controller;

import com.example.demo.model.Credit;
import com.example.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CreditController.url)
public class CreditController {
    public static final String url = "/api/credits";
    @Autowired
    private CreditService creditService;
    @GetMapping
    public List<Credit> getCredits(){
        return this.creditService.getCredits();
    }
    @GetMapping("/paidCredits")
    public List<Credit> getPaidCredits(){
        return this.creditService.getPaidCredits();
    }
    @GetMapping("/unPaidCredits")
    public List<Credit> getUnPaidCredits(){
        return this.creditService.getUnPaidCredits();
    }
    @GetMapping("/outDatedCredits")
    public List<Credit> getOutDatedCredits(){
        return this.creditService.getOutDatedCredits();
    }
    @GetMapping("/{id}")
    public Credit getCreditById(@PathVariable Long id){
        return this.creditService.getCreditById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Credit createCredit(@RequestBody Credit credit){
        return this.creditService.createCredit(credit);
    }

    
}
