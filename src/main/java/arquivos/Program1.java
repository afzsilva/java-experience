package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        String path = "src/main/java/arquivos/in.txt";
        File file = new File(path);
        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
