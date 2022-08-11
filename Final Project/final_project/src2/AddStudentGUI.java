public class AddStudentGUI extends AddGUI{
  protected String field1txt = "Name";
	protected String field2txt = "ID";
	protected String fileName = "Final Project/final_project/lib/teacher.dat";

  String successMsg = "New student successfully added :D";

	@Override
	protected void setTitle() {
		this.setTitle("Add Student");
		
	}
}