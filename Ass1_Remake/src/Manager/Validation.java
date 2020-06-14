/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import LinkedList.Bus_List;
import LinkedList.Cus_List;
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
    
    public static double checkInputDouble(double min, double max) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
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
                String result = sc.nextLine().trim();
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
    
    public static boolean checkCodeBus(Bus_List mlb, String bCode){
        for (int i = 0; i < mlb.size(); i++) {
            if(mlb.get(i).getBcode().equals(bCode)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkCodeCus(Cus_List mcl, String cCode){
        for (int i = 0; i < mcl.size(); i++) {
            if(mcl.get(i).getCcode().equals(cCode)){
                return false;
            }
        }
        return true;
    }
    
    public static String checkPhone(){
       
        while (true) {
            String phone = sc.nextLine();
            for (int i = 0; i < phone.length(); i++) {
                if(!Character.isDigit(phone.charAt(i))){
                    System.out.println("Phone not character.");
                    continue;
                }
            }
            return phone;
        }
    }
}
