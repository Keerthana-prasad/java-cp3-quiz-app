package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Result extends JFrame implements ActionListener {
    String name;
    public static int score;
    Result(String name, int score) {
        this.name = name;

        getContentPane().setBackground(new Color(231, 236, 239));
        setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/quiz-icon.png"));
        JLabel image = new JLabel(img);
        image.setBounds(45, -100, 500, 500);
        add(image);

        JLabel heading = new JLabel("Results");
        heading.setBounds(230, 300, 300, 45);
        heading.setFont(new Font("OpenSymbol", Font.BOLD, 40));
        heading.setForeground(new Color(39, 76, 119));
        add(heading);

        JLabel label_score = new JLabel("Score: " + score);
        label_score.setBounds(235, 400, 300, 32);
        label_score.setFont(new Font("OpenSymbol", Font.BOLD, 32));
        label_score.setForeground(new Color(39, 76, 119));
        add(label_score);

        JButton exit = new JButton("Exit");
        exit.setBounds(240, 450, 120, 35);
        exit.setBackground(new Color(39, 76, 119));
        exit.setForeground(new Color(231, 236, 239));
        exit.addActionListener(this);
        add(exit);


        setSize(600, 700);
        setLocation(650,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        
    }

    public static void main(String[] args) {
        new Result("User", score);
    }
}
