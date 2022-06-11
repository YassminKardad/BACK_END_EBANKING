package com.project.Ebanking_BackEnd.payload.request;

import lombok.Data;


public class ChangePasswordRequest {
	 private String oldPassword;
	 private String newPassword;
	 private String confPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	 
	 

}
