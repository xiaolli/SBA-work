package com.example.demo.entity;

/**
 * @Author: Seth
 * @Date: 2019/4/8 13:42
 * @Version 1.0
 */
public class Pay {
	  private String money;
	  private String userName;
    private String tecName;
    private int id;
    
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTecName() {
		return tecName;
	}

	public void setTecName(String tecName) {
		this.tecName = tecName;
	}


}
