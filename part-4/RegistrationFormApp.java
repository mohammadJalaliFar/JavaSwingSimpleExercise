import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationFormApp extends JFrame implements ActionListener {

    private JTextField txtName;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JRadioButton rbMale, rbFemale;
    private JCheckBox cbJava, cbPython, cbCpp;
    private JButton btnSubmit;
    private GridBagConstraints gbc;

    public RegistrationFormApp() {
        setTitle("User Registration");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        txtName = new JTextField(20);
        panel.add(txtName, gbc);

        // Row 1
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        panel.add(txtEmail, gbc);

        // Row 2
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        txtPassword = new JPasswordField(20);
        panel.add(txtPassword, gbc);

        // Row 3
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        JPanel genderPanel = new JPanel();
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        panel.add(genderPanel, gbc);

        // Row 4
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Interests:"), gbc);
        gbc.gridx = 1;
        cbJava = new JCheckBox("Java");
        cbPython = new JCheckBox("Python");
        cbCpp = new JCheckBox("C++");
        JPanel interestPanel = new JPanel();
        interestPanel.add(cbJava);
        interestPanel.add(cbPython);
        interestPanel.add(cbCpp);
        panel.add(interestPanel, gbc);

        // Row 5: Submit button
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        panel.add(btnSubmit, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Unspecified";
        StringBuilder interests = new StringBuilder();
        if (cbJava.isSelected()) interests.append("Java ");
        if (cbPython.isSelected()) interests.append("Python ");
        if (cbCpp.isSelected()) interests.append("C++ ");

        JOptionPane.showMessageDialog(this,
                "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Gender: " + gender + "\n" +
                        "Interests: " + interests.toString(),
                "Registration Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationFormApp().setVisible(true));
    }
}
