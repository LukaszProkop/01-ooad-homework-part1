package com.epam.prejap.oop.ooad.v6;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    private final Scanner in;
    private final PrintStream out;
    private final Encryptor encryptor;
    private final Decryptor decryptor;

    private Caesar(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.encryptor = new Encryptor(in, out);
        this.decryptor = new Decryptor(in, out);
    }

    private String readAction() {
        String input;
        boolean again = false;
        do {
            out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
            if (!(input.equals("encrypt") || input.equals("decrypt"))) {
                out.println("Tertium non datur!");
                again = true;
            }
        } while (again);
        return input;
    }

    private void act() {
        String input = readAction();
        if (input.equals("encrypt")) {
            encryptor.encrypt();
        } else {
            decryptor.decrypt();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        out.println("Ave Caesar! Morituri te salutant!");
        new Caesar(in, out).act();
        out.println("Vale!");
    }

}
