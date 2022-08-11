import java.util.ArrayList;

class TableModelEmployee extends TableModelUser{

	TableModelEmployee(ArrayList<Person> p, ArrayList<boolean[]> arrayList){
		super(p,arrayList);
  }

	@Override
	public Attendance update(){
		Attendance attd = new Attendance();
		for (Object[] o : data){
			Employee s = new Employee((String)o[0], (String)o[1], (String)o[2]);
			boolean[] b = {(boolean)o[3],(boolean)o[4],(boolean)o[5],(boolean)o[6],(boolean)o[7]};
			attd.addPerson(s, b);
		}
		return attd;
	}
}