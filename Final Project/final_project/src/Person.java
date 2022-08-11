import java.io.Serializable;

public abstract class Person implements Serializable{
  protected String name;
  protected String ID;

  abstract String[] getFields();
  abstract String[] getFieldNames();

  public String getID() {
    return ID;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setID(String iD) {
    ID = iD;
  }
  @Override
  public String toString() {
		return "Name: " + name + ", " + "ID: " + ID + "\n";
	}
}
