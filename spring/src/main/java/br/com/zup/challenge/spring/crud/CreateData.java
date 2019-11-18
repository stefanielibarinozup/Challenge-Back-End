package br.com.zup.challenge.spring.crud;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateData {
    private static String NAME_FILE = "arquivo.txt";
    private static String READEWRITE_MODE = "rw";

    //chave:valor
    public void setData(String data) throws IOException {

        int index = data.indexOf(":");
        String newChave = data.substring(0, index);
        String newValor = data.substring(index+1);

        String valorChave;
        String valor;
        String chave;

        File file = new File(NAME_FILE);
        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile rf = new RandomAccessFile(file, READEWRITE_MODE);
        boolean found = false;

        while (rf.getFilePointer() < rf.length()) {
            valorChave = rf.readLine();
            index = valorChave.indexOf(":");
            chave = valorChave.substring(0, index);
            valor = valorChave.substring(index+1);

            if (chave.equals(newChave)) {
                found = true;
            }
        }

        if (found) {
            rf.close();
            System.out.println("Chave já existe");
        }
        else {
            String textoParaSalvar = newChave +":" + newValor;
            rf.writeBytes(textoParaSalvar);
            rf.writeBytes(System.lineSeparator());
            System.out.println("Salvo com sucesso");
            rf.close();
        }
    }
}
