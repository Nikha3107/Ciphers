package com.is.gronsfeld.crypto;

import java.util.Arrays;
import java.util.List;

public class Gronsfeld_cipher {

    private static final List<Character> alphabet = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е',
            'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х',
            'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');
    /**
     * Медод для расшифровывания
     * */
    public String encrypt(String sourceText,int[] key) {
        return crypt(sourceText,key,TypeOfCrypt.ENCRYPT);
    }
    /**
     * Медод для зашифровывания
     * */
    public String decrypt(String sourceText,int[] key) {
        return crypt(sourceText,key,TypeOfCrypt.DECRYPT);
    }
    /**
     * Внутренний метод для вычисления шифртекста или исходного текста
     * */
    private String crypt(String sourceText, int[] key, TypeOfCrypt type) {

        sourceText = sourceText.toLowerCase();
        key = validateKey(sourceText.length(),key);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sourceText.length(); i++) {
            char ch = sourceText.charAt(i);
            if (alphabet.contains(ch)) {
                stringBuilder.append(alphabet.get(calculateShift(alphabet.indexOf(ch),key[i],type)));
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
    /**
     * Внутренний метод для вычисления сдвига
     * */
    private int calculateShift(int index,int shift,TypeOfCrypt type) {
        switch (type) {
            case ENCRYPT:
                index += shift;
                if (index >= alphabet.size()) {
                    return Math.floorMod(index,alphabet.size());
                }
                break;
            case DECRYPT:
                index -= shift;
                if (index < 0) {
                    return Math.floorMod(index,alphabet.size());
                } else {

                }
                break;
        }
        return index;
    }
    /**
     * Внутренний метод для валидации ключа
     * */
    private int[] validateKey(int length, int[] key) {
        int[] newKey = new int[length];
        for (int i = 0; i < length; i++) {
            int keyIndex = i % key.length;
            newKey[i] = Math.abs(key[keyIndex]);
        }
        return newKey;
    }
}
