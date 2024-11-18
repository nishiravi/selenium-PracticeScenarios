package com.nishi.corejavabrushup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPractise {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Ndgishi");
		a.add("Nifgfshi");
		a.add("Nijfshi");
		a.add("Nigshi");
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		String[] avv = { "a", "b", "c" };
		List<String> jshkjf = Arrays.asList(avv);
		for (int i = 0; i < jshkjf.size(); i++) {
			System.out.println(jshkjf.get(i));
		}

		String s = "rahul shetty academy";
		String[] spillitedstring = s.split("shetty");
		for(int i=0;i<spillitedstring.length;i++)
		{
			System.out.println(spillitedstring[i]);
		}
		System.out.println(spillitedstring[1].trim());
		 for(int i=s.length()-1;i>=0;i--)
		   {
		       System.out.println(s.charAt(i));
		   }
	}

}
