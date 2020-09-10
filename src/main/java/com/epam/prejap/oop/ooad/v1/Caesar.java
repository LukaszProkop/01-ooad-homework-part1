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
                System.out.println("Enter a message to encrypt: ");
                input = in.nextLine();
                output = "";
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    if ('A' <= letter && letter <= 'Z') {
                        if (letter + 3 <= 'Z') {
                            output = output + (char)(letter + 3);
                        } else {
                            output = output + (char)(letter + 3 - 26);
                        }
                    } else {
                        output = output + letter;
                    }
                }
                System.out.println("Encrypted message: ");
                System.out.println(output);
                break;
            } else if (input.equals("decrypt")) {
                System.out.println("Enter a message to decrypt: ");
                input = in.nextLine();
                output = "";
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    if ('A' <= letter && letter <= 'Z') {
                        if (letter - 3 >= 'A') {
                            output = output + (char)(letter - 3);
                        } else {
                            output = output + (char)(letter - 3 + 26);
                        }
                    } else {
                        output = output + letter;
                    }
                }
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
