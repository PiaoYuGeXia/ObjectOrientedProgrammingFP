public class AddEmployeeGUI extends AddGUI{
    protected String field1txt = "Name";
    protected String field2txt = "Salary";
    protected String fileName = "Final Project/final_project/lib/employer.dat";
  
    String successMsg = "New employee successfully added :D";
  
    @Override
    protected void setTitle() {
      this.setTitle("Add Employee");
      
    }
}
