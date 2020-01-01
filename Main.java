
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Phonebook pb = new Phonebook();
        Scanner sc = new Scanner(System.in);
        printMenu();
        commands(sc, pb);

    }

    public static void printMenu() {
        System.out.println("phone search\n" + "available operations:\n" + " 1 add a number\n"
                + " 2 search for a number\n" + " 3 search for a person by phone number\n" + " 4 add an address\n"
                + " 5 search for personal information\n" + " 6 delete personal information\n" + " 7 filtered listing\n"
                + " x quit\n" + "");
    }

    public static void commands(Scanner sc, Phonebook pb) {
        while (true) {
            System.out.print("command: ");
            String ans = sc.nextLine();
            if (ans.equals("1")) {
                System.out.print("whose number: ");
                String who = sc.nextLine();
                System.out.print("number: ");
                String num = sc.nextLine();
                ;
                if (pb.inPB(who)) {
                    pb.addNumber(who, num);
                } else {
                    Person p = new Person(who);
                    p.addNumber(num);
                    pb.addPerson(p);
                }

            } else if (ans.equals("2")) {
                System.out.print("whose number: ");
                String who = sc.nextLine();
                pb.searchByName(who);

            } else if (ans.equals("3")) {
                System.out.print("number: ");
                String num = sc.nextLine();
                ;
                pb.searchByNumber(num);

            } else if (ans.equals("4")) {
                System.out.print("whose address: ");
                String who = sc.nextLine();
                System.out.print("street: ");
                String street = sc.nextLine();
                ;
                System.out.print("city: ");
                String city = sc.nextLine();
                ;

                if (pb.inPB(who)) {
                    pb.addAddress(who, street, city);
                } else {
                    Person p = new Person(who);
                    p.setStreet(street);
                    p.setCity(city);
                    pb.addPerson(p);
                }

            } else if (ans.equals("5")) {
                System.out.print("whose information: ");
                String who = sc.nextLine();
                pb.printInfoByName(who);

            } else if (ans.equals("6")) {
                System.out.print("whose information: ");
                String who = sc.nextLine();
                pb.removePerson(who);
            } else if (ans.equals("7")) {
                System.out.print("keyword (if empty, all listed): ");
                String keyword = sc.nextLine();
                pb.search(keyword);
            } else if (ans.equals("x")) {
                return;
            } else {

            }
            System.out.println("");
        }
    }
}
