package com.mylo.spring.controller.text;

import com.mylo.process.rest.service.RestApiService;
import com.mylo.spring.service.text.TextBO;
import com.mylo.util.aws.DefaultMyloFileUtils;
import com.mylo.util.aws.MyloFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import static com.mylo.domain.type.CvMetaType.CONTENTS;


@Api(tags = "텍스트-API")
@RestController
@RequestMapping("/v1/api/text")
@Slf4j
public class TextController {
    @Autowired
    RestApiService<Response> restApiService;
    @Autowired TextBO textBO;
    private MyloFileUtils myloFileUtils = DefaultMyloFileUtils.getInstance();

    @ApiOperation(value = "유저 정보 API")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
    public Map<String, Object> getTextMetaList(@RequestParam Integer textIdx){

        return getTextMetaList(textIdx);

    }
    @ApiOperation(value = "s3 upload")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void s3FileUpload(@RequestParam MultipartFile file){
        myloFileUtils.uploadMyloFile(CONTENTS, "1", file, false);

        //AmazonUtil.uploadAndReturnUrl(file, path, fileName, "clive-resource");
    }
}
