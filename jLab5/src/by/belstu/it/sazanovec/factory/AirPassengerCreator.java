package by.belstu.it.sazanovec.factory;

import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.air.AirPassenger;

public class AirPassengerCreator extends AirCreator {

    @Override
    public Air createAir(AirType airType, int countPassengers)
    {
        return new AirPassenger(airType, countPassengers);
    }

    @Override
    public Air createAir(AirType airType)
    {
        return new AirPassenger(airType);
    }
}
