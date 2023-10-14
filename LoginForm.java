import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    public LoginForm() {
        // Set title of the frame
        setTitle("Form Login");

        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing components
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton masuk = new JButton("Masuk");
        JButton keluar = new JButton("Keluar");
        JCheckBox tampilPass = new JCheckBox("Tampilkan Password");

        // Create panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Add components to panel
        panel.add(new JLabel("Username:"));
        panel.add(user);
        panel.add(new JLabel("Password:"));
        panel.add(pass);
        panel.add(tampilPass);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(masuk);
        panel.add(keluar);

        // Add panel to frame
        add(panel);

        // Set action listeners
        masuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Masuk ditekan");
            }
        });

        keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Keluar ditekan");
                System.exit(0);
            }
        });

        tampilPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tampilPass.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });

        // Set frame properties
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}

