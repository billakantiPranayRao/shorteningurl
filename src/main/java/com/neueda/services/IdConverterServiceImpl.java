package com.neueda.services;

import org.springframework.stereotype.Service;

@Service
public class IdConverterServiceImpl implements IdConverterService {

    private static final String POSSIBLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final long BASE = POSSIBLE_ALPHABET.length();


    /*Here I am Generating the shortenKey from integer ID*/
    @Override
    public String idToShortURL(long id) {

        StringBuilder shortenKey = new StringBuilder();
        while (id > 0) {
            shortenKey.insert(0, POSSIBLE_ALPHABET.charAt((int) (id % BASE)));
            id = id / BASE;
        }
        return shortenKey.toString();
    }

    /* Here I am Generating the integer ID back from a shortenKey*/
    @Override
    public long shortURLtoID(String shortenKey) {
        int id = 0;

        for (int i = 0; i < shortenKey.length(); i++)
        {
            if ('a' <= shortenKey.charAt(i) &&
                    shortenKey.charAt(i) <= 'z')
                id = id * 62 + shortenKey.charAt(i) - 'a';
            if ('A' <= shortenKey.charAt(i) &&
                    shortenKey.charAt(i) <= 'Z')
                id = id * 62 + shortenKey.charAt(i) - 'A' + 26;
            if ('0' <= shortenKey.charAt(i) &&
                    shortenKey.charAt(i) <= '9')
                id = id * 62 + shortenKey.charAt(i) - '0' + 52;
        }
        return id;
    }
}
