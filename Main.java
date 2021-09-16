import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library=new Library();
        Scanner input=new Scanner(System.in);
        String choice=null;
        do{

            System.out.println("-----------------+++++ welcome +++++---------------------");
            System.out.println("1-add book 2-add member 3-get book 4-return book 5-book Stat 6-members Stat ");
            System.out.println("7-search book  8-search member or (enter exit)");
            System.out.println("--------------------------------------------------------");
            System.out.print("enter number of your choice:");
            choice=input.next();
            try {
                switch (choice){

                    case "1":{
                        System.out.print("enter name of the book:");
                        String name=input.next();
                        System.out.print("enter count:");
                        int count=input.nextInt();
                        library.addBook(name,count);
                    }break;
                    case "2":{

                        System.out.print("enter name of member:");
                        String name=input.next();
                        System.out.print("enter member birthDate:");
                        String birthDate=input.next();
                        library.addMember(name,birthDate);

                    }break;
                    case "3":{
                        System.out.print("enter book id :");
                        int bookId=input.nextInt();
                        System.out.print("enter member id:");
                        int memberId=input.nextInt();
                        library.getBook(bookId,memberId);

                    }break;
                    case "4":{

                        System.out.print("enter book id :");
                        int bookId=input.nextInt();
                        System.out.print("enter member id:");
                        int memberId=input.nextInt();
                        library.returnBook(bookId,memberId);

                    }break;
                    case "5":{
                        library.printAllBooks();

                    }break;
                    case "6":{
                        library.printAllMembers();

                    }break;
                    case "7":{
                        System.out.print("enter book id: ");
                        int bookId=input.nextInt();
                        library.searchBook(bookId);

                    }break;
                    case "8":{
                        System.out.print("enter member id: ");
                        int memberId=input.nextInt();
                        library.searchMember(memberId);

                    }break;
                    case "exit": break;
                    default:{
                        System.out.println("wrong choice!");
                    }break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. ");
                String temp;
                if(input.next()=="e"){
                    temp=input.next();
                }
            }
        }while (!choice.equals("exit"));

    }
}
