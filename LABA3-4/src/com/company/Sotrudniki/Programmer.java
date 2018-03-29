package com.company.Sotrudniki;

import com.company.Except.Except;

public class Programmer extends Sotrudniki implements Info {
    public enum Dolgnost{Junior,Middle,Senior};
    private Dolgnost dolgnost;
    Programmer(String Name,int Year,int Zarplata,Dolgnost dolg)
    {
        super();
        super.SetName(Name);
        super.SetYear(Year);
        super.SetZarplata(Zarplata);
        dolgnost=dolg;
    }

    public void setDolgnost(Dolgnost dolgi) {
        this.dolgnost = dolgi;
    }
    public Dolgnost getDolgnost()
    {
        return dolgnost;
    }
    @Override
    public void Info()
    {
        try
        {
            System.out.println("Программист:" + GetName() + GetYear() + GetZarplata() + getDolgnost());
        }
        catch (Exception ex)
        {
            System.out.println("Жесть");
        }
    }
    @Override
    public int hashCode()
    {
        final int prime=33;
        int result =1;
        result=prime * result +((super.GetName()==null)? 0 : super.GetName().hashCode());
        return result;
    }
    @Override
    public String toString() {
        return "To be a programmer is not so easy as you think!" ;
    }


    @Override
    protected void How_Are_You()
    {
        System.out.println("Fine");
    }
}
