package com.epam.prejap.oop.ooad.v1;

import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input, output;
        do {
            System.out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
            if (input.equals("encrypt")) {
                input = askForPlainTextMessage(in);
                output = encryptMessage(input);
                outputEncryptedMessage(output);
                break;
            } else if (input.equals("decrypt")) {
                input = askForEncryptedMessage(in);
                output = decryptMessage(input);
                outputPlainTextMessage(output);
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
        System.out.println("Vale!");
    }

    private static void outputPlainTextMessage(String output) {
        System.out.println("Decrypted message: ");
        System.out.println(output);
    }

    private static String decryptMessage(String input) {
        String output;
        output = "";
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char character;
            character = decryptSingleCharacter(letter);
            output += character;
        }
        return output;
    }

    private static char decryptSingleCharacter(char letter) {
        char character;
        if ('A' <= letter && letter <= 'Z') {
            if (letter - 3 >= 'A') {
                character = (char) (letter - 3);
            } else {
                character = (char) (letter - 3 + 26);
            }
        } else {
            character = letter;
        }
        return character;
    }

    private static String askForEncryptedMessage(Scanner in) {
        String input;
        System.out.println("Enter a message to decrypt: ");
        input = in.nextLine();
        return input;
    }

    private static void outputEncryptedMessage(String output) {
        System.out.println("Encrypted message: ");
        System.out.println(output);
    }

    private static String encryptMessage(String input) {
        String output;
        output = "";
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char character;
            character = encryptSingleCharacter(letter);
            output += character;
        }
        return output;
    }

    private static char encryptSingleCharacter(char letter) {
        char character;
        if ('A' <= letter && letter <= 'Z') {
            // shift by 3
            if (letter + 3 <= 'Z') {
                character = (char) (letter + 3);
            } else {
                character = (char) (letter + 3 - 26);
            }
        } else {
           character = letter;
        }
        return character;
    }

    private static String askForPlainTextMessage(Scanner in) {
        String input;
        System.out.println("Enter a message to encrypt: ");
        input = in.nextLine();
        return input;
    }
}
