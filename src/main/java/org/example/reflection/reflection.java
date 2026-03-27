package org.example.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflection {
    public static void main(String[] args) {

        java.lang.Class<?> stringClass=String.class;

        Method[] declaredMethods=stringClass.getDeclaredMethods();

        for (Method method:declaredMethods){
            System.out.println(method.getName());
        }

        java.lang.reflect.Field [] declaredFields =stringClass.getDeclaredFields();
        for (Field field:declaredFields){
            System.out.println(field.getName());
        }
    }
}
