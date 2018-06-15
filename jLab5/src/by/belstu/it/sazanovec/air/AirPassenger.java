package by.belstu.it.sazanovec.air;

public class AirPassenger implements Air {

    private AirType airType;    // тип
    private int loadCapacity;   // грузоподъемность
    private int countPassengers;  // кол-во пассажиров
    private int range;  // дальность полёта
    private int speed;  // скорость

    public AirPassenger() {}
    public AirPassenger(AirType airType) {
        this.airType = airType;
    }
    public AirPassenger(AirType airType, int countPassengers) {
        this.airType = airType;
        this.countPassengers = countPassengers;

        loadCapacity = countPassengers * 70;
        range =  5000 - loadCapacity % 100;
        speed = 700 - loadCapacity % 100;
    }

    @Override
    public int getCountPassengers() { return countPassengers; }

    @Override
    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    @Override
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void setRange(int range) { this.range = range; }

    @Override
    public void setSpeed(int speed) { this.speed = speed; }

    @Override
    public String fly() {
        return "Пассажирский самолёт взлетел";
    }

    public String toString() {
        return  String.format(airType.name() + "   load capacity: %d, passengers: %d, range: %d, speed: %d",
                loadCapacity, countPassengers, range, speed);
    }
}
