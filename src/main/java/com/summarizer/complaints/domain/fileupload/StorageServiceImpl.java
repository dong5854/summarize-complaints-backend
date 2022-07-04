package com.summarizer.complaints.domain.fileupload;

import com.summarizer.complaints.config.StorageProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final StorageProperties storageProperties;

    @Override
    public void init() {
        System.out.println("초기화 구현 미완성");
    }

    @Override
    public String store(MultipartFile file) {
        try {
            file.transferTo(new File(storageProperties.getLocation() + file.getOriginalFilename()));
            System.out.println(storageProperties.getLocation() + file.getOriginalFilename());
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e);
            return "저장 실패";
        } catch (IllegalStateException e){
            e.printStackTrace();
            System.out.println(e);
            return "저장 실패";
        }

        return file.getOriginalFilename() + " 저장 성공";
    }

    @Override
    public Stream<Path> loadAll() {
        System.out.println("파일 전부 로드 구현 미완성");
        return null;
    }

    @Override
    public Path load(String filename) {
        System.out.println("파일 하나 로드 구현 미완성");
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        System.out.println("리소스 로드 구현 미완성");
        return null;
    }

    @Override
    public void deleteAll() {
        System.out.println("전부 삭제 구현 미완성");
    }
}
