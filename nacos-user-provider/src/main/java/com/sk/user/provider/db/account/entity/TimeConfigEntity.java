package com.sk.user.provider.db.account.entity;

import com.sk.user.provider.db.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_time_config")
public class TimeConfigEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 周期
     */
    private String period;

    /**
     * 市场
     */
    private String market;

    /**
     * 序号
     */
    private Integer seq;

    /**
     * 状态 1正常 2禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取周期
     *
     * @return period - 周期
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置周期
     *
     * @param period 周期
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取市场
     *
     * @return market - 市场
     */
    public String getMarket() {
        return market;
    }

    /**
     * 设置市场
     *
     * @param market 市场
     */
    public void setMarket(String market) {
        this.market = market;
    }

    /**
     * 获取序号
     *
     * @return seq - 序号
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置序号
     *
     * @param seq 序号
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取状态 1正常 2禁用
     *
     * @return status - 状态 1正常 2禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1正常 2禁用
     *
     * @param status 状态 1正常 2禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
