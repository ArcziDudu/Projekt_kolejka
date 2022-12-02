import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;

public class PersonQueue {
    Queue<Person> personQueue = new ArrayDeque<>();

    public void StartMethod(String name) {
        if(name.contains("ADD")){
           AddNewPersonToQueue(name.trim());
        } else if ("PROCESS".equals(name)) {
            processQueue();
        }
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
        boolean offer = personQueue.offer(person);
    

        System.out.println(person.generateId()+" came to the queue: "+offer);
        System.out.println("Queue: "+personQueue);

    }


}
