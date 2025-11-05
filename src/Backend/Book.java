package Backend;
import java.util.Scanner;

public class Book {
    // class data members
    public int sno;
    public String bookName;
    public String authorName;
    public int quantity;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);

    // Constructor to create a Book and take input directly
    public Book() {
        System.out.print("Enter the Serial Number: ");
        this.sno = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Enter the Book Name: ");
        this.bookName = input.nextLine();

        System.out.print("Enter the Author's Name: ");
        this.authorName = input.nextLine();

        System.out.print("Enter the Quantity of Books: ");
        this.quantity = input.nextInt();

        this.bookQtyCopy = this.quantity;
    }
}
