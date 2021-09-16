public class Library {

    private int maxBook = 100;
    private int maxMember = 100;
    private int lastIndexOfBook = 0;
    private int lastIndexOfMember = 0;

    Book[] book = new Book[maxBook];
    Member[] members = new Member[maxMember];

    private int[] bookCount = new int[maxBook];


    /*public Library() {
        for (int i = 0; i < maxBook; i++) {
            book[i] = new Book();
        }
        for (int i = 0; i < maxMember; i++) {
            members[i] = new Member();
        }
    }*/

    public void addBook(String name, int count) {

        book[lastIndexOfBook] = new Book(lastIndexOfBook,name);
        bookCount[lastIndexOfBook] = count;
        lastIndexOfBook++;

    }

    public void printAllBooks() {
        if (lastIndexOfBook == 0) {
            System.out.println("there is no book in library!");
        } else {
            System.out.println("================= books list =====================");
            for (int i = 0; i < lastIndexOfBook; i++) {
                System.out.println("book id: " + book[i].getBookID());
                System.out.println("book name: " + book[i].getBookName());
                System.out.println("count: " + bookCount[i]);
            }
        }
    }

    public void addMember(String name, String birthDate) {
        members[lastIndexOfMember] = new Member();
        members[lastIndexOfMember].setMemberID(lastIndexOfMember);
        members[lastIndexOfMember].setMemberName(name);
        members[lastIndexOfMember].setBirthDate(birthDate);
        lastIndexOfMember++;
    }

    public void printAllMembers() {
        if (lastIndexOfMember == 0) {
            System.out.println("there is no member!");
        } else {
            System.out.println("================= members list =====================");
            for (int i = 0; i < lastIndexOfMember; i++) {
                System.out.println("member id: " + members[i].getMemberID());
                System.out.println("member name: " + members[i].getMemberName());
                System.out.println("member birthDate: " + members[i].getBirthDate());
                members[i].printBorrowedBookList();
            }
        }
    }

    public int findBook(int id) {
        for (int i = 0; i < lastIndexOfBook; i++) {
            if (book[i].getBookID() == id)
                return i;
        }
        return -1;
    }

    public int findMember(int id) {
        for (int i = 0; i < lastIndexOfMember; i++) {
            if (members[i].getMemberID() == id)
                return i;
        }
        return -1;
    }

    public void getBook(int bookId, int memberId) {

        int indexBook = findBook(bookId);
        int indexMember = findMember(memberId);

        if (indexBook != -1 && indexMember != -1) {
            if (bookCount[indexBook] > 0) {
                int numberOfBorrowedBoks = members[indexMember].memberBookCount;   //number of books that member borrowed
                if (numberOfBorrowedBoks < 5) {
                    members[indexMember].book[numberOfBorrowedBoks] = book[indexBook];
                    bookCount[indexBook]--;
                    members[indexMember].memberBookCount++;
                    System.out.println(members[indexMember].getMemberName() + " gets name of the book:(" + book[indexBook].getBookName() + ").");

                } else {
                    System.out.println("Max Reached!");
                }

            } else {
                System.out.println("Not Available!");
            }
        } else {
            System.out.println("invalid input!");
        }
    }

    public void returnBook(int bookId, int memberId) {
        int indexBook = findBook(bookId);
        int indexMember = findMember(memberId);
        if (indexBook != -1 && indexMember != -1) {
            if (members[indexMember].memberBookCount > 0) {  // count of books that member borrowed
                boolean hasBook = false;
                for (int i = 0; i < 5; i++) {   //search book id in member's borrowed book list
                    if (members[indexMember].book[i].getBookID() == bookId) {
                        hasBook = true;
                        break;
                    }
                }
                if (hasBook) {
                    members[indexMember].deleteBook(bookId);
                    members[indexMember].memberBookCount--;
                    bookCount[indexBook]++;
                    System.out.println("operation done successfully!");
                }else {
                    System.out.println("you didn't get this book!");
                }

            } else {
                System.out.println(" you didn't get any book!");
            }

        } else {
            System.out.println("invalid input!");
        }
    }

    public void searchMember(int memberId) {
        int index = findMember(memberId);
        if (index != -1) {
            System.out.println("name: " + members[index].getMemberName());
            members[index].printBorrowedBookList();
        } else {
            System.out.println("member not found!");
        }
    }

    public void searchBook(int bookId) {
        int index = findBook(bookId);
        if (index != -1) {
            System.out.println("book name: " + book[index].getBookName());
            System.out.println("book count: " + bookCount[index]);

        } else {
            System.out.println("book not found!");
        }
    }

}
