package org.utils;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by langye on 2017/12/13.
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    //通过ftl模板引擎文件 视图展示http://localhost:8080/index
    public ModelMap index(ModelMap modelMap){
        //put和addAttribute存储效果页面展示一样
        modelMap.addAttribute("name","旺仔");
        modelMap.addAttribute("sex",1);

        List<String> list = new ArrayList<String>();
        list.add("张山");
        list.add("李四");
        list.add("王五");
        modelMap.put("list",list);
        return modelMap;
    }
}
