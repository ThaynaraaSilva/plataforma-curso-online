package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionSingleton {
	private static ConnectionSingleton instance;
    private Connection conexao;

    private static final String URL = "jdbc:mysql://localhost:3306/plataforma_cursos?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root"; 
    private static final String PASSWORD = "thaynara26"; 

   
    private ConnectionSingleton() throws SQLException {
        this.conexao = DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static ConnectionSingleton getInstance() throws SQLException {
        if (instance == null || instance.conexao.isClosed()) {
            instance = new ConnectionSingleton();
            System.out.println("Novo Objeto de Conexão");
        } else {
            System.out.println("Reutilizando a Conexão");
        }
        return instance;
    }


    public Connection getConnection() {
        return conexao;
    }
	
}
