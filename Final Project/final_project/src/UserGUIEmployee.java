public class UserGUIEmployee extends UserGUI{

  public UserGUIEmployee(){
    super("employer","Add Employee","View Employees");
  }

  @Override
  void addPerson() {
    AddGUIEmployee agui = new AddGUIEmployee();
    agui.setVisible(true); 
  }
}
