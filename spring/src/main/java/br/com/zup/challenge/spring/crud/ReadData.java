package br.com.zup.challenge.spring.crud;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadData {
    private static String NAME_FILE = "arquivo.txt";
    private static String READEWRITE_MODE = "rw";
    private String chavePassada;
    private String valorChave;
    private String valor;
    private String chave;
    private RandomAccessFile rf;

    public void getData(String data) throws IOException {
        chavePassada = data;
        File file = new File(NAME_FILE);

        if (file.exists()) {
            if (searchChave(file, chavePassada)) {
                System.out.println("Valor encontrado: "+ valor);
                rf.close();
            }
            else {
                System.out.println("Chave não encontrada");
                rf.close();
            }
        } else {
            System.out.println("Arquivo não está criado");
        }
    }

    private Boolean searchChave(File file, String data) throws IOException {
        Boolean result = false;
        rf = new RandomAccessFile(file, READEWRITE_MODE);
        while (rf.getFilePointer() < rf.length()) {
            valorChave = rf.readLine();
            int index = valorChave.indexOf(":");
            chave = valorChave.substring(0, index);
            valor = valorChave.substring(index+1);
            if (chave.equals(data)) {
                result = true;
            }
        }
        return result;
    }
}
