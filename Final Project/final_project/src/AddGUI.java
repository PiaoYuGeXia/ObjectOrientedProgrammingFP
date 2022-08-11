import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class AddGUI extends JFrame{
  protected JPanel contentPane;
	protected JTextField txtField1;
	protected JTextField txtField2;
	protected JButton btnAdd;
	protected JButton btnCancel;
	protected JLabel field1lbl;
	protected JLabel field2lbl;
  Attendance attd = new Attendance();
	FileManager fm = FileManager.getFileManager();

  protected String field1txt = "Name";
	protected String field2txt;
	protected String fileName;

  String successMsg = "New person successfully added :D";
  String fieldEmptyMsg = "Please fill all fields :)";
	String failMsg = "Oops, something went wrong D:";

	protected void addPerson(){
		//Make sure both fields have stuff
		if(txtField1.getText().isEmpty() | txtField2.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, fieldEmptyMsg);
		} else{
			//Read previous data to Attendance then modify it
			attd = fm.read(fileName);
			attd.addPerson(new Student(txtField1.getText(), txtField2.getText()));
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

  protected abstract void setTitle();

  public AddGUI(){
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
				addPerson();
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
