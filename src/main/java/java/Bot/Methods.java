package java.Bot;

import java.sql.*;

public class Methods implements InerfaceMethods{
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    String url="jdbc:postgresql://localhost:5432/TestBot";
    String userDB="postgres", pass="mahmudxon";
    int n=0;
    String matematika;
    String ingliz_tili;
    String temp2="";

    @Override
    public void addUser(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();



        temp2="'"+user.getTgID()+"','"+user.getUserName()+"','"+user.getFirstName()+"','"+user.getLastName()+"'";
        statement.execute("insert into users(tgid, username,firstname,lastname) values ("+temp2+")");


    }

    @Override
    public void addResult(String id, String resultIndexses) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
    }

    @Override
    public void Tekshiruvchi(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
    }

    @Override
    public boolean findUser(String id) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();

        return false;
    }
}
