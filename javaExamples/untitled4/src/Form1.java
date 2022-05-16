import javax.swing.*;

public class Form1 {

    private JPanel panel1;
    private JButton Button;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form1");
        frame.setContentPane(new Form1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
