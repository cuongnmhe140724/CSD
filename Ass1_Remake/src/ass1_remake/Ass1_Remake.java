/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1_remake;

import LinkedList.Bus_List;
import LinkedList.Cus_List;
import Manager.MenuChilds;
import Manager.MenuManager;

/**
 *
 * @author cuongnm
 */
public class Ass1_Remake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bus_List mlb = new Bus_List();
        Cus_List mlc = new Cus_List();

        while (true) {
            int choice = MenuManager.menu();
            switch (choice) {
                case 1:
                    int bus_choice = MenuChilds.menuBus();
                    switch (bus_choice) {
                        case 1:
                            MenuManager.loadBusFromFile(mlb);
                            break;
                        case 2:
                            MenuManager.addToEnd(mlb);
                            break;
                        case 3:
                            MenuManager.displayBus(mlb);
                            break;
                        case 4:
                            MenuManager.saveToFile(mlb);
                            break;
                        case 5:
                            MenuManager.searchByBCode(mlb);
                            break;
                        case 6:
                            MenuManager.deleteByBCode(mlb);
                            break;
                        case 7:
                            MenuManager.sortByBCode(mlb);
                            break;
                        case 8:
                            MenuManager.addBeforePosition(mlb);
                            break;
                        case 9:
                            MenuManager.deleteBeforeBCode(mlb);
                            break;
                        case 10:
                            MenuManager.loadBusFromFile(mlb);
                            MenuManager.displayBus(mlb);
                            break;
                        case 11:
                            MenuManager.f2(mlb);
                            MenuManager.displayBus(mlb);
                            break;
                        case 12:
                            MenuManager.f3(mlb);
                            MenuManager.displayBus(mlb);
                            break;
                        case 13:
                            MenuManager.f4(mlb);
                            MenuManager.displayBus(mlb);
                            break;
                        case 14:
                            MenuManager.f5(mlb);
                            MenuManager.displayBus(mlb);
                            break;
                                    
                    }
                    break;
                case 2:
                    int cus_choice = MenuChilds.menuCus();
                    switch (cus_choice) {
                        case 1:
                            MenuManager.loadCusFromFile(mlc);
                            break;
                        case 2:
                            MenuManager.addToEnd(mlc);
                            break;
                        case 3:
                            MenuManager.displayCus(mlc);
                            break;
                        case 4:
                            break;
                        case 5:
                            MenuManager.searchByCCode(mlc);
                            break;
                        case 6:
                            MenuManager.deleteByCCode(mlc);
                    }
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Thank you --<3");
                    return;
            }
        }
    }

}
/*--       _
       .__(.)< (MEOW)
        \___)   
 ~~~~~~~~~~~~~~~~~~--*/
