package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class NameNotEnteredException extends Exception {
    public NameNotEnteredException(String message) {
        super(message);
    }
}

public class Login extends JFrame implements ActionListener {
    JButton start;
    JTextField enter_name;

    Login() {
        getContentPane().setBackground(new Color(231, 236, 239));
        setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/quiz-icon.png"));
        JLabel image = new JLabel(img);
        image.setBounds(45, -100, 500, 500);
        add(image);

        JLabel heading = new JLabel("Think Fast");
        heading.setBounds(190, 300, 300, 45);
        heading.setFont(new Font("OpenSymbol", Font.BOLD, 40));
        heading.setForeground(new Color(39, 76, 119));
        add(heading);

        JLabel name = new JLabel("Enter Name:");
        name.setBounds(240, 350, 300, 45);
        name.setFont(new Font("OpenSymbol", Font.BOLD, 16));
        name.setForeground(new Color(39, 76, 119));
        add(name);

        enter_name = new JTextField();
        enter_name.setBounds(140, 400, 300, 25);
        add(enter_name);

        start = new JButton("Start");
        start.setBounds(200, 450, 120, 25);
        start.addActionListener(this);
        add(start);

        setSize(600, 700);
        setLocation(650, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            try {
                String name = enter_name.getText().trim(); 

               
                if (name.isEmpty()) {
                    throw new NameNotEnteredException("Name has to be entered!");
                }

                
                new Quiz(name);
                setVisible(false);

            } catch (NameNotEnteredException e) {
                
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
