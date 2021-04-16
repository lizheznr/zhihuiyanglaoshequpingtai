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
import com.ruoyi.system.domain.Relative;
import com.ruoyi.system.service.IRelativeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 家属信息Controller
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
@Controller
@RequestMapping("/system/relative")
public class RelativeController extends BaseController
{
    private String prefix = "system/relative";

    @Autowired
    private IRelativeService relativeService;

    @RequiresPermissions("system:relative:view")
    @GetMapping()
    public String relative()
    {
        return prefix + "/relative";
    }

    /**
     * 查询家属信息列表
     */
    @RequiresPermissions("system:relative:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Relative relative)
    {
        startPage();
        List<Relative> list = relativeService.selectRelativeList(relative);
        return getDataTable(list);
    }

    /**
     * 导出家属信息列表
     */
    @RequiresPermissions("system:relative:export")
    @Log(title = "家属信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Relative relative)
    {
        List<Relative> list = relativeService.selectRelativeList(relative);
        ExcelUtil<Relative> util = new ExcelUtil<Relative>(Relative.class);
        return util.exportExcel(list, "relative");
    }

    /**
     * 新增家属信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家属信息
     */
    @RequiresPermissions("system:relative:add")
    @Log(title = "家属信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Relative relative)
    {
        return toAjax(relativeService.insertRelative(relative));
    }

    /**
     * 修改家属信息
     */
    @GetMapping("/edit/{relativeId}")
    public String edit(@PathVariable("relativeId") Long relativeId, ModelMap mmap)
    {
        Relative relative = relativeService.selectRelativeById(relativeId);
        mmap.put("relative", relative);
        return prefix + "/edit";
    }

    /**
     * 修改保存家属信息
     */
    @RequiresPermissions("system:relative:edit")
    @Log(title = "家属信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Relative relative)
    {
        return toAjax(relativeService.updateRelative(relative));
    }

    /**
     * 删除家属信息
     */
    @RequiresPermissions("system:relative:remove")
    @Log(title = "家属信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(relativeService.deleteRelativeByIds(ids));
    }
}
