package com.epam.prejap.oop.ooad.v2;

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
                // ask for a plain-text message
                System.out.println("Enter a message to encrypt: ");
                input = in.nextLine();
                output = "";
                // encrypt entire message
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    // encrypt a single letter
                    if ('A' <= letter && letter <= 'Z') {
                        // shift
                        if (letter + 3 <= 'Z') {
                            output = output + (char)(letter + 3);
                        } else {
                            output = output + (char)(letter + 3 - 26);
                        }
                    } else {
                        // leave as is
                        output = output + letter;
                    }
                }
                // print encrypted message
                System.out.println("Encrypted message: ");
                System.out.println(output);
                break;
            } else if (input.equals("decrypt")) {
                // ask for encrypted message
                System.out.println("Enter a message to decrypt: ");
                input = in.nextLine();
                output = "";
                // decrypt entire message
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    // decrypt a single character
                    if ('A' <= letter && letter <= 'Z') {
                        if (letter - 3 >= 'A') {
                            output = output + (char)(letter - 3);
                        } else {
                            output = output + (char)(letter - 3 + 26);
                        }
                    } else {
                        // leave as is
                        output = output + letter;
                    }
                }
                // print decrypted message
                System.out.println("Decrypted message: ");
                System.out.println(output);
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
        System.out.println("Vale!");
    }
}
