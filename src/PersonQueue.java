import java.math.BigInteger;
import java.util.*;

public class PersonQueue {

    BigInteger bigInteger = BigInteger.ONE;
    Deque<Person> personQueue = new ArrayDeque<>();

    public void StartMethod(String name) {
        //walidator wpisywanych komend
        if(name.contains("add")){
           AddNewPersonToQueue(name.trim());
        } else if ("process".equals(name)) {
            processQueue();
        }else if(name.contains("leave person")){
            leavePersonFromQueue(name);
        }
    }


    private void leavePersonFromQueue(String name) {
        //funkcja do usuwania osoby z kolejki na podstawie imienia i nazwiska przekazanego w skanerze
        if(personQueue.isEmpty()){
            System.out.println("kolejka jest pusta");
            return;
        }
        //wyciąganie imienia i nazwiska
        String incomeString = name.substring(name.indexOf("(")+1, name.indexOf(")"));
        for (Person person : personQueue) {
            if(person.generateId().equals(incomeString)){
                    personQueue.remove(person);
                System.out.println("Leaving queue: "+person);
                break;
            }
        }
        //jesli kolejka jest pusta
        if(personQueue.isEmpty()){
            System.out.println("kolejka jest pusta");
            return;
        }
        System.out.println(personQueue);
    }

    private void processQueue() {
        //funckja do usuwania osoby z kolejkki ktora dostała się do sklepu

        //jesli jest pusta
        if(personQueue.isEmpty()){
            System.out.println("Kolejka jest pusta");
            System.out.println("Queue: "+personQueue);
            return;
        }
        //sciaga osobe z kolejki
        System.out.println("Processing queue: "+personQueue.poll()+" arrived at the store");
        System.out.println("Queue: "+personQueue);

    }

    private void AddNewPersonToQueue(String name) {
        //funkcja dodająca nową osobe do kolejki

        //wyciąganie imienia i nazwiska ze skanera
        String PersonName = name.substring(name.indexOf("(")+1, name.indexOf("_"));
        String PersonSurname = name.substring(name.indexOf("_")+1,name.indexOf(")"));

        //jesli osoba jest vipem
        if(name.contains("VIP")){
            PersonSurname= name.substring(name.indexOf("_")+1, name.indexOf(","));
        }


        boolean vip = name.contains("VIP");
        //tworzenie nowej osoby
        Person person = new Person(PersonName, PersonSurname, bigInteger, vip);
        //jesli osoba jest vipem to idzie na sam przód kolejki
        if(person.getVip()){
            personQueue.push(person);
            System.out.println(person.generateId()+" came to the queue: ");
            System.out.println(personQueue);
            return;
        }
        //funkcja do zwiększania countera dla takich samych osób na podstawie imienia i nazwiska
        extracted(PersonName, PersonSurname, bigInteger, person);

        boolean offer = personQueue.offer(person);
        //dodawanie nowej osoby na koniec kolejki
        System.out.println(person.generateId()+" came to the queue: "+offer);
        System.out.println("Queue: "+personQueue);

    }

    private void extracted(String PersonName, String PersonSurname, BigInteger bigInteger, Person person) {

        //funkcja sprawdzająca czy taka osoba jest już w kolejce i jesli tak to ma zwiększany counter

        for (Person person1 : personQueue) {
        if(person1.generateId().contains(PersonName)&&person1.generateId().contains(PersonSurname)){
            bigInteger = person1.getCounter().add(BigInteger.ONE);

            person.setCounter(bigInteger);
        }
        }
    }



}
