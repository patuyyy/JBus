package com.raihanMuhammadIhsanJBusAF.controller;

/**
 * A generic class for handling responses with success status, a message, and a payload.
 *
 * @param <T> the type of the payload
 */
public class BaseResponse<T> {
    /**
     * Indicates whether the operation was successful.
     */
    public boolean success;
    /**
     * A message providing additional information about the operation result.
     */
    public String message;
    /**
     * The payload containing the data related to the operation.
     */
    public T payload;
    /**
     * Constructs a BaseResponse with the specified success status, message, and payload.
     *
     * @param success whether the operation was successful
     * @param message additional information about the operation result
     * @param payload the payload containing the data related to the operation
     */
    public BaseResponse(boolean success, String message, T payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }
}
