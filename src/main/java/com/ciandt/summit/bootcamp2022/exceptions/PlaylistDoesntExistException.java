package com.ciandt.summit.bootcamp2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlaylistDoesntExistException extends RuntimeException{

    public static final String MESSAGE = "Playlist doesn't exist!";

    public PlaylistDoesntExistException(){
        super(MESSAGE);
    }
}
