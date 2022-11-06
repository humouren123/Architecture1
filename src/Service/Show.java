package Service;

import bean.User;
import dao.Impl.BeanDaoImpl;
import utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class Show extends JFrame implements ActionListener {
    int pageNum = 0;
    public String s1,s2,s3, s4;
    public JTextField text_1;
    public JTextField text_2;
    public JTextField text_3;
    public JTextField text_4;
    public JTextField text_5;
    public JTextField text_6;
    public JTextField text_7;
    public JTextField text_8;

    String text2 ;
    String text4 ;
    String text6 ;
    String text8 ;

    Connection connection = JDBCUtils.getConnection3();
    public Show() throws Exception {
        setTitle("All number");
        setSize(800, 600);
        setLocation(300, 200);
        setLayout(new GridLayout(5,4));
        text_1 = new JTextField();
        text_2 = new JTextField();
        text_3 = new JTextField();
        text_4 = new JTextField();
        text_5 = new JTextField();
        text_6 = new JTextField();
        text_7 = new JTextField();
        text_8 = new JTextField();



        Button bt1 = new Button("update1");
        Button bt2 = new Button("delete1");
        Button bt3 = new Button("update2");
        Button bt4 = new Button("delete2");
        Button bt5 = new Button("update3");
        Button bt6 = new Button("delete3");
        Button bt7 = new Button("update4");
        Button bt8 = new Button("delete4");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt1.setSize(80, 25);
        bt2.setSize(80, 25);
        bt3.setSize(80, 25);
        bt4.setSize(80, 25);
        bt5.setSize(80, 25);
        bt6.setSize(80, 25);
        bt7.setSize(80, 25);
        bt8.setSize(80, 25);

        add(text_1);add(text_2);add(bt1);add(bt2);
        add(text_3);add(text_4);add(bt3);add(bt4);
        add(text_5);add(text_6);add(bt5);add(bt6);
        add(text_7);add(text_8);add(bt7);add(bt8);
        setVisible(true);

        JPanel jPanel = new JPanel();
        Button bt9 = new Button("pre");
        Button bt10 = new Button("next");
        bt9.setSize(80, 25);
        bt10.setSize(80, 25);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(jPanel);
        jPanel.add(bt9);jPanel.add(bt10);
        bt9.addActionListener(this);
        bt10.addActionListener(this);
        showAll();
        setVisible(true);

    }
    void showAll() throws Exception {
        if(pageNum<0){
            pageNum = 0;
        }
        BeanDaoImpl beanDAO = new BeanDaoImpl();
        List<User> users = beanDAO.getAll(connection, pageNum*4);



        text_1.setText(users.get(0).getName());
        text_2.setText(users.get(0).getNumber());
        text_3.setText(users.get(1).getName());
        text_4.setText(users.get(1).getNumber());
        text_5.setText(users.get(2).getName());
        text_6.setText(users.get(2).getNumber());
        text_7.setText(users.get(3).getName());
        text_8.setText(users.get(3).getNumber());

        text2=text_2.getText();
        text4=text_4.getText();
        text6=text_6.getText();
        text8=text_8.getText();

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bt = e.getActionCommand();
        if (bt.equals("pre")) {
            pageNum-=1;
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("next")) {
            pageNum+=1;
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("update1")) {
            BeanDaoImpl update = new BeanDaoImpl();
            try {
                update.update(connection,new User(text_1.getText(), text_2.getText()),text2);
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("update2")) {
            BeanDaoImpl update = new BeanDaoImpl();
            try {
                update.update(connection,new User(text_3.getText(), text_4.getText()),text4);
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("update3")) {
            BeanDaoImpl update = new BeanDaoImpl();
            try {
                update.update(connection,new User(text_5.getText(), text_6.getText()),text6);
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("update4")) {
            BeanDaoImpl update = new BeanDaoImpl();
            try {
                update.update(connection,new User(text_7.getText(), text_8.getText()),text8);
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if(bt.equals("delete1")){
            BeanDaoImpl del = new BeanDaoImpl();
            try {
                del.deleteByphone(connection,text_2.getText());
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("delete2")) {
            BeanDaoImpl del = new BeanDaoImpl();
            try {
                del.deleteByphone(connection,text_4.getText());
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("delete3")) {
            BeanDaoImpl del = new BeanDaoImpl();
            try {
                del.deleteByphone(connection,text_6.getText());
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bt.equals("delete4")) {
            BeanDaoImpl del = new BeanDaoImpl();
            try {
                del.deleteByphone(connection,text_8.getText());
                JOptionPane.showMessageDialog(null, "success");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                showAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
