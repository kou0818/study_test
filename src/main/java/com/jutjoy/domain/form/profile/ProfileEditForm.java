package com.jutjoy.domain.form.profile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ProfileEditForm {
	
	//バリデーション
	//名前
	@NotEmpty(message = "*名前は必ず入力してください。")
	@Size(max = 20, message = "※名前は20字以内で入力してください")
	private String name;
	
	//性別
	@NotEmpty(message = "*性別は必ず選択してください。")
	private String gender;
	
	//趣味
	@NotEmpty(message = "*趣味は必ず入力してください。")
	@Size(max = 255, message = "※趣味は255文字以内で入力してください。")
	private String hobby;
	
	//自己紹介
	@NotEmpty(message = "*自己紹介は必ず入力してください。")
	private String introduction;
}