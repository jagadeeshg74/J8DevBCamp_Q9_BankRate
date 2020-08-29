package yaksha;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {
	

		
		public static void main(String []args) throws ParseException{
			
		Scanner sc=new Scanner(System.in);
		int s=Integer.parseInt(sc.nextLine());
		
		HashMap<String,String>hm=new HashMap<String,String>();
		HashMap<String,Integer>hm1=new HashMap<String,Integer>();
		
		
		for(int i=0;i<s;i++)
		{
			String id=sc.nextLine();
			hm.put(id, sc.nextLine());
			hm1.put(id,Integer.parseInt(sc.nextLine()));
		}
		TreeMap<String,Integer>tm=new TreeMap<String,Integer>();
		
		tm = calculateDiscount(hm,hm1);
		
		Iterator<String> it=tm.keySet().iterator();
		while(it.hasNext())
		{
		String n=it.next();
		int fac=tm.get(n);
		System.out.println(n+":"+fac);
		}
		}



	
		public static TreeMap<String,Integer> calculateDiscount(HashMap<String,String>hm,HashMap<String,Integer>hm1) throws ParseException
		{
			
			
		TreeMap<String,Integer> tm=new TreeMap<String,Integer>();
		
		// SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-uuuu")
		            .withResolverStyle(ResolverStyle.STRICT);
		 
		 
		
		Iterator<String> itr1=hm.keySet().iterator();
		while(itr1.hasNext())
		{
			try
			{
			String id=itr1.next();
			String dor=hm.get(id);
			
			int am=hm1.get(id);
			
			
			LocalDate d1=LocalDate.parse(dor, df);
			
			
			String s1="01-01-2015";
			
			LocalDate d2= LocalDate.parse(s1,df);
			
			
			
			int exp=Period.between(d1, d2).getYears();
			
		
			if(am>=20000 && exp>=5)
			{
				int dis=(int) (0.20 * am);
				tm.put(id,dis);
			}
			else if(am>=20000 && exp<5)
			{
				int dis=(int) (0.1*am);
				tm.put(id,dis);
			}
			else if(am<20000 && exp>=5)
			{
				int dis=(int) (0.15*am);
				tm.put(id,dis);
			}
			else if(am<20000 && exp<5)
			{
				int dis=(int) (0.05*am);
				tm.put(id,dis);
			}
			}
			catch(Exception e){
				System.out.println(e);
			}	
		}
		return tm;
		}
		
		
		}
		
	
	


