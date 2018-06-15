package DateBaseFiles;

import java.sql.*;


public final class DBClass
{
    private  static   String sqlConn = "jdbc:sqlite:C:\\Users\\Silent Hill\\Desktop\\Java10-12\\db\\lab10.db";

    public  static Users GetUser (String name, String Password) throws SQLException {
        Connection conn = DriverManager.getConnection(sqlConn);
        String sql = "SELECT * FROM Users where Name = ? and Password =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, Password);
        ResultSet rs = preparedStatement.executeQuery();
        Users user = null;
        while (rs.next())
        {
            user = new Users();
            user.UserName = rs.getString("Name");
            user.Role = rs.getString("Role");
        }
        conn.close();
        return user;
    }

    public  static  void RegisterUser(String name, String password, String role) throws SQLException {
        Connection conn = DriverManager.getConnection(sqlConn);
        String sql = "insert into Users values ( ?, ?, ? )";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, role);
        boolean a = preparedStatement.execute();
        conn.close();
    }
}
