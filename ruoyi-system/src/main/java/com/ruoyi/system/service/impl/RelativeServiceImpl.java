package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RelativeMapper;
import com.ruoyi.system.domain.Relative;
import com.ruoyi.system.service.IRelativeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 家属信息Service业务层处理
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
@Service
public class RelativeServiceImpl implements IRelativeService 
{
    @Autowired
    private RelativeMapper relativeMapper;

    /**
     * 查询家属信息
     * 
     * @param relativeId 家属信息ID
     * @return 家属信息
     */
    @Override
    public Relative selectRelativeById(Long relativeId)
    {
        return relativeMapper.selectRelativeById(relativeId);
    }

    /**
     * 查询家属信息列表
     * 
     * @param relative 家属信息
     * @return 家属信息
     */
    @Override
    public List<Relative> selectRelativeList(Relative relative)
    {
        return relativeMapper.selectRelativeList(relative);
    }

    /**
     * 新增家属信息
     * 
     * @param relative 家属信息
     * @return 结果
     */
    @Override
    public int insertRelative(Relative relative)
    {
        return relativeMapper.insertRelative(relative);
    }

    /**
     * 修改家属信息
     * 
     * @param relative 家属信息
     * @return 结果
     */
    @Override
    public int updateRelative(Relative relative)
    {
        return relativeMapper.updateRelative(relative);
    }

    /**
     * 删除家属信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRelativeByIds(String ids)
    {
        return relativeMapper.deleteRelativeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除家属信息信息
     * 
     * @param relativeId 家属信息ID
     * @return 结果
     */
    @Override
    public int deleteRelativeById(Long relativeId)
    {
        return relativeMapper.deleteRelativeById(relativeId);
    }
}
