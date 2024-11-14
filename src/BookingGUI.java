import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class BookingGUI extends JFrame {
    private JTextField customerIdField, tripIdField, bookingDateField;
    private JButton saveButton;

    public BookingGUI() {
        setTitle("Booking Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(50, 50, 100, 30);
        add(customerIdLabel);

        customerIdField = new JTextField();
        customerIdField.setBounds(150, 50, 200, 30);
        add(customerIdField);

        JLabel tripIdLabel = new JLabel("Trip ID:");
        tripIdLabel.setBounds(50, 100, 100, 30);
        add(tripIdLabel);

        tripIdField = new JTextField();
        tripIdField.setBounds(150, 100, 200, 30);
        add(tripIdField);

        JLabel bookingDateLabel = new JLabel("Booking Date:");
        bookingDateLabel.setBounds(50, 150, 100, 30);
        add(bookingDateLabel);

        bookingDateField = new JTextField();
        bookingDateField.setBounds(150, 150, 200, 30);
        add(bookingDateField);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 100, 30);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int customerId = Integer.parseInt(customerIdField.getText());
                int tripId = Integer.parseInt(tripIdField.getText());
                Date bookingDate = Date.valueOf(bookingDateField.getText());

                Booking booking = new Booking(customerId, tripId, bookingDate);
                booking.saveToDatabase();

                JOptionPane.showMessageDialog(null, "Booking saved!");
            }
        });

        setVisible(true);
    }
}
