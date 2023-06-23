package Homework6;

import java.util.Scanner;

public class Program {

    /**
     * TODO: Переработать структуру приложения Order, приложение должно соответствовать
     *  принципу SRP.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"866");

        Order order = new Order();
        System.out.println("ввод данных с консоли - 1,\nввод данных из файла - 2.\n");
        int choice = Integer.parseInt(scanner.nextLine());
        InputData inputData = new InputData();
        switch (choice){
            case 1:
                inputData.inputFromConsole(order);
                break;
            case 2:
                inputData.inputFromFile(order);
                break;
                }
        
        System.out.println("вывод данных (json) - 1,\nвывод данных (txt) - 2,\nвывод в консоль - 3\n");
        choice = Integer.parseInt(scanner.nextLine());
        SaveData saveData = new SaveData();
        switch (choice){
            case 1:
                saveData.saveToJson(order);
                break;
            case 2:
                saveData.saveToTxt(order);
                break;
            case 3:
                saveData.printToConsole(order);
                break;
            }
        scanner.close();
    
    }
}

