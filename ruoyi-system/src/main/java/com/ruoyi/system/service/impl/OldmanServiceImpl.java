package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OldmanMapper;
import com.ruoyi.system.domain.Oldman;
import com.ruoyi.system.service.IOldmanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 老人信息Service业务层处理
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
@Service
public class OldmanServiceImpl implements IOldmanService 
{
    @Autowired
    private OldmanMapper oldmanMapper;

    /**
     * 查询老人信息
     * 
     * @param oldmanId 老人信息ID
     * @return 老人信息
     */
    @Override
    public Oldman selectOldmanById(Long oldmanId)
    {
        return oldmanMapper.selectOldmanById(oldmanId);
    }

    /**
     * 查询老人信息列表
     * 
     * @param oldman 老人信息
     * @return 老人信息
     */
    @Override
    public List<Oldman> selectOldmanList(Oldman oldman)
    {
        return oldmanMapper.selectOldmanList(oldman);
    }

    /**
     * 新增老人信息
     * 
     * @param oldman 老人信息
     * @return 结果
     */
    @Override
    public int insertOldman(Oldman oldman)
    {
        return oldmanMapper.insertOldman(oldman);
    }

    /**
     * 修改老人信息
     * 
     * @param oldman 老人信息
     * @return 结果
     */
    @Override
    public int updateOldman(Oldman oldman)
    {
        return oldmanMapper.updateOldman(oldman);
    }

    /**
     * 删除老人信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOldmanByIds(String ids)
    {
        return oldmanMapper.deleteOldmanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除老人信息信息
     * 
     * @param oldmanId 老人信息ID
     * @return 结果
     */
    @Override
    public int deleteOldmanById(Long oldmanId)
    {
        return oldmanMapper.deleteOldmanById(oldmanId);
    }

    /**
     * 查询用户（李哲）
     * */
    @Override
    public Oldman queryUser(){
        return oldmanMapper.queryUser();
    }
}
