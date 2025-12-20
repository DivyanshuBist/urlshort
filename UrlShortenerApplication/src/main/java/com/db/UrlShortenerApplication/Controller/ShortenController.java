package com.db.UrlShortenerApplication.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.db.UrlShortenerApplication.DTO.ShortenUrlRequestWrapper;
import com.db.UrlShortenerApplication.DTO.ShortenUrlResponseWrapper;
import com.db.UrlShortenerApplication.Service.ShortenService;

import org.springframework.beans.factory.annotation.Autowired;
/*
*/
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ShortenController {

    @Autowired
    private ShortenService shortenService;

    @PostMapping("short")
    public ShortenUrlResponseWrapper Shorten(@RequestBody ShortenUrlRequestWrapper request ) {
        if(request!=null && request.getLongUrl()!=null){
            String shortUrl=shortenService.ShortUrl(request.getLongUrl());

            return new ShortenUrlResponseWrapper(shortUrl);
        }
        return null;//update this
    }
    

}
