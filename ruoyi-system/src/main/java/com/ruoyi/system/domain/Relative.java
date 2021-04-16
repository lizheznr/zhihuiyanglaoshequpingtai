package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 家属信息对象 relative
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
public class Relative extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家属Id */
    private Long relativeId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    private String password;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Long gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String address;

    public void setRelativeId(Long relativeId) 
    {
        this.relativeId = relativeId;
    }

    public Long getRelativeId() 
    {
        return relativeId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("relativeId", getRelativeId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("name", getName())
            .append("gender", getGender())
            .append("age", getAge())
            .append("phoneNumber", getPhoneNumber())
            .append("address", getAddress())
            .append("remark", getRemark())
            .toString();
    }
}
