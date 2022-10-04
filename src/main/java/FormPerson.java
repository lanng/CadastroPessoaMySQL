import javax.swing.*;
import java.awt.*;

public class FormPerson extends JFrame{
    private JPanel mainPanel;
    private JTextField txtName;
    private JTextField txtCpf;
    private JTextField txtRg;
    private JTextField txtDate;
    private JButton btnOK;
    private JTable tbHist;
    private JButton btnDel;
    private JTextField txtAddress;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormPerson");
        frame.setContentPane(new FormPerson().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(680, 550);
        frame.setVisible(true);
    }
}

