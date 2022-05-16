package NewPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class NewGui {
    private JButton button1;
    private JPanel panel1;
    private JRadioButton radioButton1;

    public NewGui() {
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
        button1.addActionListener(e -> {System.exit(0);});
//        radioButton1.addInputMethodListener(new InputMethodListener() {
//            @Override
//            public void inputMethodTextChanged(InputMethodEvent event) {
//                if (radioButton1.isSelected()) button1.setVisible(false);
//                else button1.setVisible(true);
//            }
//        });
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton1.isSelected()) button1.setVisible(false);
                else button1.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NewGui");
        frame.setContentPane(new NewGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
