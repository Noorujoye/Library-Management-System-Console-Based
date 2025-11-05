package Backend;

import java.util.Scanner;

public class Students {
   // Creating objects of Scanner and Students class
    Scanner input = new Scanner(System.in);
    Student[] theStudents = new Student[50];

    public static int count = 0;

    //Method 1
    // to avoid books
    public void addStudents(Student s) {
        for (int i=0; i<count; i++) {
            if (s.registerNum.equalsIgnoreCase(theStudents[i].registerNum)) {
                System.out.println("Student of Registration Number " + s.registerNum + " is Already registered");
                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }

    //Method 2
    //Dispalying all the students

    public void showAllStudents() {

        //printing the name and
        //corresponding registered number
        System.out.println("+-------------+--------------------+");
        System.out.println("|Student Name | Registration Number|");
        for (int i=0; i<50; i++) {
            System.out.println("| %-15s | %-20s |\n" + theStudents[i].studentName + theStudents[i].registerNum);
        }
    }

    //Method 3
    //to check the student

    public int isStudent() {
        //Display message only
        System.out.println("Enter Registration Number:");
        String registerNum = input.nextLine();

        for (int i=0; i<count; i++) {
            if (theStudents[i].registerNum.equalsIgnoreCase(registerNum)) {
                return i;
            }
        }
        System.out.println("Students is not registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    //Method 4
    // to remove the book
    public void checkOutBook(Books book) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("Checking out");

            book.showAllBooks();
            Book b = book.checkOutBook();

            System.out.println("Checking Out");

            if (b != null) {
                if (theStudents[studentIndex].bookCount <= 3) {
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].bookCount] = b;
                    theStudents[studentIndex].bookCount++;
                    return;
                } else {
                    System.out.println("Student can not Boorow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available");
        }
    }

    //Method 5
    // to add the book
    public void checkInBook(Books book) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            //Printing credential corresponding to student
            System.out.println("|------+----------+---------------+");
            System.out.println("| S.No | BookName | Author's Name |");
            System.out.println("|------+----------+---------------+");

            Student s = theStudents[studentIndex];
            for (int i=0; i<s.bookCount; i++) {
                System.out.println(
                        s.borrowedBooks[i].sno + s.borrowedBooks[i].bookName + s.borrowedBooks[i].authorName
                );
            }
            //Display the message only
            System.out.println("Enter Serial Number of Book to be Checked In");

            int sNo = input.nextInt();

            for (int i=0; i<s.bookCount; i++) {
                if (sNo == s.borrowedBooks[i].sno) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
                    return;
                }
            }
            System.out.println("Book of serial No " + sNo + "not found");
        }
    }
}
