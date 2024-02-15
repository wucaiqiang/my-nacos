package com.sk.user.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PageQueryDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    protected int pageIndex = 1;// 当前页
    protected int pageSize = 20;// 每页显示条数
}
