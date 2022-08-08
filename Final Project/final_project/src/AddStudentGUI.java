import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class AddStudentGUI extends JFrame{
  private JPanel contentPane;
	private JTextField txtField1;
	private JTextField txtField2;
	private JButton btnAdd;
	private JButton btnCancel;
	private JLabel field1lbl;
	private JLabel field2lbl;
	private String field1txt = "Name";
	private String field2txt = "NetID";
	private final String fileName = "lib/teacher.dat";
  Attendance attd = new Attendance(new HashMap<Person, Boolean[]>());

	private void addStudent(){
		this.setTitle("Add Student");
		String fieldEmptyMsg = "Please fill all fields :)";
		String successMsg = "New student successfully added :D";
		String failMsg = "Oops, something went wrong D:";

		//Make sure both fields have stuff
		if(txtField1.getText().isEmpty() | txtField2.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, fieldEmptyMsg);
		} else{
			//Read previous data to Attendance then modify it
			attd = FileManager.read(fileName);
			attd.addPerson(new Student(txtField1.getText(), txtField2.getText()));
			Boolean res = FileManager.save(attd, fileName);
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
		setBounds(800, 400, 260, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    field1lbl = new JLabel(field1txt);
		field1lbl.setBounds(20, 40, 70, 20);
		contentPane.add(field1lbl);

		field2lbl = new JLabel(field2txt);
		field2lbl.setBounds(20, 80, 70, 20);
		contentPane.add(field2lbl);
		
		txtField1 = new JTextField();
		txtField1.setBounds(90, 40, 120, 25);
		contentPane.add(txtField1);
		txtField1.setColumns(1);
		
		txtField2 = new JTextField();
		txtField2.setBounds(90, 80, 120, 25);
		contentPane.add(txtField2);
		txtField2.setColumns(1);

    //Add new person to data file
    btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent();
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
