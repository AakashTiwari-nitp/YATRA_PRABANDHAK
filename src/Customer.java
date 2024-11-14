import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void saveToDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.name);
            stmt.setString(2, this.email);
            stmt.setString(3, this.phone);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
