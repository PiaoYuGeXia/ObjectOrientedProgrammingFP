public class UserGUIEmployee extends UserGUI{

  public UserGUIEmployee(){
    super("employer","Add Employee","Attendance");
  }

  @Override
  void addPerson() {
    AddGUIEmployee agui = new AddGUIEmployee();
    agui.setVisible(true);
  }

  @Override
  void viewPerson() {
    ViewGUIEmployee vgui = new ViewGUIEmployee();
    vgui.setVisible(true);
  }
  
}
