
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CARLOS AIRES
 */
public class Banco {
    
    public Connection getConnection() {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/loja", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
