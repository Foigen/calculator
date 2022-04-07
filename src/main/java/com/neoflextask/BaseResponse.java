package com.neoflextask;

import io.swagger.annotations.ApiModelProperty;

public class BaseResponse {
    @ApiModelProperty(notes="request execution status")
    private final String status;
    @ApiModelProperty(notes = "request code")
    private final Integer resCode;
    @ApiModelProperty(notes = "result of a mathematical operation, in case of an error it also return Integer.MIN_VALUE")
    private final Integer result;

    public BaseResponse(String status, Integer resCode, Integer result) {
        this.status = status;
        this.resCode = resCode;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public Integer getResCode() {
        return resCode;
    }

    public Integer getResult() {
        return result;
    }
}
