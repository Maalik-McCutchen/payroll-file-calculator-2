package com.pluralsight;

import java.io.*;
import java.util.Scanner;


public class PayrollFileCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);



        try {
            System.out.println("Enter your employee profile: ");
            String fileName = myScanner.nextLine();

            BufferedWriter reader = new BufferedWriter(new FileWriter(fileName));
            String line;


            reader.newLine();


            while ((line = reader.newLine()) != null) {

                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);


                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
            reader.close();
        } catch (IOException e) {

            System.err.println("Error reading file: ");
        }
    }
}