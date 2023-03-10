package com.is.xor_cipher.crypto;

import java.util.Random;

public class Xor_cipher {

    String gamma;

    public String encrypt(String sourceText){
        return crypt(sourceText, setRandomGamma(sourceText.length()));
    }
    public String decrypt(String sourceText,String gammaKey){
        return crypt(sourceText,gammaKey);
    }

    private  String crypt(String sourceText,String gamma){
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < sourceText.length(); i++) {
            resultText.append((char)(sourceText.charAt(i)^gamma.charAt(i)));
        }
        return resultText.toString();
    }

    private String setRandomGamma(int length){
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append((char) (random.nextInt(256))); // use all possible characters
        }
        this.gamma = result.toString();
        return result.toString();
    }

    public String getGamma() {
        return gamma;
    }
}
