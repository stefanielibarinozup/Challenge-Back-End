package br.com.zup.challenge;


import java.io.*;

public class App {


    public static void main(String[] args) {
        File dir = new File("folder");
        for (File file : dir.listFiles()) {
            listar(file);
        }
    }
    public static void listar(File dir){
            if (dir.isFile()) {
                System.out.println(dir.getName());
                return;
            }
            System.out.println(dir.getName());
            for (File folders : dir.listFiles()) {
                listar(folders);

            }
    }

}
