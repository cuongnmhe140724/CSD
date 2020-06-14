/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.*;
import LinkedList.Bus_List;
import LinkedList.Cus_List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author cuongnm
 */
public class MenuManager {

    private static final String BUS_URL = "bus.txt";

    public static int menu() {
        System.out.printf("%-3s%-10s", "", "---MAIN MENU---\n");
        System.out.println("1. Bus list");
        System.out.println("2. Customer list");
        System.out.println("3. Booking list");
        System.out.println("0. Exit program");

        int choise = Validation.checkInputInt(0, 3);
        return choise;
    }

    //Bus
    //Load data from file
    public static void loadBusFromFile(Bus_List mlb) {
        //System.out.println("Enter a file to load data:");
        //String url = Validation.checkInputString();
        try {
//            FileReader fr = new FileReader(BUS_URL);
//            BufferedReader br = new BufferedReader(fr);
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] detailBus = line.split("[|]");
//                mlb.addLast(new Bus(detailBus[0].trim(), detailBus[1].trim(), Integer.parseInt(detailBus[2].trim()),
//                        Integer.parseInt(detailBus[3].trim()), Double.parseDouble(detailBus[4].trim()),
//                        Double.parseDouble(detailBus[5].trim())));
//            }
//            System.out.println("Load successful!");
//            fr.close();
//            br.close();
            FileReader fr = new FileReader(BUS_URL);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] a;
            Bus x;
            String xCode, xName;
            int xSeat, xBooked;
            double xDepart, xArrival;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                xCode = a[0].trim();
                xName = a[1].trim();
                xSeat = Integer.parseInt(a[2].trim());
                xBooked = Integer.parseInt(a[3].trim());
                xDepart = Double.parseDouble(a[4].trim());
                xArrival = Double.parseDouble(a[5].trim());
                x = new Bus(xCode, xName, xSeat, xBooked, xDepart, xArrival);
                mlb.addLast(x);
            }
            fr.close();
            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    //Input & add to the head
    public static void addToEnd(Bus_List mlb) {
        while (true) {
            System.out.println("Enter bCode");
            String bCode = Validation.checkInputString();
            if (!Validation.checkCodeBus(mlb, bCode)) {
                System.out.println("Duplicates code");
                continue;
            }
            System.out.println("Enter bus name:");
            String bus_name = Validation.checkInputString();
            System.out.println("Enter number of seat:");
            int seat = Validation.checkInputInt(0, Integer.MAX_VALUE);
            System.out.println("Enter number of booker:");
            int booked = Validation.checkInputInt(0, seat);
            System.out.println("Enter depart time:");
            double depart_time = Validation.checkInputDouble(0, Double.MAX_VALUE);
            System.out.println("Enter  arrival time:");
            double arrival_time = Validation.checkInputDouble(depart_time, Double.MAX_VALUE);
            Bus b = new Bus(bCode, bus_name, seat, booked, depart_time, arrival_time);
            mlb.addLast(b);
            System.out.println("Add successful!");
            return;
        }
    }

    //Display data
    public static void displayBus(Bus_List mlb) {
        System.out.println("List Bus:");
        mlb.traverse();
    }

    //Save bus list to file
    public static void saveToFile(Bus_List mlb) {
        System.out.println("");
        try {
            FileWriter fw = new FileWriter(BUS_URL);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < mlb.size(); i++) {
                Bus b = mlb.get(i);
                pw.printf("%s|%s|%d|%d|%f|%f\n", b.getBcode(), b.getBus_name(),
                        b.getSeat(), b.getBooked(), b.getDepart_time(), b.getArrival_time());
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
        }
    }

    //Search by bcode
    public static void searchByBCode(Bus_List mlb) {
        System.out.println("Enter a code to search");
        String bCode = Validation.checkInputString();
        boolean check = false;
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase(bCode)) {
                System.out.println(mlb.get(i));
                check = true;
            }
        }
        if (!check) {
            System.out.println("Id not found");
        }
    }

    //Delete by bcode
    public static void deleteByBCode(Bus_List mlb) {
        System.out.println("Enter a code to delete");
        String bCode = Validation.checkInputString();
        boolean check = false;
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase(bCode)) {
                mlb.deleteAt(i);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Id not found");
        } else {
            System.out.println("Delete successful.");
        }
    }

    //Sort by bcode
    public static void sortByBCode(Bus_List mlb) {
        mlb.sortByBCode();
        System.out.println("List after sort:");
        displayBus(mlb);
    }

    //Add before position  k
    public static void addBeforePosition(Bus_List mlb) {
        System.out.println("Enter a position to add:");
        int k = Validation.checkInputInt(0, mlb.size());
        while (true) {
            String bCode = Validation.checkInputString();
            if (!Validation.checkCodeBus(mlb, bCode)) {
                System.out.println("Duplicates code");
                continue;
            }
            String bus_name = Validation.checkInputString();
            int seat = Validation.checkInputInt(0, Integer.MAX_VALUE);
            int booked = Validation.checkInputInt(0, seat);
            double depart_time = Validation.checkInputDouble(0, Double.MAX_VALUE);
            double arrival_time = Validation.checkInputDouble(0, depart_time);
            Bus b = new Bus(bCode, bus_name, seat, booked, depart_time, arrival_time);
            mlb.insertBefore(k, b);
            break;
        }
    }

    //delete before position k
    public static void deleteBeforeBCode(Bus_List mlb) {
        System.out.println("Enter a b code :");
        String bCode = Validation.checkInputString();
        boolean check = false;
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase(bCode)) {
                mlb.deleteAt(i - 1);
                check = true;
            }
        }
        if (!check) {
            System.out.println("B code not found.");
        }
    }

    //Customer
    //Load data from file
    public static void loadCusFromFile(Cus_List mlc) {
        System.out.println("Enter a file to load data:");
        String url = Validation.checkInputString();
        try {
            File f = new File(url);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] detailCus = line.split(":");
                mlc.addLast(new Customer(detailCus[0], detailCus[1], detailCus[2]));
            }
            System.out.println("Load successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add to end
    public static void addToEnd(Cus_List mcl) {
        while (true) {
            System.out.println("Enter customer code:");
            String ccode = Validation.checkInputString();
            if (!Validation.checkCodeCus(mcl, ccode)) {
                System.out.println("Duplicate code.");
                continue;
            }
            System.out.println("Enter customer name:");
            String cus_name = Validation.checkInputString();
            System.out.println("Enter phone:");
            String phone = Validation.checkPhone();
            Customer c = new Customer(ccode, cus_name, phone);
            mcl.addLast(c);
            System.out.println("Add successful!");
        }
    }

    //display data
    public static void displayCus(Cus_List mcl) {
        System.out.println("List Bus:");
        mcl.traverse();
    }
    //save to file

    //search by c code
    public static void searchByCCode(Cus_List mcl) {
        System.out.println("Enter a code to search");
        String cCode = Validation.checkInputString();
        for (int i = 0; i < mcl.size(); i++) {
            if (mcl.get(i).getCcode().equalsIgnoreCase(cCode)) {
                System.out.println(mcl.get(i));
            }
        }
    }

    //Delete by ccode
    public static void deleteByCCode(Cus_List mcl) {
        System.out.println("Enter a code to delete");
        String cCode = Validation.checkInputString();
        for (int i = 0; i < mcl.size(); i++) {
            if (mcl.get(i).getCcode().equalsIgnoreCase(cCode)) {
                mcl.deleteAt(i);
            }
        }
    }

    public static void f2(Bus_List mlb) {
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase("2")) {
                mlb.get(i).setSeat(9);
            }
        }
    }

    public static void f3(Bus_List mlb) {
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase("3")) {
                mlb.deleteAt(i);
            }
        }
    }

    public static void f4(Bus_List mlb) {
        mlb.addLast(new Bus("9", "E", 3, 1, 1, 8));
    }

    public static void f5(Bus_List mlb) {
        mlb.sortBySeat();
    }
}
