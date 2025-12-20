package com.db.UrlShortenerApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ShortenUrlRequestWrapper {
    private String longUrl;
}
