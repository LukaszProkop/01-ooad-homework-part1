package com.epam.prejap.oop.ooad.v5;

import java.util.Scanner;

class Encryptor {

    static void encrypt(Scanner in) {
        String input;
        String output;
        input = readPlainTextMessage(in);
        output = encryptMessage(input);
        printEncryptedMessage(output);
    }

    private static String readPlainTextMessage(Scanner in) {
        System.out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }

    private static String encryptMessage(String input) {
        StringBuilder output;
        output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(encryptLetter(input.charAt(i)));
        }
        return output.toString();
    }

    private static char encryptLetter(char letter) {
        char encrypted;
        if ('A' <= letter && letter <= 'Z') {
            int offset = 3;
            encrypted = shiftRight(letter, offset);
        } else {
            // leave as is
            encrypted = letter;
        }
        return encrypted;
    }

    private static char shiftRight(char letter, int offset) {
        char encrypted;
        if (letter + offset <= 'Z') {
            encrypted = (char) (letter + offset);
        } else {
            encrypted = (char) (letter + offset - 26);
        }
        return encrypted;
    }

    public static void printEncryptedMessage(String output) {
        System.out.println("Encrypted message: ");
        System.out.println(output);
    }
}
