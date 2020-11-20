package com.ruoyi.web.controller.archives.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 申请审批表管理对象 user_3
 * 
 * @author zhoubiao
 * @date 2020-11-17
 */
public class User3 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户身份证 */
    @NotBlank

    @Pattern(regexp="^[1-9]\\d{5}(18|19|20|(3\\d))\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",message = "身份证号码格式错误！")
    private String id;

    /** 村委会 */
    @Excel(name = "村委会")
    private String village;

    /** 姓名 */
    @NotBlank(message = "姓名不能为空！")
    @Excel(name = "姓名")
    private String uName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 年龄 */


    @Excel(name = "年龄")
    private Integer age;

    /** 家庭人口 */
    @Excel(name = "家庭人口")
    private Integer number;

    /** 具有劳动能力的人数 */
    @Excel(name = "具有劳动能力的人数")
    private Integer ableWork;

    /** 某某组居民 */
    @Excel(name = "某某组居民")
    private String uGroup;

    /** 住房面积(注意精确度的提示) */
    @Excel(name = "住房面积(注意精确度的提示)")
    private Double area0;

    /** 承包责任田 */
    @Excel(name = "承包责任田")
    private Double area1;

    /** 责任山 */
    @Excel(name = "责任山")
    private Double area2;

    /** 责任土 */
    @Excel(name = "责任土")
    private Double area3;

    /** 家庭主要收入来源 */
    @Excel(name = "家庭主要收入来源")
    private Double income;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year1;

    /** 收入(单位:元) */
    @Excel(name = "收入(单位:元)")
    private Double money;

    /** 家庭困难原因 */
    @Excel(name = "家庭困难原因")
    private String reason;

    /** 某户 */
    @Excel(name = "某户")
    private String name1;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uDate;

    /** 参加评议人数 */
    @Excel(name = "参加评议人数")
    private Integer number1;

    /** 得到同意票数 */
    @Excel(name = "得到同意票数")
    private Integer agreeNumber;

    /** 得票排位名次 */
    @Excel(name = "得票排位名次")
    private Integer agreeRank;

    /** 评议小组组长签字 */
    @Excel(name = "评议小组组长签字")
    private String signName0;

    /** 村委会负责人签字 */
    @Excel(name = "村委会负责人签字")
    private String signName1;

    /** 乡镇审批负责人签字 */
    @Excel(name = "乡镇审批负责人签字")
    private String signName2;

    /** 县扶贫办复核签字 */
    @Excel(name = "县扶贫办复核签字")
    private String signName3;

    /** 评议小组组长签字日期 */
    @Excel(name = "评议小组组长签字日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate0;

    /** 村委会负责人签字日期 */
    @Excel(name = "村委会负责人签字日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate1;

    /** 乡镇审批负责人签字日期 */
    @Excel(name = "乡镇审批负责人签字日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate2;

    /** 县扶贫办复核签字日期 */
    @Excel(name = "县扶贫办复核签字日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate3;

    /** 县政府审批日期 */
    @Excel(name = "县政府审批日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate4;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setVillage(String village) 
    {
        this.village = village;
    }

    public String getVillage() 
    {
        return village;
    }
    public void setuName(String uName) 
    {
        this.uName = uName;
    }

    public String getuName() 
    {
        return uName;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }
    public void setAbleWork(Integer ableWork) 
    {
        this.ableWork = ableWork;
    }

    public Integer getAbleWork() 
    {
        return ableWork;
    }
    public void setuGroup(String uGroup) 
    {
        this.uGroup = uGroup;
    }

    public String getuGroup() 
    {
        return uGroup;
    }
    public void setArea0(Double area0) 
    {
        this.area0 = area0;
    }

    public Double getArea0() 
    {
        return area0;
    }
    public void setArea1(Double area1) 
    {
        this.area1 = area1;
    }

    public Double getArea1() 
    {
        return area1;
    }
    public void setArea2(Double area2) 
    {
        this.area2 = area2;
    }

    public Double getArea2() 
    {
        return area2;
    }
    public void setArea3(Double area3) 
    {
        this.area3 = area3;
    }

    public Double getArea3() 
    {
        return area3;
    }
    public void setIncome(Double income) 
    {
        this.income = income;
    }

    public Double getIncome() 
    {
        return income;
    }
    public void setYear1(Integer year1) 
    {
        this.year1 = year1;
    }

    public Integer getYear1() 
    {
        return year1;
    }
    public void setMoney(Double money) 
    {
        this.money = money;
    }

    public Double getMoney() 
    {
        return money;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setName1(String name1) 
    {
        this.name1 = name1;
    }

    public String getName1() 
    {
        return name1;
    }
    public void setuDate(Date uDate) 
    {
        this.uDate = uDate;
    }

    public Date getuDate() 
    {
        return uDate;
    }
    public void setNumber1(Integer number1) 
    {
        this.number1 = number1;
    }

    public Integer getNumber1() 
    {
        return number1;
    }
    public void setAgreeNumber(Integer agreeNumber) 
    {
        this.agreeNumber = agreeNumber;
    }

    public Integer getAgreeNumber() 
    {
        return agreeNumber;
    }
    public void setAgreeRank(Integer agreeRank) 
    {
        this.agreeRank = agreeRank;
    }

    public Integer getAgreeRank() 
    {
        return agreeRank;
    }
    public void setSignName0(String signName0) 
    {
        this.signName0 = signName0;
    }

    public String getSignName0() 
    {
        return signName0;
    }
    public void setSignName1(String signName1) 
    {
        this.signName1 = signName1;
    }

    public String getSignName1() 
    {
        return signName1;
    }
    public void setSignName2(String signName2) 
    {
        this.signName2 = signName2;
    }

    public String getSignName2() 
    {
        return signName2;
    }
    public void setSignName3(String signName3) 
    {
        this.signName3 = signName3;
    }

    public String getSignName3() 
    {
        return signName3;
    }
    public void setSignDate0(Date signDate0) 
    {
        this.signDate0 = signDate0;
    }

    public Date getSignDate0() 
    {
        return signDate0;
    }
    public void setSignDate1(Date signDate1) 
    {
        this.signDate1 = signDate1;
    }

    public Date getSignDate1() 
    {
        return signDate1;
    }
    public void setSignDate2(Date signDate2) 
    {
        this.signDate2 = signDate2;
    }

    public Date getSignDate2() 
    {
        return signDate2;
    }
    public void setSignDate3(Date signDate3) 
    {
        this.signDate3 = signDate3;
    }

    public Date getSignDate3() 
    {
        return signDate3;
    }
    public void setSignDate4(Date signDate4) 
    {
        this.signDate4 = signDate4;
    }

    public Date getSignDate4() 
    {
        return signDate4;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("village", getVillage())
            .append("uName", getuName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("number", getNumber())
            .append("ableWork", getAbleWork())
            .append("uGroup", getuGroup())
            .append("area0", getArea0())
            .append("area1", getArea1())
            .append("area2", getArea2())
            .append("area3", getArea3())
            .append("income", getIncome())
            .append("year1", getYear1())
            .append("money", getMoney())
            .append("reason", getReason())
            .append("name1", getName1())
            .append("uDate", getuDate())
            .append("number1", getNumber1())
            .append("agreeNumber", getAgreeNumber())
            .append("agreeRank", getAgreeRank())
            .append("signName0", getSignName0())
            .append("signName1", getSignName1())
            .append("signName2", getSignName2())
            .append("signName3", getSignName3())
            .append("signDate0", getSignDate0())
            .append("signDate1", getSignDate1())
            .append("signDate2", getSignDate2())
            .append("signDate3", getSignDate3())
            .append("signDate4", getSignDate4())
            .toString();
    }
}
