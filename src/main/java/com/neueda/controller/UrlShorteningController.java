package com.neueda.controller;

import com.neueda.dto.OriginalUrlDto;
import com.neueda.dto.ShortenUrlDto;
import com.neueda.services.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class UrlShorteningController {

    @Autowired
    private ShortenUrlService urlService;

    @PostMapping("/shortenUrl")
    public ResponseEntity<ShortenUrlDto> shortenUrl(@Validated @RequestBody OriginalUrlDto originalUrlDto) {

        return ResponseEntity.ok(new ShortenUrlDto(urlService.shortenUrl(originalUrlDto.getOriginalUrl())));
    }

}
