package com.summarizer.complaints.web.fileupload;

import com.summarizer.complaints.service.fileupload.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final StorageService storageService;

    @PostMapping(value = "/files/voice-file") // 음성 파일 업로드
    public String voiceUpload(@RequestParam("voice-file") MultipartFile file){
        return storageService.store(file);
    }


    @PostMapping(value = "/complaint-summery/list")  // 민원 요약본(텍스트) 조회
    public String PostSummery(@RequestBody("username") String username) throws IOException {
        return storageService.loadByUserName(username);
    }

    @GetMapping(value = "/complaint-summery/list")  // 민원 요약본(텍스트) 조회
    public String GetSummery(@RequestParam("username") String username) throws IOException {
        return storageService.loadByUserName(username);
    }
}