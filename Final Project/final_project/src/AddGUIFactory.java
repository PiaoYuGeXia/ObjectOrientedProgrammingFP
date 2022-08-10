public class AddGUIFactory {
  AddGUI agui;

  public AddGUI create(String credential){
    //check credential
  if(credential.equals("teacher")){
    agui = new AddStudentGUI();
  } else if(credential.equals("employer")){
    agui = new AddEmployeeGUI();
  } else{
    System.out.println("Unreachable Code!");
    System.exit(1);
  }
  return agui;
  }
  
}
