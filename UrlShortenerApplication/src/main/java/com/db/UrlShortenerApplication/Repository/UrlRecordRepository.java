package com.db.UrlShortenerApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.UrlShortenerApplication.Entity.UrlRecord;
import java.util.Optional;


@Repository
public interface UrlRecordRepository extends JpaRepository<UrlRecord,Integer> {
    Optional<UrlRecord> findByShortUrl(String shortUrl);
}
