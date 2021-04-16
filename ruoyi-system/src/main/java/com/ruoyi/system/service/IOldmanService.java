package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Oldman;

/**
 * 老人信息Service接口
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
public interface IOldmanService 
{
    /**
     * 查询老人信息
     * 
     * @param oldmanId 老人信息ID
     * @return 老人信息
     */
    public Oldman selectOldmanById(Long oldmanId);

    /**
     * 查询老人信息列表
     * 
     * @param oldman 老人信息
     * @return 老人信息集合
     */
    public List<Oldman> selectOldmanList(Oldman oldman);

    /**
     * 新增老人信息
     * 
     * @param oldman 老人信息
     * @return 结果
     */
    public int insertOldman(Oldman oldman);

    /**
     * 修改老人信息
     * 
     * @param oldman 老人信息
     * @return 结果
     */
    public int updateOldman(Oldman oldman);

    /**
     * 批量删除老人信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOldmanByIds(String ids);

    /**
     * 删除老人信息信息
     * 
     * @param oldmanId 老人信息ID
     * @return 结果
     */
    public int deleteOldmanById(Long oldmanId);


    /**
     * 查询用户（李哲）
     * */
    public Oldman queryUser();
}
