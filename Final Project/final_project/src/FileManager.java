import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileManager {
  public static Boolean save(Attendance attd, String fileName){
    try{
      FileOutputStream fos = new FileOutputStream(fileName);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(attd);
      oos.flush();
      oos.close();
      return true;
    }catch(IOException e){
      e.printStackTrace();
      return false;
    }
  }
  public static Attendance read(String fileName){
    Attendance attd = new Attendance(new HashMap<Person, Boolean[]>());
    try {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      
      attd = (Attendance)ois.readObject();
      ois.close();
    }catch(IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
    return attd;
  }
}
