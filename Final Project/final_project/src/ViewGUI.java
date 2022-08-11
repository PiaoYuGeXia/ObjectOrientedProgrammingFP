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

public class ViewGUI extends JFrame{
  protected JPanel contentPane;
  protected JButton btnCancel;
	protected JTable table;
	protected JScrollPane scrollPane;
	protected TableModelStudent tmodel;
	FileManager fm = FileManager.getFileManager();

  protected Attendance attd;
  protected String dataFile;

  public ViewGUI(String dataFile){
    this.dataFile = dataFile;
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
				attd = tmodel.update();
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