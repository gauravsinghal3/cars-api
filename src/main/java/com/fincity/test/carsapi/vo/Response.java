package com.fincity.test.carsapi.vo;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import java.util.Date;

public class Response {
    private Date timestamp;
    private String message;
    private String details;

    public Response(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
