package com.is.xor_cipher;

import com.is.file.File;
import com.is.xor_cipher.crypto.Xor_cipher;

public class Main {

    final static String in = "src/main/resources/in.txt";
    final static String cipherText = "src/main/resources/cipher-text.txt";
    final static String sourceText = "src/main/resources/source-text";
    public static void main(String[] args) {
        String text = File.fileReader(in);
        Xor_cipher cipher = new Xor_cipher();
        String ciphertext = cipher.encrypt(text);
        File.fileWriter(ciphertext,cipherText);
        File.fileWriter(cipher.decrypt(ciphertext,cipher.getGamma()),sourceText);
    }

}
