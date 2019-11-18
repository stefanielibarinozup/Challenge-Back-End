package br.com.zup.challenge.spring.crud;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ListData {
    private static String NAME_FILE = "arquivo.txt";
    private static String READEWRITE_MODE = "rw";
    private String chavePassada;
    private String valorChave;
    private String valor;
    private String chave;
    private RandomAccessFile rf;
    private List<String> listChave = new ArrayList<>();

    public void getData() throws IOException {
        File file = new File(NAME_FILE);
        if (file.exists()) {
            listarChave(file);
            if (listChave.isEmpty()){
                System.out.println("Lista vazia!");
            }else {
                System.out.println(listChave);
            }
        }
        else {
            System.out.println("Arquivo não existe");
        }

    }

    private void listarChave(File file) throws IOException {
        rf = new RandomAccessFile(file, READEWRITE_MODE);
        while (rf.getFilePointer() < rf.length()) {
            valorChave = rf.readLine();
            int index = valorChave.indexOf(":");
            chave = valorChave.substring(0, index);
            listChave.add(chave);
        }
    }
}
