package com.testng.proj;

import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test call = new Test();
		call.demo();

	}
	
	public void demo() {
		
		String[] s= {"abc", "abc", "efg", "hIJ"};
		String b="";
		
		for(int i=0;i<s.length-1;i++) {
			if(s[i]!=s[i+1]) {
				System.out.println(s[i]);
			}
			
		}
		
		
		
	}

}
