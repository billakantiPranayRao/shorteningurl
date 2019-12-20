package com.neueda.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_SHORTEN_URL")
public class ShortenUrl {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "original_Url")
    private String originalUrl;

    @Column(name = "shorten_Key")
    private String shortenKey;

    @CreationTimestamp
    @Column(name = "create_time_stamp", updatable = false)
    private LocalDateTime createTimeStamp;

    public ShortenUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenKey() {
        return shortenKey;
    }

    public void setShortenKey(String shortenKey) {
        this.shortenKey = shortenKey;
    }

}
