package com.salioubah.usermanagement.demo.exception;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class to define proper message
 */
public class ExceptionResponse
{
    private Date timestamp;
    private List<ObjectError> errors;
    public ExceptionResponse(Date timestamp, List<ObjectError> errors)
    {
        super();
        this.timestamp = timestamp;
        this.errors = errors;
    }
    public ExceptionResponse(Date timestamp, String error)
    {
        super();
        this.timestamp = timestamp;

        // Generic behavior to handle a simple error message
        ObjectError oe = new ObjectError("errors", error);
        ArrayList<ObjectError> aoe = new ArrayList<>();
        aoe.add(oe);
        this.errors = aoe;
    }
    public Date getTimestamp()
    {
        return timestamp;
    }
    public List<ObjectError> getErrors()
    {
        return errors;
    }
}
