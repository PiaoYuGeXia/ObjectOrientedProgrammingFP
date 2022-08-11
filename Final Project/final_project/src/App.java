import java.io.File;

public class App {
    public static void main(String[] args) {
        LoginGUI lgui = new LoginGUI();
        lgui.setVisible(true);

        // //initialize files
        // String fileTeacher = "Final Project/final_project/lib/teacher.dat";
        // String fileEmployer = "Final Project/final_project/lib/employer.dat";
        // FileManager fm = FileManager.getFileManager();
        // Attendance attdStudent = new Attendance();
        // attdStudent.addPerson(new Student("Jason", "jz4495"));
        // fm.save(attdStudent, fileTeacher);

        // Attendance attdEmployee = new Attendance();
        // attdEmployee.addPerson(new Student("Jason", "jz4495"));
        // fm.save(attdEmployee, fileEmployer);
        // attdStudent = fm.read(fileTeacher);
        // System.out.println(attdStudent.getPpl().get(0).getName());
        // System.out.println(attdStudent.getAttd().get(0)[2]);
    }
}
