package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xiehaodong
 * @Date: 2021/3/11 - 13:19
 * @Description: com.ruoyi.web.controller.system
 * @version: 1.0
 */
@Controller
@RequestMapping("/system/monitoring")
public class MonitoringController extends BaseController {
    private String prefix = "system/monitoring";

    @RequiresPermissions("system:monitoring:view")
    @GetMapping()
    public String monitoring(){
            return prefix + "/monitoring";
    }


}
