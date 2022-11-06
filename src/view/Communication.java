package view;

import Service.Show;
import Service.Insert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;



class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        communication run = new communication();
    }
}

class communication extends JFrame implements ActionListener {
    private TextField text_1;   //单行文本输入框  （姓名）
    private TextField text_2;   //单行文本输入框  （电话）

    public communication() {
        JFrame mainFrame = new JFrame("通讯录");
        mainFrame.setLocation(800, 600);
        mainFrame.setSize(250, 220);
        mainFrame.setLayout(null);
        Button bt1 = new Button("Add");
        mainFrame.add(bt1);
        bt1.setLocation(10, 30);
        bt1.setSize(200, 25);
        bt1.addActionListener(this);
        Button bt2 = new Button("All");
        mainFrame.add(bt2);
        bt2.setLocation(10, 65);
        bt2.setSize(200, 25);
        bt2.addActionListener(this);
        Button bt4 = new Button("close the window");
        mainFrame.add(bt4);
        bt4.setLocation(10, 100);
        bt4.setSize(200, 25);
        bt4.addActionListener(this);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bt = e.getActionCommand();
        if (bt.equals("Add")) {
            try {
                Insert();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (bt.equals("close the window")) {
            System.exit(0);
        }

        if (bt.equals("All")) {
            try {
                Display();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

    void Insert() throws SQLException {
         Insert insertTel = new Insert();
    }

    void Display() throws Exception {
        Show display = new Show();
    }

}
