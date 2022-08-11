public class UserGUIFactory{
  UserGUI ugui;
  public void create(String credential){
    switch(credential){
      case "teacher":
        ugui = new UserGUITeacher();
        ugui.setVisible(true);
        break;
      case "employer":
        ugui = new UserGUIEmployee();
        ugui.setVisible(true);
        break;
      default:
        System.out.println("Unreachable code!");
        System.exit(1);
    }
  }
}