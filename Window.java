import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private JLabel label;
    private JRadioButton redRadioButton, yellowRadioButton, blackRadioButton, orangeRadioButton, greenRadioButton;
    private JButton moveLeftButton, moveRightButton;

    public Window() {
        setTitle("Testing");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        label = new JLabel("Programming is fun");
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, java.awt.Color.black));
        redRadioButton = new JRadioButton("Red");
        yellowRadioButton = new JRadioButton("Yellow");
        blackRadioButton = new JRadioButton("Black");
        orangeRadioButton = new JRadioButton("Orange");
        greenRadioButton = new JRadioButton("Green");

        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redRadioButton);
        colorGroup.add(yellowRadioButton);
        colorGroup.add(blackRadioButton);
        colorGroup.add(orangeRadioButton);
        colorGroup.add(greenRadioButton);

        moveLeftButton = new JButton("<= Left");
        moveRightButton = new JButton("Right =>");

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(redRadioButton);
        topPanel.add(yellowRadioButton);
        topPanel.add(blackRadioButton);
        topPanel.add(orangeRadioButton);
        topPanel.add(greenRadioButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(moveLeftButton);
        bottomPanel.add(moveRightButton);

        add(topPanel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        redRadioButton.addActionListener(new ColorChange(Color.RED));
        yellowRadioButton.addActionListener(new ColorChange(Color.YELLOW));
        blackRadioButton.addActionListener(new ColorChange(Color.BLACK));
        orangeRadioButton.addActionListener(new ColorChange(Color.ORANGE));
        greenRadioButton.addActionListener(new ColorChange(Color.GREEN));

        moveLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLabelLeft();
            }
        });
        moveRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLabelRight();
            }
        });
    }

    private class ColorChange implements ActionListener {
        private Color color;

        public ColorChange(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setForeground(color);
        }
    }

    private void moveLabelLeft() {
        Point currentLocation = label.getLocation();
        int newX = currentLocation.x - 10;
        if (newX >= 0) {
            label.setLocation(newX, currentLocation.y);
        }
    }

    private void moveLabelRight() {
        Point currentLocation = label.getLocation();
        int newX = currentLocation.x + 10;
        int labelWidth = label.getWidth();
        int windowWidth = getWidth();
        if (newX + labelWidth <= windowWidth) {
            label.setLocation(newX, currentLocation.y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window textColorChanger = new Window();
            textColorChanger.setVisible(true);
        });
    }
}
