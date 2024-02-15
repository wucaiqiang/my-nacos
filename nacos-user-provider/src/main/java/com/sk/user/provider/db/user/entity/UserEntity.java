package com.sk.user.provider.db.user.entity;


import com.sk.user.provider.db.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tb_user")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * googleKey
     */
    @Column(name = "google_key")
    private String googleKey;

    /**
     * google status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    @Column(name = "google_status")
    private Byte googleStatus;

    /**
     * 登陆密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 登陆密码盐值
     */
    @Column(name = "login_salt")
    private String loginSalt;

    /**
     * 资金密码
     */
    @Column(name = "transaction_password")
    private String transactionPassword;

    /**
     * 资金密码盐值
     */
    @Column(name = "transaction_salt")
    private String transactionSalt;

    /**
     * 上一次登录时间
     */
    @Column(name = "last_login_previous_time")
    private Date lastLoginPreviousTime;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 用户状态
     */
    @Column(name = "lock_status")
    private Byte lockStatus;

    /**
     * 审核状态
     */
    @Column(name = "check_status")
    private Byte checkStatus;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Date checkTime;

    /**
     * 用户类型 1为普通用户，2为交易所用户，3为机器人，4为交易所资产账号
     */
    private Byte type;

    /**
     * 用户级别(0普通用户1广告主审核中2广告主3广告主失败）
     */
    private Byte level;

    /**
     * 国家区号，关联国家区号表
     */
    @Column(name = "country_id")
    private Integer countryId;

    /**
     * 用户头像
     */
    @Column(name = "head_image")
    private String headImage;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 广告限额
     */
    @Column(name = "price_limit")
    private BigDecimal priceLimit;

    /**
     * 保证金
     */
    private BigDecimal deposit;

    /**
     * 保证金单位
     */
    @Column(name = "deposit_unit")
    private String depositUnit;

    /**
     * 邀请码
     */
    @Column(name = "invite_code")
    private String inviteCode;

    /**
     * 邀请是否有效
     */
    @Column(name = "invite_valid")
    private Byte inviteValid;

    /**
     * 消息提醒开关 0 关 1开
     */
    @Column(name = "message_status")
    private Byte messageStatus;

    /**
     * 广告激活状态 0 未激活 1 已激活
     */
    @Column(name = "ad_status")
    private Byte adStatus;

    /**
     * 区分不同的服务系统
     */
    @Column(name = "service_key")
    private String serviceKey;

    /**
     * 语言标识 en_us 为中文、en_us为英文
     */
    private String language;

    /**
     * 电话 status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    @Column(name = "phone_status")
    private Byte phoneStatus;

    /**
     * 邮箱 status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    @Column(name = "email_status")
    private Byte emailStatus;

    /**
     * kyc状态 0未实名1审核中2审核成功3审核失败
     */
    @Column(name = "kyc_status")
    private Byte kycStatus;

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
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取googleKey
     *
     * @return google_key - googleKey
     */
    public String getGoogleKey() {
        return googleKey;
    }

    /**
     * 设置googleKey
     *
     * @param googleKey googleKey
     */
    public void setGoogleKey(String googleKey) {
        this.googleKey = googleKey;
    }

    /**
     * 获取google status -1为默认状态  1 为开启状态 0 为关闭状态
     *
     * @return google_status - google status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    public Byte getGoogleStatus() {
        return googleStatus;
    }

    /**
     * 设置google status -1为默认状态  1 为开启状态 0 为关闭状态
     *
     * @param googleStatus google status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    public void setGoogleStatus(Byte googleStatus) {
        this.googleStatus = googleStatus;
    }

    /**
     * 获取登陆密码
     *
     * @return login_password - 登陆密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登陆密码
     *
     * @param loginPassword 登陆密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取登陆密码盐值
     *
     * @return login_salt - 登陆密码盐值
     */
    public String getLoginSalt() {
        return loginSalt;
    }

    /**
     * 设置登陆密码盐值
     *
     * @param loginSalt 登陆密码盐值
     */
    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt;
    }

    /**
     * 获取资金密码
     *
     * @return transaction_password - 资金密码
     */
    public String getTransactionPassword() {
        return transactionPassword;
    }

    /**
     * 设置资金密码
     *
     * @param transactionPassword 资金密码
     */
    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }

    /**
     * 获取资金密码盐值
     *
     * @return transaction_salt - 资金密码盐值
     */
    public String getTransactionSalt() {
        return transactionSalt;
    }

    /**
     * 设置资金密码盐值
     *
     * @param transactionSalt 资金密码盐值
     */
    public void setTransactionSalt(String transactionSalt) {
        this.transactionSalt = transactionSalt;
    }

    /**
     * 获取上一次登录时间
     *
     * @return last_login_previous_time - 上一次登录时间
     */
    public Date getLastLoginPreviousTime() {
        return lastLoginPreviousTime;
    }

    /**
     * 设置上一次登录时间
     *
     * @param lastLoginPreviousTime 上一次登录时间
     */
    public void setLastLoginPreviousTime(Date lastLoginPreviousTime) {
        this.lastLoginPreviousTime = lastLoginPreviousTime;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取用户状态
     *
     * @return lock_status - 用户状态
     */
    public Byte getLockStatus() {
        return lockStatus;
    }

    /**
     * 设置用户状态
     *
     * @param lockStatus 用户状态
     */
    public void setLockStatus(Byte lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * 获取审核状态
     *
     * @return check_status - 审核状态
     */
    public Byte getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置审核状态
     *
     * @param checkStatus 审核状态
     */
    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取审核时间
     *
     * @return check_time - 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置审核时间
     *
     * @param checkTime 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取用户类型 1为普通用户，2为交易所用户，3为机器人，4为交易所资产账号
     *
     * @return type - 用户类型 1为普通用户，2为交易所用户，3为机器人，4为交易所资产账号
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置用户类型 1为普通用户，2为交易所用户，3为机器人，4为交易所资产账号
     *
     * @param type 用户类型 1为普通用户，2为交易所用户，3为机器人，4为交易所资产账号
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取用户级别(0普通用户1广告主审核中2广告主3广告主失败）
     *
     * @return level - 用户级别(0普通用户1广告主审核中2广告主3广告主失败）
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * 设置用户级别(0普通用户1广告主审核中2广告主3广告主失败）
     *
     * @param level 用户级别(0普通用户1广告主审核中2广告主3广告主失败）
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * 获取国家区号，关联国家区号表
     *
     * @return country_id - 国家区号，关联国家区号表
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * 设置国家区号，关联国家区号表
     *
     * @param countryId 国家区号，关联国家区号表
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * 获取用户头像
     *
     * @return head_image - 用户头像
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     * 设置用户头像
     *
     * @param headImage 用户头像
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取用户姓名
     *
     * @return username - 用户姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取广告限额
     *
     * @return price_limit - 广告限额
     */
    public BigDecimal getPriceLimit() {
        return priceLimit;
    }

    /**
     * 设置广告限额
     *
     * @param priceLimit 广告限额
     */
    public void setPriceLimit(BigDecimal priceLimit) {
        this.priceLimit = priceLimit;
    }

    /**
     * 获取保证金
     *
     * @return deposit - 保证金
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * 设置保证金
     *
     * @param deposit 保证金
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * 获取保证金单位
     *
     * @return deposit_unit - 保证金单位
     */
    public String getDepositUnit() {
        return depositUnit;
    }

    /**
     * 设置保证金单位
     *
     * @param depositUnit 保证金单位
     */
    public void setDepositUnit(String depositUnit) {
        this.depositUnit = depositUnit;
    }

    /**
     * 获取邀请码
     *
     * @return invite_code - 邀请码
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * 设置邀请码
     *
     * @param inviteCode 邀请码
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    /**
     * 获取邀请是否有效
     *
     * @return invite_valid - 邀请是否有效
     */
    public Byte getInviteValid() {
        return inviteValid;
    }

    /**
     * 设置邀请是否有效
     *
     * @param inviteValid 邀请是否有效
     */
    public void setInviteValid(Byte inviteValid) {
        this.inviteValid = inviteValid;
    }

    /**
     * 获取消息提醒开关 0 关 1开
     *
     * @return message_status - 消息提醒开关 0 关 1开
     */
    public Byte getMessageStatus() {
        return messageStatus;
    }

    /**
     * 设置消息提醒开关 0 关 1开
     *
     * @param messageStatus 消息提醒开关 0 关 1开
     */
    public void setMessageStatus(Byte messageStatus) {
        this.messageStatus = messageStatus;
    }

    /**
     * 获取广告激活状态 0 未激活 1 已激活
     *
     * @return ad_status - 广告激活状态 0 未激活 1 已激活
     */
    public Byte getAdStatus() {
        return adStatus;
    }

    /**
     * 设置广告激活状态 0 未激活 1 已激活
     *
     * @param adStatus 广告激活状态 0 未激活 1 已激活
     */
    public void setAdStatus(Byte adStatus) {
        this.adStatus = adStatus;
    }

    /**
     * 获取区分不同的服务系统
     *
     * @return service_key - 区分不同的服务系统
     */
    public String getServiceKey() {
        return serviceKey;
    }

    /**
     * 设置区分不同的服务系统
     *
     * @param serviceKey 区分不同的服务系统
     */
    public void setServiceKey(String serviceKey) {
        this.serviceKey = serviceKey;
    }

    /**
     * 获取语言标识 en_us 为中文、en_us为英文
     *
     * @return language - 语言标识 en_us 为中文、en_us为英文
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语言标识 en_us 为中文、en_us为英文
     *
     * @param language 语言标识 en_us 为中文、en_us为英文
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取电话 status -1为默认状态  1 为开启状态 0 为关闭状态
     *
     * @return phone_status - 电话 status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    public Byte getPhoneStatus() {
        return phoneStatus;
    }

    /**
     * 设置电话 status -1为默认状态  1 为开启状态 0 为关闭状态
     *
     * @param phoneStatus 电话 status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    public void setPhoneStatus(Byte phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    /**
     * 获取邮箱 status -1为默认状态  1 为开启状态 0 为关闭状态
     *
     * @return email_status - 邮箱 status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    public Byte getEmailStatus() {
        return emailStatus;
    }

    /**
     * 设置邮箱 status -1为默认状态  1 为开启状态 0 为关闭状态
     *
     * @param emailStatus 邮箱 status -1为默认状态  1 为开启状态 0 为关闭状态
     */
    public void setEmailStatus(Byte emailStatus) {
        this.emailStatus = emailStatus;
    }

    /**
     * 获取kyc状态 0未实名1审核中2审核成功3审核失败
     *
     * @return kyc_status - kyc状态 0未实名1审核中2审核成功3审核失败
     */
    public Byte getKycStatus() {
        return kycStatus;
    }

    /**
     * 设置kyc状态 0未实名1审核中2审核成功3审核失败
     *
     * @param kycStatus kyc状态 0未实名1审核中2审核成功3审核失败
     */
    public void setKycStatus(Byte kycStatus) {
        this.kycStatus = kycStatus;
    }
}
