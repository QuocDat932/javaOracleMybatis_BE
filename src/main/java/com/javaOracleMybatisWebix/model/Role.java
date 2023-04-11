package com.javaOracleMybatisWebix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	private int roleId;
	private String roleName;
	private String isUse;
	private String descriptions;
}
