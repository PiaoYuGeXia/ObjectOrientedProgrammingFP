public class ViewGUIFactory {
  ViewGUI vgui;
  public ViewGUI create(String credential){
    switch(credential){
      case "teacher":
      vgui = new ViewGUIStudent();
      vgui.setVisible(true);
        break;
      case "employer":
      vgui = new ViewGUIEmployee();
      vgui.setVisible(true);
        break;
      default:
        System.out.println("Unreachable code!");
        System.exit(1);
    }
    return vgui;
  }
}
