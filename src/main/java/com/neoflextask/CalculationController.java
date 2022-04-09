package com.neoflextask;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculation/")
@Api(value = "calculation",tags = "calculation API")
public class CalculationController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 200;
    private static final int TEAPOT_FAILURE = 418;

    @GetMapping("/")
    @ApiOperation(value = "test option",response = BaseResponse.class)
    @ApiResponses(value={
            @ApiResponse(code=CODE_SUCCESS,message = "success")
    })
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS, Integer.MIN_VALUE);
    }

    @GetMapping("/sum")
    @ApiOperation(value = "Return the result of the addition",response = BaseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code=CODE_SUCCESS,message = SUCCESS_STATUS),
            @ApiResponse(code=TEAPOT_FAILURE,message = ERROR_STATUS)
    })
    public BaseResponse sum(@RequestParam Integer first, @RequestParam Integer second) {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS, first + second);
    }

    @GetMapping("/dif")
    @ApiOperation(value = "Return the result of the subtraction",response = BaseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code=CODE_SUCCESS,message = SUCCESS_STATUS),
            @ApiResponse(code=TEAPOT_FAILURE,message = ERROR_STATUS)
    })
    public BaseResponse dif(@RequestParam Integer first, @RequestParam Integer second) {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS, first - second);
    }

    @GetMapping("/prod")
    @ApiOperation(value = "Return the result of the multiplication",response = BaseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code=CODE_SUCCESS,message = SUCCESS_STATUS),
            @ApiResponse(code=TEAPOT_FAILURE,message = ERROR_STATUS)
    })
    public BaseResponse prod(@RequestParam Integer first, @RequestParam Integer second) {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS, first * second);
    }

    @GetMapping("/quot")
    @ApiOperation(value = "Return the result of the division",response = BaseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code=CODE_SUCCESS,message = SUCCESS_STATUS),
            @ApiResponse(code=TEAPOT_FAILURE,message = ERROR_STATUS)
    })
    public BaseResponse quot(@RequestParam Integer first, @RequestParam Integer second) {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS, first / second);
    }

    @ExceptionHandler(Throwable.class)
    public BaseResponse handleException(Throwable e) {
        System.err.println(e.getMessage());
        return new BaseResponse(ERROR_STATUS, TEAPOT_FAILURE, Integer.MIN_VALUE);
    }
}
