
import java.util.ArrayList;

/**
 *
 * @author TapTap
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Validation validation = new Validation();
        list.add(new Student("1", "Nguyen Van A", "Fall", "Java")); 
        list.add(new Student("1", "Nguyen Van A", "Summer", "Java")); 
        list.add(new Student("1", "Nguyen Van A", "Spring", "Java")); 
//        list.add(new Student("1", "Nguyen Van A", "Fall", ".net"));
        list.add(new Student("2", "Nguyen Van B", "Fall", ".net"));
//        list.add(new Student("3", "Nguyen Van D", "Fall", ".net"));
        //loop until user want to exit program
        while (true) {
            //Show menu option
            Managerment.menu();
            // user input choice with  ranger a to 5
            int choice = validation.getChoice(1, 5);
            // Base on the selected option of user with each case 
            switch (choice) {
                case 1:
                    Managerment.createStudent(list);
                    break;
                case 2:
                    Managerment.findAndSort(list);
                    break;
                case 3:
                    Managerment.updateOrDelete(list);
                    break;
                case 4:
                    Managerment.report(list);
                    break;
                case 5:
                    return;
            }
        }
    }

}
