import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

abstract class TableModelUser extends AbstractTableModel{

	protected String[] columnNames;
	protected Object[][] data;

	TableModelUser(ArrayList<Person> p, ArrayList<boolean[]> attdList){
    int varlength = p.get(0).getFields().length;
    String[] fieldNames = p.get(0).getFieldNames();
		columnNames = new String[fieldNames.length+5];
    columnNames[columnNames.length-1] = "Friday";
    columnNames[columnNames.length-2] = "Thursday";
    columnNames[columnNames.length-3] = "Wednesday";
    columnNames[columnNames.length-4] = "Tuesday";
    columnNames[columnNames.length-5] = "Monday";
		data = new Object[p.size()][varlength + 5];
		for(int i = 0; i < p.size(); i++){
			String[] vars = p.get(i).getFields();
      for(int j = 0; j < varlength + 5; j++){
        if(j < varlength){
          data[i][j] = vars[j];
          columnNames[j] = fieldNames[j];
        } else{
          data[i][j] = (boolean)attdList.get(i)[j-varlength];
        }
      }
    }
	}

	abstract Attendance update();

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

	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}