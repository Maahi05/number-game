import java.util.*;
public class StudentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManagementSystem sms =
                new StudentManagementSystem();

        while(true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    Student s =
                            new Student(roll, name, grade);

                    sms.addStudent(s);

                    break;

                case 2:

                    System.out.print("Enter Roll No to Remove: ");
                    int removeRoll = sc.nextInt();

                    sms.removeStudent(removeRoll);

                    break;

                case 3:

                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();

                    sms.searchStudent(searchRoll);

                    break;

                case 4:

                    sms.displayAllStudents();

                    break;

                case 5:

                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
           
        }
        
    }
}
class Student {

    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Grade   : " + grade);
        System.out.println("----------------------");
    }
}

class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();

    // Add Student
    void addStudent(Student s) {
        students.add(s);
        System.out.println("Student Added Successfully");
    }

    // Remove Student
    void removeStudent(int rollNo) {

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.rollNo == rollNo) {
                students.remove(i);
                System.out.println("Student Removed");
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    // Search Student
    void searchStudent(int rollNo) {

        for(Student s : students) {

            if(s.rollNo == rollNo) {
                System.out.println("Student Found");
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    // Display All Students
    void displayAllStudents() {

        if(students.isEmpty()) {
            System.out.println("No Students Available");
            return;
        }

        for(Student s : students) {
            s.display();
        }
    }
}

