package com.company.Sotrudniki;
import org.apache.log4j.Logger;


interface Info
{
    void Info();
}


public abstract class Sotrudniki {
    private static final Logger LOG = Logger.getLogger(Sotrudniki.class);
    public static Logger getLOG()
    {
        return LOG;
    }
    private String name;
    private int year;
    private int zarplata;
    public Sotrudniki(){}
    public void SetName(String Name){ this.name=Name; }
    public void SetYear(int Year){ this.year=Year; }
    public void SetZarplata(int Zarplata){ this.zarplata=Zarplata; }
    public String GetName(){ return name; }
    public Integer GetYear(){ return year; }
    public Integer GetZarplata(){ return zarplata; }


    @Override
    public String toString(){return "Hello"+name;}


    public int hashCode()
    {
        final int prime=19;
        int result =1;
        result=prime * result +((year==0)? 0 : GetYear().hashCode());
        return result;
    }


    protected abstract void How_Are_You();
}
