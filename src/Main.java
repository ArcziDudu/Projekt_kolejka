import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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