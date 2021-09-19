package monitorar;

import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.file.StandardWatchEventKinds.*;

public class MonitoradorArquivos {

    public static void main(String[] args) {

        verificaPasta("/Users/afzsilva/Desktop/VERIFICADAS");
    }//main

    /**
     * Retorna data e hora atual formatada em dd/MM/yyyy HH:mm:ss
     * @return data atual formatada em String
     */
    private static String getData(){
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHoraAtual.format(formato);
    }

    private static void verificaPasta(String path){

        //String path = ;
        try {

            WatchService ws = FileSystems.getDefault().newWatchService();
            Path logDir = Paths.get(path);
            logDir.register(ws,ENTRY_CREATE,ENTRY_MODIFY,ENTRY_DELETE);

            while(true){
                WatchKey key = ws.take();
                for (WatchEvent<?> event: key.pollEvents()){

                    WatchEvent.Kind<?> kind = event.kind();

                    if (ENTRY_CREATE.equals(kind)){
                        System.out.println("CRIADO : em "+ getData()+" - "+event.context());
                    }else if(ENTRY_MODIFY.equals(kind)){
                        System.out.println("MODIFICADO : em "+getData()+" - "+event.context());
                    }else if(ENTRY_DELETE.equals(kind)){
                        System.out.println("REMOVIDO : em "+getData()+" - "+event.context());
                    }
                }//for
                key.reset();
            }//while

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
