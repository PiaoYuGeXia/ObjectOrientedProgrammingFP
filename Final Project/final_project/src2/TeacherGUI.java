public class TeacherGUI extends UserGUI{

  public TeacherGUI(){
    super("teacher","Add Student","Attendance");
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
