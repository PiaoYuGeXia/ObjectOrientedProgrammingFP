import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGUIEmployee extends JFrame{
  protected JPanel contentPane;
	protected JTextField txtName;
	protected JTextField txtID;
  protected JTextField txtSalary;
	protected JButton btnAdd;
	protected JButton btnCancel;
  protected JLabel lblName;
	protected JLabel lblID;
	protected JLabel lblSalary;
  protected Attendance attd = new Attendance();
	FileManager fm = FileManager.getFileManager();
  protected final String fileName = "Final Project/final_project/lib/employer.dat";

  protected String successMsg = "New employee successfully added";
  protected String fieldEmptyMsg = "Please fill all fields";
	protected String failMsg = "Oops, something went wrong";

	protected void addEmployee(){
		//Make sure both fields have stuff
		if(txtName.getText().isEmpty() | txtID.getText().isEmpty() | txtSalary.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, fieldEmptyMsg);
		} else{
			//Read previous data to Attendance then modify it
			attd = fm.read(fileName);
			attd.addPerson(new Employee(txtName.getText(), txtID.getText(), txtSalary.getText()));
			boolean res = fm.save(attd, fileName);
			//If (not)saved successfully, respond
			if(res){
				JOptionPane.showMessageDialog(null, successMsg);
			}else{
				JOptionPane.showMessageDialog(null, failMsg);
			}
			dispose();
		}
	}
  
  public AddGUIEmployee(){
		this.setTitle("Add Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 400, 260, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    lblName = new JLabel("Name");
		lblName.setBounds(20, 40, 70, 20);
		contentPane.add(lblName);

		lblID = new JLabel("Work ID");
		lblID.setBounds(20, 80, 70, 20);
		contentPane.add(lblID);

    lblSalary = new JLabel("Work ID");
		lblSalary.setBounds(20, 120, 70, 20);
		contentPane.add(lblSalary);
		
		txtName = new JTextField();
		txtName.setBounds(90, 40, 120, 25);
		contentPane.add(txtName);
		txtName.setColumns(1);
		
		txtID = new JTextField();
		txtID.setBounds(90, 80, 120, 25);
		contentPane.add(txtID);
		txtID.setColumns(1);

    txtSalary = new JTextField("600");
		txtSalary.setBounds(90, 120, 120, 25);
		contentPane.add(txtSalary);
		txtSalary.setColumns(1);

    //Add new person to data file
    btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployee();
      }
		});
		btnAdd.setBounds(80, 180, 100, 30);
		contentPane.add(btnAdd);
		
		//Close current window
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(80, 240, 100, 30);
		contentPane.add(btnCancel);
  }
}
