
import java.util.ArrayList;

public class Person implements Comparable<Person> {

    private String name;
    private ArrayList<String> num;
    private String street;
    private String city;

    public Person(String name) {
        this.name = name;
        this.num = new ArrayList<String>();
    }

    public void addNumber(String num) {
        this.num.add(num);
    }

    public ArrayList<String> getNum() {
        return this.num;
    }

    public String getName() {
        return this.name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

}
