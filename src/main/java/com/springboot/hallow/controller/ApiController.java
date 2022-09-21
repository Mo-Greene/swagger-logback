package com.springboot.hallow.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @ApiOperation(value = "GET 메서드", notes = "@RequestParam 활용")
    @GetMapping(value = "/request")
    public String getRequestParam(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }

}
