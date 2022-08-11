public class UserGUIFactory{
  UserGUI ugui;
  public UserGUI create(String credential){
    switch(credential){
      case "teacher":
        ugui = new UserGUITeacher();
        break;
      case "employer":
        ugui = new UserGUIEmployee();
        break;
      default:
        System.out.println("Unreachable code!");
        System.exit(1);
    }
    return ugui;
  }
}