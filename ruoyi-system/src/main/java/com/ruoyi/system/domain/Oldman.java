package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.stereotype.Component;

/**
 * 老人信息对象 oldman
 *
 * @author ruoyi
 * @date 2021-03-10
 */
@Component
public class Oldman extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 老人Id */
    private Long oldmanId;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 姓名 */
    @Excel(name = "姓名")
    private String realName;

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

    /** 入院时间 */
    @Excel(name = "入院时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;

    /** 出院时间 */
    @Excel(name = "出院时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 亲属 */
    @Excel(name = "亲属")
    private String family;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idNo;

    /** 身体状况 */
    @Excel(name = "身体状况")
    private String state;

    /** 床号 */
    @Excel(name = "床号")
    private String bedNo;

    /** 编号 */
    @Excel(name = "编号")
    private String num;

    public void setOldmanId(Long oldmanId)
    {
        this.oldmanId = oldmanId;
    }

    public Long getOldmanId()
    {
        return oldmanId;
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
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getRealName()
    {
        return realName;
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
    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setFamily(String family)
    {
        this.family = family;
    }

    public String getFamily()
    {
        return family;
    }
    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getIdNo()
    {
        return idNo;
    }
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    public void setBedNo(String bedNo)
    {
        this.bedNo = bedNo;
    }

    public String getBedNo()
    {
        return bedNo;
    }
    public void setNum(String num)
    {
        this.num = num;
    }

    public String getNum()
    {
        return num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("oldmanId", getOldmanId())
               // .append("username", getUsername())
               // .append("password", getPassword())
                .append("realName", getRealName())
                //.append("gender", getGender())
               // .append("age", getAge())
              //  .append("phoneNumber", getPhoneNumber())
                //.append("address", getAddress())
                .append("beginTime", getBeginTime())
                .append("endTime", getEndTime())
               // .append("remark", getRemark())
                .append("family", getFamily())
                .append("idNo", getIdNo())
                .append("state", getState())
                .append("bedNo", getBedNo())
                .append("num", getNum())
                .toString();
    }
}