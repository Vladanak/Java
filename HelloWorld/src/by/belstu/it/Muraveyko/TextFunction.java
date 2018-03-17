package by.belstu.it.Muraveyko;

public class TextFunction{
    public TextFunction() {
    }

    public String getValue()
    {
        return "Hello From First Project";
    }
    public void deletString(){
        for(int i=0;i<9;i++)
        {
            if(i>-1)
            {
                if(i<10)
                    System.out.println(i);
            }
        }
        deletString();
    }
    public void onCreate()
    {
        for (int a = 0; a < 10; a++) {
            System.out.println("Count"+ a);
        }
    }
}
