import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentGUI extends JFrame{
  protected JPanel contentPane;
	protected JTextField txtName;
	protected JTextField txtID;
	protected JButton btnAdd;
	protected JButton btnCancel;
	protected JLabel lblName;
	protected JLabel lblID;
  Attendance attd = new Attendance();
	FileManager fm = FileManager.getFileManager();
	protected String fileName = "Final Project/final_project/lib/teacher.dat";

  String successMsg = "New student successfully added";
  String fieldEmptyMsg = "Please fill all fields";
	String failMsg = "Oops, something went wrong";

	protected void addStudent(){
		//Make sure both fields have stuff
		if(txtName.getText().isEmpty() | txtID.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, fieldEmptyMsg);
		} else{
			//Read previous data to Attendance then modify it
			attd = fm.read(fileName);
			attd.addPerson(new Student(txtName.getText(), txtID.getText()));
			Boolean res = fm.save(attd, fileName);
			//If (not)saved successfully, respond
			if(res){
				JOptionPane.showMessageDialog(null, successMsg);
			}else{
				JOptionPane.showMessageDialog(null, failMsg);
			}
			dispose();
		}
	}

  public AddStudentGUI(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 400, 260, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    lblName = new JLabel("Name");
		lblName.setBounds(20, 40, 70, 20);
		contentPane.add(lblName);

		lblID = new JLabel("Student ID");
		lblID.setBounds(20, 80, 70, 20);
		contentPane.add(lblID);
		
		txtName = new JTextField();
		txtName.setBounds(90, 40, 120, 25);
		contentPane.add(txtName);
		txtName.setColumns(1);
		
		txtID = new JTextField();
		txtID.setBounds(90, 80, 120, 25);
		contentPane.add(txtID);
		txtID.setColumns(1);

    //Add new person to data file
    btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent();
      }
		});
		btnAdd.setBounds(80, 140, 100, 30);
		contentPane.add(btnAdd);
		
		//Close current window
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(80, 200, 100, 30);
		contentPane.add(btnCancel);
  }
}
