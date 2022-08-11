public class Student extends Person{
  
  public Student(String n, String i) {
    name = n;
    ID = i;
  }

  @Override
  public String toString() {
		return "Name: " + name + ", ID: " + ID + "\n";
	}

  @Override
  String[] getFields() {
    String[] s = {name, ID};
    return s;
  }

  @Override
  String[] getFieldNames() {
    String[] s = {"Name","Work ID","Salary"};
    return s;
  }
}