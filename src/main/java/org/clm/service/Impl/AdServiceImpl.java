package org.clm.service.Impl;

import org.clm.dao.AdMapper;
import org.clm.dto.AdDto;
import org.clm.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AdServiceImpl implements AdService {

    @Value("${adImage.savePath}")
    private String path;

    @Autowired
    private AdMapper adMapper;
    /**
     * 增加广告
     * @param adDto
     * @return
     */
    @Override
    public boolean add(AdDto adDto)  {
        try {
            adDto.setImgFileName(FileUtils.save(adDto.getImgFile(),path));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        adMapper.insert(adDto);
        return true;
    }



}
