public class Student extends Person{
  protected String ID;
  
  public Student(String n, String i) {
    name = n;
    ID = i;
  }
  public String getID() {
    return ID;
  }
  public void setID(String iD) {
    ID = iD;
  }

  @Override
  public String toString() {
		return "Name: " + name + ", " + "ID: " + ID + "\n";
	}
}