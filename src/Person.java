import java.math.BigInteger;

public class Person{
    private final String name;
    private final String surname;
    private  BigInteger counter;
    private final String id;
    private Boolean vip = false;

    public Boolean getVip() {
        return vip;
    }

    public Person(String name, String surname, BigInteger counter, boolean vip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.id = generateId();
        this.vip = vip;
    }



    public BigInteger getCounter() {
        return counter;
    }

    public String generateId() {
        //generowanie id w celu przedstawiania osoby w terminalu
        if(!this.vip){
            return this.name+"_"+this.surname+"_"+this.counter;
        }else{
            return this.name+"_"+this.surname+"_"+this.counter+"_VIP";
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        String sb = name + "_" + surname +
                "_" + counter;
        if(this.vip){
            sb=name + "_" + surname +
                    "_" + counter + "_VIP";
        }
        return sb;
    }

    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }
}
