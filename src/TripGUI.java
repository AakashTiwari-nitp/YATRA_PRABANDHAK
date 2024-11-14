import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class TripGUI extends JFrame {
    private JTextField destinationField, costField;
    private JTextField startDateField, endDateField;
    private JButton saveButton;

    public TripGUI() {
        setTitle("Trip Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(50, 50, 100, 30);
        add(destinationLabel);

        destinationField = new JTextField();
        destinationField.setBounds(150, 50, 200, 30);
        add(destinationField);

        JLabel startDateLabel = new JLabel("Start Date:");
        startDateLabel.setBounds(50, 100, 100, 30);
        add(startDateLabel);

        startDateField = new JTextField();
        startDateField.setBounds(150, 100, 200, 30);
        add(startDateField);

        JLabel endDateLabel = new JLabel("End Date:");
        endDateLabel.setBounds(50, 150, 100, 30);
        add(endDateLabel);

        endDateField = new JTextField();
        endDateField.setBounds(150, 150, 200, 30);
        add(endDateField);

        JLabel costLabel = new JLabel("Cost:");
        costLabel.setBounds(50, 200, 100, 30);
        add(costLabel);

        costField = new JTextField();
        costField.setBounds(150, 200, 200, 30);
        add(costField);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 250, 100, 30);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String destination = destinationField.getText();
                Date startDate = Date.valueOf(startDateField.getText());
                Date endDate = Date.valueOf(endDateField.getText());
                double cost = Double.parseDouble(costField.getText());

                Trip trip = new Trip(destination, startDate, endDate, cost);
                trip.saveToDatabase();

                JOptionPane.showMessageDialog(null, "Trip saved!");
            }
        });

        setVisible(true);
    }
}
