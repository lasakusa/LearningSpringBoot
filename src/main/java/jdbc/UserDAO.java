package jdbc;
import java.sql.*;


public class UserDAO {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/boot_camp_practice";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Password";
	
	static Connection getConnection() throws SQLException{
		Connection connection =DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		return connection;
	}
	
public void insertRecord(int id, String name, String email) {
	try {
		String sql = "insert into users(id,name,email) values (?,?,?)";
		
	//get connection
	Connection connection = UserDAO.getConnection();
	
	//create a statement
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1, id);
	preparedStatement.setString(2, name);
	preparedStatement.setString(3, email);
	
	int numberOfModifiedRows = preparedStatement.executeUpdate();
	
	if(numberOfModifiedRows > 0) {
		System.out.println("data inserted successfully");
	}
	else {
		System.out.println("Data not inserted.");
		}
	
	}
	catch(Exception exception) {
		System.out.println("Data not inserted.");
		System.out.println(exception.getMessage());
		}
	
	}

public void deleteRecord(String name) {
	try {
		String sql = "delete from users where name = ?";
		
	//get connection
	Connection connection = UserDAO.getConnection();
	
	//create a statement
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setString(1, name);
	
int numberOfModifiedRows = preparedStatement.executeUpdate();
	
	if(numberOfModifiedRows > 0) {
		System.out.println("data deleted successfully");
	}
	else {
		System.out.println("Data not deleted.");
		}
	
	}
	catch(Exception exception) {
		System.out.println("Data not deleted.");
		System.out.println(exception.getMessage());
		}
	
	}

public void updateRecord(int id, String name, String email) {
	try {
		String sql = "update users set name = ?, email = ? where id = ?";
		 
	//get connection
	Connection connection = UserDAO.getConnection();
	
	//create a statement
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setString(1, name);
	preparedStatement.setString(2, email);
	preparedStatement.setInt(3, id);
	
//	System.out.print(name);
	
	
	int numberOfModifiedRows = preparedStatement.executeUpdate();
	
	if(numberOfModifiedRows > 0) {
		System.out.println("data updated successfully");
	}
	else {
		System.out.println("Data not updated.");
		}
	
	}
	catch(Exception exception) {
		System.out.println("Data not updated.");
		System.out.println(exception.getMessage());
		}
	
	}

public void fetchRecord() {
	try {
		String sql = "select * from users where id>150";
		 
	//get connection
	Connection connection = UserDAO.getConnection();
	
	//create a statement
	PreparedStatement preparedStatement = connection.prepareStatement(sql);

	// run query
				ResultSet resultSet = preparedStatement.executeQuery();

				// Process the result set
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String email = resultSet.getString("email");
					System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
				}
	
	
	}
	catch(Exception exception) {
		System.out.println("Data not available.");
		System.out.println(exception.getMessage());
		}
	
	}

}

