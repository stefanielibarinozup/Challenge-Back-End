package br.com.zup.challenge.spring.service;

import br.com.zup.challenge.spring.crud.CreateData;
import br.com.zup.challenge.spring.crud.DeleteData;
import br.com.zup.challenge.spring.crud.ListData;
import br.com.zup.challenge.spring.crud.ReadData;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ServiceSpring {

    public static void operacoesComandos(String args[]) throws IOException {
        if(args.length > 0){
            String argComando = args[0];
            String argValor = args[1];

            if(argComando.equals("set")) {
                new CreateData().setData(argValor);
            }
            else if(argComando.equals("get")) {
                new ReadData().getData(argValor);
            }
            else if(argComando.equals("list")){
                new ListData().getData();
            }
            else if(argComando.equals("delete")){
                new DeleteData().deleteData(argValor);
            }
            else {
                System.out.println("Comando não encontrado!");
            }
        }
        else {
            new CreateData().setData("ABCDEFA:171");
            new ReadData().getData("ABCDEFA");
            new ListData().getData();
            new DeleteData().deleteData("ABCDEFA");
        }
    }
}
