package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ChangeStringServiceImpl implements ChangeStringService {
	
	@Override
	public String cut(String inputForm){
	
		String str = inputForm;
        String truncatedStr = str.substring(0, str.length() - 1);

	    return truncatedStr;
	}

}
