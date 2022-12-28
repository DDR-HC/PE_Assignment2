package com.dr;

import java.util.List;

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
		
		//display all student information
		List<Student>resultList=StudentServiceImpl.displayAll();
		for(int i=0;i<resultList.size();i++) {
			System.out.println(resultList.get(i).getSID());
		}
	}
}
