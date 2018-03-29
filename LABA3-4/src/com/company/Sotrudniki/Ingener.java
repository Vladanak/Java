package com.company.Sotrudniki;

public class Ingener extends Sotrudniki implements Info{


    Ingener(String Name,int Year,int Zarplata)
    {
        super();
        super.SetName(Name);
        super.SetYear(Year);
        super.SetZarplata(Zarplata);
    }


    @Override
    public void Info()
    {
        try
        {
            System.out.println("Инженер:"+GetName()+GetYear()+GetZarplata());
        }
        catch (Exception ex)
        {
            System.out.println("Не-а");
        }
    }


    @Override
    public int hashCode()
    {
        final int prime=15;
        int result =6;
        result=prime * result +((super.GetName()==null)? 0 : super.GetYear().hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "To be a ingener is pretty good!" ;
    }


    @Override
    protected void How_Are_You()
    {
        try
        {
            System.out.println("Cool)");
        }
        catch (Exception ex)
        {
            System.out.println("Жесть");
        }
    }
}
