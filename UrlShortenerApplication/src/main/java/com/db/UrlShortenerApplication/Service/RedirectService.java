package com.db.UrlShortenerApplication.Service;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.db.UrlShortenerApplication.DTO.RedirectResponseWrapper;
import com.db.UrlShortenerApplication.Entity.UrlRecord;
import com.db.UrlShortenerApplication.Repository.UrlRecordRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RedirectService {

    private UrlRecordRepository repository;

    public RedirectResponseWrapper getLongUrlfromUrl(String shorturl){
        Optional<String> cached=CheckCacheData(shorturl);
        if(cached.isPresent()){
            return new RedirectResponseWrapper(cached.get(),"HIT");
        }

        Optional<String> dbcheck=CheckDatabase(shorturl);
        if(dbcheck.isPresent()){
            return new RedirectResponseWrapper(dbcheck.get(),"MISS");
        }

       throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL not found");
    }

    private Optional<String> CheckCacheData(String shortstr){
        return Optional.empty();
    }

    private Optional<String> CheckDatabase(String shortstr){
        return repository.findByShortUrl(shortstr)
        .map(UrlRecord::getLongUrl);
        
        
    }
}
