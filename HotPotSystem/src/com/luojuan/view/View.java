package com.luojuan.view;

import java.util.List;
import java.util.Scanner;

import com.luojuan.DAO.HotPotDAO;
import com.luojuan.bean.Hotpot;

public class View {
	
	
	public static void main(String[] args) throws Exception {
		HotPotDAO hotPotDAO = new HotPotDAO();
		Scanner in = new Scanner(System.in);
		while (true ) {
			showMenu();
			String line = in.nextLine();
			switch (line) {
			case "1"://添加火锅信息的
				System.out.println("请输入火锅信息 flavour:price:id");
				String couLine = in.nextLine();
				String [] couArr = couLine.split(":");
//				for (int i = 0; i < couArr.length; i++) {
//					System.out.println(couArr[i]);
//				}
				if (couArr[2]==null) {
					System.out.println("主键为空是不行哒");
				} else {
					Hotpot hotpot = new Hotpot(couArr[0], couArr[1],couArr[2]);
					hotPotDAO.addHotpot(hotpot);
				}
			     break;
			  case "2":
				  System.out.println("下面是所有火锅信息：");
				  List<Hotpot> list = hotPotDAO.findAll();
				 System.out.println(list);
				  break;
			  case "3":
				  System.out.println("请输入id");
				  String cString = in.nextLine();
				  List<Hotpot> list2 = hotPotDAO.findById(cString);
				  System.out.println(list2);
				  break;
			  case "4":
				  System.out.println("请输入要删除的ID");
				  String cString2 = in.nextLine();
				  hotPotDAO.deleteById(cString2);
				  break;
			default:
				break;
			}
			
			
		}
		
	}
	private static void showMenu() {
		System.out.println("******火锅系统管理******");
		System.out.println("**1.插入火锅***********");
		System.out.println("**2.查询火锅************");
		System.out.println("**3.按照ID查询火锅******");
		System.out.println("**4.按照ID删除火锅******");
		
	}
}
