package by.belstu.it.sazanovec.airmanager;

import by.belstu.it.sazanovec.Test.TotalLoadCapacityTest;
import by.belstu.it.sazanovec.Test.TotalPassCapacityTest;
import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.airport.Airport;
import by.belstu.it.sazanovec.factory.AirCreator;
import by.belstu.it.sazanovec.factory.AirPassengerCreator;
import by.belstu.it.sazanovec.factory.AirMilitaryCreator;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({TotalPassCapacityTest.class, TotalLoadCapacityTest.class})
@RunWith(Suite.class)
public final class AirManager {

    private static AirManager instance;

    private AirManager() {}

    public static AirManager getInstance() {
        if (instance == null) {
            instance = new AirManager();
        }
        return instance;
    }

    // сгенерировать аэропорт
    public Airport createAirPort (AirType airType, String name, int airCount)
            throws Exception {

        Airport airport = null;
        AirCreator airCreator = null;
        ArrayList<Air> airList = new ArrayList<Air>(airCount);

        switch (airType) {
            case Boeing707:
                airCreator = new AirPassengerCreator();
                break;
            case A320:
                airCreator = new AirPassengerCreator();
                break;
            case IL76:
                airCreator = new AirMilitaryCreator();
                break;
            default:
                throw new Exception("Неизвестный тип");
        }

        int passCount = 0;

        for (int i = 0; i < airCount; i++) {
            passCount = (int)(Math.random() * 700);
            airList.add(airCreator.createAir(airType, passCount));
        }

        airport = new Airport(airList, name);
        System.out.print(airport.getAirportName() + " has been generated");
        return airport;
    }

    // общая вместимость
    public int totalPassCapacity (Airport airport) {
        int totalCapacity = 0;
        for (Air air: airport.getAirlist()) {
            totalCapacity += air.getCountPassengers();
        }
        System.out.print(airport.getAirportName() + ": total passengers capacity is " + totalCapacity);
        return totalCapacity;
    }

    // грузоподъемность
    public int totalLoadCapacity (Airport airport) {
        int totalCapacity = 0;
        ArrayList<Air> list = airport.getAirlist();
        for (Air air: list) {
            totalCapacity += air.getLoadCapacity();
        }
        System.out.print(airport.getAirportName() + ": total load capacity is " + totalCapacity);
        return totalCapacity;
    }

    Comparator<Air> compare = new Comparator<Air>() {
        @Override
        public int compare(Air o1, Air o2) {
            return Integer.compare(o1.getRange(), o2.getRange());
        }
    };

    // сортировка по дальности полёта
    public Airport sortByRange (Airport airport) {
        airport.getAirlist().sort(compare);
        System.out.print(airport.getAirportName() + " was sorted");
        return airport;
    }

    // найти самолеты, соответствующие заданному диапазону скорости
    public ArrayList<Air> findBySpeed(Airport airport, int min, int max) {

        ArrayList<Air> newAirList = new ArrayList<>();
        for (Air air: airport.getAirlist()) {
            if (air.getSpeed() >= min && air.getSpeed() <= max) {
                newAirList.add(air);
            }
        }
        System.out.print(airport.getAirportName() + ": search operation\n" + newAirList.toString());
        return newAirList;
    }

    public class Info {
        public void sayInfo() {
            System.out.print("I'm manager");
        }
    }
}
