package quiz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Quiz extends JFrame implements ActionListener{
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_answers[][] = new String[10][1];
    String name;
    JLabel qno, question;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup grpoptions;
    JButton next, finish;
    public static int timer = 10;
    public static int user_ans = 0;
    public static int count = 0;
    public static int score = 0;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(new Color(231, 236, 239));
        setLayout(null);

        qno = new JLabel();
        qno.setBounds(290,30,50,35);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(qno);

        question = new JLabel();
        question.setBounds(30,90,600,30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(question);

        questions[0][0] = "Which of the following is not a primitive data type in Java?";
        questions[0][1] = "int";
        questions[0][2] = "float";
        questions[0][3] = "String";
        questions[0][4] = "boolean";
        answers[0][1] = "String";

        // Question 2
        questions[1][0] = "What is the size of an int data type in Java?";
        questions[1][1] = "16 bits";
        questions[1][2] = "32 bits";
        questions[1][3] = "64 bits";
        questions[1][4] = "128 bits";
        answers[1][1] = "32 bits";

        // Question 3
        questions[2][0] = "Which keyword is used to define a subclass in Java?";
        questions[2][1] = "extends";
        questions[2][2] = "implements";
        questions[2][3] = "inherits";
        questions[2][4] = "subclass";
        answers[2][1] = "extends";

        // Question 4
        questions[3][0] = "What is the default value of a boolean variable in Java?";
        questions[3][1] = "true";
        questions[3][2] = "false";
        questions[3][3] = "0";
        questions[3][4] = "null";
        answers[3][1] = "false";

        // Question 5
        questions[4][0] = "Which of the following is used to handle exceptions in Java?";
        questions[4][1] = "try-catch";
        questions[4][2] = "if-else";
        questions[4][3] = "for loop";
        questions[4][4] = "switch-case";
        answers[4][1] = "try-catch";

        // Question 6
        questions[5][0] = "Which of these access modifiers is the most restrictive in Java?";
        questions[5][1] = "private";
        questions[5][2] = "protected";
        questions[5][3] = "public";
        questions[5][4] = "default";
        answers[5][1] = "private";

        // Question 7
        questions[6][0] = "Which method is used to start a thread execution in Java?";
        questions[6][1] = "start()";
        questions[6][2] = "run()";
        questions[6][3] = "execute()";
        questions[6][4] = "begin()";
        answers[6][1] = "start()";

        // Question 8
        questions[7][0] = "Which collection does not allow duplicate elements in Java?";
        questions[7][1] = "List";
        questions[7][2] = "Queue";
        questions[7][3] = "Set";
        questions[7][4] = "Map";
        answers[7][1] = "Set";

        // Question 9
        questions[8][0] = "Which of these keywords is used to prevent inheritance in Java?";
        questions[8][1] = "final";
        questions[8][2] = "static";
        questions[8][3] = "abstract";
        questions[8][4] = "protected";
        answers[8][1] = "final";

        // Question 10
        questions[9][0] = "What does the JVM stand for?";
        questions[9][1] = "Java Variable Model";
        questions[9][2] = "Java Virtual Machine";
        questions[9][3] = "Java Versatile Machine";
        questions[9][4] = "Java Vision Model";
        answers[9][1] = "Java Virtual Machine";

        op1 = new JRadioButton();
        op1.setBounds(100, 150, 500, 30);
        op1.setFont(new Font("Dialog", Font.PLAIN, 20));
        op1.setBackground(new Color(231, 236, 239));
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(100, 200, 500, 30);
        op2.setFont(new Font("Dialog", Font.PLAIN, 20));
        op2.setBackground(new Color(231, 236, 239));
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(100, 250, 500, 30);
        op3.setFont(new Font("Dialog", Font.PLAIN, 20));
        op3.setBackground(new Color(231, 236, 239));
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(100, 300, 500, 30);
        op4.setFont(new Font("Dialog", Font.PLAIN, 20));
        op4.setBackground(new Color(231, 236, 239));
        add(op4);

        grpoptions = new ButtonGroup();
        grpoptions.add(op1);
        grpoptions.add(op2);
        grpoptions.add(op3);
        grpoptions.add(op4);

        
        next = new JButton("Next");
        next.setBounds(100, 400, 200, 25);
        next.setFont(new Font("Tahoma", Font.PLAIN, 20));
        next.setBackground(new Color(39, 76, 119));
        next.setForeground(new Color(231, 236, 239));
        next.addActionListener(this);
        add(next);

        finish = new JButton("Finish");
        finish.setBounds(310, 400, 200, 25);
        finish.setFont(new Font("Tahoma", Font.PLAIN, 20));
        finish.setBackground(new Color(39, 76, 119));
        finish.setForeground(new Color(231, 236, 239));
        finish.setEnabled(false);
        finish.addActionListener(this);
        add(finish);

        start(count);
        
        setSize(600, 700);
        setLocation(650,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==next) {
            repaint();
            user_ans = 1;
            if (grpoptions.getSelection()==null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = grpoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                finish.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource()==finish) {
            user_ans = 1;
            if (grpoptions.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = grpoptions.getSelection().getActionCommand();
            }

            for (int i=0; i< user_answers.length; i++) {
                if (user_answers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else { score += 0; }
            }
            setVisible(false);
            new Result(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left: " + timer + " s";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.PLAIN, 23));
        if (timer > 0) {
            g.drawString(time, 230, 500 );
        } else {
            g.drawString("Time out", 230, 500);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception a) {
            a.printStackTrace();
        }

        if (user_ans == 1) {
            user_ans = 0;
            timer = 10;
        } else if (timer < 0) {
            timer = 10;
            if (count == 8) {
                next.setEnabled(false);
                finish.setEnabled(true);
            }
            if (count == 9) {
                if (grpoptions.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = grpoptions.getSelection().getActionCommand();
                }

                for (int i=0; i< user_answers.length; i++) {
                    if (user_answers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else { score += 0; }
                }
                setVisible(false);
                new Result(name, score);
            } else {
                if (grpoptions.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = grpoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }
    public void start(int count) {
        qno.setText(""+(count+1));
        question.setText(questions[count][0]);
        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);
        grpoptions.clearSelection();
    }
    public static void main(String[] args) {
        new Quiz("User");
    }
}
