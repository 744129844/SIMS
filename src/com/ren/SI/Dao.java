package com.ren.SI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dao {
	//添加
	public void add(Scanner scanner,Map<String, Student> map){
		while (true) {
			System.out.println("请输入学生信息，格式是：学号,姓名,年龄,性别,生日,地址,电话,邮件(注意逗号是英文格式的),输入r返回上一层");
			String str = scanner.next();
			if(str.equals("r"))break;
			String[] strs = str.split(",");
			if (strs.length != 8) {
				System.err.println("信息输入不完全");
			} else {
				Student student = null;
				try {
					student = new Student(Integer.parseInt(strs[0]), strs[1], Integer.parseInt(strs[2]), strs[3],
							strs[4], strs[5], strs[6], strs[7]);
				} catch (Exception e) {
					System.err.println("学号和年龄请用数字");
					continue;
				}
				if (map.containsKey(student.getSid() + "")) {
					System.err.println("学号已存在,请重新输入");
					continue;
				} else {
					map.put(student.getSid() + "", student);
					System.out.println("学生添加成功\n");
					break;
				}
			} 
		}
	}
	
	//学生浏览
	public void listAll(Scanner scanner,Map<String, Student> map){
		if(map.isEmpty())System.err.println("一个学生也没有，请添加");
		else{
			for(String key:map.keySet()){
				System.out.println(map.get(key));
			}
		}
	}
	
	//查询
	public void find(Scanner scanner,Map<String, Student> map){
		boolean b=false;
		while(true){
			System.out.println("1、根据学号查询 2、根据姓名查询 3、返回上一层");
			try {
				int a=scanner.nextInt();
				switch (a) {
				case 1:
					loadBySid(scanner, map);
					break;
				case 2:
					loadByName(scanner, map);
					break;
				case 3:
					b=true;
					break;
				default:
					System.err.println("输入指令不正确");
					break;
				}
			} catch (Exception e) {
				System.err.println("输入指令格式不正确");
				scanner.next();
				continue;
			}
			if(b)break;
		}
	}
	
	
	//根据学号查询学生
	public void loadBySid(Scanner scanner,Map<String, Student> map){
		System.out.println("请输入学号");
		String sid=scanner.next();
		if(map.containsKey(sid)){
			System.out.println(map.get(sid));
		}else{
			System.err.println("没有该学生");
		}
	}
	//按姓名查询
	public void loadByName(Scanner scanner,Map<String, Student> map){
		System.out.println("请输入姓名");
		List<Student> students=new ArrayList<>();
		String name=scanner.next();
		for(String key:map.keySet()){
			if(map.get(key).getName().matches(".*"+name+".*")){
				students.add(map.get(key));
			}
		}
		if(students.isEmpty())System.out.println("找不到该学生");
		else
		for(Student stu:students){
			System.out.println(stu);
		}
	}
	
	//删除学生
	public void delete(Scanner scanner,Map<String, Student> map){
		while (true) {
			if (map.isEmpty()){
				System.err.println("一个学生也没有");
				break;
			}else {
				System.out.println("所有学生如下");
				listAll(scanner, map);
			}
			System.out.println("请输入要删除的学生的学号");
			String sid = scanner.next();
			if(map.containsKey(sid)){
				map.remove(sid);
				System.out.println("删除成功");
				break;
			}else{
				System.err.println("没有该学生");
			}
		}
		
	}
	
}
