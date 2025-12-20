package com.db.UrlShortenerApplication.Service;

import org.springframework.stereotype.Service;

import com.db.UrlShortenerApplication.Entity.UrlRecord;
import com.db.UrlShortenerApplication.Idgen.GenerateSnokeflakeId;
import com.db.UrlShortenerApplication.Repository.UrlRecordRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShortenService {

    private UrlRecordRepository repository;

    public String ShortUrl(String longUrl){
        Long id=Long.parseLong(GenerateSnokeflakeId.generate(), 2);
		String Encodedurl=ConvertIdinBase62(id);
        String url=Encodedurl.substring(Encodedurl.length()-8);
        UrlRecord rec=new UrlRecord(0, url, longUrl);
        repository.save(rec);
        return url;
    
        
    }

    private String ConvertIdinBase62(Long id){
        int Base=62;
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (id == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            int remainder = (int) (id % Base);
            sb.append(alphabet.charAt(remainder));
            id /= Base;
        }
        return sb.reverse().toString();
    }
}
