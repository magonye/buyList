package com.mike.buyList.place.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mike on 9/8/15.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="Place already exists")
public class PlaceAlreadyExistException extends Exception {
}
