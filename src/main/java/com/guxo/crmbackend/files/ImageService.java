package com.guxo.crmbackend.files;


import com.guxo.crmbackend.customer.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ImageService {

    @Value("${files.images-directory}")
    private String imagesDirectory;

    @Value("${files.photo-base-name}")
    private String photoBaseName;

    // Autowired
    private final FilesService filesService;

    //Autowired
    private final ImageRepository imageRepository;


    @Transactional
    // Saves image (photo) for current customer and returns Image object
    public Image savePhoto(MultipartFile imageFile, Customer customer) {

        String contentType = imageFile.getContentType();  // should be "image/___"
        String fileType = contentType.split("/")[0];


        if(!fileType.equals("image")){
            throw new IllegalStateException("Uploaded file is not an image!");
        }

        Image image = new Image(); // create image (to generate ID)
        imageRepository.save(image);
        String imageIdString = image.getId().toString();
        String customerIdString = customer.getId().toString();
        String imageExtension = StringUtils.getFilenameExtension(imageFile.getOriginalFilename());

        String filename = photoBaseName
                .concat(customerIdString)
                .concat("-")
                .concat(imageIdString)
                .concat(".")
                .concat(imageExtension); // photoBaseName + customerId + - + imageId + imageExtension

        String imageUrl = filesService.saveFile(imageFile, filename, imagesDirectory);

        image.setUrl(imageUrl);
        image.setOwner(customer);

        imageRepository.save(image);

        return image;
    }


}
