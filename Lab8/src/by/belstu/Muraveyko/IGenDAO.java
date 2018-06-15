package by.belstu.Muraveyko;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface IGenDAO<T, PK extends Serializable>
{
    T read(String key) throws SQLException;

    List<T> getAll() throws SQLException;
}
