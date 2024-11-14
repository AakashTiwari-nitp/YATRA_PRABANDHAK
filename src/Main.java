import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        setTitle("Yatra Prabandhak - Travel Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton customerButton = new JButton("Manage Customers");
        JButton tripButton = new JButton("Manage Trips");
        JButton bookingButton = new JButton("Manage Bookings");
        JButton exitButton = new JButton("Exit");

        customerButton.addActionListener(e -> new CustomerGUI());
        tripButton.addActionListener(e -> new TripGUI());
        bookingButton.addActionListener(e -> new BookingGUI());
        exitButton.addActionListener(e -> System.exit(0));

        add(customerButton);
        add(tripButton);
        add(bookingButton);
        add(exitButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
