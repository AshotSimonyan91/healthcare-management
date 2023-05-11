package com.example.healthcaremanagement.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

@Controller
public class MainController {

    @Value("${healthcare.uploade.image.path}")
    private String imageUploadPath;


    @GetMapping("/")
    public String main() {
        return "index";
    }


    @GetMapping(value = "/getimage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("imageName") String imageName) throws IOException {
        File file = new File(imageUploadPath + imageName);
        if(file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            return IOUtils.toByteArray(fileInputStream);
        }
        return null;
    }
}
