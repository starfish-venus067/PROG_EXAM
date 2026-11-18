

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp_question_2 extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;

    public ProductApp_question_2() {
        setTitle("Product App");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== MENU BAR =====
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(clearItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // ===== FORM PANEL - Q2.2 =====
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 1. Text box for Customer Name
        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        // 2. Combo box for Product Name
        panel.add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        // 3. Text box for Product Price
        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        // 4. Process Button
        panel.add(new JLabel(""));
        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(btnProcess);

        add(panel);

        // ===== Q2.3 - PROCESS BUTTON =====
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        clearItem.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });
        exitItem.addActionListener(e -> System.exit(0));
    }

    private void processSale() {
        try {
            // Capture customer's name and selected product
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter customer name");
                return;
            }

            // Calculations
            double vat = price * 0.15; // VAT: 15%
            double commission = price * 0.05; // Commission: 5%
            double total = price + vat + commission;

            // Message to show - EXACT format from screenshot
            String message = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt - EXACT format from screenshot
            try {
                FileWriter writer = new FileWriter("data.txt");
                writer.write("DATA LOG\n");
                writer.write("****************************\n");
                writer.write("Customer Name: " + customerName + "\n");
                writer.write("Product: " + productName + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + total + "\n");
                writer.write("****************************\n");
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp_question_2().setVisible(true);
        });
    }
}
