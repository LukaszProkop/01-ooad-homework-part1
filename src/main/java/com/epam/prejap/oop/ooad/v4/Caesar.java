package com.epam.prejap.oop.ooad.v4;

import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        System.out.println("Ave Caesar! Morituri te salutant!");
        Scanner in = new Scanner(System.in);
        String input = readAction(in);
        if (input.equals("encrypt")) {
            Encryptor.encrypt(in);
        } else {
            Decryptor.decrypt(in);
        }
        System.out.println("Vale!");
    }

    private static String readAction(Scanner in) {
        String input;
        boolean again = false;
        System.out.println(again);
        do {
            System.out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
            if (!(input.equals("encrypt") || input.equals("decrypt"))) {
                System.out.println("Tertium non datur!");
                again = true;
            } else
                again = false;
            System.out.println(again);
        } while (again);
        return input;
    }

}
