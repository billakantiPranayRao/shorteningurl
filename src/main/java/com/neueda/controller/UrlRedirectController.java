package com.neueda.controller;

import com.neueda.services.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/short")
public class UrlRedirectController {

    @Autowired
    private ShortenUrlService shortenUrlServiceurlService;

    @GetMapping("/{shortenStr}")
    public ModelAndView redirectToOriginalUrl(@PathVariable("shortenStr") String shortenStr) {
        return shortenUrlServiceurlService.getShortenUrl(shortenStr)
                .map(shortenUrl -> new ModelAndView("redirect:" + shortenUrl.getOriginalUrl()))
                .orElseGet(() -> new ModelAndView("url_not_found"));
    }

}
