package com.ren.SI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
	private static Map<String, Student> map=new HashMap<>();
	private static Dao dao=new Dao();
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("请输入以下数字选择相应的功能：\n"
					+ "1、录入学生信息 2、学生信息浏览 3、学生信息查询 4、学生信息删除 5、退出系统");
			int a=0;
			try {
				a=scanner.nextInt();
				switch (a) {
				case 1:
					dao.add(scanner,map);
					break;
				case 2:
					dao.listAll(scanner,map);
					break;
				case 3:
					dao.find(scanner,map);
					break;
				case 4:
					dao.delete(scanner, map);
					break;
				case 5:
					System.out.println("成功退出系统");
					System.exit(0);
					break;

				default:
					System.out.println("输入指令有误");
					break;
				}
			} catch (Exception e) {
				System.err.println("输入指令有误");
				scanner.next();
				continue;
			}
		}
	}
	
	
}
