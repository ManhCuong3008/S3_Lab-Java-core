
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    //check user input number limit
    public static int getChoice(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //get input of user enter a string
    public static String getInputString() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine();
            if (result.trim().isEmpty()) {
                System.err.println("Must not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //get input course of user 
    public static String getInputCourse() {
        //loop until user input correct
        while (true) {
            String result = getInputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = getInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check user input u / d
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = getInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    //check id and exist
    public static boolean checkIdExist(ArrayList<Student> list, String id, String name) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIdInList(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())) {
                return true;
            }
        }
        return false;
    }

    //check id and exist
    public static boolean checkNameChanged(ArrayList<Student> list, String id, String name) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    //check student exist
    public static boolean checkStudentExist(ArrayList<Student> list, String id,
            String semester, String courseName) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
    //check student exist
    public static boolean checkStudentExistRecordUpdate(ArrayList<Student> list, String id, String name,
            String semester, String courseName) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName()) 
                    && name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    //check user change or not
    public static boolean checkChangeInfomation(Student student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }

    //check report exist
    public static boolean checkReportExist(ArrayList<Report> listReport, String name, String course, int total) {
        for (Report report : listReport) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
}
