import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;

public class PersonQueue {
    Queue<Person> personQueue = new ArrayDeque<>();

    public void StartMethod(String name) {
        if(name.contains("add")){
           AddNewPersonToQueue(name.trim());
        } else if ("process".equals(name)) {
            processQueue();
        }else if(name.contains("leave person")){
            leavePersonFromQueue(name);
        }
    }

    private void leavePersonFromQueue(String name) {
        if(personQueue.isEmpty()){
            System.out.println("kolejka jest pusta");
        }
        String incomeString = name.substring(name.indexOf("(")+1, name.indexOf(")"));
        for (Person person : personQueue) {
            if(person.generateId().equals(incomeString)){
                personQueue.remove(person);
                System.out.println("Leaving queue: "+person);
            }
        }
        if(personQueue.isEmpty()){
            System.out.println("kolejka jest pusta");
            return;
        }
        System.out.println(personQueue);
    }

    private void processQueue() {
        if(personQueue.isEmpty()){
            System.out.println("Kolejka jest pusta");
            return;
        }
        System.out.println("Processing queue: "+personQueue.poll()+" arrived at the store");
        System.out.println("Queue: "+personQueue);
    }

    private void AddNewPersonToQueue(String name) {
        String PersonName = name.substring(name.indexOf("(")+1, name.indexOf("_"));
        String PersonSurname = name.substring(name.indexOf("_")+1,name.indexOf(")"));

        BigInteger bigInteger = BigInteger.ONE;
        Person person = new Person(PersonName, PersonSurname, bigInteger);

        extracted(PersonName, PersonSurname, bigInteger, person);
        boolean offer = personQueue.offer(person);

        System.out.println(person.generateId()+" came to the queue: "+offer);
        System.out.println("Queue: "+personQueue);

    }

    private void extracted(String PersonName, String PersonSurname, BigInteger bigInteger, Person person) {
        for (Person person1 : personQueue) {
            if(person1.generateId().contains(PersonName)&&person1.generateId().contains(PersonSurname)){
                bigInteger = bigInteger.add(BigInteger.ONE);
                person.setCounter(bigInteger);
            }
        }
    }


}
