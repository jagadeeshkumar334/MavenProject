package com.testng.proj;

public class Test1 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 call = new Test1();
		call.palindromeL2();
	}
	
	public void swapping()
	{
		int a =10;
		int b=20;		
		a=a+b;  //30
		b=a-b;	//10
		a=a-b;	//20		
		System.out.println("a value:" +a);
		System.out.println("b value: "+b);		
	}
	
	public void fib() {
		
		int num=100;		
		int a=0; 
		int b=0; 
		int c=1;
		
		for(int i=0;i<num;i++) {
			
			a=b;
			b=c;
			c=a+b;
			System.out.println(b);
		}		
	}
	
	public void duplicate_string() {
		String[] a = {"abc", "cda", "abc", "bca"};
		
		int i,j=0;
		for(i=0;i<a.length-1;i++) {
			if(a[i]!=a[j]) {
				a[j]=a[i];
				j++;
			}
		}
		for (j=0;j<i;j++) {
			System.out.println(a[j]);
		}
		
	}
	public void duplicate_elements() {
		
		//in two arrays
		int[] a= {1,2,3,4,5,9};
		int[] b= {1,6,7,7,8,9};
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					System.out.println(a[i]);
				}
			}
		}		
	}
	
	public void duplicate_elements2(){
		int i = 0,j = 0,k = 0;
		int[] a= {1,2,3,4,5,9};
		int[] b= {1,6,7,7,8,9};
		int[] c= {9,8,7,6,5,4,3,2,1};
		
		while(i<a.length && j<b.length && k<c.length) {
			if((a[i]==b[j]) && (b[j]==c[k])) {
				System.out.println(a[i]);
				i++;j++;k++;
			}
			else if (a[i]<b[j]) {
				i++;
			}
			else if (b[j]<c[k]) {
				j++;
			}
			else {
				k++;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			}
		}
	}
	
	public void palindrome() {
		String st = "kanak";
		String a="";
		char[] ch = st.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		sb.append(ch);
		a=sb.reverse().toString();
		System.out.println(a);
		
		if(st.equals(a)) {
			System.out.println("It is Palindrome: "+a );
		}
		else
			System.out.println("its not a palindrome: " +a);		
	}
	
	public void palindromeL2() {
		
		String st="kanaka";
		
		char ch[] = st.toCharArray();
		
		for(int i=ch.length-1;i>0;i--) {
			System.out.println(ch[i]);
		}
	}
}
