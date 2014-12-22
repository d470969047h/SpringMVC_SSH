package com.shinowit.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by daihui on 2014-12-22.
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping(value = "/fileupload")
    public String upload(@RequestParam("photo") MultipartFile multipartFile, HttpServletRequest request) {
        if (true == multipartFile.isEmpty()) {
            System.out.println("文件未上传");
            return "redirect:/html/upload.html";
        }
        System.out.println("文件长度: " + multipartFile.getSize());
        System.out.println("文件类型: " + multipartFile.getContentType());
        System.out.println("文件名称: " + multipartFile.getName());
        System.out.println("文件原名: " + multipartFile.getOriginalFilename());
        System.out.println("========================================");

        String relaPath = request.getServletContext().getRealPath("/upload") + "/" + multipartFile.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(relaPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/userinfo/ok";
    }
}
