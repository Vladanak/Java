package com.company;
import by.belstu.it.Muraveyko.TextFunction  ;
import by.belstu.it.Muraveyko.basejava.*  ;


public class Main {
    //TODO Add a new method
    public static void main(String[] args) {
	System.out.println("Hello World");
	TextFunction a = new TextFunction();
	a.onCreate();
	JavaTest Test=new JavaTest();
	Test.kek();
	WrapperString wrap = new WrapperString("kek");
	wrap.equals("da");
	wrap.hashCode();
	wrap.toString();

    }
}
