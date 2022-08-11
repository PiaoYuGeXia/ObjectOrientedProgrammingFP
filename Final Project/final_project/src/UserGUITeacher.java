public class UserGUITeacher extends UserGUI{

  public UserGUITeacher(){
    super("teacher","Add Student","Attendance");
  }

  @Override
  void addPerson() {
    AddGUIStudent agui = new AddGUIStudent();
    agui.setVisible(true);
    
  }

  @Override
  void viewPerson() {
    ViewGUIStudent vgui = new ViewGUIStudent();
    vgui.setVisible(true);
  }
  
}
