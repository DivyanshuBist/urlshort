package com.db.UrlShortenerApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlRecord {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "shortUrl")
    private String shortUrl;

    @Column(name = "longUrl")
    private String longUrl;
}
