import java.util.ArrayList;

public class TableModelFactory {
  TableModelUser tm;
  public TableModelUser create(String credential, ArrayList<Person> p, ArrayList<boolean[]> attdList){
    switch(credential){
      case "teacher":
        tm = new TableModelStudent(p,attdList);
        break;
      case "employer":
        tm = new TableModelEmployee(p,attdList);
        break;
      default:
        System.out.println("Unreachable code!");
        System.exit(1);
    }
    return tm;
  }
}
