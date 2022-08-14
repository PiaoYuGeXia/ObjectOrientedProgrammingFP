public class UserGUITeacher extends UserGUI{

  public UserGUITeacher(){
    super("teacher","Add Student","View Students");
  }

  @Override
  void addPerson() {
    AddGUIStudent agui = new AddGUIStudent();
    agui.setVisible(true); 
  }
}
