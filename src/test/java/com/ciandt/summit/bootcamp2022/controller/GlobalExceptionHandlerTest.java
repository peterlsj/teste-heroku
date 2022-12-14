package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.dto.ErrorDto;
import com.ciandt.summit.bootcamp2022.exceptions.MinLengthRequiredException;
import com.ciandt.summit.bootcamp2022.exceptions.MusicDoesntExistException;
import com.ciandt.summit.bootcamp2022.exceptions.MusicDoesntExistInPlaylistException;
import com.ciandt.summit.bootcamp2022.exceptions.NoContentException;
import com.ciandt.summit.bootcamp2022.exceptions.PlaylistDoesntExistException;
import com.ciandt.summit.bootcamp2022.exceptions.UnauthorizedAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static com.ciandt.summit.bootcamp2022.tests.Factory.MESSAGE_BAD_REQUEST_PAYLOAD;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class GlobalExceptionHandlerTest {
    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    @DisplayName("When argument size is less than three then return MinLengthRequiredException ")
    void whenLenghtLessThenThreeThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handleMinRequiredException(new MinLengthRequiredException());

        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
        assertEquals(400, error.getStatusCodeValue());
        assertEquals(MinLengthRequiredException.MESSAGE, Objects.requireNonNull(error.getBody()).getMessage());
    }

    @Test
    @DisplayName("When argument is not found on the Database then return NoContentException")
    void whenArgumentNotFoundThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handleNoContentException(new NoContentException());

        assertEquals(HttpStatus.NO_CONTENT, error.getStatusCode());
        assertEquals(204, error.getStatusCodeValue());
        assertEquals(NoContentException.MESSAGE, Objects.requireNonNull(error.getBody()).getMessage());
    }

    @Test
    @DisplayName("When user has not the rights then return UnauthorizedAccessException")
    void whenUserHasNotTheRightsThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handleUnauthorizedAccessException(new UnauthorizedAccessException());

        assertEquals(HttpStatus.UNAUTHORIZED, error.getStatusCode());
        assertEquals(401, error.getStatusCodeValue());
        assertEquals(UnauthorizedAccessException.MESSAGE, Objects.requireNonNull(error.getBody()).getMessage());
    }

    @Test
    @DisplayName("When payload body incorrect then return NullPointerException")
    void whenPayloadBodyIncorrectThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handleNullPointerException(new NullPointerException(MESSAGE_BAD_REQUEST_PAYLOAD));

        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
        assertEquals(400, error.getStatusCodeValue());
        assertEquals(MESSAGE_BAD_REQUEST_PAYLOAD, Objects.requireNonNull(error.getBody()).getMessage());
    }

    @Test
    @DisplayName("When music doesnt exist then return MusicDoesntExistException")
    void whenMusicDoesntExistThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handlerMusicDoesntExistException(new MusicDoesntExistException());

        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
        assertEquals(400, error.getStatusCodeValue());
        assertEquals(MusicDoesntExistException.MESSAGE, Objects.requireNonNull(error.getBody()).getMessage());
    }

    @Test
    @DisplayName("When playlist doesnt exist then return PlaylistDoesntExistException")
    void whenPlaylistDoesntExistThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handlerPlaylistDoesntExistException(new PlaylistDoesntExistException());

        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
        assertEquals(400, error.getStatusCodeValue());
        assertEquals(PlaylistDoesntExistException.MESSAGE, Objects.requireNonNull(error.getBody()).getMessage());
    }

    @Test
    @DisplayName("When music doesnt exist in playlist then return MusicDoesntExistInPlaylistException")
    void whenMusicDoesntExistInPlaylistExceptionThenReturnResponseEntity(){

        ResponseEntity<ErrorDto> error = globalExceptionHandler
                .handleMusicDoesntExistInPlaylistException(new MusicDoesntExistInPlaylistException());

        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
        assertEquals(400, error.getStatusCodeValue());
        assertEquals(MusicDoesntExistInPlaylistException.MESSAGE, Objects.requireNonNull(error.getBody()).getMessage());
    }
}
