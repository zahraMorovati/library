public class Member {

    private int memberID;
    private String memberName;
    private String birthDate;

    Book[] book=new Book[5];

    public int memberBookCount=0;
    public void setMemberID(int memberID) {
        this.memberID = memberID;

    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID() {
        this.memberID++;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void deleteBook(int bookId){

        for (int i = 0; i < memberBookCount-1; i++) {
            if(book[i].getBookID()==bookId){
                //Book temp=book[i];
                book[i]=book[i+1];
                book[i+1]=null;
            }
        }
    }

    public void printBorrowedBookList(){
        System.out.print("borrowed book list: ");
        for (int i = 0; i < memberBookCount; i++) {
            System.out.print(book[i].getBookName()+" ");
        }
        System.out.println();
    }
}
