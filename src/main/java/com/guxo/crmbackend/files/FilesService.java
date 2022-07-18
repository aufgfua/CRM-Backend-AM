package com.guxo.crmbackend.files;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
@Service
public class FilesService {

    @Value("${files.root}")
    private String filesRoot;


    // saves file and returns absolute url
    public String saveFile(MultipartFile file, String name, String directory){

        Path directoryPath = Paths.get(filesRoot, directory); // create path until destiny directory
        Path filePath = directoryPath.resolve(name); // create full path until file

        try {

            Files.createDirectories(directoryPath); // create directory not exists
            file.transferTo(filePath.toAbsolutePath().toFile()); // create file

        } catch (IOException e) {
            throw new RuntimeException("Error while saving file");
        }

        return filePath.toAbsolutePath().toString(); // return file absolute path
    }

}
