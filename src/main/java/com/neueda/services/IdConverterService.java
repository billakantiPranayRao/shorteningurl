package com.neueda.services;

public interface IdConverterService {

    String idToShortURL(long num);

    long shortURLtoID(String shortenKey);
}
