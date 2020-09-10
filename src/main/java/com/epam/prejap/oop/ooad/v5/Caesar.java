package com.epam.prejap.oop.ooad.v5;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    private static Scanner in;
    private static PrintStream out;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        out = System.out;
        out.println("Ave Caesar! Morituri te salutant!");
        act();
        out.println("Vale!");
    }

    private static void act() {
        String input = readAction();
        if (input.equals("encrypt")) {
            Encryptor.encrypt(in);
        } else {
            Decryptor.decrypt(in);
        }
    }

    private static String readAction() {
        String input;
        boolean again = false;
        do {
            out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
            if (!(input.equals("encrypt") || input.equals("decrypt"))) {
                out.println("Tertium non datur!");
                again = true;
            } else
                again = false;
        } while (again);
        return input;
    }

}
