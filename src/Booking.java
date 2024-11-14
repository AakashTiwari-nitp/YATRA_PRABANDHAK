import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Booking {
    private int id;
    private int customerId;
    private int tripId;
    private Date bookingDate;

    public Booking(int customerId, int tripId, Date bookingDate) {
        this.customerId = customerId;
        this.tripId = tripId;
        this.bookingDate = bookingDate;
    }

    public void saveToDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO bookings (customer_id, trip_id, booking_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, this.customerId);
            stmt.setInt(2, this.tripId);
            stmt.setDate(3, this.bookingDate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
