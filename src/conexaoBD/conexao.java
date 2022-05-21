import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.SQLException;

public class conexaoBD {

    public Connection conectaBD(){
        Connection conn = null;

        try{
                String url = "jdbc:mysql://localhost:3306/casaLinda?user=root&password="
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,erro.getMessage());
        }
        return conn;
    }
}