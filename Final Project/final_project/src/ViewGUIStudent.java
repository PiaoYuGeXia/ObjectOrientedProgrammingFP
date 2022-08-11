import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewGUIStudent extends JFrame{
  private JPanel contentPane;
  private JButton btnCancel;
	JTable table;
	JScrollPane scrollPane;
	TableModelStudent tmodel;
	FileManager fm = FileManager.getFileManager();

  private Attendance attd = new Attendance();
  private final String dataFile = "Final Project/final_project/lib/teacher.dat";

  public ViewGUIStudent(){
		this.setTitle("View Student");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 400, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    //Read previous data from file
    attd = fm.read(dataFile);

		//Put data into jtable for diaplay
		tmodel = new TableModelStudent(attd.getPpl(), attd.getAttd());
		table = new JTable(tmodel);
		scrollPane = new JScrollPane(table);

		
		tmodel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				attd = new Attendance();
				fm.save(attd, dataFile);
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(20,50,600,400);
		contentPane.add(scrollPane);

    //Close current window
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(600, 500, 100, 30);
		contentPane.add(btnCancel);
  }
}