package br.com.zup.challenge.spring.crud;

import java.io.*;

public class DeleteData {
    private static String NAME_FILE = "arquivo.txt";
    private static String READEWRITE_MODE = "rw";
    private String chavePassada;
    private String valorChave;
    private String valor;
    private String chave;
    private RandomAccessFile rf;

    public void deleteData(String data) throws IOException {
        chavePassada = data;
        File file = new File(NAME_FILE);

        if (file.exists()) {
            if (searchChave(file, chavePassada)) {
                deleteLine(chavePassada, valor);
                System.out.println("Valor deletado: "+ valor);
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

    private void deleteLine(String chaveLine, String valorLine) throws IOException {
        RandomAccessFile inputFile = rf;
        File tmpFile = new File("temporario.txt");
        RandomAccessFile temporario
                = new RandomAccessFile(tmpFile, READEWRITE_MODE);

        rf.seek(0);
        while (inputFile.getFilePointer() < inputFile.length()) {
            String line = inputFile.readLine();
            if (line.equals(chaveLine+":"+valorLine)) { continue; }
            temporario.writeBytes(line+ System.lineSeparator() );
        }
        inputFile.seek(0);
        temporario.seek(0);
        while (temporario.getFilePointer() < temporario.length()) {
            inputFile.writeBytes(temporario.readLine() + System.lineSeparator());
        }
        inputFile.setLength(temporario.length());
        temporario.close();
        tmpFile.delete();
    }
}
