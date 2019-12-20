package com.neueda.services;

import com.neueda.model.ShortenUrl;

import java.util.Optional;

public interface ShortenUrlService {

    String shortenUrl(String originalUrl);

    Optional<ShortenUrl> getShortenUrl(String shortenKey);
}
