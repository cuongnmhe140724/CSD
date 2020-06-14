/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Bus;
import LinkedList.MyList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 *
 * @author cuongnm
 */
public class MenuManger {
    private static final String BUS_URL = "Bus.txt";
    
    public static void loadBusFromFile(MyList<Bus> mlb){
        try {
            File f = new File(BUS_URL);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {                
                String[] detailBus = line.split(":");
                mlb.addLast(new Bus(detailBus[0], detailBus[1], Integer.parseInt(detailBus[2]), 
                        Integer.parseInt(detailBus[3]), Double.parseDouble(detailBus[4]), 
                        Double.parseDouble(detailBus[5])));
            }
            System.out.println("Load successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------------
    public static void addToHead(MyList<Bus> mlb){
        while (true) {            
            String bCode = Validation.checkInputString();
            if(!Validation.checkCode(mlb, bCode)){
                System.out.println("Duplicates code");
                continue;
            }
            String bus_name = Validation.checkInputString();
            int seat = Validation.checkInputInt(0, Integer.MAX_VALUE);
            int booked = Validation.checkInputInt(0, seat);
            double depart_time = Validation.checkInputDouble(0, Double.MAX_VALUE);
            double arrival_time = Validation.checkInputDouble(0, depart_time);
            Bus b = new Bus(bCode, bus_name, seat, booked, depart_time, arrival_time);
            mlb.addFirst(b);
            System.out.println("Add successful!");
            return;
        }
    }
    //--------------------------------------------------------------------------
    public static void displayBus(MyList<Bus> mlb){
        System.out.println("List Bus:");
        mlb.traverse();
    }
    
    //------------------------------------------------------------------------------ 
    public static void saveToFile(MyList<Bus> mlb ){
        try {
            

            File f = new File(BUS_URL);        /*Find how to solve it*/
            FileWriter fw = new FileWriter(f);

        } catch (Exception e) {
        }
    }
    
    //------------------------------------------------------------------------------ 
    //search by Product Code
    public static void searchByPCode(MyList<Bus> mlb){
        System.out.print("Enter Bus code to search: ");
        String pCode = Validation.checkInputString();
        for(int i = 0; i < mlb.size(); i++){
            Bus b = (Bus) mlb.pos(i).info;
            if(b.getBcode().equalsIgnoreCase(pCode)){
                System.out.println(b);
            }
        }
    }
    
    //------------------------------------------------------------------------------
    //delete by b code
    public static void deleteBybcode(MyList<Bus> mlb){
        System.out.println("Enter b code to delete:");
        String bCode = Validation.checkInputString();
        for (int i = 0; i < mlb.size(); i++) {
            Bus b = (Bus) mlb.pos(i).info;
            if (b.getBcode().equalsIgnoreCase(bCode)) {
                mlb.dele(mlb.pos(i));
            }
        }
    }
    
    //----------------------------------------------------------------------------
    //sort by bcode
    public static void sortBybcode(MyList<Bus> mlb){
        for (int i = 0; i < mlb.size(); i++) {
            
        }
    }
    
    
    
    
    //-------------------------------------------
    public static int menu(){
        System.out.printf( "%-3s%-10s", "", "---MAIN MENU---\n");
        System.out.println("1. Bus list");
        System.out.println("2. Customer list");
        System.out.println("3. Booking list");
        System.out.println("0. Exit program");
        
        int choise = Validation.checkInputInt(0, 3);
        return choise;
    }
}
