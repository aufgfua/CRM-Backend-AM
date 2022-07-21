package com.guxo.crmbackend.files;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {FilesService.class, String.class})
@ExtendWith(SpringExtension.class)
class FilesServiceTest {
    @Autowired
    private FilesService filesService;

    /**
     * Method under test: {@link FilesService#saveFile(MultipartFile, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveFile() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file '${files.public}/${files.user-uploaded}/directory', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        filesService.saveFile(new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")), "foo.txt", "/directory");
    }
}

