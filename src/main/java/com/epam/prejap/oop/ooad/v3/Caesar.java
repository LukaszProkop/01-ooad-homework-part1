package com.epam.prejap.oop.ooad.v3;

import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        System.out.println("Ave Caesar! Morituri te salutant!");
        Scanner in = new Scanner(System.in);
        String input, output;
        do {
            System.out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
            if (input.equals("encrypt")) {
                input = readPlainTextMessage(in);
                output = encryptMessage(input);
                printEncryptedMessage(output);
                break;
            } else if (input.equals("decrypt")) {
                input = readEncryptedMessage(in);
                output = decryptMessage(input);
                printPlainTextMessage(output);
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
        System.out.println("Vale!");
    }

    private static void printPlainTextMessage(String output) {
        // print decrypted message
        System.out.println("Decrypted message: ");
        System.out.println(output);
    }

    private static void printEncryptedMessage(String output) {
        // print encrypted message
        System.out.println("Encrypted message: ");
        System.out.println(output);
    }

    private static String readPlainTextMessage(Scanner in) {
        String input;// ask for a plain-text message
        System.out.println("Enter a message to encrypt: ");
        input = in.nextLine();
        return input;
    }

    private static String readEncryptedMessage(Scanner in) {
        String input;// ask for encrypted message
        System.out.println("Enter a message to decrypt: ");
        input = in.nextLine();
        return input;
    }

    private static String decryptMessage(String input) {
        StringBuilder output = new StringBuilder();
        // decrypt entire message
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char decrypted = decryptLetter(letter);
            output.append(decrypted);
        }
        return output.toString();
    }

    // encrypt entire message
    private static String encryptMessage(String input) {
        StringBuilder output;
        output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(encryptLetter(input.charAt(i)));
        }
        return output.toString();
    }

    // encrypt a single letter
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

    // decrypt a single character
    private static char decryptLetter(char letter) {
        char decrypted;
        if ('A' <= letter && letter <= 'Z') {
            int offset = 3;
            decrypted = shiftLeft(letter, offset);
        } else {
            // leave as is
            decrypted = letter;
        }
        return decrypted;
    }

    private static char shiftLeft(char letter, int offset) {
        char decrypted;
        // shift right
        if (letter - offset >= 'A') {
            decrypted = (char) (letter - offset);
        } else {
            decrypted = (char) (letter - offset + 26);
        }
        return decrypted;
    }

    private static char shiftRight(char letter, int offset) {
        char encrypted;// shift
        if (letter + offset <= 'Z') {
            encrypted = (char) (letter + offset);
        } else {
            encrypted = (char) (letter + offset - 26);
        }
        return encrypted;
    }
}
