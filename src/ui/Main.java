package ui;

import exceptions.InvalidDayException;
import exceptions.UnderAgeException;
import model.MinimarketManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private MinimarketManager manager;
    private Scanner sc;

    public Main(){
        this.manager = new MinimarketManager();
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int option;
        do{
            main.showMenu();
            option = main.sc.nextInt();
            main.executeOption(option);
        } while(option != 3);
    }

    public void showMenu(){
        System.out.print("\n" +
                "[1] Register new client. \n" +
                "[2] Show visitors count. \n" +
                "[3] Exit. \n" +
                "\n");
    }

    public void executeOption(int option){
        switch (option){
            case 1:
                createClient();
                break;
            case 2:
                System.out.println("The ammount of visitors today is: "+ manager.getVisitors());
                break;
        }
    }

    public void createClient(){
        System.out.print("\n" +
                "Select the type of identification: \n" +
                "1. CC \n" +
                "2. CE \n" +
                "3. PP \n" +
                "4. TI \n" +
                "\n");
        String type = null;
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 2:
                type = "CE";
                break;
            case 3:
                type = "PP";
                break;
            case 4:
                type = "TI";
                break;
            default:
                type = "CC";
                break;
        }
        System.out.print("Id: ");
        String id = sc.nextLine();
        try{
            manager.registerClient(type, id, LocalDate.now().getDayOfMonth());
        } catch (UnderAgeException e){
            System.out.println("The client is under the permitted age.");
        } catch (InvalidDayException e){
            System.out.println("The client cant access to the market in this day.");
        }

    }
}
