package com.lai.model;

import java.util.HashMap;
import java.util.Map;

public class NgonNguDAO {
	public Map<String, String> englishLanguage() {
		Map<String, String> map = new HashMap<>();
		map.put("Login.TieuDe", "Form Sign in");
		map.put("Login.TenDangNhap", "Username");
		map.put("Login.MatKhau", "Password");
		map.put("Login.MoTaTenDangNhap", "Enter your username");
		map.put("Login.MoTaMatkhau", "Enter your password");
		map.put("Login.TaoTaiKhoan", "Create a new account");
		map.put("Login.QuenMatKhau", "Forgot your password");
		map.put("Login.DangNhap", "Sign in");
		return map;

	}

	public Map<String, String> vietnameseLanguage() {
		Map<String, String> map = new HashMap<>();
		map.put("Login.TieuDe", " Form Đăng nhập");
		map.put("Login.TenDangNhap", "Tên đăng nhập");
		map.put("Login.MatKhau", "Mật khẩu");
		map.put("Login.MoTaTenDangNhap", "Nhập tên đăng nhập của bạn");
		map.put("Login.MoTaMatkhau", "Nhập mật khẩu của bạn");
		map.put("Login.TaoTaiKhoan", "Tạo tài khoản mới");
		map.put("Login.QuenMatKhau", "Quên mật khẩu");
		map.put("Login.DangNhap", "Đăng nhập");
		return map;

	}
}
