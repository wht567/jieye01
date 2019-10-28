package com.kgc.test.controller;

import com.kgc.test.entity.Takeout;
import com.kgc.test.service.TakeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TakeoutController {
    @Autowired
    private TakeoutService takeoutService;

    @RequestMapping("addTakeout")
    public String addTakeout(Takeout takeout, Model model) {
        int i = takeoutService.insertSelective(takeout);
        if (1 == i) {
            model.addAttribute("result", "alert('操作成功')");
        } else {
            model.addAttribute("result", "alert('操作失败')");
            model.addAttribute("takeout", takeout);
        }
        return "warehouse";
    }
}
