/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class Validation {
    public final static Scanner sc = new Scanner(System.in);
    
    public static int checkInputInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range " + min + "-" + max);
                System.out.println("Enter again");
            }
        }
    }
    
    public static String checkInputString() {
        while (true) {
            try {
                String result = sc.nextLine();
                if (result.isEmpty()) {
                    throw new NullPointerException();
                }
                return result;
            } catch (NullPointerException n) {
                System.out.print("Enter again: ");
                System.err.println("Please input String!");
            }
        }
    }
    
}
