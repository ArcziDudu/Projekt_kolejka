import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("add(imie_nazwisko) - dodaje kolejną osobę do kolejki");
        System.out.println("process - zdejmuje osobę która została dodana jako pierwsza");
        System.out.println("leave person(imie_nazwisko_id) - osoba zostaje usunięta z kolejki");
        System.out.println("add(imie_nazwisko, VIP) - dodaje osobe na pierwsze miejsce w kolejce");
        PersonQueue personQueue = new PersonQueue();
        Scanner scanner = new Scanner(System.in);
        //skaner do wpisywania komend
        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            try{
                personQueue.StartMethod(name);
            }catch (ConcurrentModificationException e){
                System.out.println("Błąd");
            }
        }
    }
}