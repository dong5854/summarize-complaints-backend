package com.summarizer.complaints.domain.fileupload;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();
    String store(MultipartFile file);
    Stream<Path> loadAll();
    Path load(String filename);
    String loadByUserName(String userid) throws IOException;
    Resource loadAsResource(String filename);
    void deleteAll();

}
