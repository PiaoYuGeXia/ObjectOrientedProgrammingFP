import java.io.Serializable;

public abstract class Person implements Serializable{
  protected String name;
  protected String ID;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
