import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class TrafficLightSystem extends JFrame implements ActionListener {

    // Pole 1
    private Ellipse2D redCircle1;
    private Ellipse2D yellowCircle1;
    private Ellipse2D greenCircle1;

    // Pole 2
    private Ellipse2D redCircle2;
    private Ellipse2D yellowCircle2;
    private Ellipse2D greenCircle2;

    public TrafficLightSystem() {
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Pole 1
        redCircle1 = new Ellipse2D.Double(0, 0, 50, 50);
        yellowCircle1 = new Ellipse2D.Double(0, 0, 50, 50);
        greenCircle1 = new Ellipse2D.Double(0, 0, 50, 50);

        // Pole 2
        redCircle2 = new Ellipse2D.Double(0, 0, 50, 50);
        yellowCircle2 = new Ellipse2D.Double(0, 0, 50, 50);
        greenCircle2 = new Ellipse2D.Double(0, 0, 50, 50);

        // Add circles to JFrame
        add(new JLabel(new CircleIcon(redCircle1, Color.RED)));
        add(new JLabel(new CircleIcon(yellowCircle1, Color.YELLOW)));
        add(new JLabel(new CircleIcon(greenCircle1, Color.GREEN)));

        add(new JLabel(new CircleIcon(redCircle2, Color.RED)));
        add(new JLabel(new CircleIcon(yellowCircle2, Color.YELLOW)));
        add(new JLabel(new CircleIcon(greenCircle2, Color.GREEN)));
    }

    public void actionPerformed(ActionEvent e) {
        // Set initial colors to green
        redCircle1.setFrame(0, 0, 50, 50);
        yellowCircle1.setFrame(0, 0, 50, 50);
        greenCircle1.setFrame(0, 0, 50, 50);

        redCircle2.setFrame(0, 0, 50, 50);
        yellowCircle2.setFrame(0, 0, 50, 50);
        greenCircle2.setFrame(0, 0, 50, 50);

        // Change the color of circles on pole 1 and 2 after every 2 seconds
        Timer timer1 = new Timer(2000, e1 -> {
            greenCircle1.setFrame(50, 0, 50, 50);
            redCircle1.setFrame(0, 0, 50, 50);
            yellowCircle1.setFrame(0, 0, 50, 50);
        });
        timer1.start();

        Timer timer2 = new Timer(2000, e2 -> {
            greenCircle2.setFrame(50, 0, 50, 50);
            redCircle2.setFrame(0, 0, 50, 50);
            yellowCircle2.setFrame(0, 0, 50, 50);
        });
        timer2.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrafficLightSystem tl = new TrafficLightSystem();
            tl.setVisible(true);
        });
    }

    // Inner class to draw a circle
    private static class CircleIcon implements Icon {
        public CircleIcon(Ellipse2D redCircle1, Color red) {
        }

        private final Ellipse2D circle;

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'paintIcon'");
        }

        @Override
        public int getIconWidth() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getIconWidth'");
        }

        @Override
        public int getIconHeight() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getIconHeight'");
        }
    }