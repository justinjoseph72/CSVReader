package com.justin;

import com.justin.model.PropertyInfo;
import com.justin.reader.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        try {
            System.out.println("Enter the file path :");
            Scanner sc = new Scanner(System.in);
            String filePath = sc.next();
            System.out.println(" Reading file =====>");
            CSVReader reader = new CSVReader(filePath);
            if(reader.getPropertyInfoList()!=null && !reader.getPropertyInfoList().isEmpty()){
                System.out.println("File Read Sucessfully");
                displayMenu(sc, reader);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file");
        }


    }

    private static void displayMenu(Scanner sc, CSVReader reader) {

        System.out.println("Please choose from the following option :");
        System.out.println("1) Display mean price for onward postcode W1F");
        System.out.println("2) Display average price difference between detached house and flats");
        System.out.println("3) Display top 10% most expensive properties");
        System.out.println("4) Exit");
        System.out.println(" Please enter your option: ");
        String input = sc.next();
        if(StringUtils.isNumeric(input)){
            switch (input){
                case "1": System.out.println(reader.meanPriceForOnwardPostcode()); break;
                case "2": System.out.println(reader.differenaceInAvgPricesOfDetachedAndFlats()); break;
                case "3": {
                    List<PropertyInfo> propertyInfos = reader.findTopExpensiveProperties();
                    if(propertyInfos!=null && !propertyInfos.isEmpty()){
                        System.out.println("Address \t PostCode \t Price");
                        propertyInfos.forEach(p->System.out.println(p.getAddress() + " \t" + p.getPostcode() + " \t" + p.getPrice()));
                    }
                } break;
                case "4": System.out.println("Closing the application");System.exit(0);
                default: System.out.println("Please enter a valid value");
            }
        }
        else{
            System.out.println("Please enter a numeric value");
        }
        displayMenu(sc,reader);
    }
}
