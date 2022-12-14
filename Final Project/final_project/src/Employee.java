public class Employee extends Person{
  protected String salary;
  public Employee(String n, String i, String s){
    name = n;
    ID = i;
    salary = s;
  }

  public String getSalary() {
    return salary;
  }
  public void setSalary(String salary) {
    this.salary = salary;
  }
  
  @Override
  public String toString() {
		return "Name: " + name + ", ID: " + ID + ", Salary: " + salary + "\n";
	}


  @Override
  String[] getFields() {
    String[] s = {name, ID, salary};
    return s;
  }

  @Override
  String[] getFieldNames() {
    String[] s = {"Name","Work ID","Salary"};
    return s;
  }
}