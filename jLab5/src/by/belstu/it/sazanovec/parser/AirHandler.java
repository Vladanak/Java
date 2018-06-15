package by.belstu.it.sazanovec.parser;
import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.airport.Airport;
import by.belstu.it.sazanovec.factory.AirCreator;
import by.belstu.it.sazanovec.factory.AirPassengerCreator;
import by.belstu.it.sazanovec.factory.AirMilitaryCreator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static by.belstu.it.sazanovec.air.AirType.*;
import static java.lang.String.*;

public class AirHandler extends DefaultHandler {
    private ArrayList<Air> airlist;
    private Air current = null;
    String thisElement = "";

    public AirHandler() {
        airlist = new ArrayList<Air>();
    }
    public ArrayList<Air> getAirlist() {
        return airlist;
    }
    // вызывается на старте обработки документа
    @Override
    public void startDocument() {
        System.out.print("GOOD!");
    }
    // будет вызван, когда анализатор полностью обработает содержимое
    // открывающего тега, включая его имя и все содержащиеся атрибуты
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        AirCreator airCreator = null;
        if ("air".equals(localName)) {
            AirType airType = AirType.valueOf(attrs.getValue(0));
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
                    System.out.print("UNKNONW TYPE!");
            }
            current = airCreator.createAir(airType);
        }
        thisElement = qName;
    }
    // вызывается в том случае, если анализатор встретил символьную информацию внутри элемента (тело
    // тега). Если этой информации достаточно много, то метод может быть вызван более одного раза
    @Override
    public void characters(char[ ] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (thisElement.equals("loadCapacity")) {
            current.setLoadCapacity(Integer.parseInt(s));
        }
        if (thisElement.equals("countPassengers")) {
            current.setCountPassengers(Integer.parseInt(s));
        }
        if (thisElement.equals("range")) {
            current.setRange(Integer.parseInt(s));
        }
        if (thisElement.equals("speed")) {
            current.setSpeed(Integer.parseInt(s));
        }
    }
    // сигнализирует о завершении элемента
    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("air".equals(localName)) {
            airlist.add(current);
        }
        thisElement = "";
    }
    // вызывается при завершении разбора документа
    @Override
    public void endDocument() {
        System.out.print("BAD!");
    }
}
