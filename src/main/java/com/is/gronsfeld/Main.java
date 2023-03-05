package com.is.gronsfeld;

import com.is.gronsfeld.crypto.Gronsfeld_cipher;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        System.out.print("Введите ключ: ");
        String[] keyString = scanner.nextLine().split(",");
        int[] key = new int[keyString.length];
        for (int i = 0; i < keyString.length; i++) {

            key[i] = Integer.parseInt(keyString[i].trim());
        }
        Gronsfeld_cipher cipher = new Gronsfeld_cipher();
        String ciphertext = cipher.encrypt(text,key);
        System.out.println("Зашифрованное сообщение: "+ciphertext);
        System.out.println("Расшифрованное сообщение: "+cipher.decrypt(ciphertext,key));

    }
}
