import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class UserGUI extends JFrame{

  protected Attendance attd;
  protected String dataFile;
  protected String credential;

  protected JPanel contentPane;
  protected String addbtnlbl;
  protected String viewbtnlbl;
  protected JButton btnAddPerson;
  protected JButton btnViewPerson;
  protected JButton btnClose;

  UserGUI(String credential, String addbtnlbl, String viewbtnlbl){
    this.addbtnlbl = addbtnlbl;
    this.viewbtnlbl = viewbtnlbl;
    this.credential = credential;
    this.setTitle("Logged in as: " + credential);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 260, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    //Add Person button
    btnAddPerson = new JButton(addbtnlbl);
		btnAddPerson.setBounds(50, 40, 160, 30);
		contentPane.add(btnAddPerson);
    btnAddPerson.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        addPerson();
      }
		});

    //View Person button
    btnViewPerson = new JButton(viewbtnlbl);
		btnViewPerson.setBounds(50, 100, 160, 30);
		contentPane.add(btnViewPerson);
    btnViewPerson.addActionListener(new ActionListener() {
      @Override
			public void actionPerformed(ActionEvent e) {
				viewPerson();
			}
		});
		
    //Close button
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

  void addPerson(){
    AddGUIFactory af = new AddGUIFactory();
    af.create(credential);
  }
  void viewPerson(){
    ViewGUIFactory vf = new ViewGUIFactory();
    vf.create(credential);
  }
}
