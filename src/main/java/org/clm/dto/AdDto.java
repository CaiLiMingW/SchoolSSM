package org.clm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.clm.bean.Ad;
import org.springframework.web.multipart.MultipartFile;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdDto extends Ad {
    private String img;
    private MultipartFile imgFile;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    @Override
    public String toString() {
        return "AdDto{}";
    }
}
