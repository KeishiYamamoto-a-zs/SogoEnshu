package com.example.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CutMethodTest {
    
	ApplicationServiceImplTest applicationService = new ApplicationServiceImplTest();
		
	@Test
	void oneWord() {
		String result = applicationService.cut("ご");
		String expected = "";
		assertEquals(expected,result);		
		
	}
	
	@Test
	void twoWords() {
		String result = applicationService.cut("ごぼ");
		String expected = "ご";
		assertEquals(expected,result);	
	}
    
	@Test
	void threeWords() {
		String result = applicationService.cut("ごぼう");
		String expected = "ごぼ";
		assertEquals(expected,result);	
	}
	
	@Test
	void zeroWord() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        applicationService.cut("");
	    });
	}
	
}
