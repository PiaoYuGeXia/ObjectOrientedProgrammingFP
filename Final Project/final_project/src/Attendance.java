import java.io.Serializable;
import java.util.ArrayList;

public class Attendance implements Serializable{
  private ArrayList<Person> ppl;
  private ArrayList<Boolean[]> attd;

  public Attendance(){
    ppl = new ArrayList<Person>();
    attd = new ArrayList<Boolean[]>();
  }

  public ArrayList<Boolean[]> getAttd() {
    return attd;
  }
  public int getSize(){
    return ppl.size();
  }
  public ArrayList<Person> getPpl() {
    return ppl;
  }

  //Add entry
  public void addPerson(Person p){
    ppl.add(p);
    Boolean[] temp = {false, false, false, false, false};
    attd.add(temp);
  }

  public void addPerson(Person p, Boolean[] b){
    ppl.add(p);
    attd.add(b);
  }

  //Remove entry
  public void removePerson(String name){
    int i;
    for (i = 0; i < ppl.size(); i++){
      if(ppl.get(i).getName() == name){
        break;
      }
    }
    this.ppl.remove(i);
    this.attd.remove(i);
  }

  //Toggle boolean of one person's one day
  public void takeAttendance(String name, int day){
    int i;
    for (i = 0; i < ppl.size(); i++){
      if(ppl.get(i).getName() == name){
        this.attd.get(i)[day] ^= true;
        break;
      }
    }
  }

}
