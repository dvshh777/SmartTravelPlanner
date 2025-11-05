package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    // Panel to hold the dynamic cards (UPI and Card Details)
    JPanel mainPanel;
    CardLayout cardLayout;

    // Radio buttons
    JRadioButton r1_upi, r2_card;
    
    // Buttons
    JButton payButton, backButton;

    Paytm() {
        // --- 1. Frame Setup ---
        setTitle("Payment Gateway");
        setBounds(500, 200, 800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // --- 2. Radio Buttons for UPI/Card ---
        r1_upi = new JRadioButton("UPI Payment");
        r1_upi.setBounds(100, 50, 150, 30);
        r1_upi.setFont(new Font("Tahoma", Font.BOLD, 16));
        r1_upi.setBackground(Color.WHITE);
        r1_upi.setSelected(true); // Default to UPI
        r1_upi.addActionListener(this);
        add(r1_upi);

        r2_card = new JRadioButton("Credit / Debit Card");
        r2_card.setBounds(300, 50, 250, 30);
        r2_card.setFont(new Font("Tahoma", Font.BOLD, 16));
        r2_card.setBackground(Color.WHITE);
        r2_card.addActionListener(this);
        add(r2_card);

        // Group the radio buttons so only one can be selected
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1_upi);
        bg.add(r2_card);

        // --- 3. Main Panel with CardLayout ---
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(50, 120, 700, 350);
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        // --- 4. UPI Panel (Card 1) ---
        JPanel upiPanel = new JPanel();
        upiPanel.setLayout(null);
        upiPanel.setBackground(new Color(240, 248, 255)); // Light blue bg

        // Load your QR Code Image
        // !! MAKE SURE 'qr_code.png' IS IN YOUR ICONS FOLDER !!
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/qr_code.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel qrImage = new JLabel(i3);
        qrImage.setBounds(225, 30, 250, 250);
        upiPanel.add(qrImage);

        JLabel upiText = new JLabel("Scan the QR Code to pay");
        upiText.setBounds(250, 300, 300, 30);
        upiText.setFont(new Font("Tahoma", Font.PLAIN, 18));
        upiPanel.add(upiText);

        mainPanel.add(upiPanel, "UPI"); // Add this panel with the name "UPI"

        // --- 5. Card Details Panel (Card 2) ---
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBackground(new Color(240, 248, 255)); // Light blue bg

        // Card Number
        JLabel l1 = new JLabel("Card Number:");
        l1.setFont(new Font("Tahoma", Font.BOLD, 16));
        l1.setBounds(50, 30, 150, 30);
        cardPanel.add(l1);
        
        JTextField tfCardNumber = new JTextField();
        tfCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfCardNumber.setBounds(220, 30, 300, 30);
        cardPanel.add(tfCardNumber);

        // Bank Name
        JLabel l2 = new JLabel("Bank Name:");
        l2.setFont(new Font("Tahoma", Font.BOLD, 16));
        l2.setBounds(50, 90, 150, 30);
        cardPanel.add(l2);
        
        JTextField tfBankName = new JTextField();
        tfBankName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfBankName.setBounds(220, 90, 300, 30);
        cardPanel.add(tfBankName);
        
        // Expiry Date
        JLabel l3 = new JLabel("Expiry (MM/YY):");
        l3.setFont(new Font("Tahoma", Font.BOLD, 16));
        l3.setBounds(50, 150, 150, 30);
        cardPanel.add(l3);
        
        JTextField tfExpiry = new JTextField();
        tfExpiry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfExpiry.setBounds(220, 150, 100, 30);
        cardPanel.add(tfExpiry);
        
        // CVV
        JLabel l4 = new JLabel("CVV:");
        l4.setFont(new Font("Tahoma", Font.BOLD, 16));
        l4.setBounds(350, 150, 50, 30);
        cardPanel.add(l4);

        JPasswordField pfCVV = new JPasswordField();
        pfCVV.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pfCVV.setBounds(420, 150, 100, 30);
        cardPanel.add(pfCVV);

        mainPanel.add(cardPanel, "CARD"); // Add this panel with the name "CARD"
        
        // --- 6. Pay and Back Buttons ---
        payButton = new JButton("Pay");
        payButton.setBounds(200, 500, 120, 40);
        payButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        payButton.setBackground(new Color(0, 102, 102));
        payButton.setForeground(Color.WHITE);
        payButton.addActionListener(this);
        add(payButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(450, 500, 120, 40);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setBackground(new Color(0, 102, 102));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == r1_upi) {
            // If UPI radio button is clicked, show the "UPI" panel
            cardLayout.show(mainPanel, "UPI");
            
        } else if (ae.getSource() == r2_card) {
            // If Card radio button is clicked, show the "CARD" panel
            cardLayout.show(mainPanel, "CARD");

        } else if (ae.getSource() == payButton) {
            // Show a simple success message
            JOptionPane.showMessageDialog(null, "Payment Successful!");
            
            // Go back to the Payment screen
            setVisible(false);
            new Payment().setVisible(true);
            
        } else if (ae.getSource() == backButton) {
            // Go back to the Payment screen
            setVisible(false);
            new Payment().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}