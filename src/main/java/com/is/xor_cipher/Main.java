package com.is.xor_cipher;

import com.is.xor_cipher.crypto.Xor_cipher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        Xor_cipher cipher = new Xor_cipher();
        String ciphertext = cipher.encrypt(text);
        System.out.println("Зашифрованное сообщение: "+ciphertext);
        System.out.println("Гамма: "+cipher.getGamma());
        System.out.println("Расшифрованное сообщение: "+cipher.decrypt(ciphertext,cipher.getGamma()));
    }

}
