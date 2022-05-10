import javax.swing.*;
import java.awt.event.*;

public class NewDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel1;
    private JPanel panel2;
    private int pr = 0;
    private JButton button1;

    public NewDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



    }

    private void onOK() {
        // add your code here
        //dispose();
        String str = textField1.getText();
        String str1 = textField2.getText();
        System.out.println(str+":"+str1);
        if (str.equals("alex")&& str1.equals("12345678")) {
            pr = 1;
            dispose();
            //contentPane.setVisible(false);


        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static class NewDialogImitator extends JDialog{
       private JButton button1;

        public NewDialogImitator() {
            JPanel jPanel = new JPanel();
            setBounds(10,10,500,300);
            jPanel.setVisible(true);
            System.out.println("NewDialogImitator123123");
        }
    }

    public static void main(String[] args) {
        NewDialog dialog = new NewDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.out.println("1");
        NewDialogImitator newDialogImitator = new NewDialogImitator();
        newDialogImitator.setVisible(true);
        System.out.println("2");
        System.exit(0);

    }


}
