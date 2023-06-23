package Homework6;

import java.io.FileWriter;
import java.io.IOException;

public class SaveData extends Order{


    public void saveToJson(Order orderData) {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ orderData.getClientName() + "\",\n");
            writer.write("\"product\":\""+orderData.getProduct()+"\",\n");
            writer.write("\"qnt\":"+orderData.getQnt()+",\n");
            writer.write("\"price\":"+orderData.getPrice()+"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveToTxt(Order orderData) {
    String fileName = "order.txt";
    try(FileWriter writer = new FileWriter(fileName, false))
        {
            String orderLine = "clientName " + orderData.getClientName() + ", product " + orderData.getProduct() + ", qnt " + orderData.getQnt() + ", price " + orderData.getPrice();
            writer.write(orderLine);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void printToConsole(Order orderData) {
        System.out.println("Order: clientName " + orderData.getClientName() + ", product " + orderData.getProduct() + ", qnt " + orderData.getQnt() + ", price " + orderData.getPrice());;
    }
    
}