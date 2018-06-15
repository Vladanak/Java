package by.belstu.Muraveyko;

import java.sql.*;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        MyDAO dao = new MyDAO();
        List<Planets> planetsList;
        List<Satellites> satellitesList;
        try
        {
            Connection con = dao.getConnection();

            System.out.println("All planets");
            IGenDAO<Planets, Integer> planetsDAO = dao.getPlanetsDAO(con);
            planetsList = planetsDAO.getAll();
            System.out.println(planetsList);

            System.out.println();
            System.out.println("All satellites");
            IGenDAO<Satellites, Integer> satellitesDAO = dao.getSatellitesDAO(con);
            satellitesList = satellitesDAO.getAll();
            System.out.println(satellitesList);

            System.out.println();
            System.out.println("Planets with life");
            planetsList = ((MyDAO_Planets)(planetsDAO)).planetsWithLife();
            System.out.println(planetsList);

            System.out.println();
            System.out.println("Satellite with minimal radius");
            System.out.println(((MyDAO_Sattelites)(satellitesDAO)).getWithMinRadius().toString());

            System.out.println();
            System.out.println("Transaction");
            System.out.println("before");
            System.out.println(((MyDAO_Sattelites)(satellitesDAO)).read("Moon"));
            ((MyDAO_Sattelites)(satellitesDAO)).updateRadiusByName("Moon", 500);
            con.commit();
            System.out.println("After");
            System.out.println(((MyDAO_Sattelites)(satellitesDAO)).read("Moon"));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
