public class EmployerGUI extends UserGUI{

  public EmployerGUI(){
    super("employer","Add Employee","Attendance");
  }

  @Override
  void addPerson() {
    AddEmployeeGUI agui = new AddEmployeeGUI();
    agui.setVisible(true);
  }

  @Override
  void viewPerson() {
    ViewEmployeeGUI vgui = new ViewEmployeeGUI();
    vgui.setVisible(true);
  }
  
}
