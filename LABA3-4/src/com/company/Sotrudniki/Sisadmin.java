package com.company.Sotrudniki;

public class Sisadmin extends Sotrudniki implements Info {


    Sisadmin(String Name,int Year,int Zarplata)
    {
        super();
        super.SetName(Name);
        super.SetYear(Year);
        super.SetZarplata(Zarplata);
    }


    @Override
    public void Info()
    {
        System.out.println("Сис админ:"+GetName()+GetYear()+GetZarplata());
    }


    @Override
    public int hashCode()
    {
        try {
            final int prime = 33;
            int result = 1;
            result = prime * result + ((super.GetZarplata() == 0) ? 0 : super.GetZarplata().hashCode());
            return result;
        }
        catch (Exception ex)
        {
            System.out.println("Край");
            return 0;
        }
    }


    @Override
    public String toString() {
        return "To be a sisadmin is not cool!" ;
    }


    @Override
    protected void How_Are_You()
    {
        try
        {
            System.out.println("Not so good");
        }
        catch (Exception ex)
        {
            System.out.println("Жесть");
        }
    }
}
