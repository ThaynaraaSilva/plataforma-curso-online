package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    private static final String URL = "jdbc:mysql://localhost:3306/plataformadecursosonline?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "thaynara26";

    public static Connection createConnection() throws SQLException {
        Connection conexao = null;
        try {
           
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
           
            System.out.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
            throw e;  
        }
       
        return conexao;
    }
}
