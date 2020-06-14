/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

/**
 *
 * @author cuongnm
 */
public class MenuChilds {
    public static int menuBus(){
        System.out.println("1.      Load data from file");
        System.out.println("2.      Input & add to the head");
        System.out.println("3.      Display data");
        System.out.println("4.      Save bus list to file");
        System.out.println("5.      Search by bcode");
        System.out.println("6.      Delete by bcode");
        System.out.println("7.      Sort by bcode");
        System.out.println("8.      Add before position  k");
        System.out.println("9.      Delete the node before the node having bcode = xCode");
        System.out.println("10. f1");
        System.out.println("11. f2");
        System.out.println("12. f3");
        System.out.println("13. f4");
        System.out.println("14. f5");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputInt(1, 14);
        return choice;
    }
    public static int menuCus(){
        System.out.println("1.      Load data from file");
        System.out.println("2.      Input & add to the end");
        System.out.println("3.      Display data");
        System.out.println("4.      Save customer list to file");
        System.out.println("5.      Search by ccode");
        System.out.println("6.      Delete by ccode");
        int choice = Validation.checkInputInt(1, 6);
        return choice;
    }
}
