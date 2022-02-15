package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends BaseEntity {
	// id | name | email | password | reg_amt | reg_date | role

	private String name;
	private String email;
	private String password;
	@Column(name="reg_amt")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	@Enumerated(EnumType.STRING)
	private UserRole role;

//	public User() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(String name, String email, String password, double regAmount, LocalDate regDate, UserRole role) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.regAmount = regAmount;
//		this.regDate = regDate;
//		this.role = role;
//	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public double getRegAmount() {
//		return regAmount;
//	}
//
//	public void setRegAmount(double regAmount) {
//		this.regAmount = regAmount;
//	}
//
//	public LocalDate getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(LocalDate regDate) {
//		this.regDate = regDate;
//	}
//
//	public UserRole getRole() {
//		return role;
//	}
//
//	public void setRole(UserRole role) {
//		this.role = role;
//	}
//
//	@Override
//	public String toString() {
//		return "User Id "+getId()+" [name=" + name + ", email=" + email + ", password=" + password + ", regAmount=" + regAmount
//				+ ", regDate=" + regDate + ", role=" + role + "]";
//	}
//	

}
