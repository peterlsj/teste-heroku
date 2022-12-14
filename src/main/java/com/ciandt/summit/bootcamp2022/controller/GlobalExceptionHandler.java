package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.dto.ErrorDto;
import com.ciandt.summit.bootcamp2022.exceptions.MinLengthRequiredException;
import com.ciandt.summit.bootcamp2022.exceptions.MusicDoesntExistException;
import com.ciandt.summit.bootcamp2022.exceptions.MusicDoesntExistInPlaylistException;
import com.ciandt.summit.bootcamp2022.exceptions.NoContentException;
import com.ciandt.summit.bootcamp2022.exceptions.PlaylistDoesntExistException;
import com.ciandt.summit.bootcamp2022.exceptions.UnauthorizedAccessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MinLengthRequiredException.class)
    public ResponseEntity<ErrorDto> handleMinRequiredException(MinLengthRequiredException exception) {
        log.error("MinLengthRequiredException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(value = NoContentException.class)
    public ResponseEntity<ErrorDto> handleNoContentException(NoContentException exception) {
        log.error("NoContentException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.NO_CONTENT)
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorDto);
    }

    @ExceptionHandler(value = UnauthorizedAccessException.class)
    public ResponseEntity<ErrorDto> handleUnauthorizedAccessException(UnauthorizedAccessException exception) {
        log.error("UnauthorizedAccessException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.UNAUTHORIZED)
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(NullPointerException exception) {
        log.error("NullPointerException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(value = MusicDoesntExistException.class)
    public ResponseEntity<ErrorDto> handlerMusicDoesntExistException(MusicDoesntExistException exception) {
        log.error("MusicDoesntExistException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(value = PlaylistDoesntExistException.class)
    public ResponseEntity<ErrorDto> handlerPlaylistDoesntExistException(PlaylistDoesntExistException exception) {
        log.error("PlaylistDoesntExistException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(value = MusicDoesntExistInPlaylistException.class)
    public ResponseEntity<ErrorDto> handleMusicDoesntExistInPlaylistException(MusicDoesntExistInPlaylistException exception) {
        log.error("MusicDoesntExistInPlaylistException: {}",exception.getMessage());
        var errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }
}
