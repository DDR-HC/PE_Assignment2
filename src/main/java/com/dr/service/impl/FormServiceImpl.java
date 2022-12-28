package com.dr.service.impl;

import com.dr.dao.FormDao;
import com.dr.entity.Form;

public class FormServiceImpl {
	public static Form searchBySID(String SID) {
		return FormDao.searchBySID(SID);
	}
}
