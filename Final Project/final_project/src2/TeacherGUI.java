public class TeacherGUI extends UserGUI{

  public TeacherGUI(){
    super("teacher","Add Student","Attendance");
    attd = new Attendance();
    dataFile = "Final Project/final_project/lib/teacher.dat";
  }

  @Override
  void addPerson() {
    super.addPerson();
    // TODO Auto-generated method stub
  }

  @Override
  void viewPerson() {
    // TODO Auto-generated method stub
    
  }
  
}
