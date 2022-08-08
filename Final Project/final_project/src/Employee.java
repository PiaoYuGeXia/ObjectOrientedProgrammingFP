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
}