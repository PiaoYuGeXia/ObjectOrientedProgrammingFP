public class UserGUIFactory{
  UserGUI ugui;
  public UserGUI create(String credential){
    switch(credential){
      case "teacher":
        ugui = new TeacherGUI();
        break;
      case "Employer":
        ugui = new EmployerGUI();
        break;
      default:
        System.out.println("Unreachable code!");
        System.exit(1);
    }
    return ugui;
  }
}