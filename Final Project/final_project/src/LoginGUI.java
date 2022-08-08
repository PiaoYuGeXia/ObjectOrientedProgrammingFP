import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame{
  private JPanel contentPane;
	private JTextField txtAcc;
	private JTextField txtPwd;
	private JLabel lblAcc;
	private JLabel lblPwd;
	private JButton btnLogin;
	private JButton btnExit;
  private JLabel lblMsg;

  private int checkCredential(){
    //teacher: teacher; teacher123
    if(txtAcc.getText().equals("teacher") && txtPwd.getText().equals("teacher123")){
      return 1;
    //employer: employer; employer123
    } else if(txtAcc.getText().equals("employer") && txtPwd.getText().equals("employer123")){
      return 2;
    } else{
      return 0;
    }
  }

  public LoginGUI(){
		this.setTitle("Attendance System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 260, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    lblAcc = new JLabel("Account");
		lblAcc.setBounds(20, 40, 70, 20);
		contentPane.add(lblAcc);
		
		lblPwd = new JLabel("Password");
		lblPwd.setBounds(20, 80, 70, 20);
		contentPane.add(lblPwd);
		
		txtAcc = new JTextField();
		txtAcc.setBounds(90, 40, 120, 25);
		contentPane.add(txtAcc);
		txtAcc.setColumns(1);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(90, 80, 120, 25);
		contentPane.add(txtPwd);
		txtPwd.setColumns(1);

    btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        //reset warning sign
        lblMsg.setVisible(false);
				int c = checkCredential();
        if(c == 0){ //wrong acc/pwd, clear textboxes
          lblMsg.setVisible(true);
          txtAcc.setText("");
          txtPwd.setText("");
        }else if(c == 1){ //login as teacher
          UserGUI pgui = new UserGUI("teacher");
          pgui.setVisible(true);
          dispose();
        }else{ //login as employer
          UserGUI pgui = new UserGUI("employer");
          pgui.setVisible(true);
          dispose();
        }
			}
		});
		btnLogin.setBounds(80, 160, 100, 30);
		contentPane.add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(80, 220, 100, 30);
		contentPane.add(btnExit);

    lblMsg = new JLabel("Incorrect account name or password :(");
		lblMsg.setBounds(10, 120, 240, 20);
		contentPane.add(lblMsg);
    lblMsg.setVisible(false);
  }
}
