package org.clm.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import jdk.nashorn.internal.objects.annotations.Where;
import org.clm.bean.Ad;
import org.clm.bean.Business;
import org.clm.bean.SearcrBean;
import org.clm.bean.SysParam;
import org.clm.dao.AdMapper;
import org.clm.dao.BusinessMapper;
import org.clm.dto.AdDto;
import org.clm.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AdMapper adMapper;

    @Autowired
    private BusinessMapper businessMapper;

    @RequestMapping(value = "/homead",method = RequestMethod.GET)
    public List<AdDto> homead(){

        AdDto adDto = new AdDto();
        PageHelper.startPage(1,6);
        List<AdDto> list = adMapper.selectByPrimaryKey(adDto);

        return list;
    }
    /**
     * 搜索结果页 三个参数
     */
    @RequestMapping(value = "/search/{page}/{city}/{category}/{keyword}",method = RequestMethod.GET)
    public List<Business> search(@PathVariable(value = "page")int pn,
                         @PathVariable("city")String city,
                         @PathVariable("category")String category,
                         @PathVariable("keyword")String keyword){
        /*PageHelper.startPage(pn,5);*/
        SearcrBean searcrBean = new SearcrBean (city,category,keyword);
        List<Business> list = businessMapper.selectById(searcrBean);
        return list;
    }

    /**
     * 搜索结果页 两个参数
     */

}
