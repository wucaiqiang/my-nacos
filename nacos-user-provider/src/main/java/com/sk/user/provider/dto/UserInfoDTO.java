package com.sk.user.provider.dto;

import lombok.Data;

@Data
public class UserInfoDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nickname;
	private String phone;

}
