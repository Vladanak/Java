package by.belstu.it.sazanovec.airport;

import by.belstu.it.sazanovec.air.Air;

import java.util.ArrayList;

public class Airport {


    private ArrayList<Air> airlist;
    private String airportName;

    public Airport() {
        airlist = null;
    }

    public Airport(ArrayList<Air> airport, String name) {
        airlist = airport;
        airportName = name;
    }

    public ArrayList<Air> getAirlist() {
        return airlist;
    }

    public void setAirlist(ArrayList<Air> airlist) {
        this.airlist = airlist;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void add (Air item) {
        if (airlist != null) {
            airlist.add(item);
        }
    }

    public Air remove (int index) {
        return airlist != null ? airlist.remove(index) : null;
    }

    @Override
    public String toString(){
        String airs = airportName + "------\n";
        for(Air air:getAirlist()) {
            airs += air.toString() + "\n";
        }
        System.out.print(airs);
        return airs;
    }
}

