package com.ren.SI;

public class Student implements Comparable<Student>{
	private int sid;
	private String name;
	private int age;
	private String sex;
	private String birthday;
	private String address;
	private String phone;
	private String email;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(int sid, String name, int age, String sex, String birthday, String address, String phone,
			String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "sid=" + sid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", phone=" + phone + ", email=" + email ;
	}
	@Override
	public int compareTo(Student o) {
		if(sid<o.sid)
			return -1;
		else if(sid>o.sid)
			return 1;
		return 0;
	}
}
