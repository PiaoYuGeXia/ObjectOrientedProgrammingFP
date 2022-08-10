import java.util.ArrayList;

public class Attendance {
  private ArrayList<String> name;
  private ArrayList<Person> ppl;
  private ArrayList<Boolean[]> attd;

  public Attendance getAttd() {
    return this;
  }

  //Needs to be modified/deleted
  public Attendance(){
    name = new ArrayList<String>();
    ppl = new ArrayList<Person>();
    attd = new ArrayList<Boolean[]>();
  }

  public int getSize(){
    return ppl.size();
  }

  //Add entry
  public void addPerson(Person p){
    name.add(p.getName());
    ppl.add(p);
    Boolean[] temp = {false, false, false, false, false};
    attd.add(temp);
  }

  //Remove entry
  public void removePerson(String name){
    int index = this.name.indexOf(name);
    this.name.remove(index);
    this.ppl.remove(index);
    this.attd.remove(index);
  }

  //Toggle boolean of one person's one day
  public void takeAttendance(int entry, int day){
    
  }

}
