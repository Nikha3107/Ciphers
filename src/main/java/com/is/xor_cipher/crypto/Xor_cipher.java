package com.is.xor_cipher.crypto;

import java.util.Random;

public class Xor_cipher {

    String gamma;

    /**
     * Медод для зашифровывания
     * */
    public String encrypt(String sourceText){
        return crypt(sourceText, setRandomGamma(sourceText.length()));
    }
    /**
     * Медод для расщифровывания
     * */
    public String decrypt(String sourceText,String gammaKey){
        return crypt(sourceText,gammaKey);
    }

    /**
     * Внутренний метод для вычисления шифртекста или исходного текста
     * */
    private  String crypt(String sourceText,String gamma){
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < sourceText.length(); i++) {
            resultText.append((char)(sourceText.charAt(i)^gamma.charAt(i)));
        }
        return resultText.toString();
    }

    /**
     * Внутренний метод для создания случайной гаммы
     * */
    private String setRandomGamma(int length){
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append((char) (random.nextInt(256))); // use all possible characters
        }
        this.gamma = result.toString();
        return result.toString();
    }
    /**
     * getter для гаммы
     * */
    public String getGamma() {
        return gamma;
    }
}
