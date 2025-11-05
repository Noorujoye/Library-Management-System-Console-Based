package Backend;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("+------------------------------------------------------WELCOME TO THE CDGI LIBRARY------------------------------------------------------+");
        System.out.println("|                                                   SELECT FROM THE FOLLOWING OPTIONS                                                   |");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

        // Creating object of Books and Students class
        Books b_obj = new Books();
        Students stu = new Students();

        int choice;
        int searchChoice;

        do {
            b_obj.dispMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Book b = new Book();
                    b_obj.addBook(b);
                    break;

                case 2:
                    b_obj.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Press 1 to Search with Book Serial No.");
                    System.out.println("Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();

                    switch (searchChoice) {
                        case 1:
                            b_obj.searchBySno();
                            break;
                        case 2:
                            b_obj.searchByAuthorName();
                            break;
                        default:
                            System.out.println("Invalid search choice!");
                    }
                    break;

                case 4:
                    b_obj.showAllBooks();
                    break;

                case 5:
                    Student s = new Student();
                    stu.addStudents(s);
                    break;

                case 6:
                    stu.showAllStudents();
                    break;

                case 7:
                    stu.checkOutBook(b_obj);
                    break;

                case 8:
                    stu.checkInBook(b_obj);
                    break;

                case 0:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Enter a valid choice between 0 to 8.");
            }
        } while (choice != 0);
    }
}
