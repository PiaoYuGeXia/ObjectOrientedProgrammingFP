public class EmployerGUI extends UserGUI{

  public EmployerGUI(){
    super("employer","Add Employee","Attendance");
    attd = new Attendance();
    dataFile = "Final Project/final_project/lib/employer.dat";
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
