package com.is.file;

import java.io.*;

public class File {

    public static String fileReader(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader fileReader = new FileReader(path)) {
            int c;
            while((c=fileReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    public static void fileWriter(String text, String path) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
