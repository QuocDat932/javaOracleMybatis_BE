package com.javaOracleMybatisWebix.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
	private String Mode;
//	private Integer MaKh;
//	private String TenKhach;
//	private String DiaChi;
	
	private Integer maKh;
	private String tenKh;
	private String diaChi;
	private String mail;
	private String phone;
	private String img;
	private String birthday;
	private String isUse;
	private int roleId;
	private String roleName;
	private String srcImg;
	
	public void slipImgSrc() {
		String srcImg = this.img;
		this.img = srcImg.substring(srcImg.lastIndexOf("img") == -1 
									? 0  : srcImg.lastIndexOf("img")+ 4
											, srcImg.length());
		this.srcImg = srcImg.substring(0, srcImg.indexOf(this.img));
	}
	
	List<Integer> lstRoleId;
}
