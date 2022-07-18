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

    @Value("${files.public}")
    private String publicFiles;
    @Value("${files.user-uploaded}")
    private String userUploaded;


    // saves file and returns absolute url
    public String saveFile(MultipartFile file, String fileName, String directory){

        String serverFilePath = publicFiles +"/"+ userUploaded;
        String relativePathForUrl = String.join("/", userUploaded, directory, fileName);


        Path directoryPath = Paths.get(serverFilePath, directory); // create path until destiny directory
        Path fullPath = directoryPath.resolve(fileName); // create full path until file

        try {

            Files.createDirectories(directoryPath); // create directory if doesn't exist
            file.transferTo(fullPath.toAbsolutePath().toFile()); // create file (full path required) // TODO discover why absolute path from server does not work

        } catch (IOException e) {
            throw new RuntimeException("Error while saving file");
        }

        return relativePathForUrl; // return file absolute path
    }

}
