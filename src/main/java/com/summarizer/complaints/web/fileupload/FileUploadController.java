package com.summarizer.complaints.web.fileupload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {

    @PostMapping(value = "/file/voice")
    public String voiceUpload(){
        return "POST TEST";
    }
}