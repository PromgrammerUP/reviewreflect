package org.javachina.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestRef {
	
	public static void main(String[] args) throws Exception {
		//1.用无参构造器创建一个对象
		//2.用有参构造器创建一个对象
		//3.给用无参构造器创建的对象的name属性赋值
		//4.使用getname方法获取name属性，并打印
		//5.调用无参构造器产生对象的say()方法
		//6.调用无参构造器产生对象的eat方法
		//7.调用本类的静态方法：staticMethod
		
		//1.用无参构造器创建一个对象
		//反射创建对象的和new创建对象的区别：反射创建对象的时间是new创建时间的三倍以上
		Class clazz = Class.forName("org.javachina.model.Person");
		
		Constructor con = clazz.getDeclaredConstructor();
		con.setAccessible(true);
		Object obj = 	con.newInstance();
		con.setAccessible(false);
		
		//2.用有参构造器创建一个对象
		Class[] param = new Class[]{java.lang.String.class};
		Constructor cons = clazz.getDeclaredConstructor(param);
		Object[] params = new Object[]{"李四"};
		Object objs = cons.newInstance(params);
		
		//3.给用无参构造器创建的对象的name属性赋值
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(obj, "张三");
		field.setAccessible(false);
		
//		field.setAccessible(true);
//		Object name = field.get(obj);
//		field.setAccessible(false);
//		System.out.println(name);
		
		//4.使用getname方法获取name属性，并打印
		
		Method method = clazz.getDeclaredMethod("getName");
		Object value = method.invoke(obj);
		System.out.println(value);
		//5.调用无参构造器产生对象的say()方法
		
		Method method1 =clazz.getDeclaredMethod("say");
		method1.invoke(obj);
		//6.调用无参构造器产生对象的eat方法
		
		Class[] param2 = new Class[]{java.lang.String.class};
		Method method2 = clazz.getDeclaredMethod("eat", param2);
		method2.invoke(obj, "面条");
		//7.调用本类的静态方法：staticMethod
		
		Class[] param3 = new Class[]{java.lang.String.class};
		Method method3 = clazz.getDeclaredMethod("staticMethod", param3);
		Object[] param4 = new Object[]{"林芝"};
		//静态方法不属于任何对象
		method3.invoke(null, param4);
	}
	
}
