package Backend;

import java.util.Scanner;

public class Student {
    //class member vaiables
    String studentName;
    String registerNum;

    Book[] borrowedBooks = new Book[3];
    public int bookCount = 0;

    Scanner input = new Scanner(System.in);

    //Constructor
    public Student()
    {
        //print statement
        System.out.println("Enter Student Name: ");
        this.studentName = input.nextLine();

        //Print statement
        System.out.println("Enter Registration Number");
        this.registerNum = input.nextLine();
    }
}
