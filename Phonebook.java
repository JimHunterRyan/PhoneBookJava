
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Phonebook {

    private ArrayList<Person> pb;

    public Phonebook() {
        pb = new ArrayList<Person>();
    }

    public void addPerson(Person p) {
        pb.add(p);
    }

    public void searchByName(String name) {
        String print = "not found";
        for (Person p : pb) {
            if (p.getName().equals(name)) {
                for (int i = 0; i < p.getNum().size(); i++) {
                    System.out.println(" " + p.getNum().get(i));

                }
                return;

            }
        }
        System.out.println(" " + print);

    }

    public void addAddress(String person, String street, String city) {
        for (Person p : pb) {
            if (p.getName().equals(person)) {
                p.setStreet(street);
                p.setCity(city);
            }
        }
    }

    public void printInfoByName(String name) {
        if (!numberKnown(name) && !addressKnown(name)) {
            System.out.println("  not found");
            return;
        }

        for (Person p : pb) {
            if (p.getName().equals(name)) {

                if (addressKnown(name)) {
                    System.out.println("  address: " + p.getStreet() + " " + p.getCity());
                } else {
                    System.out.println("  address unknown ");
                }
                if (numberKnown(name)) {
                    System.out.println("  phone numbers:");
                    for (int i = 0; i < p.getNum().size(); i++) {
                        System.out.println("   " + p.getNum().get(i));

                    }
                } else {
                    System.out.println("  phone number not found");
                }

            }
        }

    }

    public boolean inPB(String person) {
        for (Person p : pb) {
            if (p.getName().equals(person)) {
                return true;
            }
        }
        return false;
    }

    public void addNumber(String person, String num) {
        for (Person p : pb) {
            if (p.getName().equals(person)) {
                p.addNumber(num);
            }
        }

    }

    public void searchByNumber(String number) {
        String print = "not found";
        for (Person p : pb) {
            for (String num : p.getNum()) {
                if (num.equals(number)) {
                    System.out.println(" " + p.getName());
                    return;
                }

            }
        }
        System.out.println(" " + print);
    }

    public boolean addressKnown(String name) {
        for (Person p : pb) {
            if (p.getName().equals(name)) {
                if (!(p.getStreet() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean numberKnown(String name) {
        for (Person p : pb) {
            if (p.getName().equals(name)) {
                if (!(p.getNum().size() == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void search(String key) {
        Phonebook book = new Phonebook();
        Set<Person> people = new HashSet<Person>();
        for (Person p : pb) {
            if (p.getCity() != null) {
                if (p.getCity().contains(key)) {
                    people.add(p);
                }
            }
            if (p.getName() != null) {
                if (p.getName().contains(key)) {
                    people.add(p);
                }
            }
            if (p.getStreet() != null) {
                if (p.getStreet().contains(key)) {
                    people.add(p);
                }
            }

        }
        for (Person pers : people) {
            book.addPerson(pers);
        }
        book.sort();
        if (people.size() == 0) {
            System.out.println(" keyword not found");
        } else {

            System.out.println("");
            for (Person person : book.getBook()) {
                System.out.println(" " + person.getName());
                book.printInfoByName(person.getName());
            }
        }
    }

    public void removePerson(String name) {
        for (Person p : pb) {
            if (p.getName().equals(name)) {
                pb.remove(p);
                return;
            }
        }

    }

    public void sort() {
        Collections.sort(this.pb);
    }

    public ArrayList<Person> getBook() {
        return this.pb;
    }
}
