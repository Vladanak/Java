package by.belstu.it.sazanovec.air;

public interface Air {

    String fly();

    int getCountPassengers();
    int getLoadCapacity();
    int getRange();
    int getSpeed();
    //AirType getAirType();

    void setCountPassengers(int countPassengers);
    void setLoadCapacity(int loadCapacity);
    void setRange(int range);
    void setSpeed(int speed);
    //void setAirType(AirType airType);
}
