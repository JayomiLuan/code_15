package cn.itcast.day15.domain;

import java.util.Date;

public class User2 {
	private String username;
	private String password;
	private String name;
	private boolean gender;
	private String hobby;
	private Date birthday;
	
	@Override
	public String toString() {
		return "User2 [username=" + username + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", hobby=" + hobby + ", birthday=" + birthday + "]";
	}

	public User2(){}
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	
}
