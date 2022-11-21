package com.mylo.spring.controller.video;

import com.mylo.spring.service.video.VideoBO;
import com.mylo.util.aws.DefaultMyloFileUtils;
import com.mylo.util.aws.MyloFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Api(tags = "비디오-API")
@RestController
@RequestMapping("/v1/api/video")
@Slf4j
public class VideoController {
    @Autowired VideoBO videoBO;
    private MyloFileUtils myloFileUtils = DefaultMyloFileUtils.getInstance();

    @ApiOperation(value = "유저 정보 API")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
    public Map<String, Object> getVideoMetaList(@RequestParam Integer videoIdx){
        return videoBO.getVideoMetaList(videoIdx);
    }
//    @ApiOperation(value = "s3 upload")
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public void s3FileUpload(@RequestParam MultipartFile file){
//        myloFileUtils.uploadMyloFile(CONTENTS, "1", file, false);
//
//        //AmazonUtil.uploadAndReturnUrl(file, path, fileName, "clive-resource");
//    }
}
