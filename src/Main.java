import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        PersonQueue personQueue = new PersonQueue();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            personQueue.StartMethod(name);
        }
    }
}