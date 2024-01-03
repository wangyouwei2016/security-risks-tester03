package com.example.demo.owasp.a06_vulnerableOutdatedComponents;

public class UseDeprecated {
	
	public void useDeprecatedMethod() {
		deprecatedMethod();
	}
	
    @Deprecated
    public static void deprecatedMethod() {
        System.out.println("这个方法已经被废弃");
    }
}
