package com.summarizer.complaints.web.fileupload;

import com.summarizer.complaints.domain.fileupload.StorageService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final StorageService storageService;

    @PostMapping(value = "/files/voice")
    public String voiceUpload(@RequestParam("voice-file") MultipartFile file){
        return storageService.store(file);
    }

    @GetMapping(value = "/complaint-summery/list")
    public String SearchSummery(@RequestParam("username") String username) throws IOException {
        return storageService.loadByUserName(username);
    }
}