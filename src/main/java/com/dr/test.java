package com.dr;

import com.dr.entity.Student;
import com.dr.service.impl.StudentServiceImpl;

public class test {
	public static void main(String[] args) {
		Student result=StudentServiceImpl.searchBySID("SWE2009496");
		if(result.getSID()!=null) {
			System.out.println("找到了");
		}else {
			System.out.println("没找到");
		}
	}
}
