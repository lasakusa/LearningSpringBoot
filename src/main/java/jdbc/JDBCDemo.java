package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class JDBCDemo {
    public static void main(String[] args) {
        // Database URL, username, and password
        String jdbcURL = "jdbc:mysql://localhost:3306/boot_camp_practice"; // Replace 'demo_db' with your database name
        String username = "root"; // Replace with your database username
        String password = "Password"; // Replace with your database password
        Connection connection = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Establish the connection
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database!");
            // Step 3: Create a prepared statement
            String sql = "SELECT id, name, email FROM users WHERE id > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Step 4: Set parameter(s)
            preparedStatement.setInt(1, 101); // Example: fetch all users with id > 0
            // Step 5: Execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 6: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
            // Close the result set and statement
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Step 7: Close the connection
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}




