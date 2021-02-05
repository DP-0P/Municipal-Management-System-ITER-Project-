import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SignUp extends JFrame implements ActionListener {

    JTextField tf1, tf2, tf3, tf4;
    JLabel l1, l2, l3, l4, l5, signUp, icon;
    JPasswordField pf;
    JButton submit;
    ImageIcon sign = new ImageIcon("letter2.png");
    JComboBox cb;
    String user[] = { "General", "Administrator" };

    SignUp() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");
        signUp = new JLabel("Sign Up :");

        signUp.setBounds(105, 35, 200, 45);
        signUp.setForeground(new Color(23, 212, 212));
        signUp.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        icon = new JLabel();
        icon.setIcon(sign);
        icon.setBounds(65, 35, 35, 35);

        l1 = new JLabel("UserName");
        l1.setBounds(65, 75, 200, 30);
        l1.setForeground(new Color(23, 212, 212));
        tf1 = new JTextField();
        tf1.setBackground(new Color(138, 222, 218));
        tf1.setBounds(65, 100, 200, 30);
        tf1.setPreferredSize(new DimensionUIResource(450, 50));

        l3 = new JLabel("E-Mail");
        l3.setBounds(65, 195, 200, 30);
        l3.setForeground(new Color(23, 212, 212));
        tf3 = new JTextField();
        tf3.setBounds(65, 220, 200, 30);
        tf3.setPreferredSize(new DimensionUIResource(450, 50));

        l4 = new JLabel("Password");
        l4.setBounds(65, 255, 200, 30);
        l4.setForeground(new Color(23, 212, 212));
        pf = new JPasswordField();
        pf.setBounds(65, 280, 200, 30);
        pf.setPreferredSize(new DimensionUIResource(450, 50));

        l5 = new JLabel("Select type of user");
        l5.setBounds(65, 315, 200, 30);
        l5.setForeground(new Color(23, 212, 212));
        cb = new JComboBox(user);
        cb.setBounds(65, 340, 110, 30);

        // submit = new JButton(new ImageIcon("application.png"));
        submit = new JButton("Submit");
        submit.setBounds(200, 360, 110, 30);
        submit.addActionListener(this);

        this.add(icon);
        this.add(signUp);
        this.add(l1);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(tf1);
        this.add(tf3);
        this.add(pf);
        this.add(cb);
        this.add(submit);

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);

                if (con.isClosed())
                    System.out.println("Closed");
                else
                    System.out.println("Opened");

                Statement stm = con.createStatement();
                String sql = "INSERT INTO management VALUES(" + 12347 + ",'" + "DFHSDF" + "')";
                stm.executeUpdate(sql);
                System.out.println("data inserted");
                con.close();
                System.out.println("closed");
            } catch (Exception E) {
                E.printStackTrace();
            }
            System.out.println("working");

            //retrieving data from table
            System.out.println("trying to fetch data from table");

            try{
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);

                String query = "select ID, name from management";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int id = rs.getInt("ID");
                String name = rs.getString("Name");

                System.out.println(id);
                System.out.println(name);

                System.out.println("data retrieved");
                con.close();
                System.out.println("closed");
            }
            catch (Exception E){
                System.out.println(E);
            }
        }
    }
}

// have to change a lot
class LogIn extends JFrame implements ActionListener {

    JTextField tf1, tf2, tf3, tf4;
    JLabel l1, l2, signUp, icon;
    JPasswordField pf;
    ImageIcon sign = new ImageIcon("letter2.png");
    JComboBox cb;
    String user[] = { "General", "Administrator" };

    LogIn() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");
        signUp = new JLabel("Sign Up :");
        signUp.setBounds(105, 35, 200, 45);
        signUp.setForeground(new Color(23, 212, 212));
        signUp.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        icon = new JLabel();
        icon.setIcon(sign);
        icon.setBounds(65, 35, 35, 35);

        l1 = new JLabel("First Name");
        l1.setBounds(65, 75, 200, 30);
        l1.setForeground(new Color(23, 212, 212));
        tf1 = new JTextField();
        tf1.setBackground(new Color(138, 222, 218));
        tf1.setBounds(65, 100, 200, 30);
        tf1.setPreferredSize(new DimensionUIResource(450, 50));

        l2 = new JLabel("Password");
        l2.setBounds(65, 135, 200, 30);
        l2.setForeground(new Color(23, 212, 212));
        pf = new JPasswordField();
        pf.setBounds(65, 280, 200, 30);
        pf.setPreferredSize(new DimensionUIResource(450, 50));

        this.add(icon);
        this.add(signUp);
        this.add(l1);
        this.add(l2);
        this.add(tf1);
        this.add(pf);

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

class MunicipalManagement {
    public static void main(String[] args) {
        new SignUp();
        // new LogIn();
    }
}
