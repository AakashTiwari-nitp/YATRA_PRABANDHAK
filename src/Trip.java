import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trip {
    private int id;
    private String destination;
    private Date startDate;
    private Date endDate;
    private double cost;

    public Trip(String destination, Date startDate, Date endDate, double cost) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public void saveToDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO trips (destination, start_date, end_date, cost) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.destination);
            stmt.setDate(2, this.startDate);
            stmt.setDate(3, this.endDate);
            stmt.setDouble(4, this.cost);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
