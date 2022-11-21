package com.mylo.spring.controller.excel;

import com.mylo.process.rest.service.RestApiService;
import com.mylo.spring.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;

@Api(tags = "엑셀-API")
@RestController
@RequestMapping("/v1/api/excel")
@Slf4j
public class ExcelController {

    @Autowired
    RestApiService<Response> restApiService;
    @Autowired
    ExcelService excelBO;

    @ApiOperation(value = "download")
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void excelDownload(HttpServletRequest request, HttpServletResponse response)throws IOException{
        ExcelService.excelDownload(request, response);
    }






}


