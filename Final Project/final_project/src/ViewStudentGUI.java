import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class ViewStudentGUI extends JFrame{
  private JPanel contentPane;
  private JButton btnCancel;
	JTable table;
	JScrollPane scrollPane;
	StudentTableModel tmodel;

  private Attendance attd = new Attendance(new HashMap<Person, Boolean[]>());
  private final String dataFile = "lib/teacher.dat";

  public ViewStudentGUI(){
		this.setTitle("View Students");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 400, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    //Read previous data from file
    attd = FileManager.read(dataFile);

		//Put data into jtable for diaplay
		tmodel = new StudentTableModel(attd.getpMap());
		table = new JTable(tmodel);
		scrollPane = new JScrollPane(table);

		
		tmodel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				attd = new Attendance(tmodel.update());
				FileManager.save(attd, dataFile);
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

class StudentTableModel extends AbstractTableModel{

	private String[] columnNames = {"Name", "NetID","Monday","Tuesday","Wednesday","Thursday","Friday",""};
	private Object[][] data;

	StudentTableModel(HashMap<Person, Boolean[]> dataMap){
		data = new Object[dataMap.size()][8];
    int i = 0;
		for(Person e : dataMap.keySet()){
      data[i][0] = (String)((Student)e).getName();
			data[i][1] = (String)((Student)e).getID();
			data[i][2] = (Boolean)dataMap.get(e)[0];
			data[i][3] = (Boolean)dataMap.get(e)[1];
			data[i][4] = (Boolean)dataMap.get(e)[2];
			data[i][5] = (Boolean)dataMap.get(e)[3];
			data[i][6] = (Boolean)dataMap.get(e)[4];
			data[i][7] = "delete";
			i++;
    }
	}

	public HashMap<Person, Boolean[]> update(){
		HashMap<Person, Boolean[]> hm = new HashMap<Person, Boolean[]>();
		for (Object[] o : data){
			Student s = new Student((String)o[0], (String)o[1]);
			Boolean[] b = {(Boolean)o[2],(Boolean)o[3],(Boolean)o[4],(Boolean)o[5],(Boolean)o[6]};
			hm.put(s,b);
		}
		return hm;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		data[rowIndex][columnIndex] = aValue;
		this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}