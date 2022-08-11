import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {
  private FileManager(){};
  private static FileManager fm = new FileManager();
  public static FileManager getFileManager(){
    return fm;
  }

  public boolean save(Attendance attd, String fileName){
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
  public Attendance read(String fileName){
    Attendance attd = new Attendance();
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
