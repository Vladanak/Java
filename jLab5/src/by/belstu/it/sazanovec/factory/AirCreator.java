package by.belstu.it.sazanovec.factory;

import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;

// общий интерфйс для создания объектов в суперклассе

public abstract class AirCreator {

    //
    public abstract Air createAir(AirType airType, int countPassengers);
    public abstract Air createAir(AirType airType);
}
