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
        String argComando = "";
        String argValor = "";

        if(args.length > 0){
            argComando = args[0];
            if(args.length >= 2){
                argValor = args[1];
            }

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
        // Pra start fora do jar descomente abaixo
//        else {
//            new CreateData().setData("ABCDEFA:171");
//            new ReadData().getData("ABCDEFA");
//            new ListData().getData();
//            new DeleteData().deleteData("ABCDEFA");
//        }
    }
}
