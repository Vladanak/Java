package com.company.Except;

public class Except extends Exception
{

    public Except(){super();}

    public Except(String message,Throwable cause)
    {
        super(message,cause);
        System.out.println(message+cause);
    }

    public Except(String message)
    {
        super(message);
        System.out.println(message);

    }
}
