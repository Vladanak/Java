package by.belstu.it.sazanovec.Test;

import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.airmanager.AirManager;
import by.belstu.it.sazanovec.airport.Airport;
import by.belstu.it.sazanovec.factory.AirCreator;
import by.belstu.it.sazanovec.factory.AirPassengerCreator;
import org.junit.*;

import java.util.ArrayList;

public class TotalLoadCapacityTest {
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
        air1 = airCreator.createAir(AirType.A320);
        air2 = airCreator.createAir(AirType.Boeing707);
        air1.setLoadCapacity(180);
        air2.setLoadCapacity(210);
        airList = new ArrayList<Air>();
        airManager = AirManager.getInstance();
    }

    @Test
    @Ignore("not yet")
    public void totalLoadCapacityTest()
    {
        airList.add(air1);
        airList.add(air2);

        airport = new Airport(airList, "MinskAirport");

        int expected = 180 + 210;
        int actual = airManager.totalLoadCapacity(airport);
        Assert.assertEquals("Test failed", expected, actual);
    }

    @After
    public void tearDownAll()
    {
        airCreator = null;
        air1 = null;
        air2 = null;
        airList = null;
    }

    @AfterClass
    public static void afterTest()
    {
        System.out.println("Test has been finished");
    }
}
