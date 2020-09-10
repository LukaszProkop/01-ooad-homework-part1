package com.epam.prejap.oop.ooad.v6;

import java.io.PrintStream;
import java.util.Scanner;

class Decryptor {

    private final Scanner in;
    private final PrintStream out;

    public Decryptor(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void decrypt() {
        String input;
        String output;
        input = readEncryptedMessage(in);
        output = decryptMessage(input);
        printPlainTextMessage(output);
    }

    private String readEncryptedMessage(Scanner in) {
        System.out.println("Enter a message to decrypt: ");
        return in.nextLine();
    }

    private String decryptMessage(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            char decrypted = decryptLetter(letter);
            output.append(decrypted);
        }
        return output.toString();
    }

    private char decryptLetter(char letter) {
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

    private char shiftLeft(char letter, int offset) {
        char decrypted;
        if (letter - offset >= 'A') {
            decrypted = (char) (letter - offset);
        } else {
            decrypted = (char) (letter - offset + 26);
        }
        return decrypted;
    }

    public void printPlainTextMessage(String output) {
        System.out.println("Decrypted message: ");
        System.out.println(output);
    }

}
