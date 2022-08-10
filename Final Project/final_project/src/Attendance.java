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
    ppl.
  }

  //Toggle boolean of one person's one day
  public void takeAttendance(int entry, int day){
    
  }

  @Override
  public String toString(){
    String s = "";
    for(Person p : pMap.keySet()){
      s += p.getName() + ", " + p.getID() + ", ";
      for (Boolean b : pMap.get(p)){
        s += b + " ";
      }
      s += "\n";
    }
    return s;
  }
}
