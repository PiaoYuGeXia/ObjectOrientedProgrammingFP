import java.util.ArrayList;

public class TableModelStudent extends TableModelUser{

	TableModelStudent(ArrayList<Person> p, ArrayList<boolean[]> arrayList){
		super(p,arrayList);
  }

  @Override
  Attendance update() {
		Attendance attd = new Attendance();
		for (Object[] o : data){
			Student s = new Student((String)o[0], (String)o[1]);
			boolean[] b = {(boolean)o[2],(boolean)o[3],(boolean)o[4],(boolean)o[5],(boolean)o[6]};
			attd.addPerson(s, b);
		}
		return attd;
  }
}
