package org.clm.controller.content;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.clm.bean.Business;
import org.clm.bean.Dic;
import org.clm.bean.SearcrBean;
import org.clm.dao.BusinessMapper;
import org.clm.dao.DicMapper;
import org.clm.dto.BusinessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/businesses")
public class BusinessesController {

    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private DicMapper dicMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String search(@RequestParam(value = "pn",defaultValue = "1")int pn, Model model){
       PageHelper.startPage(pn,3);
        List<Business> list = businessMapper.select();
        PageInfo<Business> pageInfo = new PageInfo<Business>(list);
        model.addAttribute("page",pageInfo);
        return "/content/businessList";
    }

    /**
     * 修改页面
     * @PathVariable("id")
     * {1} {id} id = 1
     * 从url获取｛id｝的值
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String remove(@PathVariable("id")int id){
        businessMapper.delete(id);
        return "redirect:/businesses";
    }

    /**
     * 商户新增页面初始化
     */
    @RequestMapping(value = "/addPage"/*,method=RequestMethod.GET*/)
    public String addInit(){
        return "/content/businessAdd";
    }

    /**
     * 修改页面初始化
     * @PathVariable("id")
     * {1} {id} id = 1
     * 从url获取｛id｝的值
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String modefiyInit(@PathVariable("id")int id,Model model){
        List<Dic> citylist = dicMapper.select("city");
        List<Dic> playlist = dicMapper.select("play");
        SearcrBean searcrBean = new SearcrBean();
        searcrBean.setId(id);
        List<Business> businesslist = businessMapper.selectById(searcrBean);
        model.addAttribute("businessList",businesslist);
        model.addAttribute("cityList",citylist);
        model.addAttribute("playList",playlist);
        return "/content/businessModify";
    }

    /**
     * 修改商户
     * 不能识别PUT 和 DELETE  , 直接重定向到指定jsp页面
     * redirect:/content/businessModify
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    /*@ResponseBody*/
    public String modefiy(@PathVariable("id")int id,Business business){
        business.setId(id);
        businessMapper.update(business);
        return "redirect:/businesses/"+id;
    }

    /**
     * 增加商户
     */


}
