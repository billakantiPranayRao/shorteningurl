package com.neueda.services;

import com.neueda.dao.ShortenUrlRepository;
import com.neueda.model.ShortenUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ShortenUrlServiceImpl implements ShortenUrlService {

    @Value("${base.url}")
    private String BASE_URL;

    @Value("${shorten.url.prefix}")
    private String SHORTEN_URL_PREFIX;

    @Autowired
    private ShortenUrlRepository shortenUrlRepository;

    @Autowired
    private IdConverterService idConverterService;

    @Override
    public String shortenUrl(String originalUrl) {
        return BASE_URL.concat(SHORTEN_URL_PREFIX).concat(shortenUrlRepository.findByOriginalUrl(originalUrl)
                .orElseGet(() -> saveShortenUrl(originalUrl))
                .getShortenKey());
    }

    private ShortenUrl saveShortenUrl(String originalUrl) {

        ShortenUrl url = shortenUrlRepository.save(new ShortenUrl(originalUrl));

        String shortenKey = idConverterService.idToShortURL(url.getId());

        url.setShortenKey(shortenKey);

        return url;
    }

    @Override
    public Optional<ShortenUrl> getShortenUrl(String shortenKey) {
        return shortenUrlRepository.findById(idConverterService.shortURLtoID(shortenKey));
    }
}
