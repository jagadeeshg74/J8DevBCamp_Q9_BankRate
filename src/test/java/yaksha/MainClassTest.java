package yaksha;

import java.io.IOException;
import java.text.ParseException;


import java.util.HashMap;
import java.util.TreeMap;


import org.junit.jupiter.api.Test;



import yaksha.*;



public class MainClassTest {
	
	
	
	@Test
    public void testBankRate_calculateDiscount() throws ParseException, IOException {
       
		
        HashMap<String,String> hm = new HashMap<String,String>();
		
		hm.put("A-1010", "20-11-2007");
		hm.put("B-1011","04-12-2010");
		hm.put("C-1012", "11-11-2005");
		hm.put("D-1013","02-12-2012");
	
		
		
		HashMap<String,Integer> hm1= new HashMap<String,Integer>();
		
		hm1.put("A-1010", 25000);
		hm1.put("B-1011",30000);
		hm1.put("C-1012", 15000);
		hm1.put("D-1013",10000);
		
		
		TreeMap<String,Integer> tm=new TreeMap<String,Integer>();
		
		tm.put("A-1010",5000);
		tm.put("B-1011",3000);
		tm.put("C-1012",2250);
		tm.put("D-1013",500);
		
		
        
	//	Assertions.assertEquals(tm, MainClass.calculateDiscount(hm,hm1));
		
		
		TestUtils.yakshaAssert(TestUtils.currentTest(), MainClass.calculateDiscount(hm,hm1).equals(tm) ? "true":"false", TestUtils.businessTestFile );
		
        
        
    }
	

}
