package by.belstu.it.sazanovec.Test;

import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.airmanager.AirManager;
import by.belstu.it.sazanovec.airport.Airport;
import by.belstu.it.sazanovec.factory.AirCreator;
import by.belstu.it.sazanovec.factory.AirPassengerCreator;
import org.junit.*;

import java.util.ArrayList;

public class TotalPassCapacityTest {
    AirCreator airCreator;
    Air air1, air2;
    ArrayList<Air> airList;
    Airport airport;
    AirManager airManager;

    @BeforeClass
    public static void beforeTest()
    {
        System.out.println("Test is starting");
    }

    @Before
    public void initAll()
    {
        airCreator = new AirPassengerCreator();
        air1 = airCreator.createAir(AirType.A320, 60);
        air2 = airCreator.createAir(AirType.Boeing707, 75);
        airList = new ArrayList<Air>();
        airManager = AirManager.getInstance();
    }

    @Test(timeout = 2000)
    public void totalPassCapacityTest()
    {
        airList.add(air1);
        airList.add(air2);

        airport = new Airport(airList, "MinskAirport");

        int expected = 60 + 75;
        int actual = airManager.totalPassCapacity(airport);
        Assert.assertEquals("Test failed", expected, actual);
    }

    @After
    public void tearDownAll()
    {
        airCreator = null;
        air1 = null;
        air2 = null;
        airList = null;
        airManager = null;
    }

    @AfterClass
    public static void afterTest()
    {
        System.out.println("Test has been finished");
    }
}
