package java.Bot;

import java.sql.SQLException;

public interface InerfaceMethods {
    void addUser(User user) throws SQLException, ClassNotFoundException;
    void addResult(String id, String resultIndexses) throws ClassNotFoundException, SQLException;
    void Tekshiruvchi(User user) throws SQLException, ClassNotFoundException;
    boolean findUser(String id) throws SQLException, ClassNotFoundException;
}
