import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGUI extends JFrame{
  private JPanel contentPane;
	private JButton btnAddPerson;
	private JButton btnViewPerson;
	private JButton btnClose;
	private String addbtnlbl = "Add Person";
	private String viewbtnlbl = "View Person";

  public UserGUI(String credential){
		this.setTitle("Logged in as: " + credential);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 260, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//log in with teacher credential
		if(credential.equals("teacher")){
			addbtnlbl = "Add Student";
			viewbtnlbl = "View Student";
			//log in with employer credential
		} else if(credential.equals("employer")){
			addbtnlbl = "Add Employee";
			viewbtnlbl = "View Employee";
		} else{
			//Not possible to be here
			JOptionPane.showMessageDialog(null,"HOW DID YOU DO IT?!");
		}

    //Add Person
    btnAddPerson = new JButton(addbtnlbl);
		btnAddPerson.setBounds(50, 40, 160, 30);
		contentPane.add(btnAddPerson);
    btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGUIFactory af = new AddGUIFactory();
				AddGUI agui = af.create(credential);
				agui.setVisible(true);
			}
		});

    //View Person
    btnViewPerson = new JButton(viewbtnlbl);
		btnViewPerson.setBounds(50, 100, 160, 30);
		contentPane.add(btnViewPerson);
    btnViewPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check credential
        if(credential.equals("teacher")){
					ViewStudentGUI viewstudentgui= new ViewStudentGUI();
					viewstudentgui.setVisible(true);
				} else if(credential.equals("employer")){
					// ViewEmployeeGUI viewemployeegui = new ViewEmployeeGUI();
					// viewemployeegui.setVisible(true);
				}
			}
		});
		
    //Close 
		btnClose = new JButton("Log Out");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        LoginGUI newLogin = new LoginGUI();
        newLogin.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(50, 160, 160, 30);
		contentPane.add(btnClose);
  }
}
