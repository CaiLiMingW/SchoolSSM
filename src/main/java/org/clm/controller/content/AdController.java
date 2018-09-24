package org.clm.controller.content;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.clm.bean.Ad;
import org.clm.dao.AdMapper;
import org.clm.dao.BusinessMapper;
import org.clm.dto.AdDto;
import org.clm.service.AdService;
import org.clm.service.Impl.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Value("${adImage.savePath}")
    private String adImagePath;

    @Autowired
    private AdService adService;

    @Autowired
    private AdMapper adMapper;

    @RequestMapping
    public String init(){
        return "/content/adList";
    }

    @RequestMapping(value = "addInit")
    private String addInit(){
        return "/content/adAdd";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(AdDto adDto) throws IOException {
        adService.add(adDto);
        return  "/content/adAdd";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(@RequestParam("pn")int pn, Model model, AdDto adDto){

        PageHelper.startPage(pn,3);
        List<AdDto> list = adMapper.selectByPrimaryKey(adDto);
        PageInfo<AdDto> pageInfo = new PageInfo<AdDto>(list);
        model.addAttribute("page",pageInfo);
             return "/content/adList";
    }

    @RequestMapping(value = "/remove")
    public String removed(@RequestParam("id") int i){

        System.out.println(i);
        adMapper.deleteByPrimaryKey(i);
        return "forward:/ad/search" ;
    }

    @RequestMapping(value = "/modifyInit")
    public String modidy(@RequestParam("id")int i ){

        return "/content/adModify";
    }


}
