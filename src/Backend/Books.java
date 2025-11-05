package Backend;
import java.util.Scanner;

public class Books {

    // class data members
    Book[] arrOfBook = new Book[100];
    public static int count = 0;

    Scanner input = new Scanner(System.in);

    //Method to do check weather the book exists or not
    public int compareBookObject(Book b1, Book b2) {
        //bookName matches or not
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println("Book of this name already exists!");
            return 0;
        }
        //book serial_no matches or not
        if (b1.sno == b2.sno) {
            System.out.println("Book of this serial_No already exists!");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (this.compareBookObject(b, this.arrOfBook[i]) == 0) return;
        }
        if (count < 50) {
            arrOfBook[count] = b;
            count++;
        } else {
            System.out.println("Sorry, No more space to Add Books");
        }
    }

    //Method 3 - to search book by serial number
    public void searchBySno() {
        System.out.println("SEARCH BY SERIAL NUMBER");

        int sNo;
        System.out.print("Enter serial No of Book: ");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println("|------+----------+---------------+---------------+----------------+");
        System.out.println("| S.No | BookName | Author's Name | Book Quantity | Total Quantity |");
        System.out.println("|------+----------+---------------+---------------+----------------+");

        for (int i = 0; i < count; i++) {
            if (sNo == arrOfBook[i].sno) {
                System.out.printf("| %-5s | %-10s | %-15s| %-15s | %-16s|\n", arrOfBook[i].sno, arrOfBook[i].bookName, arrOfBook[i].authorName, arrOfBook[i].quantity, arrOfBook[i].quantity);
                flag++;
                return;
            }
        }
        if (flag == 0) {
            System.out.println("No Nook for serial No" + sNo + " fount.");
        }
    }

    //Method 4 - to search author by name
    public void searchByAuthorName() {
        System.out.println("SEARCH BY AUTHOR NAME:");
        System.out.println("Enter Author's Name:");
        String authorName = input.nextLine();
        int flag = 0;
        System.out.println("|------+----------+---------------+---------------+----------------+");
        System.out.println("| S.No | BookName | Author's Name | Book Quantity | Total Quantity |");
        System.out.println("|------+----------+---------------+---------------+----------------+");

        for (int i = 0; i < count; i++) {
            // if author matches any of its book
            if (authorName.equalsIgnoreCase(arrOfBook[i].authorName)) {
                System.out.println(
                        arrOfBook[i].sno + arrOfBook[i].bookName + arrOfBook[i].authorName + arrOfBook[i].bookQtyCopy + arrOfBook[i].quantity);
                flag++;
            }
        }
        // if no book matches for the author
        if (flag == 0) {
            System.out.println("No Books of authorName " + authorName + "Found");
        }
        //Method 5
        //to display all the books
    }

    public void showAllBooks() {
        System.out.println("Showing ALl Books");
        System.out.println("|------+----------+---------------+---------------+----------------+");
        System.out.println("| S.No | BookName | Author's Name | Book Quantity | Total Quantity |");
        System.out.println("|------+----------+---------------+---------------+----------------+");

        for (int i = 0; i < count; i++) {
            System.out.printf("| %-4s | %-8s | %-13s | %-13s | %-14s |\n",
                    arrOfBook[i].sno, arrOfBook[i].bookName, arrOfBook[i].authorName,
                    arrOfBook[i].bookQtyCopy, arrOfBook[i].quantity);
            System.out.println("|------+----------+---------------+---------------+----------------+");

        }
    }

    //Method 6
    //to edit the book
    public void upgradeBookQty() {
        System.out.println("QUANTITY OF A BOOK");
        System.out.println("Enter Serial No of Book");
        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (sNo == arrOfBook[i].sno) {
                System.out.println("Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                arrOfBook[i].quantity += addingQty;
                arrOfBook[i].bookQtyCopy += addingQty;
                return;
            }
        }
        System.out.println("Book not found with serial No " + sNo);
    }


    public void dispMenu() {
        System.out.println("+-------+------------------------------------+");
        System.out.println("| PRESS |              OPERATION             |");
        System.out.println("+-------+------------------------------------+");
        System.out.println("|Press 1|  Add new Book.                     |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 0|  Exit Application.                 |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 2|  Upgrade Quantity of a  Book.      |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 3|  Search a Book.                    |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 4|  All Books.                        |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 5|  Registered Students.              |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 6|  Show All Registered Students.     |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 7|  Check OUt Book.                   |");
        System.out.println("+--------------------------------------------+");
        System.out.println("|Press 8|  Check In  Book.                   |");
        System.out.println("+--------------------------------------------+");
    }

    //Method 8
    //to search the library
    public int isAvailable(int sno)
    {
        for (int i=0; i<count; i++) {
            if (sno == arrOfBook[i].sno) {
                if (arrOfBook[i].bookQtyCopy > 0) {
                    System.out.println("Book is available.");
                    return i;
                }
                System.out.println("The Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No Book Serial Number " + "Available in Library");
        return -1;
    }
    //Method 9
    // to remove the book from the library
    public Book checkOutBook() {
        System.out.println("Enter the Serial No of Book to be CheckOut.");
        int sno = input.nextInt();
        int bookIndex = isAvailable(sno);

        if (bookIndex != -1) {
            arrOfBook[bookIndex].bookQtyCopy--;
            return arrOfBook[bookIndex];
        }
        return null;
    }

    //Method 20
    //to add the book to the Library
    public void checkInBook(Book b) {
        for (int i=0; i<count; i++) {
            if (b.equals(arrOfBook[i])) {
                arrOfBook[i].bookQtyCopy++;
                return;
            }
        }
    }
}




















