package org.clm.service.Impl;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

public class FileUtils {
    public static String save(MultipartFile multipartFile,String SavePath) throws IOException {
        if(multipartFile!=null && multipartFile.getSize() > 0 ){
            File fileFolder = new File(SavePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            InputStream inputStream = new FileInputStream("xx");
            String path = fileFolder.getPath()+System.currentTimeMillis()+"_"
                    +multipartFile.getOriginalFilename();
            File file = new File(path);
            multipartFile.transferTo(file);
            return file.getName();
        }else {
            return null;
        }
    }
}
