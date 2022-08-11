import java.util.ArrayList;

class TableModelEmployee extends TableModelUser{

	TableModelEmployee(ArrayList<Person> p, ArrayList<Boolean[]> attd){
		super(p,attd);
  }

	public Attendance update(){
		Attendance attd = new Attendance();
		for (Object[] o : data){
			Employee s = new Employee((String)o[0], (String)o[1], (String)o[2]);
			Boolean[] b = {(Boolean)o[3],(Boolean)o[4],(Boolean)o[5],(Boolean)o[6],(Boolean)o[7]};
			attd.addPerson(s, b);
		}
		return attd;
	}
}