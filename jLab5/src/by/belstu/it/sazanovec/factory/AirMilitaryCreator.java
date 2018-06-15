package by.belstu.it.sazanovec.factory;

import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.air.AirMilitary;

public class AirMilitaryCreator extends AirCreator {

    @Override
    public Air createAir(AirType airType, int countPassengers)
    {
        return new AirMilitary(airType, countPassengers);
    }

    @Override
    public Air createAir(AirType airType)
    {
        return new AirMilitary(airType);
    }
}
