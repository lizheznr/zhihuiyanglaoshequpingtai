package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Oldman;
import com.ruoyi.system.service.IOldmanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 老人信息Controller
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
@Controller
@RequestMapping("/system/oldman")
public class OldmanController extends BaseController
{
    private String prefix = "system/oldman";

    @Autowired
    private IOldmanService oldmanService;

    @RequiresPermissions("system:oldman:view")
    @GetMapping()
    public String oldman()
    {
        return prefix + "/oldman";
    }

    /**
     * 查询老人信息列表
     */
    @RequiresPermissions("system:oldman:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Oldman oldman)
    {
        startPage();
        List<Oldman> list = oldmanService.selectOldmanList(oldman);
        return getDataTable(list);
    }

    /**
     * 导出老人信息列表
     */
    @RequiresPermissions("system:oldman:export")
    @Log(title = "老人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Oldman oldman)
    {
        List<Oldman> list = oldmanService.selectOldmanList(oldman);
        ExcelUtil<Oldman> util = new ExcelUtil<Oldman>(Oldman.class);
        return util.exportExcel(list, "oldman");
    }

    /**
     * 新增老人信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存老人信息
     */
    @RequiresPermissions("system:oldman:add")
    @Log(title = "老人信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Oldman oldman)
    {
        return toAjax(oldmanService.insertOldman(oldman));
    }

    /**
     * 修改老人信息
     */
    @GetMapping("/edit/{oldmanId}")
    public String edit(@PathVariable("oldmanId") Long oldmanId, ModelMap mmap)
    {
        Oldman oldman = oldmanService.selectOldmanById(oldmanId);
        mmap.put("oldman", oldman);
        return prefix + "/edit";
    }

    /**
     * 修改保存老人信息
     */
    @RequiresPermissions("system:oldman:edit")
    @Log(title = "老人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Oldman oldman)
    {
        return toAjax(oldmanService.updateOldman(oldman));
    }

    /**
     * 删除老人信息
     */
    @RequiresPermissions("system:oldman:remove")
    @Log(title = "老人信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(oldmanService.deleteOldmanByIds(ids));
    }
}
