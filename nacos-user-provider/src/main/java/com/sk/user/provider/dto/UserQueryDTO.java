package com.sk.user.provider.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Jack
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQueryDTO extends PageQueryDTO {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String nickname;
	private String phone;

}
