import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JTextField txtNationality;
    private JButton btnUpdate;
    private JScrollPane tableHist;

    public FormPerson() {
        Historic();
        PersonsDAO personsDAO = new PersonsDAO();
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person(txtName.getText(), txtCpf.getText(), txtRg.getText(), txtDate.getText(), txtAddress.getText(), txtNationality.getText());
                personsDAO.addPerson(person);
                Historic();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tbHist.getSelectedRow();
                if (index >= 0) {
                    int id = (int) tbHist.getModel().getValueAt(index, 0);
                    int op = JOptionPane.showConfirmDialog(mainPanel, "Deseja realmente excluir esse registro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (op == 0) {
                        personsDAO.deletePerson(id);
                        Historic();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(mainPanel, "Selecione uma linha", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tbHist.getSelectedRow();
                if (index >= 0) {
                    int id = (int) tbHist.getModel().getValueAt(index, 0);
                    int op = JOptionPane.showConfirmDialog(mainPanel, "Deseja realmente atualizar esse registro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (op == 0) {
//                        personsDAO.up(id); ->update
                        //Create a JFrame/JPanel to access the attributes and edit the infos
                        Historic();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(mainPanel, "Selecione uma linha", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void Historic(){
        PersonsDAO pdao = new PersonsDAO();
        ArrayList<Person> vet = pdao.listPersons();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("RG");
        model.addColumn("Data Nascimento");
        model.addColumn("Endereço");
        model.addColumn("Nacionalidade");
        for (int i = 0; i < vet.size(); i++) {
            Object[] v = new Object[]{
                    vet.get(i).getId(),
                    vet.get(i).getName(),
                    vet.get(i).getCpf(),
                    vet.get(i).getRg(),
                    vet.get(i).getDateOfBirth(),
                    vet.get(i).getAddress(),
                    vet.get(i).getNationality(),
            };
            model.addRow(v);
        }
        tbHist.setModel(model);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("FormPerson");
        frame.setContentPane(new FormPerson().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780, 650);
        frame.setVisible(true);
    }
}

