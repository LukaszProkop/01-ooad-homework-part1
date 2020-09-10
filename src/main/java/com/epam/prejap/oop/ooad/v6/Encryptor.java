package com.epam.prejap.oop.ooad.v6;

import java.io.PrintStream;
import java.util.Scanner;

class Encryptor {

    private final Scanner in;
    private final PrintStream out;

    public Encryptor(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void encrypt() {
        String input;
        String output;
        input = readPlainTextMessage();
        output = encryptMessage(input);
        printEncryptedMessage(output);
    }

    private String readPlainTextMessage() {
        out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }

    private String encryptMessage(String input) {
        StringBuilder output;
        output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(encryptLetter(input.charAt(i)));
        }
        return output.toString();
    }

    private char encryptLetter(char letter) {
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

    private char shiftRight(char letter, int offset) {
        char encrypted;
        if (letter + offset <= 'Z') {
            encrypted = (char) (letter + offset);
        } else {
            encrypted = (char) (letter + offset - 26);
        }
        return encrypted;
    }

    public void printEncryptedMessage(String output) {
        out.println("Encrypted message: ");
        out.println(output);
    }
}
