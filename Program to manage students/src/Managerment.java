
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Managerment {

    private final static Scanner sc = new Scanner(System.in);

    //Show menu
    public static void menu() {
        System.out.println("====================================================");
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1.Create");
        System.out.println("2.Find and Sort");
        System.out.println("3.Update/Delete");
        System.out.println("4.Report");
        System.out.println("5.Exit");
        System.out.print("Enter your choice: ");
    }

    // Create 
    //Allow user create new student
    public static void createStudent(ArrayList<Student> list) {
        //if number of students greater than 10 ask user continue or not
        if (list.size() >= 4) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        //loop until user input not duplicate
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.getInputString();
            String name = "";
            System.out.print("Enter name student: ");
            name = Validation.getInputString();
            // check id duplicate 
            if (!Validation.checkIdExist(list, id, name)) {
                System.err.println("1 Id just indentity 1 name. Pleas re-input.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = Validation.getInputString();
            System.out.print("Enter name course: ");
            String course = Validation.getInputCourse();
            //Check record of student exist or not
            if (Validation.checkStudentExist(list, id, semester, course)) {
                list.add(new Student(id, name, semester, course));
                System.out.println("Add student success.");
                return;
            } else {
                System.err.println("Record of student Duplicate.");
            }
        }
    }

    //Allow user create find and sort
    public static void findAndSort(ArrayList<Student> list) {
        //check list empty 
        if (list.isEmpty()) {
            System.err.println("List student empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(list);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist the name student.");
        } else {
            Collections.sort(listStudentFindByName, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
                }
            });
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    public static void updateName(ArrayList<Student> list, String id, String name) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.setStudentName(name);
            }
        }
    }

    //Get list student found by name
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> list) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validation.getInputString();
        for (Student student : list) {
            //check student have name contains input
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    //Get list student find by id
    public static ArrayList<Student> getListStudentById(ArrayList<Student> list, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    //Get student user want to update/delete in list found
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByID) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-10s%-15s%-15s%-15s\n", "Number", "ID", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByID) {
            System.out.printf("%-10d%-10s%-15s%-15s%-15s\n", count, student.getId(),
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.getChoice(1, listStudentFindByID.size());
        return listStudentFindByID.get(choice - 1);
    }

    // Update/Delete
    //Allow user update and delete   
    public static void updateOrDelete(ArrayList<Student> listStudent) {
        //if listStudent empty 
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = Validation.getInputString();
        ArrayList<Student> listStudentFindByID = getListStudentById(listStudent, id);
        //check listStudent empty
        if (listStudentFindByID.isEmpty()) {
            System.err.println("Not found student have this id.");
        } else {
            Student student = getStudentByListFound(listStudentFindByID);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            //check user want to update or delete
            if (Validation.checkInputUD()) {
                while (true) {
                    System.out.print("Enter id: ");
                    String idUpdate = Validation.getInputString();
                    boolean checkInputSameID = false;
                    String name = "";
                    // check id user update same with id of object student was choose
                    if (id.equalsIgnoreCase(idUpdate)) {
                        System.out.print("Enter name student: ");
                        name = Validation.getInputString();
                        checkInputSameID = true;
                    } else {
                        while (true) {
                            System.out.print("Enter name student: ");
                            name = Validation.getInputString();
                            // check idUpdate in list student
                            if (Validation.checkIdInList(listStudent, idUpdate)) {
                                // if id in list check 1 Id just indentity 1 name
                                if (!Validation.checkIdExist(listStudent, idUpdate, name)) {
                                    System.err.println("1 Id just indentity 1 name. Pleas re-input.");
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    System.out.print("Enter semester: ");
                    String semester = Validation.getInputString();
                    System.out.print("Enter name course: ");
                    String course = Validation.getInputCourse();
                    //check record of student exist or not
                    if (Validation.checkStudentExist(listStudent, idUpdate, semester, course)) {
                        student.setId(idUpdate);
                        if (checkInputSameID) {
                            updateName(listStudent, idUpdate, name);
                        } else {
                            student.setStudentName(name);
                        }
                        student.setSemester(semester);
                        student.setCourseName(course);
                        System.out.println("Update success.");
                        return;
                    } else {
                        System.err.println("Duplicate can't Update second student same record on list");
                        return;
                    }
                }
            } else {
                listStudent.remove(student);
                System.out.println("Delete success.");
            }
        }
    }

    // Report
    public static void report(ArrayList<Student> list) {
        // check list empty 
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> listReport = new ArrayList<>();
        for (Student student : list) {
            int total = 0;
            String id = student.getId();
            String courseName = student.getCourseName();
            String studentName = student.getStudentName();
            for (Student student1 : list) {
                if (id.equalsIgnoreCase(student1.getId())
                        && courseName.equalsIgnoreCase(student1.getCourseName())) {
                    total++;
                }
            }
            if (Validation.checkReportExist(listReport, studentName,
                    courseName, total)) {
                listReport.add(new Report(studentName, courseName, total));
            }
        }
        //print report
        for (Report report : listReport) {
            report.printReport();
        }
    }

}
