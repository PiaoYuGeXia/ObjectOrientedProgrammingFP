import java.util.ArrayList;

public class TableModelStudent extends TableModelUser{

	TableModelStudent(ArrayList<Person> p, ArrayList<Boolean[]> attd){
		super(p,attd);
  }

  @Override
  Attendance update() {
		Attendance attd = new Attendance();
		for (Object[] o : data){
			Student s = new Student((String)o[0], (String)o[1]);
			Boolean[] b = {(Boolean)o[2],(Boolean)o[3],(Boolean)o[4],(Boolean)o[5],(Boolean)o[6]};
			attd.addPerson(s, b);
		}
		return attd;
  }
}
