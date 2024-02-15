package com.sk.user.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private long total;
    private int pages;
    private List<T> datas;
}
