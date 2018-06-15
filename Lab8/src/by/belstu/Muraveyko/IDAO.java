package by.belstu.Muraveyko;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO
{
    Connection getConnection()throws SQLException;

    IGenDAO<Planets, Integer> getPlanetsDAO(Connection connection);

    IGenDAO<Satellites, Integer> getSatellitesDAO(Connection connection);
}
