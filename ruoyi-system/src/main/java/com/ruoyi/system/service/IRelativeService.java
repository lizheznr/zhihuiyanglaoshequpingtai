package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Relative;

/**
 * 家属信息Service接口
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
public interface IRelativeService 
{
    /**
     * 查询家属信息
     * 
     * @param relativeId 家属信息ID
     * @return 家属信息
     */
    public Relative selectRelativeById(Long relativeId);

    /**
     * 查询家属信息列表
     * 
     * @param relative 家属信息
     * @return 家属信息集合
     */
    public List<Relative> selectRelativeList(Relative relative);

    /**
     * 新增家属信息
     * 
     * @param relative 家属信息
     * @return 结果
     */
    public int insertRelative(Relative relative);

    /**
     * 修改家属信息
     * 
     * @param relative 家属信息
     * @return 结果
     */
    public int updateRelative(Relative relative);

    /**
     * 批量删除家属信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRelativeByIds(String ids);

    /**
     * 删除家属信息信息
     * 
     * @param relativeId 家属信息ID
     * @return 结果
     */
    public int deleteRelativeById(Long relativeId);
}
