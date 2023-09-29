package excecoes.ex2.application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        File file = new File("/home/mathe/Área de trabalho/Example2.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }

        System.out.println("End of program.");
    }

}
