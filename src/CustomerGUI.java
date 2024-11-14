import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerGUI extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JButton saveButton;

    public CustomerGUI() {
        setTitle("Customer Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 30);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 150, 100, 30);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 150, 200, 30);
        add(phoneField);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 100, 30);
        add(saveButton);

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            Customer customer = new Customer(name, email, phone);
            customer.saveToDatabase();
            JOptionPane.showMessageDialog(null, "Customer saved!");
        });

        setVisible(true);
    }
}
