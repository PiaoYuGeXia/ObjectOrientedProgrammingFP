import java.io.Serializable;
import java.util.HashMap;

public class Attendance implements Serializable{
  private HashMap<Person, Boolean[]> pMap;

  public HashMap<Person, Boolean[]> getpMap() {
    return pMap;
  }

  //Needs to be modified/deleted
  public Attendance(HashMap<Person, Boolean[]> hashMap){
    if(hashMap == null){
      pMap = new HashMap<Person, Boolean[]>();
    }else{
      this.pMap = hashMap;
    }
  }

  public int getSize(){
    return pMap.size();
  }

  //Add entry
  public void addPerson(Person p){
    //Monday to Friday
    pMap.put(p, new Boolean[]{false, false, false, false, false});
  }

  //Remove entry
  public void removePerson(String name){
    for(Person e : pMap.keySet()){
      if(e.getName() == name){
        pMap.remove(e);
        break;
      }
    }
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
