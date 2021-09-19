package arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program2 {

    public static void main(String[] args) {
        String path="src/main/java/arquivos/in.txt";
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();//ler uma linha

            /*Enquanto a linha nao for null
            * continua lendo próxima linha*/
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch (IOException e){
            System.err.println("ERRO "+e.getMessage());
        }finally {
            try {
                if (br != null){
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }//main
}
