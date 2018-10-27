package com.imooc.jdk.reflect;

import java.lang.reflect.Constructor;

public class Test {

	public static void main(String[] args) throws Exception {
		test1();
	}
	
    public static void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException{
        Class clazz = Student.class;

        System.out.println("public:");
        Constructor<?>[]  constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toGenericString());
        }

        System.out.println("===============================================");
        System.out.println("���й��췽��������public/protected/private/default:");
        constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toGenericString());
        }

        System.out.println("����������");
        Class c = Class.forName("algo.jdk.reflect.Student");
        Constructor con = c.getConstructor();
        System.out.println(con.toGenericString());
    }

	

}
