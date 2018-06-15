package by.belstu.it.sazanovec.main;

import by.belstu.it.sazanovec.ValidatorSAXXSD;
import by.belstu.it.sazanovec.air.Air;
import by.belstu.it.sazanovec.air.AirPassenger;
import by.belstu.it.sazanovec.airmanager.AirManager;
import by.belstu.it.sazanovec.airport.Airport;
import by.belstu.it.sazanovec.air.AirType;
import by.belstu.it.sazanovec.parser.AirHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;
import com.google.gson.Gson;

/* Авиакомпания.
Определить иерархию самолетов. Создать авиакомпанию.
Посчитать общую вместимость и грузоподъемность. Создать диспечера.
Его функции: провести сортировку самолетов компании по дальности полета,
найти самолет в компании, соответствующий заданному диапазону параметров
потребления горючего.*/

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("START");
        String fileName = "files/airlist.xml";
        String schemaName = "files/airlist.xsd";
        ValidatorSAXXSD.validate(fileName, schemaName);
        try {
            // создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            AirHandler handler = new AirHandler();
            reader.setContentHandler(handler);
            reader.parse(fileName);
            List<Air> list = handler.getAirlist();
            System.out.println(list);

            // преобразование xml в html
            TransformerFactory xstf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = null;
            transformer = xstf.newTransformer(new StreamSource("files/air.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource("files/airlist.xml"), new StreamResult("files/info.html"));

            // Serialization
            FileOutputStream out = new FileOutputStream("files/serialize.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(list.get(0));
            xmlEncoder.close();

            // DeSerialization
            FileInputStream in = new FileInputStream("files/serialize.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            Air air = (Air) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println(((AirPassenger)air).fly());

            // json
            FileWriter fw = new FileWriter("files/air.json", false);
            Gson gson = new Gson();
            gson.toJson((AirPassenger)air, fw);
            fw.close();

            FileReader fr = new FileReader("files/air.json");
            AirPassenger newAir = gson.fromJson(fr, AirPassenger.class);
            fr.close();
            System.out.println(newAir.fly());

//            AirManager airManager = AirManager.getInstance();
//            Airport firstAirport = airManager.createAirPort(AirType.A320, "Minsk Airport", 10);
//            firstAirport.toString();
//            airManager.totalLoadCapacity(firstAirport);
//            airManager.totalPassCapacity(firstAirport);
//            airManager.sortByRange(firstAirport);
//            firstAirport.toString();
//            airManager.findBySpeed(firstAirport, 750, 760);
//            AirManager.Info info = airManager.new Info();
//            info.sayInfo();
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            System.out.print("ERROR SAX PARSER"+ e);
        }
        catch (IOException e) {
            System.out.print("ERROR I/O STREAM" + e);
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
}
