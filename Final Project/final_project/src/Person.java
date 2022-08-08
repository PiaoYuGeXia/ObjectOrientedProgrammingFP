import java.io.Serializable;

public abstract class Person implements Serializable{
  protected String name;
  protected String ID;

  public String getID() {
    return ID;
  }
  public String getName() {
    return name;
  }

  //I personally don't think setters should be included
  public void setID(String iD) {
    ID = iD;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
		return name + "," + ID + "\n";
	}
}
