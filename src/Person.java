import java.math.BigInteger;

public class Person {
    private final String name;
    private final String surname;
    private final BigInteger counter;
    private final String id;

    public Person(String name, String surname, BigInteger counter) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.id = generateId();
    }

    public BigInteger getCounter() {
        return counter;
    }

    public String generateId() {
        return this.name+"_"+this.surname+"_"+this.counter;
    }

    @Override
    public String toString() {
        String sb = name +"_"+ surname +
                "_" + counter;
        return sb;
    }
}
