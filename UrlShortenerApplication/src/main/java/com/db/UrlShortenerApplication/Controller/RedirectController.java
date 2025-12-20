package com.db.UrlShortenerApplication.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.db.UrlShortenerApplication.DTO.RedirectResponseWrapper;
import com.db.UrlShortenerApplication.Service.RedirectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RedirectController {

    @Autowired
    private RedirectService redirectservice;


    @GetMapping("redirect")
    public RedirectResponseWrapper getMethodName(@RequestParam String param) {
        if(param!=null){
           return redirectservice.getLongUrlfromUrl(param);
        }
        return null;
    }
    
}
