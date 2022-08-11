public class TeacherGUI extends UserGUI{

  public TeacherGUI(){
    super("teacher","Add Student","Attendance");
    attd = new Attendance();
    dataFile = "Final Project/final_project/lib/teacher.dat";
  }

  @Override
  void addPerson() {
    AddStudentGUI agui = new AddStudentGUI();
    agui.setVisible(true);
    
  }

  @Override
  void viewPerson() {
    ViewStudentGUI vgui = new ViewStudentGUI();
    vgui.setVisible(true);
    
  }
  
}
