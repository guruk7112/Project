package Ecommerce.mycs.generic.DatabaseUtility;
/**
 * @author Gurup
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;

	public ResultSet getConnectToDataBaseSelectquery(String SelectQuery) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		ResultSet result = conn.createStatement().executeQuery(SelectQuery);

		return result;
	}

	public int getConnectToDataBaseNonSelect(String nonSelectQuery) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		int result = conn.createStatement().executeUpdate(nonSelectQuery);

		return result;
	}

	public void connectToDataBase() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");

	}

	public void closeConnections() throws SQLException {
		conn.close();
	}

}
