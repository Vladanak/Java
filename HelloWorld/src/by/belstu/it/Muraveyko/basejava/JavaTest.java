package by.belstu.it.Muraveyko.basejava;
import by.belstu.it.Muraveyko.basejava.WrapperString;

import static java.lang.Math.*;

import java.util.Arrays;
import java.util.Random;

public class JavaTest {
    public static int sint;
    public static final double SECOND_CONST=30.23f;

    public void kek() {
        char simvol='f';
        int Number=9;
        short sNumber=99;
        byte bNumber=1;
        long lNumber=999;
        boolean bool=true;
        double dNumber=2.43f;
        String slovo="program";
        String first = slovo + Number;
        System.out.println(first);
        String second = slovo + simvol;
        System.out.println(second);
        String third = slovo + dNumber;
        System.out.println(third);
        byte fourth = (byte)(bNumber + Number);
        System.out.println(fourth);
        int fifth= (int)(dNumber+lNumber);
        System.out.println(fifth);
        long sixth= Number+2147483647;
        System.out.println(sixth);
        System.out.println(sint);
        boolean seventh=bool&&bool;
        System.out.println(seventh);
        boolean eight=bool^bool;
        System.out.println(eight);
        //boolean ninth=bool+bool;
        long tenth=9223372036854775807L;
        long eleventh=0x7fff_ffff_fffL;
        char CharFirst=(char)(simvol-'a');
        System.out.println(CharFirst);
        System.out.println('\u0061');
        System.out.println("97");
        char CharResult=(char)(CharFirst+'\u0061'+97);
        System.out.println(CharResult);
        System.out.println(3.45%2.4);
        System.out.println(1.0/0.0);
        System.out.println(0.0/0.0);
        System.out.println(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));
        final int FIRST_CONST=22;
        double First_Math=Math.round(Math.PI);
        double Second_Math=Math.round(Math.E);
        double Result_Math=Math.min(First_Math,Second_Math);
        System.out.println(Result_Math);
        Random rand = new Random();
        int generation = rand.nextInt(2);
        System.out.println(generation);
        Boolean Ffirst=true;
        Character Fsecond='a';
        Integer Fthird=5;
        Byte Ffourth=2;
        Short Ffifth=1;
        Long Fsixth= Long.valueOf(10000);
        Double Fseventh= Double.valueOf(2.2f);
        Fthird=Fthird*3;
        System.out.println(Fthird);
        Fthird=Fthird+3;
        System.out.println(Fthird);
        Fthird=~Fthird;
        System.out.println(Fthird);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        int unboxforint=Fthird*2;
        System.out.println(unboxforint);
        int unboxfirbyte=Ffourth+1;
        System.out.println(Fthird.parseInt("2"));
        System.out.println(Fthird.toHexString(22));
        System.out.println(Fthird.compare(1,2));
        System.out.println(Fthird.toString());
        System.out.println(Fthird.bitCount(2));
        System.out.println(Float.isNaN(12));
        System.out.println(Double.isNaN(Math.sqrt(-1)));
        //конструктор//
        Integer i1 = new Integer("20349");
        System.out.println(i1);
        //valueof//
        String str1 = "1451";
        Integer i2 = Integer.valueOf(str1);
        System.out.println(i2);
        //parseint//
        int i3 = 0;
        String str2 = "102944";
        i3 = Integer.parseInt(str2);
        System.out.println(i3);
        //строка в байты и байты в строку//
        String inputString = "kekes";
        // преобразуем нашу строку в массив байт
        byte[] byteArray = inputString.getBytes();
        System.out.println("Строку в массив байт : " + Arrays.toString(byteArray));
        // конвертируем байты в строку
        String string6 = new String(byteArray);
        System.out.println("байты в строку : " + string6);
        //строка в логический тип//
        String s1 = "True";
        String s2 = "yes";
        boolean bool1, bool2, boolean1, boolean2;
        //с использованием метода parseBoolean
        bool1 = Boolean.parseBoolean(s1);
        bool2 = Boolean.parseBoolean(s2);
        System.out.println(bool1);
        System.out.println(bool2);
        //c использованием метода valueOf
        boolean1 = Boolean.valueOf(s1);
        boolean2 = Boolean.valueOf(s2);
        System.out.println(boolean1);
        System.out.println(boolean2);
        String s3 = "test";
        String s4 = "test";
        System.out.println("--------------------------------------------------");
        System.out.println(s3 == s4);// Эти строки имеют одно и тоже же значение
        System.out.println(s3.equals(s4));// строки указывают на один и тот же объект, потому что компилятор добавляет все литералы в пул.
        System.out.println(s3.compareTo(s4));
        s4 = null;
        System.out.println("--------------------------------------------------");
        System.out.println(s3 == s4);// Эти строки имеют одно и тоже же значение
        System.out.println(s3.equals(s4));// строки указывают на один и тот же объект, потому что компилятор добавляет все литералы в пул.
        // System.out.println(s3.compareTo(s4));
        System.out.println("--------------------------------------------------");
        String string5 = "004-034556";
        String[] parts = string5.split("-");
        String part1 = parts[0]; // 004
        String part2 = parts[1]; // 034556
        "text text".contains("text");
        System.out.println(s3.hashCode());
        System.out.println(s3.length());
        System.out.println(s3.replace('e', '0'));
        System.out.println(s3.indexOf('e'));
        char[][] c1;
        char[] c2[]={{'a','b'},{'b','c'}};
        char c3[][]={{'a','b'},{'b','c'}};
        //массив нулевой длинны
        char[] letters = new char[0];
        c1 = new char[3][];
        c1[0]=new char[1];
        c1[1]=new char[2];
        c1[2]=new char[3];
        char count = 'a';
        for (int i=0; i<c1.length; i++)
            for(int j=0; j<c1[i].length; j++)
                c1[i][j] = count++;
        for (int i=0; i<c1.length; i++)
        {
            for (int j=0; j<c1[i].length; j++)
                System.out.print(c1[i][j] + " ");
            System.out.println();
        }
        System.out.println(c1.length);
        System.out.println(c1[0].length);
        System.out.println(c1[1].length);
        System.out.println(c1[2].length);
        System.out.println("--------------------------------------------------");
        boolean comRez =c2==c3;
        c2=c3;
        System.out.println(comRez);
        for (char[] x: c2){
            System.out.println(x);
        }
        System.out.println("--------------------------------------------------");

        WrapperString kek=new WrapperString("RTR");
        System.out.println(kek);
        kek.replace('T','N');
        WrapperString kek2=new WrapperString("KIK"){
            public void replace(char oldchar,char newchar) {

                System.out.println("переопределение"+oldchar+newchar);
            }
            public void delete(char newchar) {

                System.out.println("переопределение"+newchar);
            }
        };

        kek2.replace('f','u');
        kek2.delete('Y');
        /* KEK DAROVA */










    }
}
