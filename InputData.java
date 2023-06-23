package Homework6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class InputData extends Order{

    private  Scanner scanner = new Scanner(System.in);

    private String prompt(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public void inputFromConsole(Order orderData){
        orderData.setClientName(prompt("Имя клиента: "));
        orderData.setProduct(prompt("Продукт: "));
        orderData.setQnt(Integer.parseInt(prompt("Кол-во: ")));
        orderData.setPrice(Integer.parseInt(prompt("Цена: ")));
    }

    public void inputFromFile(Order orderData){
        try (FileInputStream fis = new FileInputStream("Homework6/Order list.txt");) {
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            String order = (line.replace(":", ",")).replaceAll(" ", "");
            String [] orderInfo = order.split(",");
            //System.out.println(orderInfo);
            for (int i = 0; i < orderInfo.length-1; i++) {
            orderInfo[i] = orderInfo[i].substring(0, orderInfo[i].length());

            orderData.setClientName(orderInfo[1]);
            orderData.setProduct(orderInfo[3]);
            orderData.setQnt(Integer.parseInt(orderInfo[5]));
            orderData.setPrice(Integer.parseInt(orderInfo[7]));
            }
        }
        catch (IOException ex) {
            System.out.println ("Error: " + ex.getMessage());
        }
    }
}
