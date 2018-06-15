package by.belstu.VladMur.Task1;

public class Main
{
    private static final int CARCOUT = 20;
    private static final int PARKINGSIZE = 5;

    public static void main(String[] args)
    {
        Parking parking = new Parking(PARKINGSIZE);
        for (int i = 0; i < CARCOUT; i++)
        {
            (new Car(i, parking)).start();
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
