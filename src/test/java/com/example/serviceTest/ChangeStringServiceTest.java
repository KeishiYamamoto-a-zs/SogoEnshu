package com.example.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.service.ChangeStringServiceImpl;


class ChangeStringServiceTest {
    
	ChangeStringServiceImpl changeStringService = new ChangeStringServiceImpl();
		
	@Test
	void oneWord() {
		String result = changeStringService.cut("ご");
		String expected = "";
		assertEquals(expected,result);		
		
	}
	
	@Test
	void twoWords() {
		String result = changeStringService.cut("ごぼ");
		String expected = "ご";
		assertEquals(expected,result);	
	}
    
	@Test
	void threeWords() {
		String result = changeStringService.cut("ごぼう");
		String expected = "ごぼ";
		assertEquals(expected,result);	
	}
	
	@Test
	void zeroWord() {
	    assertThrows(Exception.class, () -> {
	    	changeStringService.cut("");
	    });
	}
	
}
