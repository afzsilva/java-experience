package arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program3 {

    public static void main(String[] args) {
        String path="src/main/java/arquivos/in.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
               line = br.readLine();
            }
        }catch (IOException e){
            System.out.println("Message Error "+e.getMessage());
        }
    }

}
