package Service;

import bean.User;
import dao.Impl.BeanDaoImpl;
import utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;


public class Insert extends JFrame implements ActionListener {
    Connection connection = JDBCUtils.getConnection3();
    public String s1, s2, s3, s4;
    public TextField text_1;
    public TextField text_2;

    public Insert() throws SQLException {
        setTitle("Add");
        setSize(600, 300);
        setLocation(600, 400);
        setLayout(new GridLayout(6, 2));
        text_1 = new TextField();
        text_2 = new TextField();
        Label lab_1 = new Label("name：");
        Label lab_2 = new Label("phone number：");
        Button bt11 = new Button("add");
        Button bt12 = new Button("clear");
        bt11.addActionListener(this);
        bt12.addActionListener(this);
        add(lab_1);
        add(text_1);
        add(lab_2);
        add(text_2);
        add(bt11);
        add(bt12);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bt = e.getActionCommand();
        if (bt.equals("add")) {
                String s1 = text_1.getText();
                String s2 = text_2.getText();
                User user = new User(s1,s2);
            BeanDaoImpl beanDAO = new BeanDaoImpl();
            try {
                beanDAO.insert(connection,user);
                JOptionPane.showMessageDialog(null, "success");
                text_1.setText("");
                text_2.setText("");
            } catch (Exception exception) {
                exception.printStackTrace();
            }


        }
        if (bt.equals("clear")) {
            text_1.setText("");
            text_2.setText("");
        }

    }
}
