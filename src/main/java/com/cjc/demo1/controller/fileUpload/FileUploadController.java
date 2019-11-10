package com.cjc.demo1.controller.fileUpload;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class FileUploadController {
    private SimpleDateFormat sdf = new SimpleDateFormat("");
    @Autowired
    private FastFileStorageClient storageClient;
    @PostMapping("/upload")
    public ModelAndView upload(MultipartFile uploadFile, HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();
        String realPath =
                req.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
            String oldName = uploadFile.getOriginalFilename();
            assert oldName != null;
            String extension = oldName.substring(oldName.lastIndexOf("."));
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                //uploadFile.transferTo(new File(folder, newName));
              /*  String path = req.getScheme() + "://" + req.getServerName() + ":" +
                        req.getServerPort() + "/uploadFile/" + format + newName;*/
                StorePath file = storageClient.uploadFile("group1", uploadFile.getInputStream(), uploadFile.getSize(), extension);
                System.out.println(file.getFullPath());
                modelAndView.addObject("uploadFile",file.getFullPath());
                modelAndView.setViewName("upload/upload");
                return modelAndView;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return modelAndView;
    }
    @RequestMapping("toUpload")
    public ModelAndView toUpload(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("upload/upload");
        return modelAndView;
    }
}